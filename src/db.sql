drop database art;
create database art;
use art;
create table artist
(
  user_id    int                                 not null,
  nation     varchar(32)                         null,
  birthday   timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
  profession varchar(32)                         null,
  info       text                                null,
  review     int       default 0                 not null,
  avatar     varchar(255)                        null,
  constraint artist_user_id_uindex
    unique (user_id)
)
  charset = utf8;

alter table artist
  add primary key (user_id);

create table artwork
(
  id     int auto_increment
    primary key,
  name   varchar(32)   not null,
  artist int           null,
  info   longtext      null,
  review int default 0 not null,
  score  int default 0 not null
)
  charset = utf8;

create table artwork_comment
(
  id        int auto_increment
    primary key,
  reply     int                                 null,
  user_id   int                                 not null,
  content   text                                null,
  timestamp datetime default CURRENT_TIMESTAMP not null,
  art_id    int                                 null
)
  charset = utf8;

create table artwork_media
(
  id         int auto_increment
    primary key,
  artwork_id int                         null,
  type       varchar(32) default 'image' null,
  url        varchar(255)                null
);

create table user
(
  id       int auto_increment
    primary key,
  name     varchar(32)                not null,
  pwd      varchar(32)                not null,
  auth     varchar(10) default 'user' not null,
  avatar   varchar(255)               null,
  sex      int         default 0      null,
  isArtist tinyint(1)  default 0      not null,
  constraint user_name_uindex
    unique (name)
)
  charset = utf8;

insert into user (name, pwd, auth, isArtist) values ('admin','4297f44b13955235245b2497399d7a93','admin',1);

# create
#   definer = root@localhost procedure per2()
# begin
#   declare num int;
#   set num = 1;
#   while num < 10000 do
#   insert into artwork values (num + 100, 'test name', 16, 'test info', 1, 3.0);
#   insert into artwork_media (artwork_id, type, url) values (num + 100, default, '/upload/37.jpg');
#   set num = num + 1;
#   end while;
# end;

