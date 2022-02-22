
set foreign_key_check=0;

truncate table city;

INSERT INTO cities(id, city_name)
values (10, 'ABUJA')
(12, 'LAGOS'),
(14, 'IBADAN'),
(16, 'UYO'),
(17, 'PORTHARCOURt'),
(18, 'ENUGU'),
(20, 'ASABA'),
(21, 'KANO'),
(24, 'UMUAHIA'),
(25, 'ONITSHA'),
(28, 'ABA'),
(30, 'OWERRI');

set foreign_key_check=1;