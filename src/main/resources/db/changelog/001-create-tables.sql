--changeset kovi:1
-- Books
CREATE TABLE book (
    id BIGINT NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
-- Authors
CREATE TABLE author (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    origin_country ENUM ('AD','AE','AF','AG','AI','AL','AM','AQ','AR','AS','AT','AU','AW','AX','AZ','BA','BB','BD','BE','BF','BG','BH','BI','BJ','BL','BM','BN','BO','BQ','BR','BS','BT','BV','BW','BY','BZ','CA','CC','CD','CF','CG','CH','CI','CK','CL','CM','CN','CO','CR','CU','CV','CW','CX','CY','CZ','DE','DJ','DK','DM','DO','DZ','EC','EE','EG','EH','ER','ES','ET','FI','FJ','FK','FM','FO','FR','GA','GB','GD','GE','GF','GG','GH','GI','GL','GM','GN','GP','GQ','GR','GS','GT','GU','GW','GY','HK','HM','HN','HR','HT','HU','ID','IE','IL','IM','IN','IO','IQ','IR','IS','IT','JE','JM','JO','JP','KE','KG','KH','KI','KM','KN','KP','KR','KW','KY','KZ','LA','LB','LC','LI','LK','LR','LS','LT','LU','LV','LY','MA','MC','MD','ME','MF','MG','MH','MK','ML','MM','MN','MO','MP','MQ','MR','MS','MT','MU','MV','MW','MX','MY','MZ','NA','NC','NE','NF','NG','NI','NL','NO','NP','NR','NU','NZ','OM','PA','PE','PF','PG','PH','PK','PL','PM','PN','PR','PS','PT','PW','PY','QA','RE','RO','RS','RU','RW','SA','SB','SC','SD','SE','SG','SH','SI','SJ','SK','SL','SM','SN','SO','SR','SS','ST','SV','SX','SY','SZ','TC','TD','TF','TG','TH','TJ','TK','TL','TM','TN','TO','TR','TT','TV','TW','TZ','UA','UG','UM','US','UY','UZ','VA','VC','VE','VG','VI','VN','VU','WF','WS','YE','YT','ZA','ZM','ZW') NOT NULL,
    PRIMARY KEY (id)
);
-- Junction table for many-to-many relationship between authors and books
CREATE TABLE book_authors (
    books_id BIGINT NOT NULL,
    authors_id BIGINT NOT NULL
);
-- Sequences for auto-incrementing IDs
CREATE SEQUENCE author_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE book_seq START WITH 1 INCREMENT BY 50;
-- Foreign key constraints for the junction table
ALTER TABLE IF EXISTS book_authors ADD CONSTRAINT FK_BOOK_AUTHORS_BOOK FOREIGN KEY (books_id) REFERENCES book;
ALTER TABLE IF EXISTS book_authors ADD CONSTRAINT FK_BOOK_AUTHORS_AUTHOR FOREIGN KEY (authors_id) REFERENCES author;
