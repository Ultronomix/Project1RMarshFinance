create table ers_users(
user_id varchar primary key default 
username varchar unique not null
email varchar unique not null
password varchar unique not null
given_name varchar not null
surname varchar not null
is_active boolean 
role_id varchar constraint foreign key
);

create table ers_reimbursements(
reimb_id varchar primary key default 
amount int 
submitted timestamp not null
resolved timestamp 
description varchar not null
receipt blob 
payment_id varchar 
author_id varchar constraint foreign key not null
resolver_id varchar constraint foreign key 
status_id varchar constraint foreign key
type_id varchar constraint foreign key not null
);

create table ers_reimbursement_statuses(
status_id varchar primary key 
status varchar unique
);

create table ers_reimbursement_types(
type_id varchar primary key
type varchar unique
);

create table ers_user_roles(
role_id VARCHAR primary key
role VARCHAR unique
);