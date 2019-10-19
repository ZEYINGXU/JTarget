-- create table user
drop table if exists jtarget_user;

create table jtarget_user
(
  user_id varchar(32) primary key ,
  user_account varchar(255),
  user_name varchar(255),
  user_password varchar(255),
  user_type varchar(10),
  user_prefer varchar(100)
);