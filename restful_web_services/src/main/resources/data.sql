insert into user_details(id,birth_date,name)
values(1001,current_date(),'Taran');

insert into user_details(id,birth_date,name)
values(1002,current_date(),'Some Person');

insert into user_details(id,birth_date,name)
values(1003,current_date(),'Other Person');

insert into post(id,description,user_id)
values(20001, 'I want to learn cloud', 1001);

insert into post(id,description,user_id)
values(20002, 'I want to learn Spring Framework', 1001);

insert into post(id,description,user_id)
values(20003, 'I want to learn Azure', 1002);
