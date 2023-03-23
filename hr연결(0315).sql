-- 230315 3교시 13장 데이터 무결성을 위한 제약조건

-- 제약조건 정보조회
desc user_constraints;

-- 해당 테이블 제약조건 확인
select * from user_constraints
where table_name = 'TBL_ORDER';

-- 해당 테이블의 칼럼 제약조건 확인
SELECT * 
FROM USER_CONS_COLUMNS
where table_name = 'TBL_ORDER';

-- tbl_test1 테이블 삭제
drop table tbl_test1;

-- tbl_test1 테이블 생성
create table tbl_test1 (
id                      number        constraint pk_tbl_test1_id  primary key,
name                 varchar2(20)   not null,
phone_number    varchar2(13)   constraint u_phone UNIQUE
);

-- tbl_test1 데이터 추가
insert into tbl_test1 (id, name) values(1, 'aa');
insert into tbl_test1 (id, name, phone_number) values(3, 'aa', '010-4567-7896');

select * from tbl_test1;

-- 주문(고객, 상품, 일자, 가격)
create table tbl_order (
고객              number,      
상품              number,
order_date      Date,
price              number,
constraint pk_order primary key(고객, 상품)
);

-- primary key : not null + unique
insert into tbl_order values(1, 100, sysdate, 1000);


-- 230315 4교시 13장 데이터 무결성을 위한 제약조건
select * from departments;
select * from employees;
select * from user_constraints where table_name = 'DEPARTMENTS';
select * from user_constraints where table_name = 'EMPLOYEES';
select * from user_cons_columns where table_name = 'EMPLOYEES';

-- parent key not found이기 떄문에 실패
update employees
set department_id =1;

ALTER TRIGGER HR.UPDATE_JOB_HISTORY disable;

drop table tbl_parent;
create table tbl_parent (
deptid         number       primary key,
deptname    varchar2(20)
);

drop table tbl_child;
create table tbl_child(
empid                number          primary key,
empname           varchar2(20)     not null,
deptid                number         constraint tbl_child_deptid_FK references tbl_parent(deptid) on delete cascade,
salary                 number         constraint tbl_child_salaty_check check( salary between 1000 and 2000),
gender               char(1)           constraint tbl_child_gender_check check(gender in('M', 'F')),
phone_number    char(13)          unique,
country               varchar2(30)    default '한국'
);

insert into tbl_child(empid, empname, deptid, salary, gender, phone_number) values(1, 'aa', 10, null, null, null);
insert into tbl_child values(2, 'bb', 10, 1500, 'M', '12345');
insert into tbl_child values(3, 'bb', 10, 1500, 'M', '12345');

select * from tbl_child;


insert into tbl_parent(deptid, deptname) values (10, '개발부');
insert into tbl_parent(deptid, deptname) values (20, '영업부');
insert into tbl_parent(deptid, deptname) values (30, '총무부');


insert into tbl_child values(1, 'aa', 10);
insert into tbl_child(empid, empname, deptid) values(2, 'bb', 20);
insert into tbl_child(empid, empname) values(3, 'cc');

-- subquery를 이용해서 table생성, not null만 복사
create table tbl_emp_backup
as
select * from employees
where department_id = 60;

select * from tbl_emp_backup;

select * from user_constraints where table_name = 'TBL_EMP_BACKUP';

update tbl_emp_backup
set department_id = 1;

rollback;

-- 제약조건추가
alter table tbl_emp_backup
add constraint tbl_emp_backup_PK
primary key(employee_id);

alter table tbl_emp_backup
add constraint tbl_emp_backup_FK
foreign key(department_id) references departments(department_id);

-- 230315 5교시 14장. 가상 테이블인 뷰
desc employees;

create or replace view empView1
as
select employee_id, first_name, last_name, email, hire_date, job_id, department_id
from employees
where department_id = 60 with check option; -- with checck option : 칼럼 값 변경불가

select * from user_views;

select * from empView1 join jobs using(job_id);

select * from empview1;

update empview1
set department_id = 100;

update empview1
set email = 'wed0406@daum.net'
where employee_id = 103;
commit;

select * from employees;

-- 조인된 뷰는 select만 가능하다, update 불가
-- force : 무조건 생성 / noforce(default) : 체크해서 문제없음녀 생성
create or replace view view_join4
as
select first_name, department_name, city, country_name
from employees join departments using(department_id)
                          join locations using(location_id)
                          join countries using(country_id);


select * from view_join4;



-- 230315 6교시 15장. 시퀀스  : 자동번호발생

create sequence seq_board;

create table tbl_board (
bno             number              primary key,
title            varchar2(50)       not null,
contents     varchar2(2000),
writer          varchar2(30)      not null
);

insert into employees
values

insert into tbl_board (bno, title, contents, writer)
values(seq_board.nextval, '수요일', 'SQL배우기', 'jj');

select * from tbl_board
where title = '수요일';

create index idx_tbl_board_title
on tbl_board(title);

-- 230315 6교시 16장. 인덱스  : SQL처리속도 향성시키기 위해 컬럼에 대해서 생성하는 오라클 객체

select *
from USER_IND_COLUMNS
where table_name = 'TBL_BOARD';


show recyclebin;                                          --휴지통에 있는 테이블을 조회
flashback table 테이블명 to before drop;       -- 삭제된 테이블을 복원
drop table 테이블명 purge;                             -- 휴지통에 남기지 않고 완전 삭제
purge table 테이블명;                                     -- 휴지통에 있는 테이블 완전 삭제
purge recyclebin;                                         -- 휴지통 비우기


-- 실행계획
select *
from employees
where first_name = initCap('steven') and last_name =initCap('king');






