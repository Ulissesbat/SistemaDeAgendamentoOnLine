-- Usuários
INSERT INTO tb_usuario (nome, email, telefone, tipo_usuario) VALUES ('Ulisses Santana', 'ulisses.cliente@email.com', '11954292806', 'CLIENTE');
INSERT INTO tb_usuario (nome, email, telefone, tipo_usuario) VALUES ('Uelques Santana', 'uelques.admin@email.com', '77945452323', 'ADMIN');
INSERT INTO tb_usuario (nome, email, telefone, tipo_usuario) VALUES ('Lais Alves', 'lais.profissional@email.com', '11953416911', 'PROFISSIONAL');



INSERT INTO tb_profissional (usuario_id, especialidade, valor_hora) VALUES (3, 'Cabeleireira', 120.00);
