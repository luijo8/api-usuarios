INSERT INTO phones (city_code, conutry_code, number) values (1, 56, 949034118);

INSERT INTO usuarios (create_at, email, is_active, last_login, modified_at, name, password, token, id) values (NOW(), 'admin@dominio.cl', true, NOW(), NOW(), 'User Admin', 'admin123*', '71fb3f2c-6de2-30c6-bb95-a7c2f330ce4d', '726ea0dd-9986-38e8-a87f-8e344d373533');

INSERT INTO usuarios_phones (usuario_id, phones_id) values ('726ea0dd-9986-38e8-a87f-8e344d373533', 1);