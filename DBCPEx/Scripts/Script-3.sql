create table board(
	idx int primary key auto_increment,
	name varchar(30) not null,
	password varchar(50) not null,
	subject varchar(300) not null,
	content text not null,
	regDate timestamp default now(),
	clickCount int(4) default 0,
	ip varchar(20) not null
);

select password('1234'), md5('1234'),sha('1234');

select length(password('1'));
select length(password('1234'));