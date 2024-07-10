-- Usar la base de datos creada
USE demoreserva;

-- Crear la tabla para usuarios
CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    user_type VARCHAR(50),
    password VARCHAR(255) NOT NULL,
    email_verified TINYINT(1) DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY email_unique (email)
);

-- Crear la tabla para habitaciones
CREATE TABLE rooms (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    photo VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50),
    PRIMARY KEY (id)
);

-- Crear la tabla para reservas
CREATE TABLE reservations (
    id BIGINT NOT NULL AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    user_id BIGINT NOT NULL,
    room_id BIGINT NOT NULL,
    total DECIMAL(10, 2),
    total_to_pay DECIMAL(10, 2),
    status VARCHAR(50),
    notified TINYINT(1) DEFAULT 0,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

