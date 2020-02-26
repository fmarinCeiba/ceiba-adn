INSERT INTO status (DESCRIPTION) VALUES ('libre');
INSERT INTO status (DESCRIPTION) VALUES ('ocupado');
INSERT INTO status (DESCRIPTION) VALUES ('mantenimiento');
INSERT INTO status (DESCRIPTION) VALUES ('fuera de servicio');

INSERT INTO category (TYPE, AMOUNT, TIME) VALUES ('normal', 2000, 60);
INSERT INTO category (TYPE, AMOUNT, TIME) VALUES ('gamer', 4000, 60);
INSERT INTO category (TYPE, AMOUNT, TIME) VALUES ('edicion', 3000, 60);
INSERT INTO category (TYPE, AMOUNT, TIME) VALUES ('full internet', 2500, 60);

INSERT INTO client (NAME, IDENTIFICATION) VALUES ('francisco', '703045');

INSERT INTO computer (NAME, ID_STATUS, ID_CATEGORY, IP, MAC, LOCATION) VALUES ('PC1', 1, 1, '192.168.100.10', 'fe80::e554:b521:ee60:e1c9%9', 'frente al servidor');