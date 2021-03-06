-- 테이블 목록 확인하기
show tables;
--- 테이블 작성하기

/*create table 테이블 이름(
	필드명 데이터타입 제한조건,
	필드명 데이터타입 제한조건,
	.
	.
	.
);*/
-- 테이블 삭제
drop table test;
-- 테이블 생성
create table test(
	idx int primary key auto_increment, -- 키필드로 사용하겠다.
	name varchar(20) not null, -- 이름은 가변길이 문자열로 20자까지 저장 및 필수 입력
	age int(3) default 0, -- 나이는 정수 3자리이며, 기본값으로 0설정
	gender char(1) check(gender in ('M','F'))
);
-- 테이블 구조 확인
desc test;

-- 입력
/*
 * inser into 테이블명 (필드명,...) values (데이터,.....);
 */
insert into test(name,gender) values ('한사람','M');
insert test values (0,'두사람',33,'F');
insert into test(name) values('세사람');
insert into test(name,age,gender) values('네사람',12,'F'); -- 필드명 순서는 중요하지 않다.
insert into test(gender,name) values('M','오사람');
-- 모든 데이터 조회
-- select 필드명... from 테이블명 where 조건문
select * from test;

-- 정렬
select name, age from test;
select * from test order by age;
select * from test order by age desc;
select * from test order by age desc, name;

-- 조건지정
select * from test where gender='M';
select * from test where gender!='M';
select * from test where gender<> 'M';
select * from test where gender<> 'M' and age>=30;

-- DB CRUD명령
-- C(create) : Insert => 넣고
-- R(Read) : Select => 읽고
-- U(Update) : Update => 수정하고
-- D(Delete) : Delete => 지우기.


 -- 개수제한
-- select 필드명.. from 테이블명 where 조건 limit 시작번호, 개수
select * from test;
select * from test limit 0,3;
select * from test order by age desc limit 0,2;
select * from test desc limit 3,2;
-- 데이터 수정 : update
-- update 테이블명 set 필드명 = 값,.... where 조건
select * from test;
update test set age= 18, gender='F' where idx=3;
update test set age=age+1;

-- 데이터 삭제
-- delete 테이블명 where 조건문

select * from test;
delete from test where age <=0;
delete from test where age<=10;

delete from test;