-- Clear existing questions to avoid duplicates on restart
DELETE FROM questions;

-- Easy Questions (Difficulty 1)
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('What is 2 + 2?', '3', '4', '5', 'B', 1);
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('What is the capital of France?', 'London', 'Berlin', 'Paris', 'C', 1);
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('Which planet is known as the Red Planet?', 'Mars', 'Jupiter', 'Saturn', 'A', 1);

-- Medium Questions (Difficulty 2)
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('What does JPA stand for?', 'Java Persistence API', 'Java Primary Account', 'JSON Parsing API', 'A', 2);
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('Which of these is a Spring Boot starter?', 'spring-boot-starter-web', 'spring-boot-starter-data', 'spring-boot-starter-app', 'A', 2);
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('What HTTP method is typically used for fetching data?', 'POST', 'GET', 'PUT', 'B', 2);

-- Hard Questions (Difficulty 3)
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('What is the default scope of a bean in Spring?', 'Prototype', 'Session', 'Singleton', 'C', 3);
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('In database terms, what is ACID?', 'Atomicity, Consistency, Isolation, Durability', 'Association, Caching, Indexing, Durability', 'Atomicity, Caching, Isolation, Delegation', 'A', 3);
INSERT INTO questions (text, option_a, option_b, option_c, correct_answer, difficulty) VALUES ('What does the `transient` keyword do in Java?', 'Makes a variable non-serializable', 'Makes a method thread-safe', 'Makes a class final', 'A', 3);
