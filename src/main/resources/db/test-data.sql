
INSERT INTO roles(ID, ROLE) values (1,'Admin'),(2,'User') , (3,'Manager');


INSERT INTO Resume (resume_id, name, description, education, phone)
VALUES (101, 'PHP dev', 'Testing description php dev resume', 'IITU 3 course ITSE1909R group', '+77477782877');
INSERT INTO Resume (resume_id, name, description, education, phone)
VALUES (102, 'Kotlin jun dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group',
        '+77477782878');
INSERT INTO Resume (resume_id, name, description, education, phone)
VALUES (103, 'Kotlin middle dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group',
        '+77477782879');

INSERT INTO Candidates (candidate_id, account_name, email, age, status, resume_id, role_id, created_at,password)
VALUES (101, 'Davlat', 'dushurbakiev@gmail.com', 22, 1, null, 1, current_timestamp,'pass101');
INSERT INTO Candidates (candidate_id, account_name, email, age, status, resume_id, role_id, created_at,password)
VALUES (102, 'Raf', 'dushurbakiev@gmail.com', 22, 2, null, 2, current_timestamp,'pass102');
INSERT INTO Candidates (candidate_id, account_name, email, age, status, resume_id, role_id, created_at,password)
VALUES (103, 'Karim', 'dushurbakiev@gmail.com', 22, 3, null, 3, current_timestamp,'pass103');

INSERT INTO Vacancy (vacancy_id, name, status, amount, candidate_id)
VALUES (101, 'PHP', 1, 10000, 101);
INSERT INTO Vacancy (vacancy_id, name, status, amount, candidate_id)
VALUES (102, 'Kotlin jun', 1, 10000, 102);
INSERT INTO Vacancy (vacancy_id, name, status, amount, candidate_id)
VALUES (103, 'Kotlin middle', 1, 10000, 103);


