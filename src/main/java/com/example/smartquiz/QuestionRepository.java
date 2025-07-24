package com.example.smartquiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // This custom query finds one random question of a specific difficulty
    @Query(value = "SELECT * FROM questions WHERE difficulty = ?1 ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Question> findRandomByDifficulty(int difficulty);
}
