-- create table jtarget_job
drop table if exists jtarget_job;

CREATE table jtarget_job
(
  job_id varchar(32) primary key,
  job_region varchar(255),
  job_salary double(10, 2),
  job_name varchar(255),
  job_contact varchar(255),
  job_detail varchar(10000),
  domain varchar(100),
  profession varchar(100),
  experience_min tinyint,
  experience_max tinyint,
  soft_skills varchar(100),
  create_by varchar(32),
  create_date timestamp
);

