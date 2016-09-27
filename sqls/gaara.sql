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