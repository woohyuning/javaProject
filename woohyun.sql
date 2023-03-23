CREATE TABLE Bank_User ( -- 계정 테이블
    user_id VARCHAR2(20) primary key,                                     -- 아이디
    user_pw VARCHAR2(20) not null,                                          -- 비밀번호
    user_name VARCHAR2(20) not null,                                      -- 이름
    user_address VARCHAR2(100) not null,                                -- 주소
    user_phone_number VARCHAR2(20) not null                        -- 연락처
);

CREATE TABLE Account_list ( -- 계좌 테이블
    acc_number VARCHAR2(20) PRIMARY KEY,                                                   -- 계좌번호
    acc_pass    NUMBER(4)   not null,                                                                   -- 계좌비밀번호
    user_id   VARCHAR2(20),                                                                                   -- 아이디
    acc_balance NUMBER(18,2),
    constraint Account_check_account_balance check(acc_balance >= 0),           -- 계좌잔액
    FOREIGN KEY (user_id) REFERENCES Bank_User(user_id)
);

CREATE TABLE Account_DW ( -- 입출금 테이블
    rowCount NUMBER(10),                                                                                      -- 순번
    acc_number VARCHAR2(20) not null,                                                                 -- 계좌번호
    division VARCHAR2(10)
    CONSTRAINT Account_DW_division check (division in('입금','출금')),              -- 입출금 구분
    amount NUMBER(18,2) not null,                                                                         -- 입출금액
    division_date DATE DEFAULT systimestamp,                                                    -- 입금시간
    FOREIGN KEY (acc_number) REFERENCES Account_list(acc_number)            -- 계좌번호 외래키 설정
);

-- Deposit_SEQ 시퀀스 생성
CREATE SEQUENCE Account_DW_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;
/

-- 시퀀스 자동등록 Account_DW_rowCount 트리거 생성
CREATE OR REPLACE TRIGGER Account_DW_rowCount
BEFORE INSERT ON Account_DW
FOR EACH ROW
BEGIN
  SELECT Account_DW_SEQ.NEXTVAL INTO :NEW.rowCount FROM DUAL;
END;
/

-- 시퀀스 자동등록 Account_DW_division_date 트리거 생성
CREATE OR REPLACE TRIGGER Account_DW_division_date
BEFORE INSERT OR UPDATE ON Account_DW
FOR EACH ROW
BEGIN
  :NEW.division_date := SYSTIMESTAMP;
END;
/
