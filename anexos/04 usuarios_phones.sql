CREATE TABLE public.usuarios_phones
(
    usuario_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phones_id integer NOT NULL,
    CONSTRAINT uk_ps7cvju8lvlx547lluxsvwjfu UNIQUE (phones_id),
    CONSTRAINT fk1nejpl9x03xjo07f8ukul4ui7 FOREIGN KEY (usuario_id)
        REFERENCES public.usuarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk5b6cyftei8qv18dkbtoh0qfak FOREIGN KEY (phones_id)
        REFERENCES public.phones (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.usuarios_phones
    OWNER to postgres;