DROP TABLE IF EXISTS Vacancy;
DROP TABLE IF EXISTS Candidates;
DROP TABLE IF EXISTS Resume;

CREATE TABLE Resume
(
    resume_id   INT          NOT NULL,
    name        varchar(100) NOT NULL,
    description varchar(100) not null,
    education   varchar(100) not null,
    phone       varchar(100) not null,
    created_at date default current_date,
    PRIMARY KEY (resume_id)
);

DROP TABLE IF EXISTS Candidates;
CREATE TABLE Candidates
(
    candidate_id INT         NOT NULL,
    account_name varchar(60) NOT NULL,
    email        varchar(40) NOT NULL,
    age          INTEGER     NOT NULL,
    status       INTEGER     NOT NULL,
    resume_id    INTEGER     NOT NULL,
    created_at date default current_date,
    PRIMARY KEY (candidate_id),
    CONSTRAINT fk_resume
        FOREIGN KEY (resume_id)
            REFERENCES Resume (resume_id)
            ON DELETE CASCADE
);


DROP TABLE IF EXISTS Vacancy;
CREATE TABLE Vacancy
(
    vacancy_id   INT          NOT NULL,
    name         varchar(100) NOT NULL,
    status       INTEGER      NOT NULL,
    amount       INTEGER      NOT NULL,
    candidate_id INTEGER      NOT NULL,
    created_at date default current_date,
    PRIMARY KEY (vacancy_id),
    CONSTRAINT fk_candidates
        FOREIGN KEY (candidate_id)
            REFERENCES Candidates (candidate_id)
            ON DELETE CASCADE
);