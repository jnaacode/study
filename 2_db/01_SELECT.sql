/*SELECT (DML 또는 DQ) : 조회

- 데이터를 조회(SELECT)하면 조건에 맞는 행들이 조회됨 
이때 조회된 행들의 집합을 "RESULT SET"이라고 한다. 

- RESULT SET에는 0개 이상의 행이 포함될 수 있다. 
    왜 ? 0개 이상 조건이 맞는 행이 없을 수도 있기 때문에 

*/

--EMPLYEE 테이블에서 모든 사원의 정보를 조회 
--'*': ALL,모든,전부 
SELECT * FROM EMPLOYEE;

-- [SELECT 컬럼명 FROM 테이블]
-- EMPLOYEE 테이블에서 모든 사원의 이름만 조회 
SELECT EMP_NAME FROM EMPLOYEE;

-- {SELECT 컬럼명, 컬럼명,...FROM 테이블명]
-- EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 전화번호 조회 

SELECT EMP_ID,EMP_NAME,EMP_NO FROM EMPLOYEE;

--EMLOYEE 테이블에서 모든 사원의 사번, 이름, 이메일, 입사일 조회 

SELECT EMP_ID,EMP_NAME,EMP_NO,HIRE_DATE FROM EMPLOYEE;

--DEPARTMENT 테이블에 있는 모든 행 조회 
SELECT * FROM DEPARTMENT;

-----------------------------------------------------------------------------

-- <컬럼 값 산술 연산>SPOOL
-- 컬럼값 : 테이블의 한칸(== 한셀)에 작성된 값(DATA)

-- SELECT문 작성시 컬럼명에 산술 연산을 작성하면 
-- 조회되는 결과 컬럼 값에 산술 연산이 반영된다. 

-- EMPLOYEE 테이블에서 모든 사원의 사번, 이름 ,급여 조회 +100만 조회 
SELECT EMP_ID,EMP_NAME,SALARY,SALARY+1000000
FROM EMPLOYEE;

--EMPLYOEE 테이블에서 모든 사원의 이름, 급여, 연봉(급여*12개월)을 조회 
SELECT EMP_ID,EMP_NAME,SALARY,SALARY*12 FROM EMPLOYEE;

-----------------------------------------------------------------------------

-- (중요) <오늘 날짜 조회>
SELECT SYSDATE FROM DUAL;


-- SYSDATE : 시스템 상의 현재 날짜 
--          (년/월/일/시/분/초 단위까지 표현 가능하지만, 
--          디벨로퍼의 날짜 표기 방법이 년/월/일로 지정되어 있는 것이다. 

-- DUAL(DUmmy tAbLe): 가짜 테이블(임시테이블, 단순 조회 테이블)
-- ** DB는 날짜 데이터의 연산(+,-)이 가능하다 (일단위)**

--SELECT 오늘, 내일, 어제 FROM DUAL;
SELECT SYSDATE,SYSDATE+1,SYSDATE-1 FROM DUAL;

--EMPLOYEE 테이블에서 이름, 입사일, 오늘까지 근무한 날짜 조회 
SELECT EMP_NAME,HIRE_DATE,(SYSDATE- HIRE_DATE)/365 FROM EMPLOYEE;


--<컬럼 별칭 지전>
-- SELECT 조회 결과의 집합인 RESULT SET에 컬럼명을 지점 

/*
1) 컬럼명 AS 별칭 : 띄어쓰기 X 특수문자 X 문자 O
2) 컬럼명 별칭 : 1번에서 AS만 생략 한 것 

3) 컬럼명 AS "별칭" : 띄어쓰기 O, 특수문자 O, 문자O
4) 컬럼명 "별칭" : 3번에서 AS만 생략 한 것 
*/


-- EMPLOYEE 테이블에서 
-- 사번, 이름, 급여(원), 근무 일수를 모두 조회 
SELECT EMP_ID AS 사번,
       EMP_NAME 이름,
       SALARY AS "급여(원)",
       SYSDATE-HIRE_DATE "근무 일수"
FROM EMPLOYEE;

-----------------------------------------------------------------------------
-- 리터럴 : 값 자체 
-- DB에서의 리터럴 : 임의로 지정한 값을 기존 테이블에 존재하는 값처럼 사용 
-- 리터럴표기법 ''(홑따옴표)

SELECT EMP_NAME,SALARY,'원' AS 단위
FROM EMPLOYEE;

-----------------------------------------------------------------------------

--DISTINCT : 조회 시 컬럼에 포함된 중복 값을 한번만 표시할때 사용 


-- (주의사항)
-- 1) DISTINCT는 SELECT문에 딱 한번만 작성할 수 있다.
-- 1) DISTINCT는 SELECT문에 가장 앞에 작성되어야한다. 

