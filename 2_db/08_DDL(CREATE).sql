/*
- 데이터 딕셔너리란 ? 
자원을 효율적으로 관리하기 위한 다양한 정보를 저장하는 시스템 테이블
데이터 딕셔너리라는 사용자가 테이블을 생성하거나 사용자를 변경하는 등의 
작업을 할때 데이터베이스 서버에 의해 자동으로 갱신되는 테이블 

- User_tables : 자신의 계정이 소유한 객체 등에 관한 정보를 조회할 수 잇는 딕셔너리 뷰 

*/
--------------------------------------------------------------------------------------------------------------------

-- DDL(DATA DEFINITION LANGUAGE) : 데이터 정의 언어

-- 객체(OBJECT)를 만들고(CREATE), 수정(ALTER)하고, 삭제(DROP) 등
-- 데이터의 전체 구조를 정의하는 언어로 주로 DB관리자, 설계자가 사용함

-- 오라클에서의 객체 : 테이블(TABLE), 뷰(VIEW), 시퀀스(SEQUENCE),
--                   인덱스(INDEX), 패키지(PACKAGE), 트리거(TRIGGER)
--                   프로시져(PROCEDURE), 함수(FUNCTION),
--                   동의어(SYNONYM), 사용자(USER)

--------------------------------------------------------------------------------------------------------------------
-- CREATE

-- 테이블이나 인덱스, 뷰 등 다양한 데이터베이스 객체를 생성하는 구문
-- 테이블로 생성된 객체는 DROP구문을 통해 제거할 수 있음 

-- 1. 데이블 생성하기 
-- 테이블이란 ? 
-- 행(row)과 열(column)으로 구성되는 가장 기본적인 데이터베이스 객체 
-- 데이터 베이스 내에서 모든 데이터는 테이블을 통해서 저장된다. 

-- [표현식] 
/*
    CREATE TABLE 테이블명 (
        컬럼명 자료형(크기), 
        컬럼명 자료형(크기),
        ...);
*/

/* 자료형
    NUMBER : 숫자형(정수, 실수)
    CHAR(크기) : 고정길이 문자형 (2000BYTE) 
        -> ex) CHAR(10) 컬럼에 'ABC' 3BYTE 문자열만 저장해도 10BYTE 저장공간을 모두 사용. 
        
    VARCHAR2(크기) : 가변길이 문자형 (4000 BYTE)
        -> ex) VARCHAR2(10) 컬럼에 'ABC' 3BYTE 문자열만 저장하면 나머지 7BYTE를 반환함.
        
    DATE : 날짜 타입
    BLOB : 대용량 이진 데이터 (4GB)
    CLOB : 대용량 문자 데이터 (4GB)
*/

-- 1) MEMBER 테이블 생성 
CREATE TABLE MEMBER1(
    MEMER_ID VARCHAR2(20), --가변 길이 문자열 20바이트 (영어, 숫자만 작성 시 20글자 작성 가능)
    MEMBER_PWD VARCHAR2(20),
    MEMBER_NAEM VARCHAR2(30), -- 한글은 3BYTE니까 한글은 10글자 사용 가능
    MEMBER_SSN CHAR(14), --990808-1234567
    EMPLOYEE_DATE DATE DEFAULT SYSDATE
);
-- Table MEMBER이(가) 생성되었습니다.
-- DEFAULT : 입력되는 값이 없거나 'DEFAULT' 키워드 사용 시에 기록되어질 값을 지정 

-- 만든 테이블 확인 
SELECT * FROM MEMBER;
SELECT * FROM User_tables; --딕셔너리 뷰 (데이터 딕셔너리에서 일부분만 뽑아서 만든 가상 테이블)
-- 접속창 > 계정열고 > 테이블 클릭 > 위쪽 새로고침 클릭 > MEMBER 테이블 보임

-- 2) 컬럼에 주석 달기 
-- [표현식] 
-- COMMENT ON COLUMN 테이블.컬러명 IS '주석내용';
COMMENT ON COLUMN MEMBER1.MEMER_ID IS '회원 아이디';
COMMENT ON COLUMN MEMBER1.MEMBER_PWD IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER1.MEMBER_NAEM IS '회원 이름';
COMMENT ON COLUMN MEMBER1.MEMBER_SSN IS '주민 등록 번호';
COMMENT ON COLUMN MEMBER1.EMPLOYEE_DATE IS '회원 가입일';

