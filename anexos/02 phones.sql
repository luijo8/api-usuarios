CREATE TABLE public.phones
(
    id integer NOT NULL DEFAULT nextval('phones_id_seq'::regclass),
    city_code integer,
    conutry_code integer,
    "number" integer,
    CONSTRAINT phones_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.phones
    OWNER to postgres;