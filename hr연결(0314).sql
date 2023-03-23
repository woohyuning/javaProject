-- 230314 2교시 07.조인
-- Non-Equi Join(=이외의 연산자를 이용해서 조인)
create table salgrade(
    grade       char(1)     primary key,
    minsal      number,
    maxsal      number
    );

insert into salgrade values('A', 0, 5000);
insert into salgrade values('B', 5001, 15000);
insert into salgrade values('C', 15001, 20000);
insert into salgrade values('D', 20001, 30000);
commit;

-- 직원의 이름, 급여, 급여의 등급 출력
select first_name 이름, salary 급여, grade 등급
from employees e, salgrade s
where e.salary between s.minsal and s.maxsal;

select first_name 이름, salary 급여, grade 등급
from employees e join salgrade s on(e.salary between s.minsal and s.maxsal);
--                     on(salary between minsal and maxsal);

-- self join : 하나의 테이블에서 조인
select 직원.employee_id 직원ID, 직원.first_name 직원이름, 매니저.employee_id 매니저ID, 매니저.first_name 매니저이름
from employees 직원, employees 매니저
where 직원.manager_id = 매니저.employee_id(+) -- Oracle문법 outer join
order by 1;

select 직원.employee_id 직원ID, 직원.first_name 직원이름, 매니저.employee_id 매니저ID, 매니저.first_name 매니저이름
from employees 직원 left outer join employees 매니저 on(직원.manager_id = 매니저.employee_id)
order by 1;

-- 230314 3교시 07.조인 self join
-- 탄탄히 다지기 4. 매니저가 KING인 사원들의 이름과 직급을 출력하시오.
-- self join
select 직원.employee_id 직원ID, 직원.first_name 이름, 직원.last_name 성,  jobs.job_title 직급
from employees 직원, employees 매니저, jobs
where 직원.manager_id = 매니저.employee_id
         and 직원.job_id = jobs.job_id
         and 매니저.last_name = initcap('king');
-- subQuery
select employee_id 직원ID, first_name 이름, last_name 성
from employees
where manager_id = (select employee_id
                             from employees
                             where first_name = 'Steven' and last_name = 'King');

-- 탄탄히 다지기 5. Steven King과 동일한 부서에서 근무하는 사원의 이름을 출력하시오.
-- self join
select 직원.employee_id 직원ID, 직원.first_name 이름, 직원.last_name 성, 직원.department_id  부서ID
from employees 직원, employees 스티븐
where 직원.department_id = 스티븐.department_id
         and 스티븐.first_name = 'Steven' and 스티븐.last_name = 'King';
-- subQuery
select employee_id 직원ID, first_name 이름, last_name 성, department_id  부서ID
from employees
where department_id = (select department_id
                                 from employees
                                 where first_name = 'Steven' and last_name = 'King');

-- 부서와 직원
desc departments;
desc employees;
-- 부서정보출력, menager_id는 부서장을 의미, 부서장은 직원 중 한명(부서장의 이름, 급여, 입사일)
-- 부서장이 없는 부서도 출력결과에 포함된다.
select d.*, e.first_name 이름, e.salary 급여, e.hire_date 입사일
from departments d, employees e
where d.manager_id = e.employee_id(+);

select d.*, e.first_name 이름, e.salary 급여, e.hire_date 입사일
from departments d left outer join employees e on(d.manager_id = e.employee_id);

-- full outer join
-- 부서없는 직원 + 직원없는부서 둘다 출력
select first_name 이름, salary 급여, department_name 부서명
from employees full outer join departments using(department_id);

-- 230314 4교시 08. 서브쿼리
-- 탄탄히 다지기 2. Kevin 동일한 직급을 가진 사원을 출력하는 SQL 문을 작성해 보시오.
-- subquery에서 subquery의 결과가 단일행인지 다중행인지 주의, --- 단일행연산자(=, >, <), 다중행연산자(in, all)
select *
from employees
where job_id in(
            select job_id
            from employees
            where first_name  = 'Kevin');

-- 탄탄히 다지기 3. Neena의 급여와 동일하거나 더 많이 받는 사원 명과 급여를 출력하시오.
-- subsuery결과가 1건이면 단일행 연산자를 사용 : >, >=, =, <=, <
-- subsuery결과가 1건이면 다중행 연산자를 사용 : >= all, >all, >=any, >and
-- all : and연산
-- any : or연산
select *
from employees
where salary >= all (
            select salary
            from employees
            where first_name = 'Alexander');