-- USER_TABLES : 사용자가 작성한 테이블을 확인하는 뷰 
-- 데이터 딕셔너리에 정의되어 있음 
SELECT * FROM USER_TABLES;

-- MEMBER 테이블에 샘플 데이터 삽입
INSERT INTO MEMBER1 VALUES('MEM01','123ABC','홍길동','990808-1234567', DEFAULT);
COMMIT;


-- 데이터 삽입 확인
SELECT * FROM MEMBER1;

-- 추가 샘플 데이터 삽입
-- 가입일 -> SYSDATE를 활용
INSERT INTO MEMBER1 VALUES('MEM02', 'QWER1234', '김영희', '980909-2345678', SYSDATE);
COMMIT;
SELECT * FROM MEMBER;

-- 가입일 -> DEFAULT 활용(테이블 생성 시 정의된 값이 반영됨)
INSERT INTO MEMBER1 VALUES('MEM03', 'ASDFQWER', '박철수', '950405-1111222', DEFAULT);
COMMIT;
SELECT * FROM MEMBER;

-- 가입일 -> INSERT 시 미작성 하는 경우 -> DEAFULT 값이 반영됨
INSERT INTO MEMBER(MEMER_ID, MEMBER_PWD, MEMBER_NAEM, MEMBER_SSN)
VALUES('MEM04', '12341234', '이지연', '000101-4564567');
COMMIT;
--  데이터  삽입 확인
SELECT * FROM MEMBER;

-- 주민등록번호의 데이터 타입을 NUMBER로 지정할 경우 문제점 
CREATE TABLE MEMBER2(
MEMBER_NAME VARCHAR2(30),
MEMBER_SSN NUMBER);

INSERT INTO MEMBER2 VALUES ('홍길동',9908081234567);
SELECT * FROM MEMBER2;

INSERT INTO MEMBER2 VALUES('김영희',0011134567890); -- 출력 값 : 11134567890
SELECT * FROM MEMBER2;

--> NUMBER 타입 컬럼에 데이터 삽입 시 앞에 0이 있으면 사라지는 문제점이 있음!

DROP TABLE MEMBER2; -- 테이블 삭제 

--------------------------------------------------------------------------------------------------------------------

-- 제약조건 (CONSTRAINTS)

/*
    사용자가 원하는 조건의 데이터만 유지하기 위해서 특정 컬럼에 설정하는 제약.
    데이터 무결성 보장을 목적으로 함 
    -> 데이터 무결성이란 ? 중복 최소화 / NULL 최소화 지향
    
    + 입력 데이터에 문제가 없는지 자동으로 검사하는 목적
    + 데이터의 수정/삭제 가능여부 검사등을 목적으로 함 
        --> 제약조건을 위배하는 DML 구문은 수행할 수 없음!
    
    제약조건 종류
    PRIMARY KEY, NOT NULL, UNIQUE, CHECK, FOREIGN KEY.
   
*/

-- 제약 조건 확인 
--USER_CONSTRAINTS: 사용자가 작성한 제약조건을 확인하는 딕셔너리 뷰 
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;

-- USER_CONS_COLUMNS : 제약조건이 걸려 있는 컬럼을 확인하는 딕셔너리 뷰 
DESC USER_CONS_COLUMS;
SELECT * FROM USER_CONS_COLUMNS;

-- 1.NOT NULL
-- 해당 컬럼에 반드시 값이 기록되어야 하는 경우 사용
-- 삽입 / 수정 시 NULL값을 허용하지 않도록 컬럼레벨에서 제한 
CREATE TABLE USER_USED_MN(
    USER_NO NUMBER NOT NULL, -- 사용자 번호 (무조건 있어야 함==NULL이면 안된다)
                             -- 컬럼 레벨 제약조건 설정 
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);
    
INSERT INTO USER_USED_MN
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_MN
VALUES(NULL, NULL, NULL, NULL, NULL, '010-1234-5678', 'hong123@kh.or.kr');
--ORA-01400: NULL을 ("PJA"."USER_USED_MN"."USER_NO") 안에 삽입할 수 없습니다
--ORA-01400 --> 오류코드로 구글링 


