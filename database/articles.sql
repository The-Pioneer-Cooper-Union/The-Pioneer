CREATE SEQUENCE article_id_seq START WITH 1;
CREATE TYPE article_status AS ENUM('pending', 'approved', 'rejected');

CREATE TABLE articles(
    article_id bigint not null default nextval('article_id_seq'),
    title varchar(255) not null,
    content varchar(255) not null,
    user_id bigint not null,
    submission_date date not null,
    article_status article_status not null,
    media_url varchar(255),
    PRIMARY KEY (article_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);