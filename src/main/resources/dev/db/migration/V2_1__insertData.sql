-- Insert data in "user"
INSERT INTO "user" (id, username, password, email, created_at)
VALUES
    (DEFAULT, 'john_doe', 'password123', 'john.doe@example.com', CURRENT_TIMESTAMP),
    (DEFAULT, 'alice_wonder', 'wonderland456', 'alice.wonder@example.com', CURRENT_TIMESTAMP),
    (DEFAULT, 'bob_smith', 'secret789', 'bob.smith@example.com', CURRENT_TIMESTAMP),
    (DEFAULT, 'emma_jones', 'emma123', 'emma.jones@example.com', CURRENT_TIMESTAMP),
    (DEFAULT, 'peter_pan', 'neverland456', 'peter.pan@example.com', CURRENT_TIMESTAMP);

-- Insert data in "user_detail"
INSERT INTO user_detail (id, first_name, last_name, age, birth_day, user_id)
VALUES
    (DEFAULT, 'John', 'Doe', 30, '1992-05-15', 1),
    (DEFAULT, 'Alice', 'Wonder', 25, '1997-02-20', 2),
    (DEFAULT, 'Bob', 'Smith', 28, '1994-09-10', 3),
    (DEFAULT, 'Emma', 'Jones', 35, '1988-12-05', 4),
    (DEFAULT, 'Peter', 'Pan', 22, '2001-07-30', 5);

-- Insert data in "rol"
INSERT INTO rol (id, name)
VALUES
    (DEFAULT, 'Admin'),
    (DEFAULT, 'Editor'),
    (DEFAULT, 'Viewer'),
    (DEFAULT, 'Moderator'),
    (DEFAULT, 'Guest');

-- Insert data in "user_rol"
INSERT INTO user_rol (user_id, rol_id, active, created_at)
VALUES
    (1, 1, true, CURRENT_TIMESTAMP),
    (2, 2, true, CURRENT_TIMESTAMP),
    (3, 3, true, CURRENT_TIMESTAMP),
    (4, 1, true, CURRENT_TIMESTAMP),
    (5, 3, true, CURRENT_TIMESTAMP);

-- Insert data in "permission"
INSERT INTO permission (id, name, description, created_at)
VALUES
    (DEFAULT, 'READ_POST', 'Permission to read posts', CURRENT_TIMESTAMP),
    (DEFAULT, 'WRITE_POST', 'Permission to write posts', CURRENT_TIMESTAMP),
    (DEFAULT, 'DELETE_POST', 'Permission to delete posts', CURRENT_TIMESTAMP),
    (DEFAULT, 'EDIT_PROFILE', 'Permission to edit user profile', CURRENT_TIMESTAMP),
    (DEFAULT, 'VIEW_DASHBOARD', 'Permission to view the dashboard', CURRENT_TIMESTAMP);

-- Insert data in "rol_permission"
INSERT INTO rol_permission (id, rol_id, permission_id, created_at)
VALUES
    (DEFAULT, 1, 1, CURRENT_TIMESTAMP),
    (DEFAULT, 2, 2, CURRENT_TIMESTAMP),
    (DEFAULT, 3, 3, CURRENT_TIMESTAMP),
    (DEFAULT, 4, 4, CURRENT_TIMESTAMP),
    (DEFAULT, 5, 5, CURRENT_TIMESTAMP);