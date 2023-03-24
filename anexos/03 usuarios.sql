CREATE TABLE public.usuarios
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_at timestamp without time zone,
    email character varying(50) COLLATE pg_catalog."default",
    is_active boolean,
    last_login timestamp without time zone,
    modified_at timestamp without time zone,
    name character varying(30) COLLATE pg_catalog."default",
    password character varying(60) COLLATE pg_catalog."default",
    token character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuarios_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.usuarios
    OWNER to postgres;