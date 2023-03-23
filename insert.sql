insert into Bank_User values('kim', '1234', 'kim','Seoul', '1234-5678');
insert into Bank_User values('hong', '4567', 'hong','Seoul', '7777-5678');
insert into Bank_User values('roh', '0000', 'roh','Deagu', '8888-5678');


insert into account_list values('010-8847-6578', '0001', 'roh', 10000);
insert into account_list values('010-1234-6578', '1111', 'roh', 5000);
insert into account_list values('010-4567-6578', '2222', 'hong', 7000);
insert into account_list values('010-9999-6578', '3333', 'hong', 3000);
insert into account_list values('010-8888-6578', '4444', 'kim', 4000);

select * from bank_user;
select * from account_list;
select * from account_dw;

desc bank_user;
desc account_list;

insert into account_dw (acc_number, division, amount) values('010-8847-6578', '입금', 5000);

select user_id, acc_number, acc_balance
				from Account_list
				order by 1;

select rowCount, user_id, acc_number, acc_balance, to_char(division_date, 'yy-MM-dd HH24:mm:ss') 시간
from account_dw inner join account_list using(acc_number);


select user_id, acc_number, acc_balance
				from Account_list where user_id = 'roh';
                
                
                
commit;