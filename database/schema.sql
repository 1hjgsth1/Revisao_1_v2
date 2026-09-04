CREATE TABLE IF NOT EXISTS caixa_da_agua (
                                             id serial PRIMARY KEY,
                                             marca varchar,
                                             modelo varchar,
                                             dimensao double precision[],
                                             cor varchar,
                                             material varchar,
                                             formato varchar,
                                             preco varchar
);

CREATE TABLE IF NOT EXISTS movimentacao (
                                            id serial PRIMARY KEY,
                                            valor varchar,
                                            data_movimentacao date,
                                            descricao varchar
);

SELECT * FROM movimentacao;