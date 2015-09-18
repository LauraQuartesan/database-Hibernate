CREATE TABLE cliente
(
  partita_iva numeric(15,0) NOT NULL,
  email character varying(32),
  nome character varying(32) NOT NULL,
  telefono character varying(30),
  indirizzo character varying(64),
  CONSTRAINT cliente_pkey PRIMARY KEY (partita_iva)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cliente
  OWNER TO postgres;

 CREATE TABLE ordine
(
  numero_fattura character varying(30) NOT NULL,
  cliente numeric(15,0),
  prezzo numeric(9,2) NOT NULL,
  data_ordine date NOT NULL,
  data_completamento date,
  CONSTRAINT ordine_pkey PRIMARY KEY (numero_fattura),
  CONSTRAINT fk_fxwj7jnjdexcrnps0954p65om FOREIGN KEY (cliente)
      REFERENCES cliente (partita_iva) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT ordine_prezzo_check CHECK (prezzo >= 0::numeric)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ordine
  OWNER TO postgres;

CREATE TABLE modello
(
  numero integer NOT NULL,
  cliente numeric(15,0),
  CONSTRAINT modello_pkey PRIMARY KEY (numero),
  CONSTRAINT fk_29mu4afcb2c1lnd0wicbpy7bl FOREIGN KEY (cliente)
      REFERENCES cliente (partita_iva) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE modello
  OWNER TO postgres;

CREATE TABLE tessuto
(
  codice integer NOT NULL,
  variante_colore character varying(32) NOT NULL,
  CONSTRAINT tessuto_pkey PRIMARY KEY (codice, variante_colore)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tessuto
  OWNER TO postgres;
  
CREATE TABLE filato
(
  titolo integer NOT NULL,
  codice_colore integer NOT NULL,
  fornitore character varying(32) NOT NULL,
  costo numeric(4,2) NOT NULL,
  CONSTRAINT filato_pkey PRIMARY KEY (titolo, codice_colore, fornitore),
  CONSTRAINT filato_costo_check CHECK (costo >= 0::numeric)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE filato
  OWNER TO postgres;
  
CREATE TABLE materiale
(
  id integer NOT NULL,
  CONSTRAINT materiale_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE materiale
  OWNER TO postgres;
  
CREATE TABLE articolo
(
  codice integer NOT NULL,
  ordine character varying(30),
  modello integer,
  materiale integer,
  tipo character varying(16) NOT NULL,
  quantita integer NOT NULL,
  lavorazione character varying(16),
  CONSTRAINT articolo_pkey PRIMARY KEY (codice),
  CONSTRAINT fk_38jxd94jascfc16vybewi9kyh FOREIGN KEY (materiale)
      REFERENCES materiale (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_t37cbhev5dj5at95nrlgjj9a5 FOREIGN KEY (ordine)
      REFERENCES ordine (numero_fattura) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tqk3oyhhxxbcltcjlnu0ap4l1 FOREIGN KEY (modello)
      REFERENCES modello (numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT articolo_quantita_check CHECK (quantita > 0)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE articolo
  OWNER TO postgres;
  
CREATE TABLE consegna
(
  data_consegna date NOT NULL,
  articolo integer NOT NULL,
  quantita_consegnata integer NOT NULL,
  corriere character varying(32) NOT NULL,
  completata boolean NOT NULL,
  CONSTRAINT consegna_pkey PRIMARY KEY (data_consegna, articolo),
  CONSTRAINT fk_sv1m6ws5mcpx03x30ym0n3cqc FOREIGN KEY (articolo)
      REFERENCES articolo (codice) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT consegna_quantita_consegnata_check CHECK (quantita_consegnata >= 0)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE consegna
  OWNER TO postgres;

CREATE TABLE fornisce_tessuto
(
  cliente numeric(15,0) NOT NULL,
  codice_tessuto integer NOT NULL,
  colore_tessuto character varying(32) NOT NULL,
  CONSTRAINT fornisce_tessuto_pkey PRIMARY KEY (cliente, codice_tessuto, colore_tessuto),
  CONSTRAINT fk_ltovg31m9rjhpl248daajh0dt FOREIGN KEY (cliente)
      REFERENCES cliente (partita_iva) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_scsfutfnef1dmgqj0poc3q8u0 FOREIGN KEY (codice_tessuto, colore_tessuto)
      REFERENCES tessuto (codice, variante_colore) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE fornisce_tessuto
  OWNER TO postgres;

CREATE TABLE costituito_da_tessuto
(
  materiale integer NOT NULL,
  codice_tessuto integer NOT NULL,
  colore_tessuto character varying(32) NOT NULL,
  CONSTRAINT costituito_da_tessuto_pkey PRIMARY KEY (materiale, codice_tessuto, colore_tessuto),
  CONSTRAINT fk_4jio3bl2wbam6tvf13annwbc7 FOREIGN KEY (materiale)
      REFERENCES materiale (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_gb8wpf7e0wmsmo8gbx9ym13l FOREIGN KEY (codice_tessuto, colore_tessuto)
      REFERENCES tessuto (codice, variante_colore) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE costituito_da_tessuto
  OWNER TO postgres;
  
CREATE TABLE costituito_da_filato
(
  materiale integer NOT NULL,
  titolo_filato integer NOT NULL,
  colore_filato integer NOT NULL,
  fornitore_filato character varying(32) NOT NULL,
  CONSTRAINT costituito_da_filato_pkey PRIMARY KEY (materiale, titolo_filato, colore_filato, fornitore_filato),
  CONSTRAINT fk_f9e8bbp5lbk1xh6t2si7jvgm6 FOREIGN KEY (materiale)
      REFERENCES materiale (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_hrsqlqpi8j6o8owyxbq2alj1q FOREIGN KEY (titolo_filato, colore_filato, fornitore_filato)
      REFERENCES filato (titolo, codice_colore, fornitore) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE costituito_da_filato
  OWNER TO postgres;