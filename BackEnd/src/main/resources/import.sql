-- Usuários
INSERT INTO usuario (nome, email, senha, tipo, especialidade) VALUES ('Ulisses Cliente', 'ulisses.cliente@email.com', '123456', 'CLIENTE', NULL);
INSERT INTO usuario (nome, email, senha, tipo, especialidade) VALUES ('Lais Cliente', 'lais@email.com', '123456', 'CLIENTE', NULL);
INSERT INTO usuario (nome, email, senha, tipo, especialidade) VALUES ('Dr. Felipe Profissional', 'felipe.profissional@email.com', '123456', 'PROFISSIONAL', 'Fisioterapeuta');
INSERT INTO usuario (nome, email, senha, tipo, especialidade) VALUES ('Dra. Ana Profissional', 'ana.profissional@email.com', '123456', 'PROFISSIONAL', 'Psicóloga');

-- Serviços
INSERT INTO servico (nome, descricao, duracao, preco) VALUES ('Sessão de Fisioterapia', 'Tratamento completo de fisioterapia com duração de 45 minutos.', 45, 120.00);
INSERT INTO servico (nome, descricao, duracao, preco) VALUES ('Atendimento Psicológico', 'Sessão de psicoterapia com duração de 60 minutos.', 60, 150.00);

-- Agendas
INSERT INTO agenda (profissional_id, hora_inicio, hora_fim, intervalo_inicio, intervalo_fim, tempo_tolerancia, dias_permitidos) VALUES (3, '08:00:00', '17:00:00', '12:00:00', '13:00:00', 10, 'MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY');
INSERT INTO agenda (profissional_id, hora_inicio, hora_fim, intervalo_inicio, intervalo_fim, tempo_tolerancia, dias_permitidos) VALUES (4, '09:00:00', '18:00:00', '12:30:00', '13:30:00', 15, 'MONDAY,WEDNESDAY,FRIDAY');

-- Agendamentos
INSERT INTO agendamento (cliente_id, profissional_id, servico_id, data_hora) VALUES (1, 3, 1, '2025-04-10T09:00:00');
INSERT INTO agendamento (cliente_id, profissional_id, servico_id, data_hora) VALUES (2, 4, 2, '2025-04-11T10:00:00');

-- Notificações
INSERT INTO notificacao (agendamento_id, mensagem, enviada) VALUES (1, 'Lembrete: Sessão de fisioterapia às 09:00 no dia 10/04.', TRUE);
INSERT INTO notificacao (agendamento_id, mensagem, enviada) VALUES (2, 'Lembrete: Sessão de psicoterapia às 10:00 no dia 11/04.', FALSE);
