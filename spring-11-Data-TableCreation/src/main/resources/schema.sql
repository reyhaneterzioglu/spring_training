-- create table EMPLOYEES
-- (
--
--     id bigint not null,
--     name varchar(255),
--     primary key (id)
--
-- );

drop table if exists employees;
create table employees
(
    id   bigint not null,
    name varchar(255),
    primary key (id)

);