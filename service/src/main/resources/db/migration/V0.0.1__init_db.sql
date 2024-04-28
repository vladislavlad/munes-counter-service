create table users
(
    id          bigserial primary key not null,
    uuid        uuid unique           not null,
    username    varchar               not null,
    first_name  varchar,
    last_name   varchar,
    middle_name varchar,
    active      boolean               not null default true,
    created_at  timestamptz           not null,
    updated_at  timestamptz           not null,
    deleted_at  timestamptz                    default null,
    deleted_by  uuid                           default null
);

create unique index uq__users__username on users (username) where deleted_at is null;

create table user_rates
(
    id         bigserial primary key not null,
    user_id    bigint references users (id),
    rate_type  varchar(10),
    rate       real,
    currency   varchar(10),
    created_at timestamptz,
    updated_at timestamptz,
    deleted_at timestamptz default null,
    deleted_by uuid        default null
);

create unique index uq__user_rates__user_id on user_rates (user_id) where deleted_at is null;

create table user_work_record
(
    id         bigserial primary key not null,
    user_uuid  uuid unique           not null,
    start_time timestamptz           not null,
    end_time   timestamptz
);