----------------------------------------------------------------------------
--2. UNIQUE 제약조건
-- 컬럼에 입력 값에 대해서 중복을 제한하는 제약조건
-- 컬럼레벨에서 설정가능, 테이블 레벨에서 설정 가능
-- 단, UNIQUE 제약조건이 설정된 컬럼에 NULL값은 중복 삽입 가능 

-- UNIQUE 제약 조건 테이블 생성 
CREATE TABLE USER_USED_UK(
    USER_NO NUMBER,
    --USER_ID VARCHAR2(20)UNIQUE ,--컬럼레벨 제약조건 설정 (제약조건명 미지정)
    --USER_ID VARCHAR2(20) CONSTRAINT USER_ID_U UNIQUE,
                                             --제약 조건명 
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    
    -- 테이블 레벨 제약조건 설정 부분 
    --UNIQUE(USER_ID) --테이블 레벨 제약조건 설정(제약조건명 미지정)
    CONSTRAINT USER_ID_U UNIQUE(USER_ID) --제약조건명 지정 
);
DROP TABLE USER_USED_UK; --테이블 삭제 

INSERT INTO USER_USED_UK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_UK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
--> 같은 ID인 데이터가 이미 테이블에 있으므로 UNIQUE 제약 조건에 위배되어 오류 발생 
-- ORA-00001: (UNIQUE)무결성 제약 조건(PJA.USER_ID_U)에 위배됩니다
            
INSERT INTO USER_USED_UK
VALUES(1, NULL, 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
-- ID에 NULL값 삽입가능

INSERT INTO USER_USED_UK
VALUES(1, NULL, 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
-- ID에 NULL값 중복 삽입 가능 

SELECT * FROM USER_USED_UK;

-- 오류 보고에 나타나는 SYS_C008635 같은 제약 조건명으로
-- 해당 제약 조건이 설정된 테이블명, 컬럼, 제약 조건 타입 조회 
SELECT UCC.TABLE_NAME, UCC.COLUMN_NAME, UC.CONSTRAINT_TYPE
FROM USER_CONSTRAINTS UC, USER_CONS_COLUMNS UCC
WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
AND UCC.CONSTRAINT_NAME = 'USER_ID_U';
                        -- 제약조건명 

----------------------------------------------------------------------------

-- UNIQUE 복합키 
-- 두개 이상의 컬럼을 묶어서 하나의 UNIQUE 제약 조건을 설정함
--> 모든 컬럼의 값이 같아야 중복으로 취급합 !!
--> 복합키는 테이블 레벨로만 지정할 수 있다. 

CREATE TABLE USER_USED_UK2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20) ,
    USER_PWD VARCHAR2(30) ,
    USER_NAME VARCHAR2(30) ,
    GENDER VARCHAR2(10) ,
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)   ,
    
    -- 테이블 레벨 제약조건 설정
    CONSTRAINT USER_ID_NAME_U UNIQUE(USER_ID, USER_NAME)
);

INSERT INTO USER_USED_UK2
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_UK2
VALUES(2, 'user02', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
--> USER_ID가 다름 -> 삽입 성공 

INSERT INTO USER_USED_UK2
VALUES(2, 'user02', 'pass01', '고길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
--> USER_NAME 다름 -> 삽입성공

INSERT INTO USER_USED_UK2
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
--> 여러 컬럼을 묶어서 UNIQUE 제약 조건이 설정 되어 있으면
--  두컬럼이 모두 중복되는 값일 경우에만 오류 발생
-- ORA-00001: 무결성 제약 조건(PJA.USER_ID_NAME_U)에 위배됩니다

SELECT * FROM USER_USED_UK2;

----------------------------------------------------------------------------

--3. PRIMARY KEY(기본키) 제약조건
-- 테이블에서 한 행의 정보를 찾기위해 사용할 컬럼을 의미함 (주민등록키..)
-- 테이블에 대한 식별자(IDENTIFIER)역할을 함 
-- NOT NULL + UNIQUE 제약조건을 의미
-- 한 테이블당 한개만 설정 할 수 있음 
-- 컬럼레벨,테이블레벨 둘다 설정 가능함
-- 한 개 컬럼에 설정할 수도 있고, 여러개의 칼럼을 묶어서 설정할 수 있음 (복합키)

SELECT * FROM EMPLOYEE WHERE EMP_ID =200;

CREATE TABLE USER_USED_PK(

    USER_NO NUMBER /*CONSTRAINT USER_NO_PK*/ /* PRIMARY KEY*/,--컬럼레벨 PK 지정 
                  /* 생략가능*/
    UEER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50), 
    
    CONSTRAINT USE_NO_PK PRIMARY KEY(USER_NO)--테이블 레벨 PK 지정 

);

DROP TABLE USER_USED_PK;

INSERT INTO USER_USED_PK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_PK
VALUES(1, 'user02', 'pass02', '이순신', '남', '010-5678-9012', 'lee123@kh.or.kr');
-- 기본 키 중복으로 오류 
-- ORA-00001: 무결성 제약 조건(PJA.USE_NO_PK)에 위배됩니다

INSERT INTO USER_USED_PK
VALUES(NULL, 'user03', 'pass03', '유관순', '여', '010-9999-3131', 'yoo123@kh.or.kr');
-- 키본키가 NULL이므로 오류 'ORA-01400: NULL을 ("PJA"."USER_USED_PK"."USER_NO") 안에 삽입할 수 없습니다 '

----------------------------------------------------------------------------

--PRIMARY KEY 복합기 (테이블 레벨만 가능)

CREATE TABLE USER_USED_PK2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    CONSTRAINT PK_USERNO_USERID PRIMARY KEY(USER_NO, USER_ID) -- 복합키
);

