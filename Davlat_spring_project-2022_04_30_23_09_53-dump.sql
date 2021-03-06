toc.dat                                                                                             0000600 0004000 0002000 00000014574 14233266542 0014461 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       5    	                z            Davlat_spring_project    14.0    14.0     	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                    0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                    1262    49004    Davlat_spring_project    DATABASE     t   CREATE DATABASE "Davlat_spring_project" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
 '   DROP DATABASE "Davlat_spring_project";
                postgres    false         ?            1259    70966 
   candidates    TABLE     J  CREATE TABLE public.candidates (
    candidate_id integer NOT NULL,
    account_name character varying(60) NOT NULL,
    email character varying(40) NOT NULL,
    age integer,
    status integer,
    resume_id integer,
    role_id integer,
    created_at date DEFAULT CURRENT_DATE,
    password character varying(100) NOT NULL
);
    DROP TABLE public.candidates;
       public         heap    postgres    false         ?            1259    70965    candidates_candidate_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.candidates_candidate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.candidates_candidate_id_seq;
       public          postgres    false    212                    0    0    candidates_candidate_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.candidates_candidate_id_seq OWNED BY public.candidates.candidate_id;
          public          postgres    false    211         ?            1259    70959    resume    TABLE       CREATE TABLE public.resume (
    resume_id integer NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(100) NOT NULL,
    education character varying(100) NOT NULL,
    phone character varying(100) NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);
    DROP TABLE public.resume;
       public         heap    postgres    false         ?            1259    70954    roles    TABLE     `   CREATE TABLE public.roles (
    id integer NOT NULL,
    role character varying(50) NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false         ?            1259    70983    vacancy    TABLE     ?   CREATE TABLE public.vacancy (
    vacancy_id integer NOT NULL,
    name character varying(100) NOT NULL,
    status integer NOT NULL,
    amount integer NOT NULL,
    candidate_id integer NOT NULL,
    created_at date DEFAULT CURRENT_DATE
);
    DROP TABLE public.vacancy;
       public         heap    postgres    false         i           2604    70969    candidates candidate_id    DEFAULT     ?   ALTER TABLE ONLY public.candidates ALTER COLUMN candidate_id SET DEFAULT nextval('public.candidates_candidate_id_seq'::regclass);
 F   ALTER TABLE public.candidates ALTER COLUMN candidate_id DROP DEFAULT;
       public          postgres    false    211    212    212                   0    70966 
   candidates 
   TABLE DATA                 public          postgres    false    212       3333.dat           0    70959    resume 
   TABLE DATA                 public          postgres    false    210       3331.dat           0    70954    roles 
   TABLE DATA                 public          postgres    false    209       3330.dat           0    70983    vacancy 
   TABLE DATA                 public          postgres    false    213       3334.dat            0    0    candidates_candidate_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.candidates_candidate_id_seq', 2, true);
          public          postgres    false    211         q           2606    70972    candidates candidates_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_pkey PRIMARY KEY (candidate_id);
 D   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_pkey;
       public            postgres    false    212         o           2606    70964    resume resume_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.resume
    ADD CONSTRAINT resume_pkey PRIMARY KEY (resume_id);
 <   ALTER TABLE ONLY public.resume DROP CONSTRAINT resume_pkey;
       public            postgres    false    210         m           2606    70958    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    209         s           2606    70988    vacancy vacancy_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT vacancy_pkey PRIMARY KEY (vacancy_id);
 >   ALTER TABLE ONLY public.vacancy DROP CONSTRAINT vacancy_pkey;
       public            postgres    false    213         v           2606    70989    vacancy fk_candidates    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT fk_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates(candidate_id) ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.vacancy DROP CONSTRAINT fk_candidates;
       public          postgres    false    3185    213    212         t           2606    70973    candidates fk_resume    FK CONSTRAINT     ?   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fk_resume FOREIGN KEY (resume_id) REFERENCES public.resume(resume_id) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.candidates DROP CONSTRAINT fk_resume;
       public          postgres    false    210    3183    212         u           2606    70978    candidates fk_role    FK CONSTRAINT     ?   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES public.roles(id) ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.candidates DROP CONSTRAINT fk_role;
       public          postgres    false    212    209    3181                                                                                                                                            3333.dat                                                                                            0000600 0004000 0002000 00000001521 14233266542 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.candidates (candidate_id, account_name, email, age, status, resume_id, role_id, created_at, password) VALUES (101, 'Davlat', 'dushurbakiev@gmail.com', 22, 1, NULL, 1, '2022-04-30', 'pass101');
INSERT INTO public.candidates (candidate_id, account_name, email, age, status, resume_id, role_id, created_at, password) VALUES (102, 'Raf', 'dushurbakiev@gmail.com', 22, 2, NULL, 2, '2022-04-30', 'pass102');
INSERT INTO public.candidates (candidate_id, account_name, email, age, status, resume_id, role_id, created_at, password) VALUES (103, 'Karim', 'dushurbakiev@gmail.com', 22, 3, NULL, 3, '2022-04-30', 'pass103');
INSERT INTO public.candidates (candidate_id, account_name, email, age, status, resume_id, role_id, created_at, password) VALUES (2, 'ushurbakiev', 'davlat.accdev@gmail.com', 19, 1, NULL, 1, '2022-04-30', 'qaz123');


                                                                                                                                                                               3331.dat                                                                                            0000600 0004000 0002000 00000001230 14233266542 0014246 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.resume (resume_id, name, description, education, phone, created_at) VALUES (101, 'PHP dev', 'Testing description php dev resume', 'IITU 3 course ITSE1909R group', '+77477782877', '2022-04-30');
INSERT INTO public.resume (resume_id, name, description, education, phone, created_at) VALUES (102, 'Kotlin jun dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group', '+77477782878', '2022-04-30');
INSERT INTO public.resume (resume_id, name, description, education, phone, created_at) VALUES (103, 'Kotlin middle dev', 'Testing description Kotlin dev resume', 'IITU 3 course ITSE1909R group', '+77477782879', '2022-04-30');


                                                                                                                                                                                                                                                                                                                                                                        3330.dat                                                                                            0000600 0004000 0002000 00000000256 14233266542 0014254 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.roles (id, role) VALUES (1, 'Admin');
INSERT INTO public.roles (id, role) VALUES (2, 'User');
INSERT INTO public.roles (id, role) VALUES (3, 'Manager');


                                                                                                                                                                                                                                                                                                                                                  3334.dat                                                                                            0000600 0004000 0002000 00000000661 14233266542 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.vacancy (vacancy_id, name, status, amount, candidate_id, created_at) VALUES (101, 'PHP', 1, 10000, 101, '2022-04-30');
INSERT INTO public.vacancy (vacancy_id, name, status, amount, candidate_id, created_at) VALUES (102, 'Kotlin jun', 1, 10000, 102, '2022-04-30');
INSERT INTO public.vacancy (vacancy_id, name, status, amount, candidate_id, created_at) VALUES (103, 'Kotlin middle', 1, 10000, 103, '2022-04-30');


                                                                               restore.sql                                                                                         0000600 0004000 0002000 00000012667 14233266542 0015407 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: candidates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidates (
    candidate_id integer NOT NULL,
    account_name character varying(60) NOT NULL,
    email character varying(40) NOT NULL,
    age integer,
    status integer,
    resume_id integer,
    role_id integer,
    created_at date DEFAULT CURRENT_DATE,
    password character varying(100) NOT NULL
);


ALTER TABLE public.candidates OWNER TO postgres;

--
-- Name: candidates_candidate_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.candidates_candidate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.candidates_candidate_id_seq OWNER TO postgres;

--
-- Name: candidates_candidate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.candidates_candidate_id_seq OWNED BY public.candidates.candidate_id;


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
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    role character varying(50) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

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
-- Name: candidates candidate_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates ALTER COLUMN candidate_id SET DEFAULT nextval('public.candidates_candidate_id_seq'::regclass);


--
-- Data for Name: candidates; Type: TABLE DATA; Schema: public; Owner: postgres
--

\i $$PATH$$/3333.dat

--
-- Data for Name: resume; Type: TABLE DATA; Schema: public; Owner: postgres
--

\i $$PATH$$/3331.dat

--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

\i $$PATH$$/3330.dat

--
-- Data for Name: vacancy; Type: TABLE DATA; Schema: public; Owner: postgres
--

\i $$PATH$$/3334.dat

--
-- Name: candidates_candidate_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.candidates_candidate_id_seq', 2, true);


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
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


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
-- Name: candidates fk_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES public.roles(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         