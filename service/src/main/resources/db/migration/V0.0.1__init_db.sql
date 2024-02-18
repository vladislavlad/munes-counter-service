create table user_info
(
    id         bigserial primary key not null,
    user_uuid  uuid unique           not null,
    active     boolean               not null default true,
    created_at timestamptz           not null,
    updated_at timestamptz           not null
);

create table user_rate
(
    user_id    bigint references user_info (id),
    rate_type  varchar(10),
    rate       real,
    currency   varchar(10),
    archived   boolean default false,
    created_at timestamptz,
    updated_at timestamptz
);

create table user_work_record
(
    id         bigserial primary key not null,
    user_uuid  uuid unique           not null,
    start_time timestamptz           not null,
    end_time   timestamptz
);