INSERT INTO USER_USED_PK2
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_PK2
VALUES(1, 'user02', 'pass02', '이순신', '남', '010-5678-9012', 'lee123@kh.or.kr');

INSERT INTO USER_USED_PK2
VALUES(2, 'user01', 'pass01', '유관순', '여', '010-9999-3131', 'yoo123@kh.or.kr');

INSERT INTO USER_USED_PK2
VALUES(1, 'user01', 'pass01', '신사임당', '여', '010-9999-9999', 'sin123@kh.or.kr');
-- 회원번호와 아이디 둘다 중복 되었을때만 제약조건 위배 에러 발생 
-- ORA-00001: 무결성 제약 조건(PJA.PK_USERNO_USERID)에 위배됩니다

SELECT  * FROM USER_USED_PK2;

--PRIMARY KEY(식별키)는 NULL이 들어갈 수 없다. ->복합키여도 PRIMARY KEY 이므로 NULL절대 안됨! 
INSERT INTO USER_USED_PK2
VALUES(NULL, 'user01', 'pass01', '신사임당', '여', '010-9999-9999', 'sin123@kh.or.kr');

-------------------------------------------------------------------------------------------------

--4. FOREIGN KEY(외부키/외래키) 제약조건 
-- 다른 테이블의 PK 또는 UNIQUE 제약조건이 설정된 컬럼 

-- 참조(REFERENCES)된 다른 테이블의 컬럼이 제공하는 값만 사용할 수 있음
-- FOREIGN KEY제약조건에 의해서 테이블간의 관계(RELATIONSHIP)가 형성됨
-- 제공되는 값 외에는 NULL을 사용할 수 있음

-- 컬럼레벨일 경우
-- 컬럼명 자료형(크기) [CONSTRAINT 이름] REFERENCES 참조할 테이블명 [(참조할컬럼)] [삭제룰]

-- 테이블레벨일 경우
-- [CONSTRAINT 이름] FOREIGN KEY (적용할컬럼명) REFERENCES 참조할테이블명 [(참조할컬럼)] [삭제룰]
          --> 테이블 레벨에서만  FOREIGN KEY 단어가 사용된다!

-- * 참조될 수 있는 컬럼은 PRIMARY KEY컬럼과, UNIQUE 지정된 컬럼만 외래키로 사용할 수 있음
--참조할 테이블의 참조할 컬럼명이 생략이 되면, PRIMARY KEY로 설정된 컬럼이 자동 참조할 컬럼이 됨

