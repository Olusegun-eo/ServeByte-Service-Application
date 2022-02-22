create database serveByte;

create user 'serv_byte_user'@'localhost' identified by 'Servebyte@123';
grant all privileges on serveByte.* to 'serv_byte_user'@'localhost';
flush privileges;
