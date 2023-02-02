DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS books_genre;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS author;

CREATE TABLE author( 
	author_id INT AUTO_INCREMENT NOT NULL,
	author_name VARCHAR(128) NOT NULL,
	PRIMARY KEY (author_id)
);
CREATE table genre(
	genre_id INT auto_increment not null,
	genre_name varchar(128) not null,
	primary key (genre_id)
);
create table books(
	book_isbn varchar(17) not null,
	book_title Varchar(200) not null,
	book_status varchar(3) not null,
	author_id int,
	primary key (book_isbn),
	foreign key (author_id) references author (author_id) on delete cascade
);
create table books_genre(
	book_isbn varchar(17) not null,
	genre_id int not null,
	foreign key (book_isbn) references books (book_isbn) on delete cascade,
	foreign key (genre_id) references genre (genre_id) on delete cascade,
	unique key (book_isbn, genre_id)
);
create table review(
	review_id int auto_increment not null,
	review_text text not null,
	book_isbn varchar(17) not null,
	primary key (review_id),
	foreign key (book_isbn) references books (book_isbn) on delete cascade
);