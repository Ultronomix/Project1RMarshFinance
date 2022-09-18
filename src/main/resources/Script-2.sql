create table ers_users(
user_id uuid primary key default gen_random_uuid(), 
username varchar unique not null,
email varchar unique not null,
password varchar unique not null,
given_name varchar not null,
surname varchar not null,
is_active boolean, 
role_id uuid, 
foreign key (role_id) REFERENCES ers_user_roles (role_id)

);

create table ers_reimbursements(
reimb_id uuid primary key default gen_random_uuid(), 
amount int, 
submitted timestamp not null,
resolved timestamp, 
description varchar not null,
receipt varchar, 
payment_id varchar, 
author_id uuid not null,
resolver_id uuid,
status_id varchar,
type_id varchar, 
foreign key (status_id) references ers_reimbursement_statuses (status_id),
foreign key (type_id) references ers_reimbursement_types (type_id),
foreign key (resolver_id) references ers_users(user_id),
foreign key (author_id) references ers_users (user_id)

);

create table ers_reimbursement_statuses(
status_id varchar primary key,
status varchar 
);

create table ers_reimbursement_types(
type_id varchar primary key,
type varchar 

);

create table ers_user_roles(
role_id uuid primary key default gen_random_uuid(),
role VARCHAR
);


select *
from ers_user_roles;



insert into ers_user_roles (role)
values ('Admin');

select *
from ers_user_roles;

insert into ers_users (username, email, password, given_name, surname, is_active, role_id)
VALUES('Admin Marsh', 'rema0813@yahoo.com', 'Passw0rd1234', 'Regina', 'Marsh','True', 'a243f8e0-0b4d-45ca-a40c-1a6d2b2f8fce');


select *
from ers_users
join ers_user_roles
on ers_users.role_id = ers_user_roles.role_id;

create user ReginaM with password 'Passw0rd1234';

select *
from ers_users;

insert into ers_user_roles(role)
values('Finance Manager');

insert into ers_user_roles(role)
values('Employee');


create table reimbursement (
amount int,
submitted varchar,
description varchar,
payment_id int,
author_id varchar,
status_id varchar,
type_id varchar,

foreign key (type_id) references ers_reimbursement_types (type_id)


);


insert into ers_reimbursement_types (type_id, type)
values ('89', 'Travel');

insert into reimbursement (amount, submitted, description, payment_id, author_id, status_id, type_id)
values ('200', 'monday', 'Traveled to Wisconsin for meeting', '0023', 'Sammy Turner', 'Pending', '89');



insert into ers_reimbursement_types (type_id, type)
values ('99', 'Food');

