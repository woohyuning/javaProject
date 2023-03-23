select * from account_list;

select acc_balance from Account_list where acc_number = '123';

update Account_list 
set acc_balance = acc_balance + (select acc_balance from Account_list where acc_number =?) 
where acc_number = ?;

insert into account_dw (amount, division, acc_number)
values( 1 , '입금', 123 );

select user_id, acc_number, acc_balance
				from Account_list
				where user_id = 'roh';


select * from account_dw;


select rowcount, acc_number, division, amount, to_char(division_date , 'yy/MM/dd hh24:mm:ss')
from account_dw
where acc_number = '123';

desc account_dw;
desc bank_user;

select * from bank_user;

select * from bank_user where user_id ='roh';

update bank_user
set user_address = 'deagu', user_phone_number = '010-1234-1234', user_pw = '1234'
where user_id = 'roh';

commit;


commit;

