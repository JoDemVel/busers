CREATE TABLE "user"(
    id          BIGINT PRIMARY KEY,
    username    VARCHAR(150) NOT NULL,
    password    VARCHAR(150) NOT NULL,
    email       VARCHAR(150) UNIQUE NOT NULL,
    created_at  TIMESTAMP
);

CREATE SEQUENCE user_sequence AS BIGINT INCREMENT 1;

ALTER TABLE "user" ALTER COLUMN id SET DEFAULT nextval('user_sequence');

CREATE TABLE user_detail(
    id          BIGINT PRIMARY KEY,
    first_name  VARCHAR(100) NOT NULL,
    last_name   VARCHAR(100) NOT NULL,
    age         INTEGER,
    birth_day   DATE,
    user_id     BIGINT UNIQUE
);

ALTER TABLE user_detail ADD CONSTRAINT fk_user_detail_ref_user FOREIGN KEY (user_id)
    REFERENCES "user" (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE SEQUENCE user_detail_sequence AS BIGINT INCREMENT 1;

ALTER TABLE user_detail ALTER COLUMN id SET DEFAULT nextval('user_detail_sequence');

CREATE TABLE rol(
    id      INTEGER PRIMARY KEY,
    name    VARCHAR(100) NOT NULL
);

CREATE SEQUENCE rol_sequence AS INTEGER INCREMENT 1;

ALTER TABLE rol ALTER COLUMN id SET DEFAULT nextval('rol_sequence');

CREATE TABLE user_rol(
    user_id     BIGINT NOT NULL,
    rol_id      INTEGER NOT NULL,
    active      BOOLEAN NOT NULL,
    created_at  TIMESTAMP,
    PRIMARY KEY (user_id, rol_id),
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);