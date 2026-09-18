CREATE DATABASE IF NOT EXISTS gestion_empleados;



USE gestion_empleados;

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(200) NOT NULL,
    departamento VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_baja TIMESTAMP,
    CHECK (salario > 0)
);