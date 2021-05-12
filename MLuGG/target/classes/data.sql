insert into PERSON_TBL (id, username, password, role) values (1, 'Leida', '$2y$12$9nwrDKpfzv2y0GYQ6SP1t.bFRJ92Je70.wGIEK6ymeEsfNbiis.MO', 'USER');
insert into PERSON_TBL (id, username, password, role) values (2, 'Amanda', '$2y$12$CbIHUpVIbqdZfhvxH0b7vuKVc8/dElGI7QjIysT/W43Yo4at58tLm', 'USER');
insert into PERSON_TBL (id, username, password, role) values (3, 'Roberta', '$2y$12$POOjKOr/wsyRzopxWUyCTOlYvAzqEKb1BMPZFpsQCez6ZoVkXV2U6', 'ADMIN');


insert into PRODUCT_TBL (id, product, obs, state, costperday, costperhour) values (1, 'Caixas de Som', 'Precisa de Manutenção após o serviço', 'Funcional', '150.00', '19.00');
insert into PRODUCT_TBL (id, product, obs, state, costperday, costperhour) values (2, 'Equipamento de Som Completo', 'Precisa de Manutenção após o serviço', 'Funcional', '250.00', '32.00');
insert into PRODUCT_TBL (id, product, obs, state, costperday, costperhour) values (3, 'Kit Apresentação', 'Precisa de Instalação Profissional', 'Funcional', '300.00', '38.00');


insert into CLIENT_TBL (id, name, uf, city, street, complement, number, cep, phonenumber) values (1, 'Qiron', 'RS', 'Santa Maria', 'Av. Roraima', 'Camobi, Prédio 2','11', '98000000', '(55) 3220-8836');
insert into CLIENT_TBL (id, name, uf, city, street, complement, number, cep, phonenumber) values (2, 'UFSM', 'RS', 'Santa Maria', 'Av. Roraima', 'Camobi, Reitoria','11', '98000000', '(55) 3220-1111');
insert into CLIENT_TBL (id, name, uf, city, street, complement, number, cep, phonenumber) values (3, 'UFN', 'RS', 'Santa Maria', 'R. dos Andradas', 'Centro','1614', '97010030', '(55) 3220-1200');