package com.example.smartquiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public String start(HttpSession session) {
        // Reset session attributes for a new quiz
        session.setAttribute("score", 0);
        session.setAttribute("difficulty", 1); // Start with easy questions
        session.setAttribute("lastAnswerCorrect", null);
        return "redirect:/quiz";
    }

    @GetMapping("/quiz")
    public String quiz(HttpSession session, Model model) {
        Integer difficulty = (Integer) session.getAttribute("difficulty");
        if (difficulty == null) {
            difficulty = 1; // Default to easy if session is lost
        }

        Optional<Question> questionOpt = questionRepository.findRandomByDifficulty(difficulty);

        if (questionOpt.isPresent()) {
            model.addAttribute("question", questionOpt.get());
            model.addAttribute("score", session.getAttribute("score"));
            model.addAttribute("lastAnswerCorrect", session.getAttribute("lastAnswerCorrect"));
            return "quiz"; // Renders quiz.html
        } else {
            // No more questions at this difficulty, end the quiz
            return "redirect:/results";
        }
    }

    @PostMapping("/submit")
    public String submit(@RequestParam Long questionId, @RequestParam String answer, HttpSession session) {
        Optional<Question> questionOpt = questionRepository.findById(questionId);
        if (questionOpt.isPresent()) {
            Question question = questionOpt.get();
            Integer score = (Integer) session.getAttribute("score");
            Integer difficulty = (Integer) session.getAttribute("difficulty");

            if (question.getCorrectAnswer().equals(answer)) {
                // Correct answer
                session.setAttribute("score", score + 1);
                // Increase difficulty, but cap at 3 (Hard)
                if (difficulty < 3) {
                    session.setAttribute("difficulty", difficulty + 1);
                }
                session.setAttribute("lastAnswerCorrect", true);
            } else {
                // Incorrect answer
                // Decrease difficulty, but cap at 1 (Easy)
                if (difficulty > 1) {
                    session.setAttribute("difficulty", difficulty - 1);
                }
                session.setAttribute("lastAnswerCorrect", false);
            }
        }
        return "redirect:/quiz";
    }

    @GetMapping("/results")
    public String results(HttpSession session, Model model) {
        model.addAttribute("score", session.getAttribute("score"));
        return "results"; // Renders results.html
    }
}
