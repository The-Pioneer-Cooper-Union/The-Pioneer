CREATE SEQUENCE users_id_seq START WITH 1;


CREATE TABLE users(
    user_id bigint not null default nextval('users_id_seq'),
    username varchar(50) not null,
    email varchar(255) not null,
    password_hash varchar(50) not null, 
    user_type varchar(50) not null, 
    major varchar(50) not null,
    graduation_year int not null,
    profile_pic varchar(255),
    short_bio varchar(500),
    PRIMARY KEY (user_id), 
    UNIQUE (username),
    UNIQUE (email)
);