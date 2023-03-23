-- < 03/13 2교시 >
-- 5장.4 SQL주요 함수(일자 연습) 
select sysdate 오늘날짜, hire_date 입사일자,
        floor((sysdate-hire_date)/365) 근속년도1,
        floor((months_between(sysdate, hire_date)/12)) 근속년도2,
        add_months(hire_date, 1) "1개월 후",
        last_day(hire_date) 마지막일,
        next_day(hire_date, '수요일') 처음오는수요일,
        round(hire_date, 'month') "반올림", -- 16이상이면 월 올라감
        trunc(hire_date, 'month') "버림", -- 해당월 출력 
        first_name 이름, salary 급여
from employees;

-- 5장.5 SQL주요 함수(문자형 연습) 
select sysdate 오늘날짜, to_char(sysdate, 'yyyy/mm/dd hh:mi:ss DAY DY MON AM') "to_char출력연습",
        to_char(10000000, 'L999,999,999'),
        to_date(20220101, 'yyyymmdd')
from dual;

select first_name 이름, hire_date 입사일
from employees
where hire_date = to_date('030617', 'rrmmdd');

-- nls_date_format 설정을 바꿀 수 있다.  alter session set nls_date_format='';
select * from nls_session_parameters;

-- rr/mm/dd     rrmmdd    : rr은 50이상이면 19, 미만이면 20
select first_name 이름, hire_date 입사일
from employees
where hire_date = '03/06/17';

select first_name 이름, hire_date 입사일
from employees
where hire_date = '030617';

select first_name 이름, hire_date 입사일
from employees
where hire_date = '20030617';


-- NVL(칼럼명, 리턴값) : Null을 0 or 다른값으로 변환
-- NVL2(칼럼명, 참 값, 거싯 값) : Null을 다른값으로 변환
select first_name 이름, hire_date 입사일, salary 급여, commission_pct 커미션,
        salary + (salary * NVL(commission_pct, 0)) 실수령액1,
        salary + (salary * NVL2(commission_pct, commission_pct, 0)) 실수령액2,
        NVL2(commission_pct, '커미션 있음', '커미션 없음') 실수령액3
from employees
order by commission_pct ; -- nulls first : Asc경우 null값 뒤에나옴, 먼저 출력문

-- 탄탄히 다지기 7.1. 사원들 중에서 이름이 K로 시작하는 사원의 사원번호와 사원이름을 출력하시오.
select first_name 이름, MANAGER_ID 사번, nvl(to_char(MANAGER_ID), 7839) EMPNO, last_name ENAME,
        NVL2(to_char(MANAGER_ID), to_char(MANAGER_ID),  'C E O') MANAGER,
        department_id 부서, nvl(to_char(department_id), '부서없음') 부서확인,
        decode(department_id, 10, 'A', 60, 'B', 90, 'C', 'D') 부서DECODE,
--     case when 조건문 then 출력문 ··· else 나머지값 end "칼럼이름"  
        salary, case when salary >= 10000 then '매우많음'
                 when salary >= 10000 then '매우많음'
                 when salary >= 7000 then '많음'
                 when salary >= 5000 then '기본'
                 else '적음'
                 end "케이스연습",
--      7.2. 이름 중에 K를 포함하는 사원의 사원번호와 사원이름을 출력하시오.
        case when first_name like 'A%' then 'A로시작' else '아님' end "cass연습2",
--      7.3. 이름이 K로 끝나는 사원의 사원번호와 사원이름을 출력하시오.
        case when first_name like '%a' then 'A로끝' else '아님' end "cass연습3"
from employees;

-- 6장.1 그룹 함수(Group) 
-- 집계함수(칼럼명) : 값의 null은 무시한다
-- 집계함수(*) : null 포함
-- group by절이 없으면 전체에 대한 집계이다.
select sum(salary), sum(commission_pct), avg(salary), count(salary), sum(salary)/count(salary),
        count(*) 전체건수,  count(commission_pct), count(manager_id)
from employees;

