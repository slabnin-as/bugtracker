DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO admin;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public IS 'standard public schema';

CREATE TYPE users_role AS ENUM('ADMIN', 'MANAGER', 'DEVELOPER');
CREATE TYPE issue_type AS ENUM('EPIC', 'STORY', 'TASK', 'BUG');
CREATE TYPE issue_state AS ENUM('OPEN','INPROGRESS','REVIEW','TEST','RESOLVED','REOPENED','CLOSE');

CREATE TABLE public.users
(
    password character varying(32) COLLATE pg_catalog."default" NOT NULL,
    name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    login character varying(32) COLLATE pg_catalog."default" UNIQUE NOT NULL,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 100000 MINVALUE 100000 MAXVALUE 999999 CACHE 1 ),
    role users_role NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.issues
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1000 MINVALUE 1000 MAXVALUE 9999 CACHE 1 ),
    project_id integer NOT NULL,
    parent_id integer,
    title character varying(45) NOT NULL,
    description character varying(45),
    reporter_id integer NOT NULL,
    assignee_id integer,
    type issue_type NOT NULL,
    state issue_state NOT NULL,
    create_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.projects
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1000 MINVALUE 1000 MAXVALUE 9999 CACHE 1 ),
    title character varying(45) NOT NULL,
    department character varying(45) NOT NULL,
    owner_id integer NOT NULL,
    admin_id integer NOT NULL,
    create_date date NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.projects ADD CONSTRAINT user_id FOREIGN KEY (owner_id) REFERENCES public.users (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
ALTER TABLE public.issues ADD CONSTRAINT project_id FOREIGN KEY (project_id) REFERENCES public.projects (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;