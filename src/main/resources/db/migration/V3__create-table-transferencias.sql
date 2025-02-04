CREATE TABLE transferencias (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                conta_destino VARCHAR(255),
                                conta_origem VARCHAR(255),
                                data_agendamento DATE,
                                data_transferencia DATE,
                                taxa DECIMAL(10,2),
                                valor DECIMAL(10,2)
);