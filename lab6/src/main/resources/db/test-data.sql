INSERT INTO Resume (resume_id, name, description, education, phone)
VALUES (1, 'PHP dev', 'Testing description php dev resume', 'IITU 3 course ITSE1909R group', '+77477782877');
INSERT INTO Resume (resume_id, name, description, education, phone)
VALUES (2, 'Kotlin jun dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group', '+77477782878');
INSERT INTO Resume (resume_id, name, description, education, phone)
VALUES (3, 'Kotlin middle dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group',
        '+77477782879');

INSERT INTO Candidates (candidate_id, account_name, email, age, status, resume_id)
VALUES (1, 'Davlat', 'dushurbakiev@gmail.com', 22, 1, 1);
INSERT INTO Candidates (candidate_id, account_name, email, age, status, resume_id)
VALUES (2, 'Raf', 'dushurbakiev@gmail.com', 22, 2, 1);
INSERT INTO Candidates (candidate_id, account_name, email, age, status, resume_id)
VALUES (3, 'Karim', 'dushurbakiev@gmail.com', 22, 3, 1);

INSERT INTO Vacancy (vacancy_id, name, status, amount,candidate_id)
VALUES (1, 'PHP', 1, 10000, 1);
INSERT INTO Vacancy (vacancy_id, name, status, amount, candidate_id)
VALUES (2, 'Kotlin jun', 1, 10000, 2);
INSERT INTO Vacancy (vacancy_id, name, status, amount, candidate_id)
VALUES (3, 'Kotlin middle', 1, 10000, 3);


