CREATE TABLE frequencia(
    id bigint not null auto_increment,
    status BOOLEAN,
    aluno bigint not null,
    PRIMARY KEY(id)
);

ALTER TABLE frequencia ADD CONSTRAINT fk_aluno
FOREIGN KEY (aluno) REFERENCES alunos(id);

