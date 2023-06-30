-- TCL(TRANSACTION CONTROL LANGUAGE) : 트랜잭션 제어 언어 
-- COMMIT(트랜젝션 종료 후 저장),ROLLBACK(트랜젝션 취소),SAVEPOINT(임시저장)

-- DML: 데이터 조작 언어로 데이터의 삽입, 수정, 삭제 
-- 트랜젝션은 DML과 관련되어 있다. 

/* TRANSACTION이란?
- 데이터베이스의 논리적 연산 단위 == 장바구니라고 생각하자. 

- 데이터 변경 사항을 묶어 하나의 트랜젝션에 담아 처리함
- 트렌젝션의 대상이 되는 데이터 변경 사항 : INSERT,UPDATE,DELETE (DML)

EX) INSERT 수행 ---------------------------------> DB 반영(X)

    INSERT 수행 -> 트렌젝션에 추가  -> COMMIT -> DB반영(O)
    
    INSERT 10번 수행 -> 1개에 트렌젝션에 10개 추가 -> ROLLBACK ->DB 반영(X)
    
    1) COMMIT : 메모리 버퍼(트랜젝션)에 입시 저장된 변경사항을 DB에 반영 
    2) ROLLBACK : 메모리 버퍼(트렌젝션)에 임시 저장된 데이터 변경 사항을 삭제하고 마지막 COMMIT 상태로 돌아간다. 
    3) SAVEPOINT : 메모리버퍼(트랜젝션)에 저장 지점을 정의 하여 ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아닌 저장지점까지만 일부 ROLLBACK
    
    [SAVEPOINT 사용법]
    
    SAVEPOINT 포인트명 1;
    ...
    SAVEPOINT 포인트명 2;    
    ...
    ROLLBACK TO 포인트명 1; -> 포인트 1 지점까지 데이터 변경사항 삭제

*/

--CREATE TABLE DEPARTMENT2 AS SELECT * FROM DEPARTMENT;
--DEPARTMENT2 테이블 현재 상태 확인 
SELECT * FROM DEPARTMENT2;

-- D0,경리부,L2 삽입 
INSERT INTO DEPARTMENT2 VALUES('D1','기획팀', 'L1');
INSERT INTO DEPARTMENT2(DEPT_ID,DEPT_TITLE,LOCATION_ID)VALUES('D0','경리부','L2');

SELECT*FROM DEPARTMENT2;

ROLLBACK;

-- 롤백 후 다시 확인 
SELECT*FROM DEPARTMENT2;
-- 다시 INSERT 후 COMMIT
INSERT INTO DEPARTMENT2 VALUES('D1','기획팀', 'L1');
COMMIT;

-- ROLLBACK 수행 후 경리부가 삭제되었는지 확인 
ROLLBACK;
SELECT*FROM DEPARTMENT2;

-------------------------------------------------------------------------------
DELETE FROM DEPARTMENT2 WHERE DEPT_TITLE = '기획팀';

-- D0 삭제 시점에 SAVEPOINT 지정 
SAVEPOINT SP1; --Savepoint이(가) 생성되었습니다.

-- D9 삭제 
DELETE FROM DEPARTMENT2 WHERE DEPT_ID = 'D9';
SELECT * FROM DEPARTMENT2;

-- 일반 ROLLBACK 시 D9,D0가 복구됨 (이전에 커밋한 부분으로 간다)
ROLLBACK; 
SELECT * FROM DEPARTMENT2;

-- SP1까지 ROLLBACK 
ROLLBACK TO SP1;
SELECT * FROM DEPARTMENT2;

ROLLBACK; -- 일반 ROLLBACK 시 D9,D0가 복구됨 (이전에 커밋한 부분으로 간다)
SELECT * FROM DEPARTMENT2;























