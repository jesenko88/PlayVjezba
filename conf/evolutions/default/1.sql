# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  id                        integer not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_customer primary key (id))
;

create sequence customer_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists customer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists customer_seq;

