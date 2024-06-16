CREATE TABLE IF NOT EXISTS holdings
(
    id character varying(255) NOT NULL,
    amount_held integer NOT NULL,
    share_id character varying(255) NOT NULL,
    CONSTRAINT holdings_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS portfolios
(
    id character varying(255) NOT NULL,
    cash double precision,
    CONSTRAINT portfolios_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS portfolios_holdings
(
    portfolio_ent_id character varying(255) NOT NULL,
    holdings_id character varying(255) NOT NULL,
    CONSTRAINT ukt6n2c4wew4q6lrka24esfilqs UNIQUE (holdings_id),
    CONSTRAINT fk94lwx6spc1dmgiyp07355wika FOREIGN KEY (holdings_id)
        REFERENCES public.holdings (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkj7akgi1vy8q3asblq5fvntwhn FOREIGN KEY (portfolio_ent_id)
        REFERENCES public.portfolios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)