select * from usersignup
use murach
ALTER TABLE usersignup MODIFY password  VARCHAR(100);

ALTER TABLE usersignup ADD Role VARCHAR(20);


truncate table usersignup;
ALTER TABLE `usersignup` ADD PRIMARY KEY (EmailAddress);