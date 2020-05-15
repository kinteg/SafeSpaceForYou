create sequence hibernate_sequence start 1 increment 1;

create table if not exists post
(
    id            int8 not null,
    author        text not null,
    title text    not null,
    main_text     text not null,
    date_creation timestamp not null,
    primary key (id)
);