-- 탄탄히 다지기 4. seattle에서 근무하는 사원의 이름, 부서 번호를 출력하시오. 
select first_name 이름, department_id 부서번호
from employees  join departments using(department_id)
                        join locations using(location_id)
where city = 'Seattle';

select first_name 이름, department_id 부서번호
from employees
where department_id = any (
        select department_id
        from departments
        where location_id = (
                select location_id
                from locations
                where city = 'Seattle')
        );

-- 탄탄히 다지기 5. IT 부서에서 근무하는 모든 사원의 이름과 급여를 출력하시오.
select first_name 이름, salary 급여
from employees
where department_id = (
        select department_id
        from departments
        where department_name = 'IT');

-- 탄탄히 다지기 6. 직속상관이 KING인 사원의 이름과 급여를 출력하시오. 
select first_name 이름, salary 급여
from employees
where manager_id = any (
        select employee_id
        from employees
        where last_name = 'King'); -- and first_name = 'Steven');

-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장은 다음과 같습니다. 
select *
from employees
where salary >= (
        select avg(salary)
        from employees);

-- 
select *
from employees
where salary >= any (
        select avg(salary)
        from employees
        group by department_id);

-- 탄탄히 다지기 7. 부서별로 가장 급여를 많이 받는 사원의 정보(사원 번호, 사원이름, 급여, 부서번호)를 출력하시오.(IN 연산자 이용)
-- 다중칼럼 subquery
select employee_id 사원번호, first_name 사원이름, salary 급여, department_id 부서번호
from employees
where (department_id, salary) in (
        select department_id, max(salary)
        from employees
        group by department_id);

select count(distinct department_id)
from employees;

-- 탄탄히 다지기 8. 직급(JOB)이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력하시오.
select first_name 이름, department_id 부서번호, department_name 부서명, city 지역
from employees join departments using(department_id)
                      join locations using(location_id)
where job_id in (
        select job_id
        from jobs
        where job_title like '%Manager%');



-- 230314 6교시 09. DDL(Data Definition Language)
-- rowid : 논리적인 주소값
select rowid, employee_id, first_name
from employees;

-- <실습하기> 컬럼에 기간(3년)을 저장하기
create table tbl_test1(
id         number,
name    varchar2(20),
gender  char(1),
year01   interval year(3) to month 
);

-- INTERVAL YEAR(년도에 대한 자릿수) TO MONTH(달에 대한 자릿수)
insert into tbl_test1 values(1, 'abc', 'M', interval '36' month(3));
insert into tbl_test1 values(2, 'def', 'F', interval '12' month(3));
commit;

select id, name, gender, sysdate + year01
from tbl_test1;

select *
from tbl_test1
where gender = 'M';
--where name = 'abc';

-- employees 테이블 데이터 tbl_emp 테이블에 백업
create table tbl_emp
as
select * from employees;

-- employees 테이블 데이터 tbl_emp2 테이블에 department_id = 60 인 데이터만 백업
create table tbl_emp2
as
select * from employees
where department_id = 60;

-- employees 테이블 데이터 tbl_emp3 테이블 구조만 백업
create table tbl_emp3
as
select * from employees
where 1 = 0;

-- employees 테이블 데이터 tbl_emp4 테이블에 department_id, first_name 칼럼만 백업
create table tbl_emp4
as
select department_id, first_name from employees
where 1 = 0;

select * from tbl_emp4;

desc tbl_emp4;

alter table tbl_emp4 add (job_id varchar2(50));
alter table tbl_emp4 modify (job_id varchar2(100));
-- 사이즈를 늘리는것은 가능, 이미 데이터가 있을때 사이즈 줄이는 것은 불가능
alter table tbl_emp4 modify (first_name varchar2(30));
-- 데이터가 있어도 지워진다
alter table tbl_emp4 drop column first_name;

insert into tbl_emp4 values(1, '12345678901234567890', 'ABC');

-- 테이블 삭제
drop table tbl_emp4;

desc tbl_emp2;
select * from tbl_emp2;
truncate table tbl_emp; -- 데이터 삭제 복구불가

