CREATE TABLE items (
  id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name VARCHAR(32) NOT NULL,
  price INTEGER NOT NULL
);

INSERT INTO items (name, price) VALUES ('apple', 150);
INSERT INTO items (name, price) VALUES ('orange', 300);
INSERT INTO items (name, price) VALUES ('banana', 250);
