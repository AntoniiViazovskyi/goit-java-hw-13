
INSERT INTO Client(name)
VALUES
    ('Jack'),
    ('Bill'),
    ('Mary'),
    ('Jade'),
    ('Ken'),
    ('Mark'),
    ('Anne'),
    ('Leo'),
    ('Barbara'),
    ('Mike');

INSERT INTO Planet(name)
VALUES
    ('MARS'),
    ('EARTH'),
    ('MOON'),
    ('JUPITER'),
    ('NEPTUNE');

INSERT INTO Ticket(created_at,client_id,from_planet_id,to_planet_id)
VALUES
    ('2021-10-09 10:00:00',9,1,2),
    ('2022-05-01 12:30:00',2,2,5),
    ('2024-06-26 22:10:00',10,4,3),
    ('2019-11-19 12:00:00',8,2,1),
    ('2020-01-07 18:45:00',5,5,4),
    ('2022-03-11 12:10:00',4,3,2),
    ('2023-06-17 16:00:00',7,4,2),
    ('2021-09-20 21:00:00',1,2,5),
    ('2024-11-01 14:20:00',3,1,3),
    ('2020-12-24 06:30:00',6,2,4);