-- EMPLOYEE 테이블에 저장된 직원들이 속해있는 부서 코드 종류 조회 
SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;

-----------------------------------------------------------------------------

-- WHERE절 
-- 테이블에서 조건을 충족하는 값을 가진 행만 조회하고자 할 때 사용 
-- 비교연산자 : >, <, >=, <=, =(같다), != ,<>(같지않다)

-- EMPLOYEE 테이블에서 급여가 3백만원 초과인 직원의 
-- 사번 이름 급여 부서코드를 조회 
/*해석순서*/
/*3*/SELECT EMP_ID,EMP_NAME,SALARY,DEPT_CODE 
/*1*/ FROM EMPLOYEE
/*2*/ WHERE SALARY >3000000;

-- EMPLOYEE테이블에서 부서코드가 'D9'인 직원의 
-- 사번,이름,부서코드,전화번호 조회 
SELECT EMP_ID,EMP_NAME,DEPT_CODE,PHONE
FROM EMPLOYEE
WHERE DEPT_CODE='D9';

-----------------------------------------------------------------------------

-- 논리연산자 (AND,OR)
-- EMPLOYEE테이블에서 급여가 200만 이상이고
-- 부서코드가 'D6'인 직원의 
-- 이름,급여,부서코드를 조회 

SELECT EMP_NAME,SALARY,DEPT_CODE
FROM EMPLOYEE
WHERE SALARY >= 2000000
AND DEPT_CODE ='D6';

-- EMPLOYEE테이블에서
-- 급여가 300만이상, 500만 이하인 직원 
-- 사번, 이름, 급여 조회 

SELECT EMP_ID,EMP_NAME,SALARY
FROM EMPLOYEE
WHERE 5000000>=SALARY AND SALARY >= 3000000;

-- EMPLOYEE테이블에서
-- 부서코드가 'D6' 또는 'D9'인 사원의 
-- 사번, 이름,부서코드 조회 

SELECT EMP_ID,EMP_NAME,DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE ='D6'
OR DEPT_CODE = 'D9';

-----------------------------------------------------------------------------
-- 컬럼명 BETWEEN A AND B : 컬럼 값이 A 이상 B이하인 경우 

-- EMPLOYEE테이블에서
-- 급여가 300만이상, 500만 이하인 직원 
-- 사번, 이름, 급여 조회 

SELECT EMP_ID,EMP_NAME,SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3000000 AND 5000000;

-- 컬럼명 NOT BETWEEN A AND B : 컬럼 값이 A이상 B이하가 아닌경우 
--                           ==컬럼 값이 A 미만 B초과인 경우 

-- EMPLOYEE테이블에서
-- 급여가 200만미만, 500만 초과인 직원의 
-- 사번, 이름, 급여 조회 
SELECT EMP_ID,EMP_NAME,SALARY 
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 2000000 AND 5000000;

/*BETWEEN을 이용한 날짜 비교*/
-- EMPLOYEE 테이블에서 
-- 입사일이 1990/01/01~1999/12/31일(90년도 입사자)
-- 사번, 이름, 입사일 조회 

SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '1990/01/01' AND '1999/12/31';

