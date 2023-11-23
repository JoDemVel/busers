CREATE TABLE permission(
    id          INTEGER PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    created_at  TIMESTAMP
);

CREATE SEQUENCE permission_sequence AS INTEGER INCREMENT 1;

ALTER TABLE permission ALTER COLUMN id SET DEFAULT nextval('permission_sequence');

CREATE TABLE rol_permission(
    id INTEGER PRIMARY KEY,
    rol_id INTEGER NOT NULL,
    permission_id INTEGER NOT NULL,
    created_at TIMESTAMP
);

ALTER TABLE rol_permission ADD CONSTRAINT fk_rol_permission_ref_rol FOREIGN KEY (rol_id)
    REFERENCES rol (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE rol_permission ADD CONSTRAINT fk_rol_permission_ref_permission FOREIGN KEY (permission_id)
    REFERENCES permission (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE SEQUENCE rol_permission_sequence AS INTEGER INCREMENT 1;

ALTER TABLE rol_permission ALTER COLUMN id SET DEFAULT nextval('rol_permission_sequence');