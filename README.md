# Desarrolla tu primera API REST desde cero con Spring Boot aplicando buenas practicas

## Este proyecto tiene la configuración y desarrollo necesario para que comiences a crear tu primera API REST desde cero con Spring Boot aplicando buenas practicas para potenciar tus proyectos.

## Script de la base de datos

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
```