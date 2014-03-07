alter table item add column recipeId int(11);

drop table if exists `user`;
drop table if exists recipe;
drop table if exists user_preference;
drop table if exists user_allergies;
drop table if exists user_dislikes;
drop table if exists ingredients;

create table user (id int(11) auto_increment primary key, first_name char(255), middle_name char(255), last_name char(255), birthyear int);
create table recipe (id int(11) auto_increment primary key, description text(16384), cuisine char(255), calories bigint);
create table user_preference(id int(11) auto_increment primary key, userId int(11) not null, preference char(255));
create table user_allergies(id int(11) auto_increment primary key, userId int(11) not null, allergy char(255));
create table user_dislikes(id int(11) auto_increment primary key, userId int(11) not null, dislike char(255));
create table ingredients(id int(11) auto_increment primary key, recipeId int(11) not null, ingredient char(255));

insert into idmapping values (1, '1');
insert into idmapping values (2, '2');
insert into idmapping values (3, '3');
insert into idmapping values (4, '4');
insert into idmapping values (5, '5');
insert into idmapping values (6, '6');

insert into user values (1, 'Jonh', 'I', 'Doe', 1980);
insert into user values (2, 'Roger', 'T', 'Young', 1985);
insert into user values (3, 'Jane', 'D', 'Warren', 1962);
insert into user values (4, 'David', 'F', 'Fisher', 1960);
insert into user values (5, 'Cate', 'M', 'Rice', 1995);
insert into user values (6, 'Emma', 'P', 'Marshall', 1999);

insert into item values (1, 1, '1', 'ITEM', 'Recipe 1 (Asian)'   , '', 'http://easyrec.org/recipes/1', 'http://easyrec.org/recipes/1.jpg',1,CURRENT_TIMESTAMP,'0000-00-00 00:00:00',1);
insert into item values (2, 1, '2', 'ITEM', 'Recipe 2 (Asian)'   , '', 'http://easyrec.org/recipes/2', 'http://easyrec.org/recipes/2.jpg',1,CURRENT_TIMESTAMP,'0000-00-00 00:00:00',2);
insert into item values (3, 1, '3', 'ITEM', 'Recipe 3 (African)' , '', 'http://easyrec.org/recipes/3', 'http://easyrec.org/recipes/3.jpg',1,CURRENT_TIMESTAMP,'0000-00-00 00:00:00',3);
insert into item values (4, 1, '4', 'ITEM', 'Recipe 4 (African)' , '', 'http://easyrec.org/recipes/4', 'http://easyrec.org/recipes/4.jpg',1,CURRENT_TIMESTAMP,'0000-00-00 00:00:00',4);
insert into item values (5, 1, '5', 'ITEM', 'Recipe 5 (American)', '', 'http://easyrec.org/recipes/5', 'http://easyrec.org/recipes/5.jpg',1,CURRENT_TIMESTAMP,'0000-00-00 00:00:00',5);
insert into item values (6, 1, '6', 'ITEM', 'Recipe 6 (American)', '', 'http://easyrec.org/recipes/6', 'http://easyrec.org/recipes/6.jpg',1,CURRENT_TIMESTAMP,'0000-00-00 00:00:00',6);

insert into recipe values (1, 'Recipe 1 (Asian)'   , 'Asian', 100);
insert into recipe values (2, 'Recipe 2 (Asian)'   , 'Asian', 110);
insert into recipe values (3, 'Recipe 3 (African)' , 'African', 200);
insert into recipe values (4, 'Recipe 4 (African)' , 'African', 210);
insert into recipe values (5, 'Recipe 5 (American)', 'American', 300);
insert into recipe values (6, 'Recipe 6 (American)', 'American', 310);

insert into ingredients values ( 1, 1, 'Peanut');
insert into ingredients values ( 2, 1, 'Chicken');
insert into ingredients values ( 3, 2, 'Poultry');
insert into ingredients values ( 4, 2, 'Turkey');
insert into ingredients values ( 5, 3, 'Chicken');
insert into ingredients values ( 6, 3, 'Onion');
insert into ingredients values ( 7, 4, 'Tomatoes');
insert into ingredients values ( 8, 4, 'Onion');
insert into ingredients values ( 9, 5, 'Peanut');
insert into ingredients values (10, 5, 'Turkey');
insert into ingredients values (11, 6, 'Poultry');
insert into ingredients values (12, 6, 'Onion');

insert into user_allergies values (1, 1, 'Peanut');
insert into user_allergies values (2, 3, 'Onion');

insert into user_dislikes values (1, 2, 'African');
insert into user_dislikes values (2, 5, 'Asian');
