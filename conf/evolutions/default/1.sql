# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table evento (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  descricao                     varchar(255),
  organizador                   varchar(255),
  preco                         double,
  data_evento                   datetime(6),
  constraint pk_evento primary key (id)
);


# --- !Downs

drop table if exists evento;