CREATE TABLE USER_GRADE(
  GRADE_CODE NUMBER PRIMARY KEY,
  GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE VALUES (10, '일반회원');
INSERT INTO USER_GRADE VALUES (20, '우수회원');
INSERT INTO USER_GRADE VALUES (30, '특별회원');

SELECT * FROM USER_GRADE;


CREATE TABLE USER_USED_FK(
  USER_NO NUMBER PRIMARY KEY,
  USER_ID VARCHAR2(20) UNIQUE,
  USER_PWD VARCHAR2(30) NOT NULL,
  USER_NAME VARCHAR2(30),
  GENDER VARCHAR2(10),
  PHONE VARCHAR2(30),
  EMAIL VARCHAR2(50),
  GRADE_CODE NUMBER -- CONSTRAINT GRADE_CODE_FK REFERENCES USER_GRADE(GRADE_CODE) --컬럼 레벨 FK 설정 
 ,CONSTRAINT GRADE_CODE_FK FOREIGN KEY(GRADE_CODE) REFERENCES  USER_GRADE
 
);


INSERT INTO USER_USED_FK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr', 10);

INSERT INTO USER_USED_FK
VALUES(2, 'user02', 'pass02', '이순신', '남', '010-5678-9012', 'lee123@kh.or.kr', 10);

INSERT INTO USER_USED_FK
VALUES(3, 'user03', 'pass03', '유관순', '여', '010-9999-3131', 'yoo123@kh.or.kr', 30);

INSERT INTO USER_USED_FK
VALUES(4, 'user04', 'pass04', '안중근', '남', '010-2222-1111', 'ahn123@kh.or.kr', null);
-- NULL 사용 가능 

SELECT * FROM USER_USED_FK;

INSERT INTO USER_USED_FK
VALUES(5, 'user05', 'pass05', '윤봉길', '남', '010-6666-1234', 'yoon123@kh.or.kr', 50);
-- > 50이라는 값은 USER_GRADE테이블 GRADE_CODE컬럼에서 제공하는 값이 아니므로 
--   외래키 제약 조건에 위배되어 오류 발생 (==50을 참조하지 않아서 오류 발생한다)
-- ORA-02291: 무결성 제약조건(PJA.GRADE_CODE_FK)이 위배되었습니다- 부모 키가 없습니다 
            --> 참조 무결성 위배 
            
-------------------------------------------------------------------------------------------------


-- * FOREIGN KEY 삭제 옵션 
-- 부모 테이블의 데이터 삭제 시 자식 테이블의 데이터를 
-- 어떤식으로 처리할 지에 대한 내용을 설정 할 수 있다. 

SELECT * FROM USER_GRADE; --참조 당하는 테이블 == 부모테이블
SELECT * FROM USER_USED_FK;   --참조 하는 테이블 == 자식테이블

DELETE FROM USER_GRADE
WHERE GRADE_CODE = 10;
-- ORA-02292: 무결성 제약조건(PJA.GRADE_CODE_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다 -- 자식도 10을 쓰고 있음 그러니 삭제 못해 ! 

-- 1) ON DELETE RESTRICTED(삭제제한)로 기본 지정되어 있음 
-- FOREIGN KEY로 지정된 컬럼에서 사용되고 있는 값일 경우 
-- 제공하는 컬럼의 값은 삭제하지 못함 

-- GRADE_CODE 중에서 외래키로 참조되고 있지 않으므로 삭제 가능!
COMMIT;

DELETE FROM USER_GRADE
WHERE GRADE_CODE = 20;

-- 20 삭제 되었는지 확인 
SELECT * FROM USER_GRADE; 
ROLLBACK;


--2) ON DELETE SET NULL: 부모키 삭제시 자식키를 NULL로 변경하는 옵션

