-- create table user
drop table if exists jtarget_apply;

create table jtarget_apply
(
  apply_id varchar(32) primary key,
  job_id varchar(32),
  user_id varchar(32)
);

