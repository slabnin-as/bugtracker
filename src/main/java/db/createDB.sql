DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO admin;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public IS 'standard public schema';

CREATE TYPE users_role AS ENUM('ADMIN', 'MANAGER', 'DEVELOPER');

CREATE TABLE public.users
(
    password character varying(32) COLLATE pg_catalog."default" NOT NULL,
    name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    login character varying(32) COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 100000 MINVALUE 100000 MAXVALUE 999999 CACHE 1 ),
    role users_role NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT login UNIQUE (login)
)