-- 탄탄히 다지기 1. 가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일을 출력하는 쿼리문을 작성하시오. 
select Max(hire_date) "최근 입사한 입사일", min(hire_date) "가장 오래된 입사일"
from employees;

-- 탄탄히 다지기 2. 10번 부서 소속 사원중에서 커미션을 받는 사원의 수를 구해보시오.
select count(commission_pct), count(*)
from employees
where department_id = 80;
-- and commission_pct is not null;


-- distinct 중복제거
select count(job_id) job_id, count(department_id) department_id,
        count(distinct job_id) job_id중복제거, count(distinct department_id) department_id중복제거
from employees;

select distinct deparment_id
from employees
where department_id is not null;

-- 집계함수를 사용하지 않은 칼럼이 select 절에 있다면 반드시 group by 절에 참여해야 한다
-- 부서별 salary평균
select department_id 부서, max(job_id), avg(salary) 평균
from employees
where department_id <= 110
group by department_id
order by 1;

select department_id 부서, job_id, avg(salary) 평균
from employees
where department_id <= 110 -- where 절에는 그룹함수를 쓸 수 없다
group by department_id, job_id
having avg(salary) >=10000
order by 평균 desc;

-- max(칼럼명) , min(칼럼명)
select department_id, max(salary), min(salary)
from employees
GROUP by department_id;

select count(*)
from employees
where department_id = 10;

-- 쿼리문 실행순서 ( FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY )
-- select          -5
-- from           -1
-- where         -2
-- group by     -3
-- having         -4
-- order by      -6

-- SQL_LAB2(단일행 함수)_3장1절
-- 7. 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오.
select department_id 부서, count(department_id) 부서수
from employees
group by department_id
having count(department_id) >= 5;

-- 8. 각 부서별 최대급여와 최소급여를 조회하시오.
-- 단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에 조회결과에서 제외시킨다.
select department_id 부서, max(salary) 최대급여, min(salary) 최소급여
from employees
group by department_id
--having max(salary) <> min(salary)
having count(*) > 1;

-- 9. 부서가 50, 80, 110 번인 직원들 중에서 급여를 5000 이상 24000 이하를 받는
-- 직원들을 대상으로 부서별 평균 급여를 조회하시오.
-- 다, 평균급여가 8000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은
-- 부서면저 출력되도록 해야 한다.
select department_id 부서, avg(salary) 평균급여
from employees
where department_id in(50, 80, 110) and salary between 5000 and 24000
group by department_id
having avg(salary) >= 8000
order by 평균급여 desc;

update employees
set employee_id = 1
where employee_id = 100;


-- 230313 5교시
-- chapter2.2 관계데이터모델(무결성 제약조건)
-- WH table 생성
create table WH(
    id         number           PRIMARY key,
    name    varchar2(20)
);

-- WH table 데이터 추가
insert into WH values(1, 'AA');
insert into WH values(2, 'BB');

-- WH table 데이터 검색
select * from wh;

-- WH table 데이터 수정( id 1 -> 100 )
update WH set id=100 where id=1;


-- 230313 6교시
-- 07장 조인
-- 100번 직원의 근무하는 부서이름을 알고 싶다.
-- 직원이 부서를 참조한다. (건수는 직원건수만큼 나온다.)
select *
from employees
where employee_id = 100;

select *
from departments
where department_id = 90;

-- 위 select 문 2개를 조인
-- DBVendor문법
select employee_id 사번, first_name 이름, department_name 부서명, departments.department_id 부서코드
from employees, departments
where employees.department_id = departments.department_id
order by 1;

-- ANSI표준문법1
-- Join하고자하는 칼럼이 일치하는 경우 사용
select employee_id 사번, first_name 이름, department_name 부서명, department_id 부서코드
from employees join departments using(department_id)
order by 1;

-- ANSI표준문법2
-- Join하고자하는 칼럼이 일치하지 않는 경우 사용
select employee_id 사번, first_name 이름, department_name 부서명, dept.department_id 부서코드
from employees emp join departments dept on(emp.department_id = dept.department_id)
order by 1;

