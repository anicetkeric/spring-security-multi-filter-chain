
INSERT INTO app_role(id, code) VALUES (1, 'ROLE_ADMIN');
INSERT INTO app_role (id, code) VALUES (2, 'ROLE_GUEST');
INSERT INTO app_role (id, code) VALUES (3, 'ROLE_USER');

INSERT INTO app_user(id, username, password, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES (1, 'userdemo', 'jSN&9veq', true, false,false, false);
INSERT INTO app_user(id, username, password, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES (2, 'admin', 'B6=]ZHvb', true, false,false, false);

INSERT INTO role_user(role_id, user_id) VALUES (3, 1);
INSERT INTO role_user(role_id, user_id) VALUES (1, 2);
INSERT INTO role_user(role_id, user_id) VALUES (3, 2);
