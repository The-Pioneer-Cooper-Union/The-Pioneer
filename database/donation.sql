CREATE SEQUENCE donation_id_seq START WITH 1;

CREATE TABLE donation(
    donation_id bigint not null default nextval('donation_id_seq'),
    user_id bigint not null,
    donation_comment varchar(500),
    donation_date date not null,
    donation_amount bigint not null,
    PRIMARY KEY (donation_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);