CREATE TABLE USER_GRADE2(
  GRADE_CODE NUMBER PRIMARY KEY,
  GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE2 VALUES (10, '일반회원');
INSERT INTO USER_GRADE2 VALUES (20, '우수회원');
INSERT INTO USER_GRADE2 VALUES (30, '특별회원');

-- ON DELETE SET NUL 삭제 옵션이 적용된 테이블 생성
CREATE TABLE USER_USED_FK2(
  USER_NO NUMBER PRIMARY KEY,
  USER_ID VARCHAR2(20) UNIQUE,
  USER_PWD VARCHAR2(30) NOT NULL,
  USER_NAME VARCHAR2(30),
  GENDER VARCHAR2(10),
  PHONE VARCHAR2(30),
  EMAIL VARCHAR2(50),
  GRADE_CODE NUMBER CONSTRAINT GRADE_CODE_FK2 REFERENCES USER_GRADE2 ON DELETE SET NULL
                                                                     --> 삭제 옵션 추가                
);

--샘플 데이터 삽입
INSERT INTO USER_USED_FK2
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr', 10);

INSERT INTO USER_USED_FK2
VALUES(2, 'user02', 'pass02', '이순신', '남', '010-5678-9012', 'lee123@kh.or.kr', 10);

INSERT INTO USER_USED_FK2
VALUES(3, 'user03', 'pass03', '유관순', '여', '010-9999-3131', 'yoo123@kh.or.kr', 30);

INSERT INTO USER_USED_FK2
VALUES(4, 'user04', 'pass04', '안중근', '남', '010-2222-1111', 'ahn123@kh.or.kr', null);

COMMIT;

SELECT * FROM USER_GRADE2;
SELECT * FROM USER_USED_FK2;

-- 부모 테이블인 USER_GRADE2에서 GRADE_CODE = 10삭제 
-- ON DELETE SET NULL 옵션이 설정되어 있어 오류 없이 삭제 됨 
DELETE FROM USER_GRADE2 WHERE GRADE_CODE = 10;

SELECT * FROM USER_GRADE2; --부모테이블 삭제 확인 (10없음)
SELECT * FROM USER_USED_FK2; -- 자식 테이블 NULL 변환 확인 


--3) ON DELETE CASCADE : 부모키 삭제시 자식키도 함께 삭제됨
-- 부모키 삭제 시 값을 사용하는 자식 테이블의 컬럼에 해당하는 행이 삭제가 됨 

