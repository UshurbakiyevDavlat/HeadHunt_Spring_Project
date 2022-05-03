DROP TABLE IF EXISTS Vacancy;
DROP TABLE IF EXISTS Candidates;
DROP TABLE IF EXISTS Resume;


create table roles
(
    id   integer     not null
        constraint roles_pkey
            primary key,
    role varchar(50) not null
);

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
create table Candidates
(
    candidate_id serial
        constraint candidates_pkey
            primary key,
    account_name varchar(60)  not null,
    email        varchar(40)  not null,
    age          integer,
    status       integer,
    resume_id    integer
        constraint fk_resume
            references resume
            on delete cascade,
    role_id      integer
        constraint fk_role
            references roles
            on delete cascade,
    created_at   date default CURRENT_DATE,
    password     varchar(100) not null
);
-- CREATE TABLE Candidates
-- (
--     candidate_id INT         NOT NULL   primary key ,
--     account_name varchar(60) NOT NULL,
--     email        varchar(40) NOT NULL,
--     age          INTEGER     NOT NULL,
--     status       INTEGER     NOT NULL,
--     resume_id    INTEGER     NOT NULL,
--     created_at date default current_date,
--     PRIMARY KEY (candidate_id),
--     CONSTRAINT fk_resume
--         FOREIGN KEY (resume_id)
--             REFERENCES Resume (resume_id)
--             ON DELETE CASCADE
-- );


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