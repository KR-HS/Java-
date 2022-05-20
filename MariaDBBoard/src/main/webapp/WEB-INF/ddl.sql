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

insert into board(name,password,subject,content,ip) 
values
	('한사람',password('1234'),'제목1','내용1','192.168.0.45'),
	('한사람',password('1234'),'제목2','내용2','192.168.0.45'),
	('한사람',password('1234'),'제목3','내용3','192.168.0.45'),
	('한사람',password('1234'),'제목4','내용4','192.168.0.45'),
	('한사람',password('1234'),'제목5','내용5','192.168.0.45');

delete from board where subject="제목1";



-- 댓글 테이블을 만들자
create table board_comment(
	idx int primary key auto_increment,
	ref int not NULL,
	name varchar(30) not null,
	password varchar(50) not null,
	content text not null,
	regDate timestamp default now(),
	ip varchar(20) not NULL,
	FOREIGN KEY(ref) REFERENCES board(idx)
);

desc board_comment;
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME ="board_comment";

-- 댓글 추가
SELECT idx FROM board;

insert into board_comment(ref,name,password,content,ip) 
values 
(13,'멍멍이','1234','댓글을 달아보자','192.168.45.67'),
(2,'멍멍이2','1234','댓글을 달아보자','192.168.45.67'),
(3,'멍멍이3','1234','댓글을 달아보자','192.168.45.67'),
(4,'멍멍이4','1234','댓글을 달아보자','192.168.45.67'),
(13,'멍멍이5','1234','댓글을 달아보자','192.168.45.67');

;