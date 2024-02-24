CREATE SEQUENCE article_id_seq START WITH 1;
CREATE TYPE article_status AS ENUM('pending', 'approved', 'rejected');
CREATE TYPE category AS ENUM('News', 'Opinion', 'Events', 'Letters', 'Face of Cooper', 'Alumni Interview', 'Comics','Interviews','Columns', 'Sports');

CREATE TABLE articles(
    article_id bigint not null default nextval('article_id_seq'),
    title varchar(255) not null,
    content varchar(255) not null,
    user_id bigint not null,
    submission_date date not null,
    article_status article_status not null,
    picture varchar(255),
    media_url varchar(255),
    category category not null,

    PRIMARY KEY (article_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);