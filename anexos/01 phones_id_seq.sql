CREATE SEQUENCE public.phones_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.phones_id_seq
    OWNER TO postgres;