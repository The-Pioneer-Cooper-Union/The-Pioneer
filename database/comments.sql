CREATE SEQUENCE comment_id_seq START WITH 1;

CREATE TABLE comments(
    comment_id bigint not null default nextval('comment_id_seq'),
    article_id bigint not null,
    user_id bigint not null,
    comment_text varchar(255) not null,
    comment_date date not null,
    parent_comment_id bigint,
    PRIMARY KEY (comment_id),
    FOREIGN KEY (article_id) REFERENCES articles(article_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (parent_comment_id) REFERENCES comments(comment_id)
);