CREATE TABLE USER_GRADE3(
  GRADE_CODE NUMBER PRIMARY KEY,
  GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE3 VALUES (10, '일반회원');
INSERT INTO USER_GRADE3 VALUES (20, '우수회원');
INSERT INTO USER_GRADE3 VALUES (30, '특별회원');

-- ON DELETE CASCADE 삭제 옵션이 적용된 테이블 생성
CREATE TABLE USER_USED_FK3(
  USER_NO NUMBER PRIMARY KEY,
  USER_ID VARCHAR2(20) UNIQUE,
  USER_PWD VARCHAR2(30) NOT NULL,
  USER_NAME VARCHAR2(30),
  GENDER VARCHAR2(10),
  PHONE VARCHAR2(30),
  EMAIL VARCHAR2(50),
  GRADE_CODE NUMBER  ,
  
  CONSTRAINT GRADE_CODE_FK3 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE3(GRADE_CODE) ON DELETE CASCADE
);

--샘플 데이터 삽입
INSERT INTO USER_USED_FK3
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr', 10);

INSERT INTO USER_USED_FK3
VALUES(2, 'user02', 'pass02', '이순신', '남', '010-5678-9012', 'lee123@kh.or.kr', 10);

INSERT INTO USER_USED_FK3
VALUES(3, 'user03', 'pass03', '유관순', '여', '010-9999-3131', 'yoo123@kh.or.kr', 30);

INSERT INTO USER_USED_FK3
VALUES(4, 'user04', 'pass04', '안중근', '남', '010-2222-1111', 'ahn123@kh.or.kr', null);

COMMIT;

SELECT * FROM USER_GRADE3;
SELECT * FROM USER_USED_FK3;

-- 부모 테이블인 USER_GRADE3에서 GRADE_CODE = 10삭제 
DELETE FROM USER_GRADE3 WHERE GRADE_CODE = 10;

SELECT * FROM USER_GRADE3; --부보 행 삭제 확인(10없어짐)
SELECT * FROM USER_USED_FK3;ㅇ -- 10을 참조하던 자식 행 삭제 확인(종속 관계의 행이 모두 삭제됨)
-- ON DELETE CASCADE 옵션으로 인해 참조키를 사용한 행이 삭제됨을 확인

-------------------------------------------------------------------------------------------------

--5. CHECK 제약조건 : 컬럼에 기록되는 값에 조건 설정을 할 수 있음 
-- CHECK (컬럼명 비교연산자 비교값)
-- 주의 : 비교값은 리터럴만 사용할 수 있음, 변하는 값이나 함수 사용 불가 

CREATE TABLE USER_USED_CHECK(
  USER_NO NUMBER PRIMARY KEY,
  USER_ID VARCHAR2(20) UNIQUE,
  USER_PWD VARCHAR2(30) NOT NULL,
  USER_NAME VARCHAR2(30),
  
  GENDER VARCHAR2(10) CONSTRAINT GENDER_CHECK CHECK(GENDER IN ('남','여'))  ,
  
  PHONE VARCHAR2(30),
  EMAIL VARCHAR2(50)
);

INSERT INTO USER_USED_CHECK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_CHECK
VALUES(2, 'user02', 'pass02', '홍길동', '남자', '010-1234-5678', 'hong123@kh.or.kr');
-- GENDER 컬럼에 CHECK 제약조건으로 '남' 또는 '여'만 기록이 가능한데 
-- '남자'라는 조건 이외에 값이 들어와 에러 발생 
-- ORA-02290: 체크 제약조건(PJA.GENDER_CHECK)이 위배되었습니다

-- CHECK 제약 조건은 범위로도 설정 가능 


-- [연습 문제]
-- 회원가입용 테이블 생성(USER_TEST)
-- 컬럼명 : USER_NO(회원번호) - 기본키(PK_USER_TEST), 
--         USER_ID(회원아이디) - 중복금지(UK_USER_ID),
--         USER_PWD(회원비밀번호) - NULL값 허용안함(NN_USER_PWD),
--         PNO(주민등록번호) - 중복금지(UK_PNO), NULL 허용안함(NN_PNO),
--         GENDER(성별) - '남' 혹은 '여'로 입력(CK_GENDER),
--         PHONE(연락처),
--         ADDRESS(주소),
--         STATUS(탈퇴여부) - NOT NULL(NN_STATUS), 'Y' 혹은 'N'으로 입력(CK_STATUS)
-- 각 컬럼의 제약조건에 이름 부여할 것

CREATE TABLE USER_TEST(
  USER_NO NUMBER CONSTRAINT PK_USER_TEST PRIMARY KEY,
  USER_ID VARCHAR2(20) CONSTRAINT UK_USER_ID UNIQUE,
  USER_PWD VARCHAR2(30) CONSTRAINT NN_USER_PWD NOT NULL,
  PNO VARCHAR2(30) CONSTRAINT UK_PNO UNIQUE CONSTRAINT NN_PNO NOT NULL,
  
  -- CONSTRAINT UK_PNO UNIQUE (PNO)
  
  GENDER VARCHAR2(10) CONSTRAINT CK_GENDER CHECK(GENDER IN ('남','여')),
  PHONE VARCHAR2(30),
  ADDRESS VARCHAR2(100),
  STATUS VARCHAR2(20) DEFAULT 'N' CONSTRAINT NN_STATUS NOT NULL,
  CONSTRAINT CK_STATUS CHECK(STATUS IN ('Y','N'))
  --STATUS VARCHAR2(20) CONSTRAINT CK_STATUS CHECK(STATUS IN ('Y','N')) CONSTRAINT NN_STATUS NOT NULL
);

COMMENT ON COLUMN USER_TEST.USER_ID IS '회원 아이디';
COMMENT ON COLUMN USER_TEST.USER_PWD IS '회원 비밀번호';
COMMENT ON COLUMN USER_TEST.USER_NO IS '회원 이름';
COMMENT ON COLUMN USER_TEST.PNO IS '주민 등록 번호';
COMMENT ON COLUMN USER_TEST.GENDER IS '성별';
COMMENT ON COLUMN USER_TEST.PHONE IS '연락처';
COMMENT ON COLUMN USER_TEST.ADDRESS IS '주소';
COMMENT ON COLUMN USER_TEST.STATUS IS '탈퇴여부';

INSERT INTO USER_TEST
VALUES(1, 'user01', 'pass01', '880122-1234567', '남', '010-1111-9999', '서울시 강남구 역삼동','N');

SELECT * FROM USER_TEST;

INSERT INTO USER_TEST
VALUES (2, 'user02', 'pass02', '890222-2234567', '여', '010-2222-9999', '서울시 강남구 삼성동', 'N');
INSERT INTO USER_TEST
VALUES (3, 'user03', 'pass03', '900322-2234567', '여', '010-3333-9999', '서울시 강남구 청담동', 'Y');
INSERT INTO USER_TEST
VALUES (4, 'user04', 'pass04', '910422-1234567', '남', '010-4444-9999', '서울시 강남구 도곡동', 'N');
INSERT INTO USER_TEST
VALUES (5, 'user05', 'pass05', '920522-2234567', '여', '010-5555-9999', '서울시 강남구 대치동', 'N');


-- 테이블 확인 
SELECT * FROM USER_TEST;

-- 테이블 주석 확인 
SELECT * FROM USER_COL_COMMENTS
WHERE TABLE_NAME = 'USER_TEST';

--테이블 제약 조건 확인 
SELECT * FROM USER_CONSTRAINTS "C1"
JOIN USER_CONS_COLUMNS "C2" USING(CONSTRAINT_NAME)
WHERE C1.TABLE_NAME = 'USER_TEST';

-----------------------------------------------------------------------------------

-- 8. SUBQUERY 를 이용한 테이블 생성 
-- 컬럼명, 데이터 타입, 값이 복사되고, 제약조건은 NOT NULL만 복사됨 

--1) 테이블 전체 복사 
CREATE TABLE EMPLOYEE_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE_COPY;

