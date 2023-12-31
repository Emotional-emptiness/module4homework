
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
    ('John Doe', '1990-01-15', 'Trainee', 800),
    ('Jane Smith', '1985-03-25', 'Junior', 1200),
    ('Maxim Ivanov', '1980-06-10', 'Middle', 2500),
    ('Anna Kovalenko', '1992-09-30', 'Senior', 6000),
    ('Michael Johnson', '1988-07-20', 'Trainee', 900),
    ('Sara Williams', '1995-05-12', 'Junior', 1300),
    ('Olga Petrova', '1987-04-03', 'Middle', 2800),
    ('Robert Davis', '1991-12-29', 'Senior', 6200),
    ('David Lee', '1993-10-15', 'Trainee', 850),
    ('Sophia Anderson', '1986-08-05', 'Junior', 1250);



INSERT INTO client (NAME) VALUES
     (1, '2023-01-01', '2023-03-01'),
    (2, '2023-02-01', '2023-04-01'),
    (3, '2023-03-01', '2023-05-01'),
    (4, '2023-04-01', '2023-06-01'),
    (5, '2023-05-01', '2023-07-01');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
     (1, '2023-01-01', '2023-03-01'),
    (2, '2023-02-01', '2023-04-01'),
    (3, '2023-03-01', '2023-05-01'),
    (4, '2023-04-01', '2023-06-01'),
    (5, '2023-05-01', '2023-07-01'),
    (6, '2023-06-01', '2023-08-01'),
    (7, '2023-07-01', '2023-09-01'),
    (8, '2023-08-01', '2023-10-01'),
    (9, '2023-09-01', '2023-11-01');



INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (3, 7),
    (4, 8),
    (4, 9),
    (5, 10),
    (6, 1),
    (6, 2),
    (7, 3),
    (7, 4),
    (8, 5),
    (9, 6),
    (9, 7),
    (10, 8),
    (10, 9),
    (10, 10);
