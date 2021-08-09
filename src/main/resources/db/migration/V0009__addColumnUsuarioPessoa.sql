ALTER TABLE pessoas
ADD COLUMN usuario_id BIGINT NOT NULL DEFAULT 0;

ALTER TABLE pessoas ADD CONSTRAINT  fk_usuario_pessoa
FOREIGN KEY (usuario_id) REFERENCES usuario (id);