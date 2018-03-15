CREATE TABLE public.transaction
(
    txn_id integer NOT NULL,
    txn_date date,
    amount integer,
    CONSTRAINT transaction_pkey PRIMARY KEY (txn_id)
);

CREATE TABLE public.customer
(
    txn_id integer NOT NULL,
    cust_name character varying COLLATE pg_catalog."default" NOT NULL,
    cust_mail character varying COLLATE pg_catalog."default",
    cust_cont character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (txn_id),
    CONSTRAINT customer_txn FOREIGN KEY (txn_id)
        REFERENCES public.transaction (txn_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