select * from tbl_emp;
delete from tbl_emp; -- 데이터 삭제 원상복구가능
rollback; -- 원상복구가능

rename tbl_emp to tbl_employee; -- 테이블 이름변경

-- 딕셔너리뷰
select * from user_tables;
select * from all_tables;
select * from dba_tables;

-- 230314 7교시 10. DML(Data manipulation language)
-- 제약조건은 복사안됨
create table tbl_emptest
as
select employee_id, first_name, salary, hire_date
from employees
where department_id = 60;

insert into tbl_emptest values(1, 'AA', 1000, sysdate);
insert into tbl_emptest (employee_id, first_name, hire_date) values(2, 'BB', sysdate);
insert into tbl_emptest (employee_id, hire_date) values(3, sysdate-1);
insert into tbl_emptest (hire_date) values(sysdate-1);

desc tbl_emptest;
select * from tbl_emptest;

-- 칼럼의 값을 넣지 않으면 암시적으로 null이다.
-- 명시적으로 null 값을 부여가능
insert into tbl_emptest (employee_id, first_name, hire_date) values(4, null, sysdate);
insert into tbl_emptest (employee_id, first_name, hire_date) values(5, '', sysdate); -- ''는 null이다

-- table의 구조만들기
create table tbl_dept
as
select * from departments where 1=0;

desc tbl_dept;
select * from tbl_dept;

insert into tbl_dept
select employee_id, first_name, 100, 1700 from employees;


create table tbl_emp_update
as
select * from employees;

select * from tbl_emp_update;

update tbl_emp_update
set salary = salary * 1.1
where department_id = 50;

-- transaction 처리를 하는 명령어 ( 하나의 논리적인 작업)
rollback; -- 작업을 끝내고 DB에 반영하지않는다
commit; -- 작업을 끝내고 DB에 반영한다.

-- 부서가 90번인 직원들을 Diana 직원과 같은 부서, 같은 salary로 변경한다;
update tbl_emp_update
set department_id = (
                select department_id
                from employees
                where first_name = 'Diana'),
    salary = (
                select salary
                from employees
                where first_name = 'Diana')
where department_id = 90;


delete from tbl_emp_update
where department_id = (
            select department_id
            from employees
            where first_name = 'Diana');

select * from tbl_emp_update;



drop table EMP01;
drop table EMP02;

create table EMP01
as
select employee_id empno, first_name ENAME, job_id JOB, manager_id MGR,
          hire_date HIREDATE, salary SAL, commission_pct COMM, department_id DEPTNO
from employees
where department_id = 60;
commit;

create table EMP02
as
select employee_id empno, first_name ENAME, job_id JOB, manager_id MGR,
          hire_date HIREDATE, salary SAL, commission_pct COMM, department_id DEPTNO
from employees
where department_id = 60;
commit;

--EMP02에 있는 1건 수정하기
select * from emp02;
select * from emp01;

update emp02 set  job='aa' , SAL = 9999, comm = 0.1, deptno=88
where empno=103;

--EMP02에 신규를 삽입하기
insert into emp02 values(111,'jj','bb',100, sysdate, 8888,0.2, 77);


MERGE INTO EMP01
USING EMP02 ON(EMP01.EMPNO=EMP02.EMPNO)
WHEN MATCHED THEN
        UPDATE SET
        EMP01.ENAME=EMP02.ENAME,
        EMP01.JOB=EMP02.JOB,
        EMP01.MGR=EMP02.MGR,
        EMP01.HIREDATE=EMP02.HIREDATE,
        EMP01.SAL=EMP02.SAL,
        EMP01.COMM=EMP02.COMM,
        EMP01.DEPTNO=EMP02.DEPTNO
WHEN NOT MATCHED THEN
        INSERT VALUES(EMP02.EMPNO, EMP02.ENAME, EMP02.JOB,
        EMP02.MGR, EMP02.HIREDATE, EMP02.SAL,
        EMP02.COMM, EMP02.DEPTNO);
        
select * from EMP01;

-- SQL_LAB4(SubQuery)_3장3절
-- 1. 'IT'부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.
select first_name 이름, salary 급여, hire_date 입사일
from employees
where department_id = (
        select department_id
        from departments
        where department_name = 'IT');

