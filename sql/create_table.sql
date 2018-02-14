CREATE TABLE nome (
	id BIGSERIAL PRIMARY KEY,
	prefixo TEXT,
	primeiro_nome TEXT NOT NULL,
	nomes_do_meio TEXT,
	sobrenome TEXT NOT NULL,
	sufixo TEXT);
CREATE TABLE endereco (
	id BIGSERIAL PRIMARY KEY,
	logradouro TEXT NOT NULL,
	numero INT NOT NULL,
	bairro TEXT NOT NULL,
	complemento TEXT);
CREATE TABLE telefone (
	id BIGSERIAL PRIMARY KEY,
	ddd INT NOT NULL,
	numero TEXT NOT NULL);
CREATE TABLE contribuinte (
	id BIGSERIAL PRIMARY KEY,
	nome_id BIGINT REFERENCES nome(id),
	endereco_id BIGINT REFERENCES endereco(id),
	telefone_id BIGINT REFERENCES telefone(id));
