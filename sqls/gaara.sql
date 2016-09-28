CREATE TABLE client(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(id),
  client_id VARCHAR(255) NOT NULL,
  client_secret VARCHAR(255) NOT NULL,
  redirect_uri VARCHAR(255) NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  is_disabled BIT DEFAULT 0
);

CREATE TABLE user(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  user_id VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  nickname VARCHAR(50) NOT NULL,
  is_disabled BIT DEFAULT 0
);

CREATE TABLE access_token(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  client_id VARCHAR(255) NOT NULL,
  user_id VARCHAR(50) NOT NULL,
  access_token VARCHAR(255) NOT NULL,
  expire_in LONG NOT NULL,
  refresh_token VARCHAR(255) NOT NULL,
  is_available BIT DEFAULT 0,
  create_time DATE NOT NULL
);

CREATE TABLE auth_code(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  client_id VARCHAR(255) NOT NULL,
  user_id VARCHAR(50) NOT NULL,
  auth_code VARCHAR(255) NOT NULL,
  is_available BIT DEFAULT 0,
  create_time DATE NOT NULL
);