
CREATE TABLE persons (
                         id BIGINT NOT NULL PRIMARY KEY,
                         first_name TEXT,
                         last_name TEXT,
                         email TEXT,
                         team TEXT,
                         created_at TIMESTAMP NOT NULL
);

CREATE TABLE notes (
                       id BIGINT NOT NULL PRIMARY KEY,
                       body TEXT,
                       created_at TIMESTAMP NOT NULL,
                       person_id BIGINT,
                       FOREIGN KEY (person_id) REFERENCES persons(id)
);

SELECT * FROM

    INSERT INTO persons (id, first_name, last_name, email, team, created_at)
VALUES
    (1, 'John', 'Doe', 'johndoe@example.com', 'Marketing', '2021-06-15 12:34:56'),
    (2, 'Jane', 'Doe', 'janedoe@example.com', 'Sales', '2020-09-23 09:23:45'),
    (3, 'Bob', 'Smith', 'bobsmith@example.com', 'Engineering', '2022-01-01 00:00:00'),
    (4, 'Alice', 'Johnson', 'alicejohnson@example.com', 'HR', '2021-11-11 11:11:11'),
    (5, 'Tom', 'Jones', 'tomjones@example.com', 'Operations', '2020-12-31 23:59:59');

-- generate notes for John Doe (id = 1)
INSERT INTO notes (id, body, created_at, person_id)
VALUES
    (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '2021-06-15 12:45:00', 1),
    (2, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2021-06-17 10:23:45', 1),
    (3, 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2021-06-20 15:30:00', 1),
    (4, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2021-07-01 09:15:30', 1),
    (5, 'Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '2021-07-10 14:00:00', 1),
    (6, 'Mauris euismod leo nec nibh sagittis, a consequat ex elementum.', '2021-07-20 11:45:00', 1);

-- generate notes for Jane Doe (id = 2)
INSERT INTO notes (id, body, created_at, person_id)
VALUES
    (7, 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.', '2020-09-25 16:30:00', 2),
    (8, 'Nulla facilisi. Etiam vel varius dolor, at posuere nisi.', '2020-10-01 09:15:00', 2),
    (9, 'Vivamus at justo eget quam tempor suscipit.', '2020-10-05 14:30:00', 2),
    (10, 'In hac habitasse platea dictumst. Sed eget dapibus ipsum, a luctus orci.', '2020-10-10 11:00:00', 2),
    (11, 'Nam eleifend odio et elit rhoncus, in mollis elit dapibus.', '2020-10-15 15:45:00', 2);

-- generate notes for Bob Smith (id = 3)
INSERT INTO notes (id, body, created_at, person_id)
VALUES
    (14, 'Aliquam tincidunt velit et nisi ullamcorper, eu iaculis lacus sagittis.', '2022-01-10 08:45:00', 3),
    (15, 'Nunc pharetra metus in lacus ultrices, at blandit sapien lacinia.', '2022-01-15 11:15:00', 3),
    (16, 'Proin bibendum imperdiet mauris quis rutrum.', '2022-01-20 14:30:00', 3),
    (17, 'Donec commodo, odio ut iaculis efficitur, velit dolor consequat velit, a sagittis augue lacus a quam.', '2022-01-25 10:00:00', 3),
    (18, 'Vestibulum consectetur elit sit amet efficitur facilisis.', '2022-01-30 16:15:00', 3);

-- generate notes for Alice Johnson (id = 4)
INSERT INTO notes (id, body, created_at, person_id)
VALUES
    (19, 'Morbi quis justo nec ipsum fermentum dignissim.', '2021-11-30 09:30:00', 4),
    (20, 'Nam eu felis id nisl dictum iaculis.', '2021-12-10 14:45:00', 4),
    (21, 'Curabitur id ligula facilisis, suscipit dolor nec, sagittis lorem.', '2021-12-15 11:00:00', 4),
    (22, 'Suspendisse aliquam dui vel mauris hendrerit ultricies.', '2022-01-02 13:30:00', 4),
    (23, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce semper.', '2022-01-10 16:45:00', 4),
    (24, 'Nulla facilisi. Nunc pulvinar risus id odio dapibus, vel cursus augue placerat.', '2022-01-20 08:15:00', 4),
    (25, 'Praesent ultrices massa a luctus imperdiet.', '2022-01-25 10:00:00', 4);

-- generate notes for Bob Brown (id = 5)
INSERT INTO notes (id, body, created_at, person_id)
VALUES
    (26, 'Donec pharetra mi nec leo malesuada euismod.', '2020-09-15 11:30:00', 5),
    (27, 'Maecenas bibendum eros sed nunc scelerisque, in laoreet velit pulvinar.', '2020-09-20 15:00:00', 5),
    (28, 'Quisque lobortis quam vel mi fringilla, ac rutrum neque posuere.', '2020-09-25 12:45:00', 5),
    (29, 'Nullam vehicula elit sit amet elit tempus convallis.', '2020-10-01 14:00:00', 5),
    (30, 'Morbi semper justo eget nibh ullamcorper, in finibus turpis consectetur.', '2020-10-05 16:15:00', 5),
    (31, 'Aliquam volutpat purus nec metus facilisis, at vestibulum neque viverra.', '2020-10-10 10:30:00', 5),
    (32, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce semper arcu in sapien rutrum, eget dignissim leo rhoncus.', '2020-10-15 13:45:00', 5),
    (33, 'Nam ac nulla sed diam luctus interdum.', '2020-10-20 09:00:00', 5),
    (34, 'In mollis purus ac mi eleifend, sed pharetra ante dictum.', '2020-10-25 12:30:00', 5);