select first_name 이름, salary 급여, hire_date 입사일
from employees join departments using(department_id)
where department_name = 'IT';

-- 2. 'Alexander' 와 같은 부서에서 근무하는 직원의 이름과 부서id를 조회하시오.
select first_name 이름, department_id 부서ID
from employees
where department_id in (
        select department_id
        from employees
        where first_name = 'Alexander');

select first_name 이름, department_id 부서ID
from employees
where department_id = any (
        select department_id
        from employees
        where first_name = 'Alexander');

-- 3-1. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
select first_name 이름, department_id 부서ID, salary 급여
from employees
where salary > (
        select avg(salary)
        from employees
        where department_id = 80);

-- 3-1. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
--      단 80번부서의 평균도 출력결과에 포함시킨다. (스칼라 subquery)
select first_name 이름, department_id 부서ID, salary 급여, (
                                                                            select avg(salary)
                                                                            from employees
                                                                            where department_id = 80)
from employees
where salary > (
        select avg(salary)
        from employees
        where department_id = 80);

--- inline view
select first_name 이름, department_id 부서ID, salary 급여, dept80.sal80
from employees, (
        select avg(salary) sal80
        from employees
        where department_id = 80) dept80
where salary >dept80.sal80 ;



-- 4. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 
-- 50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명, 부서id를 조회하시오.
select first_name 이름, salary 급여, department_name 부서명, department_id 부서ID
from employees left outer join departments using(department_id)
where salary>(
        select avg(salary)
        from employees
        where department_id=50)
and salary>(
        select min(salary)
        from employees join departments using(department_id)
                              join locations using(location_id)
        where city='South San Francisco');

select first_name 이름, salary 급여, department_name 부서명, department_id 부서ID
from employees left outer join departments using(department_id)
where salary> all(
        (
        select avg(salary)
        from employees
        where department_id=50),
        (
        select min(salary)
        from employees join departments using(department_id) 
                              join locations using(location_id)
        where city='South San Francisco')
);


-- SQL_LAB5(SELF JOIN)_6장2절 SELF JOIN
-- 1. 직원의 이름과 관리자 이름을 조회하시오.
select 직원.employee_id 직원ID, 직원.first_name 직원이름, 매니저.employee_id 매니저ID, 매니저.first_name 매니저이름
from employees 직원, employees 매니저 
where 직원.manager_id = 매니저.employee_id;

select 직원.employee_id 직원ID, 직원.first_name 직원이름, 매니저.employee_id 매니저ID, 매니저.first_name 매니저이름
from employees 직원 inner join employees 매니저 on(직원.manager_id = 매니저.employee_id);

-- 2. 직원의 이름과 관리자 이름을 조회하시오.
-- 관리자가 없는 직원정보도 모두 출력하시오.
select 직원.employee_id 직원ID, 직원.first_name 직원이름, 매니저.employee_id 매니저ID, 매니저.first_name 매니저이름
from employees 직원, employees 매니저  
where 직원.manager_id = 매니저.employee_id(+);

select 직원.employee_id 직원ID, 직원.first_name 직원이름, 매니저.employee_id 매니저ID, 매니저.first_name 매니저이름
from employees 직원 left outer join employees 매니저 on(직원.manager_id = 매니저.employee_id);

--3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오.
--단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
select 매니저.employee_id 매니저ID, 매니저.first_name 매니저이름, COUNT(*) 직원수
from employees 직원 left outer join employees 매니저 on(직원.manager_id = 매니저.employee_id)
group by 매니저.employee_id, 매니저.first_name
having count(매니저.first_name) >=  3
order by 1;

-- SQL_LAB6(SubQuery,Join, 함수)_6장3절
-- 1. 직원들의 이름, 입사일, 부서명을 조회하시오.
-- 단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
-- 그리고 부서가 없는 직원에 대해서는 '<부서없음>' 이 출력되도록 한다. (outer-join , nvl() )
select first_name 이름, hire_date 입사일,
        nvl(department_name, '<부서없음>') 부서명,
        nvl(to_char(department_id), '<부서없음>') "부서ID NVL",
        nvl2(department_name, to_char(department_id), '<부서없음>') "부서ID NVL2"
from employees left outer join departments using(department_id);

