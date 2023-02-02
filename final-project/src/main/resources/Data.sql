-- author 
insert into author (author_name) values ('Natasha Preston');
insert into author (author_name) values ('Stephen King');
insert into author (author_name) values ('Tim Green');
insert into author (author_name) values ('Matthew Quick');
insert into author (author_name) values ('Caroline B. Cooney');


-- books
insert into books values ('987-0-316-12797-4', 'Boy21', 'In', 4);
insert into books values ('978-0-06-248561-8', 'The big game', 'In', 3);
insert into books values ('978-1987412017', 'Lie to Me', 'In', 1);
insert into books values ('978-0-245-80679-6', "Salem's Lot", 'In', 2);
insert into books values ('978-0-593-12496-3', 'The twin', 'In', 1);
insert into books values ('978-1492618522', 'Awake', 'In', 1);
insert into books values ('978-0-545-01972-9', 'Enter Three Witches - A Story of Macbeth', 'In', 5);
 
-- genres
insert into genre (genre_name) values ('young adult');
insert into genre (genre_name)  values ('sports');
insert into genre (genre_name)  values('romance');
insert into genre (genre_name)  values('horror');
insert into genre (genre_name)  values('thriller');
insert into genre (genre_name)  values('mystery');
insert into genre (genre_name)  values('fantasy');
 
-- book_genre
insert into books_genre values ('987-0-316-12797-4', 2);
insert into books_genre values ('987-0-316-12797-4', 1);
insert into books_genre values ('978-0-06-248561-8', 2);
insert into books_genre values ('978-1987412017', 3);
insert into books_genre values ('978-0-245-80679-6', 4);
insert into books_genre values ('978-0-593-12496-3', 6);
insert into books_genre values ('978-0-593-12496-3', 1);
insert into books_genre values ('978-1492618522', 5);
insert into books_genre values ('978-1492618522', 1);
insert into books_genre values ('978-0-545-01972-9', 7);
