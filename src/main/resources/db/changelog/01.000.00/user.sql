-- liquibase formatted sql
-- changeset aevsyukov_1@edu.hse.ru:1 logicalFilePath:01.000.00/user.sql
create table "user"
(
    id        varchar primary key,
    user_name varchar,
    email     varchar,
    password  varchar
)
-- rollback drop table "user";