-- 2. 직원의 직책에 따라 월급을 다르게 지급하려고 한다.
-- 직책에 'Manager'가 포함된 직원은 급여에 0.5를 곱하고 나머지 직원들에 대해서는 원래의 급여를 지급하도록 한다. 
-- 적절하게 조회하시오. (decode)
select first_name 이름, job_id 직책ID, job_title 직책, salary,
        decode(substr(job_title, -7), 'Manager' , salary * 0.5, salary) salary2,
        case when job_title like '%Manager' then salary * 0.5 else salary end salary3
from employees inner join jobs using(job_id);


create table empBackup
as
select * from employees;

select * from empBackup;

update empBackup
set salary = salary * 0.5
where employee_id in (select employee_id
                               from empBackup join jobs using(job_id)
                               where substr(job_title,-7,7) = 'Manager');

-- 3. 각 부서별로 최저급여를 받는 직원의 이름과 부서id, 급여를 조회하시오.
select first_name, department_id, salary
from employees
where (department_id, salary) in (
        select department_id, min(salary)
        from employees
        group by department_id);

select * from employees where department_id=100 and salary = 6900;


-- 4. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도
-- 출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오.
select job_title, count(employee_id) 인원수
from employees right outer join jobs using(job_id)
group by job_title
having count(*) >=3;

-- 5. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.
select first_name, department_name, salary
from employees join departments using(department_id)
where (department_id, salary) in (
        select department_id, max(salary)
        from employees
        group by department_id);
        
-- inline view
select first_name, department_name, salary, deptSalMax.maxsal
from employees, departments, (
        select department_id, max(salary) maxsal
        from employees
        group by department_id) deptSalMax
where employees.department_id = departments.department_id
and    employees.department_id = deptSalMax.department_id
and    employees.salary = deptSalMax.maxsal;

select count(distinct department_id)
from employees;

-- 6. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 최소급여를 마지막에 포함시켜 출력 하시오. ( 스칼라 subquery )
select first_name 이름, department_id 부서ID, salary 급여, (select min(salary)
                                                                             from employees e2
                                                                             where e1.department_id = e2.department_id) "부서의 최소급여"
from employees e1;

-- inline view
select first_name 이름, department_id 부서ID, salary 급여, deptMinSal.sal "부서의 최소급여"
from employees join (select department_id, min(salary) sal
                             from employees
                             group by department_id) deptMinSal using (department_id);

-- SQL_LAB7(Inline View 와 Top-N SubQuery)_6장4절
-- 1. 급여를 가장 많이 받는 상위 5명의 직원 정보를 조회하시오.
-- pseudo 칼럼( 실제칼럼은 아닌데 칼럼인 것처럼 행동하는 객체)
select rownum 순번, aa.*
from (
        select first_name 이름, salary 급여
        from employees
        order by salary desc ) aa
where rownum <= 5;

select *
from (select rownum 순번, aa.*
        from (
                select first_name 이름, salary 급여
                from employees
                order by salary desc ) aa )
where 순번 = 5;


-- mysql :
        select rownum, first_name, salary
        from employees
        order by salary desc limit 5;


--2. 커미션을 가장 많이 받는 상위 3명의 직원 정보를 조회하시오.
select rownum 순번, aa.*
from (
        select first_name 이름, salary 급여, commission_pct 커미션
        from employees
        order by commission_pct desc nulls last, salary desc) aa
where rownum <= 3;

select *
from (
        select rownum 순번, aa.*
        from (
                select first_name 이름, salary 급여, commission_pct 커미션
                from employees
                order by commission_pct desc nulls last, salary desc) aa )
where 순번 = 3;

-- 3. 월별 입사자 수를 조회하되, 입사자 수가 5명 이상인 월만 출력하시오.
select to_char(hire_date, 'mm') 월, count(*) "입사자 수"
from employees
group by to_char(hire_date, 'mm')
having count(*) >= 5;

-- 4. 년도별 입사자 수를 조회하시오. 
-- 단, 입사자수가 많은 년도부터 출력되도록 합니다.
select to_char(hire_date, 'yyyy') 년도, count(*) "입사자 수"
from employees
group by to_char(hire_date, 'yyyy')
order by 2 desc;




select * from tbl_test1;
select * from salgrade;
select * from departments;
select * from employees;
select * from locations;
select * from countries;
select * from jobs;