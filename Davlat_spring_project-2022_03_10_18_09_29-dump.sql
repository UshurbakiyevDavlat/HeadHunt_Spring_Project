toc.dat                                                                                             0000600 0004000 0002000 00000011007 14212365171 0014440 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP           	        
        z            Davlat_spring_project    14.0    14.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                     0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                    1262    49004    Davlat_spring_project    DATABASE     t   CREATE DATABASE "Davlat_spring_project" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
 '   DROP DATABASE "Davlat_spring_project";
                postgres    false                     2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false                    0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3         �            1259    60728 
   candidates    TABLE     "  CREATE TABLE public.candidates (
    candidate_id integer NOT NULL,
    account_name character varying(60) NOT NULL,
    email character varying(40) NOT NULL,
    age integer NOT NULL,
    status integer NOT NULL,
    resume_id integer NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);
    DROP TABLE public.candidates;
       public         heap    postgres    false    3         �            1259    60722    resume    TABLE       CREATE TABLE public.resume (
    resume_id integer NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(100) NOT NULL,
    education character varying(100) NOT NULL,
    phone character varying(100) NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);
    DROP TABLE public.resume;
       public         heap    postgres    false    3         �            1259    60739    vacancy    TABLE     �   CREATE TABLE public.vacancy (
    vacancy_id integer NOT NULL,
    name character varying(100) NOT NULL,
    status integer NOT NULL,
    amount integer NOT NULL,
    candidate_id integer NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);
    DROP TABLE public.vacancy;
       public         heap    postgres    false    3         �          0    60728 
   candidates 
   TABLE DATA                 public          postgres    false    210       3322.dat �          0    60722    resume 
   TABLE DATA                 public          postgres    false    209       3321.dat �          0    60739    vacancy 
   TABLE DATA                 public          postgres    false    211       3323.dat i           2606    60733    candidates candidates_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_pkey PRIMARY KEY (candidate_id);
 D   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_pkey;
       public            postgres    false    210         g           2606    60727    resume resume_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.resume
    ADD CONSTRAINT resume_pkey PRIMARY KEY (resume_id);
 <   ALTER TABLE ONLY public.resume DROP CONSTRAINT resume_pkey;
       public            postgres    false    209         k           2606    60744    vacancy vacancy_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT vacancy_pkey PRIMARY KEY (vacancy_id);
 >   ALTER TABLE ONLY public.vacancy DROP CONSTRAINT vacancy_pkey;
       public            postgres    false    211         m           2606    60745    vacancy fk_candidates    FK CONSTRAINT     �   ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT fk_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates(candidate_id) ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.vacancy DROP CONSTRAINT fk_candidates;
       public          postgres    false    210    3177    211         l           2606    60734    candidates fk_resume    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fk_resume FOREIGN KEY (resume_id) REFERENCES public.resume(resume_id) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.candidates DROP CONSTRAINT fk_resume;
       public          postgres    false    210    209    3175                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 3322.dat                                                                                            0000600 0004000 0002000 00000001010 14212365171 0014235 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.candidates (candidate_id, account_name, email, age, status, resume_id, created_at) VALUES (1, 'Davlat', 'dushurbakiev@gmail.com', 22, 1, 1, '2022-03-10');
INSERT INTO public.candidates (candidate_id, account_name, email, age, status, resume_id, created_at) VALUES (2, 'Raf', 'dushurbakiev@gmail.com', 22, 2, 1, '2022-03-10');
INSERT INTO public.candidates (candidate_id, account_name, email, age, status, resume_id, created_at) VALUES (3, 'Karim', 'dushurbakiev@gmail.com', 22, 3, 1, '2022-03-10');


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        3321.dat                                                                                            0000600 0004000 0002000 00000001222 14212365171 0014241 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.resume (resume_id, name, description, education, phone, created_at) VALUES (1, 'PHP dev', 'Testing description php dev resume', 'IITU 3 course ITSE1909R group', '+77477782877', '2022-03-10');
INSERT INTO public.resume (resume_id, name, description, education, phone, created_at) VALUES (2, 'Kotlin jun dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group', '+77477782878', '2022-03-10');
INSERT INTO public.resume (resume_id, name, description, education, phone, created_at) VALUES (3, 'Kotlin middle dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group', '+77477782879', '2022-03-10');


                                                                                                                                                                                                                                                                                                                                                                              3323.dat                                                                                            0000600 0004000 0002000 00000000645 14212365171 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.vacancy (vacancy_id, name, status, amount, candidate_id, created_at) VALUES (1, 'PHP', 1, 10000, 1, '2022-03-10');
INSERT INTO public.vacancy (vacancy_id, name, status, amount, candidate_id, created_at) VALUES (2, 'Kotlin jun', 1, 10000, 2, '2022-03-10');
INSERT INTO public.vacancy (vacancy_id, name, status, amount, candidate_id, created_at) VALUES (3, 'Kotlin middle', 1, 10000, 3, '2022-03-10');


                                                                                           restore.sql                                                                                         0000600 0004000 0002000 00000010124 14212365171 0015364 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "Davlat_spring_project";
--
-- Name: Davlat_spring_project; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Davlat_spring_project" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE "Davlat_spring_project" OWNER TO postgres;

\connect "Davlat_spring_project"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: candidates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidates (
    candidate_id integer NOT NULL,
    account_name character varying(60) NOT NULL,
    email character varying(40) NOT NULL,
    age integer NOT NULL,
    status integer NOT NULL,
    resume_id integer NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);


ALTER TABLE public.candidates OWNER TO postgres;

--
-- Name: resume; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resume (
    resume_id integer NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(100) NOT NULL,
    education character varying(100) NOT NULL,
    phone character varying(100) NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);


ALTER TABLE public.resume OWNER TO postgres;

--
-- Name: vacancy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vacancy (
    vacancy_id integer NOT NULL,
    name character varying(100) NOT NULL,
    status integer NOT NULL,
    amount integer NOT NULL,
    candidate_id integer NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);


ALTER TABLE public.vacancy OWNER TO postgres;

--
-- Data for Name: candidates; Type: TABLE DATA; Schema: public; Owner: postgres
--

\i $$PATH$$/3322.dat

--
-- Data for Name: resume; Type: TABLE DATA; Schema: public; Owner: postgres
--

\i $$PATH$$/3321.dat

--
-- Data for Name: vacancy; Type: TABLE DATA; Schema: public; Owner: postgres
--

\i $$PATH$$/3323.dat

--
-- Name: candidates candidates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_pkey PRIMARY KEY (candidate_id);


--
-- Name: resume resume_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume
    ADD CONSTRAINT resume_pkey PRIMARY KEY (resume_id);


--
-- Name: vacancy vacancy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT vacancy_pkey PRIMARY KEY (vacancy_id);


--
-- Name: vacancy fk_candidates; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT fk_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates(candidate_id) ON DELETE CASCADE;


--
-- Name: candidates fk_resume; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fk_resume FOREIGN KEY (resume_id) REFERENCES public.resume(resume_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            