select employee_id 사번, first_name 이름, department_name 부서명, departments.department_id 부서코드
from employees left outer join departments on(employees.department_id = departments.department_id)
order by 1;

select employee_id 사번, first_name 이름, department_name 부서명, departments.department_id 부서코드
from employees full outer join departments on(employees.department_id = departments.department_id)
order by 1;

-- 직원이 어떤 직급인지 자세히 알고자 한다. job_title, max_salry, min_salry
desc employees;
desc jobs;
-- PK(Primary key) : Null불가 + Unique
-- FK(Forenign key) : 참조키, 다른 테이블 혹은 자신의 테이블의 pk를 참조한다.
select first_name 이름, salary 급여, jobs.*
from employees, jobs
where employees.job_id = jobs.job_id;

select first_name 이름, salary 급여, job_id, job_title, min_salary, max_salary
from employees join jobs using(job_id);

-- 230313 7교시
-- 테이블 이름에 별명설정 가능하다
select first_name 이름, salary 급여, j.*
from employees e join jobs j on(e.job_id = j.job_id)
where e.job_id = 'IT_PROG';

-- Seattle 도시에 사는 직원 검색
select first_name 이름, job_id 부서, salary 급여, city 도시, department_name 부서명
from employees, departments, locations
where  employees.department_id = departments.department_id 
and departments.location_id = locations.location_id
and city = 'Seattle';

select first_name 이름, job_id 부서, salary 급여, city 도시, department_name 부서명
from employees join departments using(department_id)
                      join locations using(location_id)
where city = 'Seattle';

select departments.department_id, first_name 이름, job_id 부서, salary 급여, city 도시, department_name 부서명
from employees join departments on(employees.department_id = departments.department_id )
                      join locations on(departments.location_id = locations.location_id)
where city = 'Seattle';

-- Accounting 부서 소속 사원의 이름과 입사일을 출력하시오.
select first_name 이름, hire_date 입사일, department_name 부서명
from departments join employees using(department_id)
where department_name = initCap('Accounting');


--LAP SQL_LAB3(JOIN)_3장2절
-- 1.직원들의 이름과 직급명(job_title)을 조회하시오.
select first_name 이름, job_title 직급명
from employees join jobs using(job_id);

-- 2.부서이름과 부서가 속한 도시명(city)을 조회하시오.
select department_name 부서이름, city 도시명
from departments join locations using(location_id);

-- 3. 직원의 이름과 근무국가명을 조회하시오. (employees, departments, locations,countries)
 select first_name 이름, country_name 근무국가명
 from departments join employees using(department_id)
                        join locations using(location_id)
                        join countries using(country_id);

-- 4. 직책(job_title)이 'manager' 인 사람의 이름, 직책, 부서명을 조회하시오.
 select first_name 이름, job_title 직책, department_name 부서명
 from employees  join jobs using(job_id)
                        join departments using(department_id)
where job_title like '%Manager%';

 select first_name 이름, job_title 직책,  department_name 부서명
 from employees  join jobs using(job_id)
                        join departments using(department_id)
where substr(job_title, -7,7) = 'Manager';

-- 5. 직원들의 이름, 입사일, 부서명을 조회하시오.
 select first_name 이름, hire_date 입사일, department_name 부서명
 from departments join employees using(department_id);

-- 6. 직원들의 이름, 입사일, 부서명을 조회하시오.
-- 단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
 select first_name 이름, hire_date 입사일, department_name 부서명
 from employees left join departments using(department_id);

--7. 직원의 이름과 직책(job_title)을 출력하시오.
--단, 사용되지 않는 직책이 있다면 그 직책정보도 출력결과에 포함시키시오.
 select first_name 이름, job_title 직책
 from employees left join departments using(department_id)
                            join jobs using(job_id);                      

select * from departments;

select * from employees;

select * from locations;

select * from countries;

select * from jobs;
