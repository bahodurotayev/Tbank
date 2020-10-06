-- returning customer(firstname,lastname,transaction-id,trans_type,,trans-account,trans-amount,trans_date;--
SELECT customer.fname,customer.lname,transaction.id, transaction.transaction_type,transaction.trans_account,transaction.transaction_amount,transaction.date
FROM db_bank.transaction
JOIN db_bank.customer ON transaction.customer_id = customer.id
where transaction.customer_id=2 and transaction.date > CURRENT_DATE - 6; -- last 6 days transaction 
