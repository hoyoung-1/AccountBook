drop table account;
drop table userinfo;
drop SEQUENCE seq_acc;
drop sequence seq_user;

create sequence seq_user increment by 1;
create sequence seq_acc INCREMENT by 1;

create table userinfo (
    no number(10,0) not null,
    name varchar2(15) not null,
    id VARCHAR2 (20) not null,
    password VARCHAR2 (24) not null,
    regdate DATE DEFAULT sysdate
);

alter table userinfo add CONSTRAINT pk_userinfo
primary key (name);

create table account (
    no number(10,0) not null,
    name varchar2(15),
    history varchar2(4000),
    expenses NUMBER(38,0) default 0,
    income number(38,0)default 0,
    total number(38,0),
    updateDate Date default sysdate
);

alter table account add CONSTRAINT pk_account
primary key (no);
alter table account add CONSTRAINT for_account FOREIGN KEY (name)
REFERENCES userinfo(name);

commit;

-- 여기까지 테이블 작성
select * from account;
select * from userinfo;
