-- < 03/10 4교시 >
-- SQL은 대소문자 구별 없음
-- 여러문장으로 작성가능
-- 문장끝은 ;
-- select * : *는 모든칼럼을 의미
-- invalid indentifier : 식별자오류(식별자 -> 칼럼이름, table이름)
-- 문자값은 바드시 ''를 써야한다
-- "table or view does not exist"
-- Oracle은 데이터 사전이 있다...데이터 사전에 데이터 이름을 대문자로 저장해놓는다.
-- 값은 대소문자 구별한다

---- 벤더가 제공하는 문법
--select *
--from A, B
--where A.id = B.id(+);

---- ANSI 표준 문법
--select *
--from A left outer join B using id;

desc employees; -- employees 구조

select * from tab; -- DB의 테이블 검색

select * from employees; -- employees의 모든 칼럼 검색

select EMPLOYEE_ID, FIRST_NAME from employees; -- employees의 EMPLOYEE_ID, FIRST_NAME 칼럼 검색

select department_id  from employees; -- employees의 department_id 칼럼 검색

-- 값이 없다 : null
-- null값을 계산하면 null
-- null을 대체할 필요가 있다.
-- nvl(비교값, 대체값)
-- 칼럼 옆에 식별자 설정 가능(as 생략가능)
-- 특수문자가 포함된 식별자 이름은 ""로 감싼다.
-- 연결 연산자는 + 가 아니다. || 이다. mysql은 concat()

select employee_id 직원번호, first_name || ' ' || last_name 이름,
        concat(concat(first_name, ' '), last_name) 이름2,
        salary 기본급, commission_pct 커미션,
        salary + (salary * nvl(commission_pct, 0)) as "커미션 적용급여"  -- 해석순서 2
from employees; -- 해석순서 1

-- distinct : 나열된 칼럼의 같은 값이 있으면 중복 배제된다
select DISTINCT department_id, job_id
from employees;

-- 조건절(where)
select employee_id 직원번호, first_name 이름, last_name 성, salary 급여 -- 해석순서3
from employees -- 해석순서1
where salary >= 10000 -- 해석순서2
order by 4 desc; -- 해석순서4
-- order by 칼럼이름 or 별명 or select 순번(SQL은 순번은 1부터 시작)
-- order by salary desc; -- 해석순서4
-- order by 급여 desc; -- 해석순서4


-- < 03/10 5교시 >
--> RR형식 :  > 50면 1900년대, < 50면 2000년대 
select employee_id 직원번호, first_name 이름, salary 급여,
        to_char(hire_date, 'yyyy/mm/dd hh:mi:ss') 입사일,
        department_id -- 3
from employees --1
where salary >= 10000
and department_id = 80
and first_name = 'Lisa'  -- 2
order by hire_date, salary desc; --4

-- DUAL table은 Oracle에서 제공하는 dummy table
desc dual
select * from dual;

-- floor : 무조건 내림, ceil : 무조건 올림, round : 반올림
select 1+2, sysdate, floor(10.9) "무조건 내림", ceil(10.1) "무조건 올림",
       round(35.678) "정수로 반올림", round(35.678, 1) "정수로 반올림2",  round(35.678, -1) "정수로 반올림3"
from dual;

-- 사번이 홀수인 직원 조회
select *
from employees
where mod(employee_id, 2) = 1;

-- upper : 대문자로 변환, lower : 소문자로 변환, initcap : 첫글자만 대문자 + 나머지 소문자
-- length : 문자길이 반환(1byte), lengthB : 문자길이 반환(2byte)
select FIRST_NAME, upper(FIRST_NAME), lower(FIRST_NAME), INITCAP(email),
       length(FIRST_NAME), length('한글'), lengthB('한글')
from employees;


select lengthb('oracle'), lengthb('오라클')
from dual;


-- nls_parameters 이 al32utf8이다... 한글이 3byte
select * from v$nls_parameters;



-- first_name가 david를 검색한다
-- 만약에 first_name 칼럼으로 색인(index)가 구성되어 있었다면 함수를 이용했을 시 index는 깨진다(index 사용불가)
select *
from employees
where first_name = initCap('david');

select *
from employees
where lower(FIRST_NAME) = 'david';

select *
from employees
where upper(first_name) = upper('david');


-- < 03/10 6교시 >

-- 1. 급여가 15000 이상인 직원들의 이름, 급여, 부서id를 조회하시오. --
select first_name 이름, salary 급여, department_id 부서ID
from employees
where salary >= 15000;

/* 2. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.
      연봉은 급여(salary)에 12를 곱한 값입니다. */
select first_name 이름, salary 급여, salary * 12 연봉
from employees
where salary * 12 >= 170000;

-- 3. 직원 중에서 부서id가 없는 직원의 이름과 급여를 조회하시오. --
select first_name 이름, salary 급여
from employees
where department_id is null;

-- 4. 2004년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오. --
select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where to_char(hire_date, 'yyyy') <= '2004';

select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where hire_date <= '2004/12/31'; -- 자동형변환 제공

-- 논리 연산자 (and, or, not) --
-- 1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오. --
select first_name 이름, salary 급여, department_id 부서ID
from employees
where (department_id = 80 or department_id = 50) and salary >= 13000;

select first_name 이름, salary 급여, department_id 부서ID
from employees
where department_id in(50,80) and salary >= 13000;