/***'1990/01/01'날짜를 문자열 형식으로 작성하게 되면 DB가 알아서 판단하여 날짜타입(DATE)으로 형변환을 진행함.***

/*LIKE
-비교하려는 값이 특정한 패턴을 만족시키면 조회하는 연산자

[작성법]
WHERE 컬럼명 LIKE '패턴'
-- LIKE패턴(와일드카드) : '%'(포함),'_'(글자 수)


'%'예시 
1) 'A%' : 문자열에 A로 시작하는 모든 컬럼 값 
2) '%A' : 문자열에 A로 끝나는 모든 컬럼 값
3) '%A%' : 문자열에 A가 포함되어 있는 모든 컬럼 값

'_'예시 
1) 'A_': A뒤에 아무거나 한글자 
2) /'___A' : A 앞에 아무거나 세글자 (4글자 문자열이면서 A로 끝나야함)

*/

--EMPLOYEE 테이블에서 성이'이'씨인 사원의 사번, 이름 조회 
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '이%';

--EMPLOYEE 테이블에서 이름에'하'가 포함된 사원의 사번, 이름 조회 
SELECT EMP_ID,EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

--EMPLOYEE 테이블에서 전화번호가 010으로 시작하는 사원의 사번, 이름,전화번호 조회
SELECT EMP_ID,EMP_NAME,PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '010%';

SELECT EMP_ID,EMP_NAME,PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '010________';

-- 010으로 시작하지 않는 사람들 조회하기 
--> NOT LIKE (LIKE 결과를 부정) 

SELECT EMP_ID,EMP_NAME,PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- EMPLOYEE 테이블에서 
-- 이메일에 _앞글자가 세글자인 사번, 이름, 이메일 조회 
SELECT EMP_ID,EMP_NAME,EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';a

-- 문제점 : 와일드 카드 문자(_)와 패턴에 사용된 일반문자(_)의 모양이 같아서 문제 발생
-- 해결방법 : ESCAPE OPTION을 이용하여 일반 문자로 처리할 '_','%'앞에 아무 특수문자나 붙임 
SELECT EMP_ID,EMP_NAME,EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___$_%'ESCAPE'$';
                --> $뒤 한 글자만 (_)을 일반 문자 취급
                
-- 연습문제
--1. EMPLOYEE 테이블에서 이름 끝이 '연'으로 끝나는 사원의 이름 조회 
SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE '%연';

--2.EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 조회 
SELECT EMP_NAME, PHONE FROM EMPLOYEE WHERE PHONE NOT LIKE '010%';

--3.EMPLOYEE테이블에서 메일주소 '_'의 앞이 4자 이면서 DEPT_CODE가 D9또는 D6이고 
--  고용일이 90/01/01~00/12/01이고 급여 270만 이상인 사원 전체를 조회 
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '____$_%'ESCAPE'$' 
AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6')
AND HIRE_DATE BETWEEN '1990/01/01' AND '2000/12/01' 
AND SALARY >=2700000;


--종수오빠 코드 왜 나오지? 의문이지만 선생님이 모르겠다~ 라고 함
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____$_' ESCAPE '$'
AND DEPT_CODE='D9' OR DEPT_CODE='D6'
AND SALARY>=2700000
AND HIRE_DATE BETWEEN '1990/01/01' AND '2000/12/01';

-- 연산자 우선순위
/*
1. 산술연산자
2. 연결연산자
3. 비교연산자
4. IS NULL / IS NOT NULL, LIKE, IN / NOT IN
5. BETWEEN AND / NOT BETWEEN AND
6. NOT(논리연산자)
7. AND(논리연산자)
8. OR(논리연산자)
*/

-----------------------------------------------------------------------------

/*IN 연산자
-비교하려는 값과 목록에 작성된 값 중 일치하는 것이 있으면 조회하는 연산자
-- OR 연산을 연달아 작성한 효과 

[작성법]
컬럼명 IN (값 1,값2, 값3...)
*/

-- EMPLOYEE테이블에서 부서코드가 D1 또는 D6 또는 D9인 사원의 사번,이름, 부서코드 조회 

SELECT EMP_ID,EMP_NAME,DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D1' OR DEPT_CODE = 'D6' OR DEPT_CODE = 'D9'  
WHERE DEPT_CODE IN ('D1','D6','D9');

