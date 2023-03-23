CREATE TABLE Account ( -- 계정 테이블
    account_number NUMBER(10) PRIMARY KEY, -- 계좌번호
    account_type VARCHAR2(20),                           -- 계정유형
    account_balance NUMBER(18,2),                      -- 계정잔액
    owner_name VARCHAR2(50),                            -- 소유자 이름
    owner_address VARCHAR2(100),                      -- 소유자 주소
    owner_phone_number VARCHAR2(20)              -- 소유자 연락처
);

CREATE TABLE Deposit ( -- 입금 테이블
    deposit_id NUMBER(10) PRIMARY KEY,          -- 입금ID
    account_number NUMBER(10),                         -- 계좌번호
    deposit_amount NUMBER(18,2),                       -- 입금액
    deposit_date DATE,                                           -- 입금일
    transaction_id NUMBER(10),                             -- 식별ID
    FOREIGN KEY (account_number) REFERENCES Account(account_number) -- 계좌번호 외래키 설정
);

CREATE TABLE Withdrawal ( -- 출금 테이블
    withdrawal_id NUMBER(10) PRIMARY KEY,   -- 출금ID
    account_number NUMBER(10),                       -- 계좌번호
    withdrawal_amount NUMBER(18,2),                -- 출금액
    withdrawal_date DATE,                                   -- 출금일
    transaction_id NUMBER(10),                          -- 식별ID
    FOREIGN KEY (account_number) REFERENCES Account(account_number) -- 계좌번호 외래키 설정
);
-- Deposit_SEQ 시퀀스 생성
CREATE SEQUENCE Deposit_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Withdrawal_SEQ 시퀀스 생성
CREATE SEQUENCE Withdrawal_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 시퀀스 자동등록 Deposit_TransactionID 트리거 생성
CREATE OR REPLACE TRIGGER Deposit_TransactionID
BEFORE INSERT ON Deposit
FOR EACH ROW
BEGIN
  SELECT Deposit_SEQ.NEXTVAL INTO :NEW.transaction_id FROM DUAL;
END;

-- 시퀀스 자동등록 Withdrawal_TransactionID 트리거 생성
CREATE OR REPLACE TRIGGER Withdrawal_TransactionID
BEFORE INSERT ON Withdrawal
FOR EACH ROW
BEGIN
SELECT Withdrawal_SEQ.NEXTVAL INTO :NEW.transaction_id FROM DUAL;
END;