-- 2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오. --
select first_name 이름, salary 급여, department_id 부서ID, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where to_char(hire_date, 'yyyy') >= '2005' and salary >= 1300 and salary <= 20000 ;

select employee_id, first_name 이름, salary 급여, department_id 부서ID, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where to_char(hire_date, 'yyyy') >= '2005' and salary BETWEEN 1300 and 20000;

-- 3. 2005년도 입사한 직원의 정보만 출력하시오. --
select *
from employees
where to_char(hire_date, 'yyyy') = 2005; -- 자동형변환


-- < 03/10 7교시 >
-- ppt 05 연습문제02
--  05년도에 입사한 직원을 알아내기 위해 SUBSTR 함수를 이용하여 HIREDATE 컬럼에서
-- 첫 글자부터 2개를 추출하여 그 값이 05인지를 체크하는 방법으로도 구해 보도록 하세요.

select *
from employees
where substr(hire_date, 1, 2) = '05';

select *
from employees
where to_char(hire_date, 'RR') = '05';

select *
from employees
where to_char(hire_date, 'yyyy') = '2005';

--  3. 다음은 이름이 E로 끝나는 사원을 검색해 보도록 합시다.
--      SUBSTR 함수를 이용하여 ENAME 컬럼의 마지막 문자 한개만 추출해서 이름이 E로 끝나는 사원을 검색해 보도록 하시오.
--     <힌트> 시작 위치를 -1로 주고 추출할 문자 개수를 1로 주면 됩니다. 

select *
from employees
where substr(first_name, -1) = 'e';

select *
from employees
where substr(first_name, -1) = lower('E');



-- 4. 이름이 D로 시작하는 직원의 이름, 급여, 입사일을 조회하시오. --
select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where substr(first_name, 1, 1) = 'D';

-- 5. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오. --
select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where substr(hire_date, 4, 2) = '12';

select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where to_char(hire_date, 'mm') = 12; -- 자동형변환

-- intex 찾기 : instr(대상, 찾을글자, 시작위치, 몇번째)
select first_name, instr(first_name, 'a'), instr(first_name, 'a', 2, 2)
from employees;

-- ppt 05 연습문제05
-- 이름의 세 번째 자리가 R로 끝나는 사원을 검색하기 위해서
-- 와일드카드 _ 와 LIKE 연산자를 사용하여 다음과 같이 표현할 수 있습니다.
-- _는 임의문자 1자, %는 임의문자 0자 이상
select first_name
from employees
where first_name like '__r%';

-- 6. 이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오. --
select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where first_name like '%le%';

-- 7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오. --
select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where first_name like '%m';

select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where substr(first_name, -1, 1) = 'm';

-- 8. 이름의 세번째 글자가 r인 이름, 급여, 입사일을 조회하시오. --
select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where first_name like '__r%';

select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where substr(first_name, 3, 1) = 'r';

-- 9. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오. --
select first_name 이름, commission_pct 커미션, salary + (commission_pct*salary) 급여
from employees
where commission_pct is not null;

-- 10. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오. --
select first_name 이름, commission_pct 커미션, salary 급여
from employees
where commission_pct is null;

--11. 2000년대에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
--급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
--단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
--먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.
select *
from employees
where to_char(hire_date, 'yyyy') >= '2000'
and department_id in(30, 50, 80)
and salary between 5000 and 17000
and commission_pct is not null
order by hire_date, salary  desc;

-- asc : null이 뒤에 나오는 정책 -> nulls first로 null 위치를 앞으로 조정가능
-- desc : null이 앞에 나오는 정책  -> nulls last로 null 위치를 뒤로 조정가능
select *
from employees
order by commission_pct desc nulls last;
--order by commission_pct asc nulls first;

select lpad(first_name, 8, '#'), rpad(first_name, 8, '#'),
         '!' || ltrim('    oracle') || '!' 왼쪽,
         '!' || rtrim('     oracle          ') || '!' 오른쪽,
         '!' || trim('     oracle          ') || '!' 양쪽,
         '!' || trim('o' from 'oooooooo oracleooooooo') || '!' 양쪽o
from employees;

-- SQL_LAB2(단일행 함수)_3장1절 --
-- 1. 이름이 'adam' 인 직원의 급여와 입사일을 조회하시오. --
select salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where first_name = initCap('adam');

--2. 나라 명이 'united states of america' 인 나라의 국가 코드를 조회하시오.
select *
from countries
where lower(country_name) = 'united states of america';

--3. 'Adam의 입사일은 95/11/02 이고, 급여는 7000 입니다.' 이런 식으로 직원정보를 조회하시오.
select first_name || '의 입사일은 ' || hire_date || '이고, 급여는 ' || salary || '입니다.' 직원정보
from employees;

--4. 이름이 5글자 이하인 직원들의 이름, 급여, 입사일을 조회하시오.
select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where length(first_name) <= 5;

--5.2006년도에 입사한 직원의 이름, 입사일을 조회하시오.
select first_name 이름, to_char(hire_date, 'yyyy/mm/dd') 입사일
from employees
where to_char(hire_date, 'yyyy') = '2006';

--6. 7년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무년차를 조회하시오.
select first_name 이름, to_char(hire_date, 'yyyy/mm/dd') 입사일, salary 급여, trunc(months_between(sysdate, hire_date)/12) 근무연차
from employees
where trunc(months_between(sysdate, hire_date)/12) >= 7;


select * from employees;


select sysdate, hire_date, trunc((sysdate - hire_date)/365)
from dual, employees;