-- EMPLOYEE테이블에서 사번200,205,210인 사원의 사번,이름 조회 
SELECT EMP_ID,EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID IN (200,205,210);

SELECT EMP_ID,EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID NOT IN (200,205,210);

-----------------------------------------------------------------------------

-- 연결연산자(||)
-- 여러 값을 하나의 칼럼 값으로 연결하는 연산자
-- (자바의 문자열 + (이어쓰기) 효과)

SELECT EMP_NAME ||'의 급여는'|| SALARY || '원 입니다,' AS "결과"
FROM EMPLOYEE;

-----------------------------------------------------------------------------

/*NULL 처리 연산자 

-- JAVA에서 NULL :참조하는 객체가 없다. 
-- DB에서 NULL : 칼럼 값이 없다. 

1) IS NULL :칼럼 값이 NULL인 경우 조회 
2) IS NOT NULL : 칼럼 값이 NULL이 아닌 경우 조회

*/

-- EMPLOYEE 테이블에서 전화번호가 없는 사원의 사번, 이름 전화번호 조회 
SELECT EMP_ID, EMP_NAME,PHONE
FROM EMPLOYEE
WHERE PHONE IS NULL;

-- EMPLOYEE 테이블에서 보너스를 받는 사원의 이름, 보너스 조회 
SELECT EMP_NAME,BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

/*ORDER BY 절 
- SELECT문의 조회 결과 (RESULT SET)를 정렬할 때 작성하는 구문 

- *****SELECT문 가장 마지막에 해석*****

[작성법]
3: SELECT 컬럼명 AS 별칭,컬럼명,컬럼명.....
1: FROM 테이블명 
2: WHERE 조건식 
4: ORDER BY 컬럼명 | 별칭 | 컬럼순서 [정렬방식(오름/내림] [NULLS FIRST|LAST]
*/

--EMPLOYEE 테이블에서 급여 "오름차순"으로 이름, 급여 조회 
SELECT EMP_NAME,SALARY
FROM EMPLOYEE
ORDER BY SALARY ASC;--(ASENDING)

--EMPLOYEE 테이블에서 급여 "내림차순"으로 이름, 급여 조회 
SELECT EMP_NAME,SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;--(DSENDING)

-- 급여가 200만 이상인 사원을 오름차순 정렬
SELECT *
FROM EMPLOYEE
WHERE SALARY >=2000000
ORDER BY SALARY /*ASC*/;
--ORDER BY 정렬 방식은 기본적으로 오름차순으로 !ASC 생략가능 

--**정렬은 숫자, 문자, 날짜 모두 사용 가능**

--이름 오름차순
SELECT EMP_NAME FROM EMPLOYEE ORDER BY EMP_NAME;

--고용일 내림차순
SELECT EMP_NAME , HIRE_DATE 
FROM EMPLOYEE 
--ORDER BY HIRE_DATE DESC;
ORDER BY 2 DESC; --> 컬럼 순서로 내림차순 진행! 

--연봉내림차순
SELECT EMP_NAME , SALARY * 12 AS 연봉 
FROM EMPLOYEE 
--WHERE 연봉 >=5000000 --> 해석 순서가 별칭 해석 전이기 때문에 오류 발생 
--ORDER BY SALARY*12 DESC; --> 컬럼명
--ORDER BY 2 DESC; --> 컬럼순서
ORDER BY 연봉 DESC;

--보너스 정렬 
SELECT EMP_NAME,BONUS 
FROM EMPLOYEE 
--ORDER BY BONUS; --> NULL LAST 기본값(NULLSR값은 항상 밑에 깔린다)
--ORDER BY BONUS DESC; -- NULLS FIRST 기본값 
ORDER BY BONUS NULLS LAST;

--오름차순 정렬 시 NULLS LAST가 기본값
--내림차순 정렬 시 NULSS FIRST가 기본값

/*정렬중첩(큰 분류를 먼저 정렬하고 내부에 작은 분류를 정렬)*/
-- EMPLOYEE테이블에서 부서코드 오름차순 정렬후 
-- 부서별 급여 내림차순 정렬 
SELECT EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
ORDER BY DEPT_CODE,SALARY DESC;