--2) JOIN한 후 원하는 컬럼만 테이블로 복사 
CREATE TABLE EMPLOYEE_COPY2
AS SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME 
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

SELECT * FROM EMPLOYEE_COPY2;

--3) 테이블 형태(컬럼명,데이터 타입) 만 복사 (데이터 복사 X) 
CREATE TABLE EMPLOYEE_COPY3
AS SELECT * FROM EMPLOYEE 
   WHERE 1 = 0; 
   
SELECT * FROM EMPLOYEE_COPY3;

-----------------------------------------------------------------------------------

--9. 제약조건 추가
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] PRIMARY KEY(컬럼명)
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] 
--  FOREIGN KEY(컬럼명) REFERENCES 참조 테이블명(참조컬럼명)
     --> 참조 테이블의 PK를 기본키를 FK로 사용하는 경우 참조컬럼명 생략 가능
                                                                                                                                                      
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] UNIQUE(컬럼명)
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] CHECK(컬럼명 비교연산자 비교값)
-- ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;\

-- 테이블 제약 조건 확인 
SELECT * FROM USER_CONSTRAINTS C1
JOIN USER_CONS_COLUMNS C2 USING(CONSTRAINT_NAME)
WHERE C1.TABLE_NAME ='EMPLOYEE_COPY';

-- NOT NULL 제약조건만 반사된 EMPLOYEE_COPY테이블에 
-- EMP_ID 칼럼에 PRIMARY KEY 제약조건 추가 

-- 새롭게 추가한다. 
ALTER TABLE EMPLOYEE_COPY ADD
CONSTRAINT PK_EMP_COPY PRIMARY KEY(EMP_ID);

-- * 수업시간에 활용하던 테이블에는 FK 제약조건 없는상태이므로 추가!!

-- EMPLOYEE테이블의 DEPT_CODE에 외래키 제약조건 추가
-- 참조 테이블은 DEPARTMENT, 참조 컬럼은 DEPARTMENT의 기본키
ALTER TABLE EMPLOYEE ADD 
CONSTRAINT KF_DEPT_CODE FOREIGN KEY(DEPT_CODE)REFERENCES DEPARTMENT;
                                 -- 컬럼명 생략 시 DEPARTMENT PK 컬럼과 연결


-- EMPLOYEE테이블의 JOB_CODE 외래키 제약조건 추가
-- 참조 테이블은 JOB, 참조 컬럼은 JOB의 기본키
ALTER TABLE EMPLOYEE ADD
FOREIGN KEY(JOB_CODE) REFERENCES JOB;

-- EMPLOYEE테이블의 SAL_LEVEL 외래키 제약조건 추가
-- 참조 테이블은 SAL_GRADE, 참조 컬럼은 SAL_GRADE의 기본키
ALTER TABLE EMPLOYEE ADD
FOREIGN KEY(SAL_LEVEL) REFERENCES SAL_GRADE;

-- DEPARTMENT테이블의 LOCATION_ID에 외래키 제약조건 추가
-- 참조 테이블은 LOCATION, 참조 컬럼은 LOCATION의 기본키
ALTER TABLE DEPARTMENT ADD
FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION;

-- LOCATION테이블의 NATIONAL_CODE에 외래키 제약조건 추가
-- 참조 테이블은 NATIONAL, 참조 컬럼은 NATIONAL의 기본키
ALTER TABLE LOCATION ADD
FOREIGN KEY(NATIONAL_CODE) REFERENCES NATIONAL;










