-- Usuários
INSERT INTO tb_usuario (nome, email, telefone, tipo_usuario) VALUES ('Ulisses Santana', 'ulisses.cliente@email.com', '11954292806', 'CLIENTE');
INSERT INTO tb_usuario (nome, email, telefone, tipo_usuario) VALUES ('Uelques Santana', 'uelques.admin@email.com', '77945452323', 'ADMIN');
INSERT INTO tb_usuario (nome, email, telefone, tipo_usuario) VALUES ('Lais Alves', 'lais.profissional@email.com', '11953416911', 'PROFISSIONAL');
INSERT INTO tb_usuario (nome, email, telefone, tipo_usuario) VALUES ('Luana Alves', 'luana.profissional@email.com', '11953415454', 'PROFISSIONAL');



INSERT INTO tb_profissional (usuario_id, especialidade, valor_hora) VALUES (3, 'Cabeleireira', 120.00);
INSERT INTO tb_profissional (usuario_id, especialidade, valor_hora) VALUES (4, 'Dentista', 200.00);


INSERT INTO tb_servicos (duracao, valor, profissional_id, nome) VALUES ('45 minutos',  120.00, 3, 'Corte de Cabelo');
INSERT INTO tb_servicos (duracao, valor, profissional_id, nome) VALUES ('30 minutos',   80.00, 3, 'Barba e Sobrancelha');
INSERT INTO tb_servicos (duracao, valor, profissional_id, nome) VALUES ('60 minutos', 150.00, 3, 'Corte + Hidratação');


INSERT INTO tb_servicos (duracao, valor, profissional_id, nome) VALUES ('30 minutos', 200.00, 4, 'Limpeza Dentária');
INSERT INTO tb_servicos (duracao, valor, profissional_id, nome) VALUES ('90 minutos', 500.00, 4, 'Canal');
INSERT INTO tb_servicos (duracao, valor, profissional_id, nome) VALUES ('60 minutos', 300.00, 4, 'Clareamento Dental');


INSERT INTO tb_agenda (DIAS_DISPONIVEIS, PROFISSIONAL_USUARIO_ID) VALUES ('{"seg": ["08:00", "12:00", "13:00", "17:00"], "ter": ["08:00", "12:00", "13:00", "17:00"], "qua": ["08:00", "12:00", "13:00", "17:00"], "qui": ["08:00", "12:00", "13:00", "17:00"], "sex": ["08:00", "12:00", "13:00", "17:00"], "sab": ["09:00", "12:00", "13:00", "16:00"]}', 3);
INSERT INTO tb_agenda (DIAS_DISPONIVEIS, PROFISSIONAL_USUARIO_ID) VALUES ('{"seg": ["07:00", "12:00", "13:00", "16:00"], "ter": ["09:00", "12:00", "13:00", "18:00"], "qua": ["08:00", "12:00", "13:00", "17:00"], "qui": ["08:00", "12:00", "13:00", "17:00"], "sex": ["07:30", "12:00", "13:00", "16:30"], "sab": ["08:00", "12:00", "13:00", "16:30"]}', 4);


INSERT INTO tb_agendamentos (DATA_HORA, PROFISSIONAL_ID, SERVICO_ID, USUARIO_ID, STATUS) VALUES ('2024-04-10 09:00:00', 3, 1, 1, 'CONCLUIDO');
INSERT INTO tb_agendamentos (DATA_HORA, PROFISSIONAL_ID, SERVICO_ID, USUARIO_ID, STATUS) VALUES ('2024-04-10 10:30:00', 3, 2, 2, 'CONFIRMADO');
INSERT INTO tb_agendamentos (DATA_HORA, PROFISSIONAL_ID, SERVICO_ID, USUARIO_ID, STATUS) VALUES ('2024-04-12 15:30:00', 3, 2, 3, 'CANCELADO');

INSERT INTO tb_agendamentos (DATA_HORA, PROFISSIONAL_ID, SERVICO_ID, USUARIO_ID, STATUS) VALUES ('2024-04-11 14:00:00', 4, 3, 1, 'CANCELADO');
INSERT INTO tb_agendamentos (DATA_HORA, PROFISSIONAL_ID, SERVICO_ID, USUARIO_ID, STATUS) VALUES ('2024-04-12 11:00:00', 4, 1, 2, 'CONFIRMADO');
INSERT INTO tb_agendamentos (DATA_HORA, PROFISSIONAL_ID, SERVICO_ID, USUARIO_ID, STATUS) VALUES ('2024-04-13 08:45:00', 4, 3, 3, 'CONCLUIDO');


INSERT INTO tb_notificacao (CANAL, DATA_HORA, AGENDAMENTOS_ID, MENSAGEM) VALUES (0, '2024-04-09 18:00:00', 1, 'Confirmação: Consulta agendada para 10/04 às 09:00 com Dra. Luana Alves');
INSERT INTO tb_notificacao (CANAL, DATA_HORA, AGENDAMENTOS_ID, MENSAGEM) VALUES (0, '2024-04-09 18:30:00', 2, 'Confirmação: Consulta agendada para 10/04 às 10:30 com Dra. Luana Alves');
INSERT INTO tb_notificacao (CANAL, DATA_HORA, AGENDAMENTOS_ID, MENSAGEM) VALUES (2, '2024-04-11 09:00:00', 3, 'Cancelamento: Consulta de 12/04 às 15:30 foi cancelada');
INSERT INTO tb_notificacao (CANAL, DATA_HORA, AGENDAMENTOS_ID, MENSAGEM) VALUES (2, '2024-04-10 10:00:00', 4, 'Cancelamento: Consulta de 11/04 às 14:00 foi cancelada');
INSERT INTO tb_notificacao (CANAL, DATA_HORA, AGENDAMENTOS_ID, MENSAGEM) VALUES (1, '2024-04-11 08:00:00', 5, 'Lembrete: Você tem consulta agendada para 12/04 às 11:00');
INSERT INTO tb_notificacao (CANAL, DATA_HORA, AGENDAMENTOS_ID, MENSAGEM) VALUES (0, '2024-04-12 19:00:00', 6, 'Confirmação: Consulta concluída em 13/04 às 08:45');

