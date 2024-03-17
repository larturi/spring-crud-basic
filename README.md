# API REST con Spring Boot

### Local

1. Levantar la BD MySQL con Docker
```bash
docker-compose up -d
```

2. Crear la BD
```bash
CREATE TABLE `db_springboot_dev`.`clients` (
  `id` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `created_at` date  NOT NULL,
  PRIMARY KEY (`id`));
INSERT INTO clients (firstname, lastname, email, created_at) VALUES('Joel', 'Jurado', 'juradoec@yahoo.com', '2023-08-01');
INSERT INTO clients (firstname, lastname, email, created_at) VALUES('Carlos', 'Miranda', 'mirandaTr98@gmail.com', '2023-08-02');
INSERT INTO clients (firstname, lastname, email, created_at) VALUES('Marcela', 'Sanchez', 'schMarce@itb.com', '2023-08-03');
INSERT INTO clients (firstname, lastname, email, created_at) VALUES('Ben', 'Tennyson', 'ben10@cn.com', '2023-08-04');

ALTER TABLE clients 
CHANGE COLUMN created_at created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
```

3. Levantar con Maven
```bash
mvn clean install

mvn spring-boot:run
```


