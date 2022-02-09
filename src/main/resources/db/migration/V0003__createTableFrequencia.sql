CREATE TABLE frequencia(
    id bigint not null auto_increment,
    status Boolean not null,
    id_aluno bigint not null,
    PRIMARY KEY(id)
);

ALTER TABLE frequencia ADD CONSTRAINT fk_id_aluno
FOREIGN KEY (id_aluno) REFERENCES alunos(id);

