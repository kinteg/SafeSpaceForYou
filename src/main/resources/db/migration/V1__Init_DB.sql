create sequence hibernate_sequence start 1 increment 1;

create table usr
(
    id         int8      not null,
    username   text      not null,
    password   text      not null,
    first_name text      not null,
    last_name  text      not null,
    created    timestamp not null,
    updated    timestamp not null,
    primary key (id)
);

create table role
(
    id      int8      not null,
    name    text      not null,
    created timestamp not null,
    updated timestamp not null,
    primary key (id)
);

create table user_role
(
    user_id int8 not null,
    role_id int8 not null,
    primary key (user_id, role_id),
    foreign key (user_id) references usr (id),
    foreign key (role_id) references role (id)
);

create table if not exists post
(
    id        int8      not null,
    title     text      not null,
    main_text text      not null,
    created   timestamp not null,
    updated   timestamp not null,
    user_id   int8      not null,
    primary key (id),
    foreign key (user_id) references usr (id)
);