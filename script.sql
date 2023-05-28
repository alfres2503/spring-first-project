CREATE DATABASE examplespringdb;

USE examplespringdb;

create table users
(
    id        int          not null
        primary key,
    name      varchar(255) not null,
    last_name varchar(255) not null,
    email     varchar(255) not null,
    phone     varchar(255) not null,
    password  varchar(255) not null,
    constraint email
        unique (email),
    constraint phone
        unique (phone)
);


