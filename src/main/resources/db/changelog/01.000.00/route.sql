-- liquibase formatted sql
-- changeset aevsyukov_1@edu.hse.ru:2 logicalFilePath:01.000.00/route.sql
create table route
(
    id               uuid primary key,
    user_id          varchar references "user" (id),
    route_name       varchar,
    description      varchar,
    duration         time,
    length           bigint,
    start_point      varchar,
    end_point        varchar,
    route_preview    varchar,
    is_draft         boolean,
    last_modified_at timestamp,
    created_at       timestamp
);
-- rollback drop table route;