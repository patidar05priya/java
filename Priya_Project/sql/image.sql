create table Image(
ImageName varchar(100),
Path varchar(100),
Price Double,
Color Varchar(10),
Dicription varchar(100),
size varchar(10),
Fabric varchar(50),
MadeIn varchar(20),
Gender varchar(20),
Type Varchar(15),
dateofEntry varchar(50)

);

use murach;
select * from Image;
ALTER TABLE Image MODIFY Color  VARCHAR(20);

drop table Image;
UPDATE Image set Type = 'Jeans' WHERE 	Dicription = 'Torn jeans casual ';
ALTER TABLE `Image` ADD PRIMARY KEY (ImageName);