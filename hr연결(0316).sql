--230316 1교시 복습

-- 복습1( 자신의 속한 부서의 평균급여보다 더 적은 급여를 받는 직원들을 조회하시오)
-- subquery
select *
from employees outerEmp
where salary < (
        select avg(salary)
        from employees   
        where department_id = outerEmp.department_id
);

-- inline view
select *
from employees, (
                    select department_id, avg(salary) sal
                    from employees   
                    group by department_id) inlineView_emp
where employees.department_id = inlineView_emp.department_id
and employees.salary < inlineView_emp.sal;

-- JDBC로 작성해보기

create sequence seq_employee
start with 300;

insert into employees(EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)
values(seq_employee.nextval, 'aa', 'bb', sysdate, 'IT_PROG');

ROLLBACK;


update employees
set EMAIL = ?, DEPARTMENT_ID = ?, JOB_ID = ?, SALARY = ?
where EMPLOYEE_ID = ?;

alter trigger update_job_history enable;

delete from job_history;
commit;

select *
from employees;

desc employees;

select *
from user_constraints
where table_name = 'EMPLOYEES';

select *
from user_constraints
where table_name = 'DEPARTMENTS';



select * from user_tab_privs_made;
select * from USER_TAB_PRIVS_RECD ;



-- 복습2(복합키를 가진 Table을 FK로 설정하기)
drop table tbl_parent cascade constraints;
drop table tbl_child cascade constraints;

create table tbl_parent (
pid1    number,
pid2    number,
pname   varchar2(30),
constraint pk_tbl_parent primary key(pid1, pid2)
);

insert into tbl_parent values(1, 1, 'aa');
insert into tbl_parent values(1, 2, 'bb');

delete from tbl_parent where pid1= 1 and pid2 =1;

create table tbl_child (
ch_id    number  primary key,
ch_name varchar2(20),
pid1    number, pid2    number, constraint fk_parent foreign key(pid1, pid2) references tbl_parent(pid1, pid2) on delete cascade
);

insert into tbl_child values(100, 'AA', 1, 1);

select * from tbl_child;

commit;

-- 230316 6교시 20장. PL/SQL기초
-- Procedure
set SERVEROUTPUT ON;

declare
    v_empId number := 100;      --스칼라타입
    v_empName varchar2(20);
    v_salary    employees.salary%TYPE;  -- 래퍼런스타입
    v_email     employees.email%TYPE;
    v_emp       employees%rowtype;
    
    TYPE  firstname_type IS TABLE OF employees.first_name%TYPE
    INDEX BY BINARY_INTEGER;
    
    TYPE  JOB_TABLE_TYPE IS TABLE OF employees.job_id%TYPE
    INDEX BY BINARY_INTEGER;

    seq BINARY_INTEGER := 0;
    first_arr firstname_type;
    job_arr job_table_type;
begin
    v_empName := '스티븐';
    v_salary := 20000;
    v_email := '이메일입니다.';
    dbms_output.put_line('Hello');
    dbms_output.put_line('아이디는 ' || v_empid);
    dbms_output.put_line('이름은 ' || v_empname);
    dbms_output.put_line('v_email : ' || v_salary);
    dbms_output.put_line('email : ' || v_email);
    
    select *
    into v_emp
    from employees
    where employee_id = 100;
    
    dbms_output.put_line('직원번호 : ' || v_emp.employee_id);
    dbms_output.put_line('fname : ' || v_emp.first_name);
    dbms_output.put_line('lname : ' || v_emp.last_name);
    dbms_output.put_line('salary : ' || v_emp.salary);
    dbms_output.put_line('email : ' || v_emp.email);
    
    for empRow in (select first_name, job_id from employees where department_id = 60) loop
        seq := seq+1;
        first_arr(seq) := empRow.first_name;
        job_arr(seq) := empRow.job_id;
        dbms_output.put_line('읽은 데이터 : ' || empRow.first_name || ' --- 테이블 저장 : ' || first_arr(seq) || ' --- ' || empRow.job_id);
    end loop;
end;
/

-- 230316 7교시 20장. PL/SQL기초
-------------------
declare
-- 1건을 조회
    v_fname employees.first_name%type;
    v_empid number := 101;
    v_salary employees.salary%type;
    
-- 레코드 타입을 정의
    TYPE emp_record_type IS RECORD(
    v_empno    employees.employee_id%TYPE,
    v_ename    employees.first_name%TYPE,
    v_job         employees.job_id%TYPE,
    v_deptno   employees.department_id%TYPE);

    v_empRecord emp_record_type;

begin
    select first_name, salary
    into v_fname, v_salary
    from employees
    where employee_id = v_empid;

    dbms_output.put_line('직원번호 : ' || v_empid);
    dbms_output.put_line('직원이름 : ' || v_fname);
    dbms_output.put_line('salary : ' || v_salary);
    dbms_output.put_line('----------------------');
-- 여러건
    for emp_record in (select * from employees where department_id = 60) loop
        dbms_output.put_line('employee_id : ' || emp_record.employee_id);
        dbms_output.put_line('first_name : ' || emp_record.first_name);
        dbms_output.put_line('salary : ' || emp_record.salary);
        dbms_output.put_line('----------------------');    
    end loop;
    
    select employee_id, first_name, job_id, department_id
    into v_emprecord
    from employees
    where employee_id = 101;
        
    dbms_output.put_line('v_empno : ' || v_emprecord.v_empno);
    dbms_output.put_line('v_ename : ' || v_emprecord.v_ename);
    dbms_output.put_line('v_job : ' || v_emprecord.v_job);
    dbms_output.put_line('v_deptno : ' || v_emprecord.v_deptno);
    
end;
/
---------------------------------
DECLARE
    su number := 0;
begin
    loop
        su := su+1;
        if su > 5 then
             exit;
        end if;
       dbms_output.put_line(su);
    end loop;
end;
/
---------------------------------
create or replace procedure sp_print10
is
    su number := 100;
begin
    for i in REVERSE 1..10 loop
         dbms_output.put_line(i);
    end loop;
end;
/

execute sp_print10;

desc user_source;

select * from user_source;

---------------------------------
create or replace  procedure sp_emp1( v_empid in employees.employee_id%type,
                                                              v_salary out employees.salary%type,
                                                              v_jobid out  employees.job_id%type
)
is
    v_record employees%rowtype;
begin
      select *
      into v_record
      from employees
      where employee_id = v_empid;
      
      dbms_output.put_line('직원이름:'||v_record.first_name);
      dbms_output.put_line('salary:'||v_record.salary);
      dbms_output.put_line('hire_date:'||v_record.hire_date);
      
      v_salary := v_record.salary;
      v_jobid := v_record.job_id;
end;
/

variable a number;
variable b varchar2(30);

execute sp_emp1(101, :a, :b);
execute sp_emp1(103, :a, :b);

print a
print b

select * from employees;