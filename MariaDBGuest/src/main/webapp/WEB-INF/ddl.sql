create table guestbook(
 		idx int primary key auto_increment,
 		name varchar(40) not null,
 		password varchar(40) not null,
 		content text not null, 			/*여기만 변경*/
 		regDate timestamp default now(),
 		ip varchar(20) not null
);
select * from guestbook;
delete from guestbook;