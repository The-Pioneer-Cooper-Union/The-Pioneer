CREATE SEQUENCE article_id_seq START WITH 1;

CREATE TABLE articles(
    article_id bigint not null default nextval('article_id_seq'),
    title varchar(255) not null,
    content text not null,
    user_id bigint not null,
    submission_date date not null,
    article_status varchar(50) not null,
    picture varchar(255),
    media_url varchar(255),
    category varchar(50) not null,

    PRIMARY KEY (article_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);