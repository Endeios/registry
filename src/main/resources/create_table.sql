CREATE TABLE IF NOT EXISTS public.car_records
(
    model text   NOT NULL,
    brand text   NOT NULL,
    plate text   NOT NULL,
    year  bigint NOT NULL,
    id    bigserial  NOT NULL

);
ALTER TABLE
    public.car_records
    ADD
        CONSTRAINT car_records_pkey PRIMARY KEY (id)