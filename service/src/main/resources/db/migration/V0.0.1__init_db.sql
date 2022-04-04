create table user_info
(
    id        bigserial primary key not null,
    user_uuid uuid unique           not null,
    rate      real,
    active    boolean               not null default true
);

create table user_work_record
(
    id         bigserial primary key not null,
    user_uuid  uuid unique           not null,
    start_time timestamptz           not null,
    end_time   timestamptz
);
