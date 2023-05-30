--2023-05-30
create table member(
id varchar(30) not null,
pw varchar(50) not null,
name varchar(20) not null,
email varchar(100) not null,
phone varchar(30),
regdate datetime default now(),
event int not null,
auth int default 0,
Primary key(id));