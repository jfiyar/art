create database artworkcms;
use artworkcms;
create table artist
(
  user_id    int           null,
  nation     varchar(32)   null,
  birthday   timestamp     null,
  profession varchar(32)   null,
  info       varchar(255)  null,
  revire     int default 0 not null,
  constraint artist_user_id_uindex
    unique (user_id)
)
  charset = utf8;

create table artwork
(
  id     int auto_increment
    primary key,
  name   varchar(32)      not null,
  artist int              null,
  info   longtext         null,
  review int    default 0 not null,
  score  double default 0 not null
)
  charset = utf8;

create table artwork_comment
(
  id        int auto_increment
    primary key,
  reply     int                                 null,
  user_id   int                                 not null,
  content   varchar(255)                        null,
  timestamp timestamp default CURRENT_TIMESTAMP not null
)
  charset = utf8;

create table artwork_media
(
  artwork_id int          not null,
  type       varchar(16)  not null,
  url        varchar(255) null
)
  charset = utf8;

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

INSERT INTO artworkcms.user (id, name, pwd, auth, avatar, sex, isArtist) VALUES (1, 'admin', '123123', 'user', null, 0, 0);
INSERT INTO artworkcms.user (id, name, pwd, auth, avatar, sex, isArtist) VALUES (2, '与众不同', '123123', 'user', null, 0, 0);
INSERT INTO artworkcms.user (id, name, pwd, auth, avatar, sex, isArtist) VALUES (6, '与众同', '123123', 'user', null, 0, 0);
INSERT INTO artworkcms.user (id, name, pwd, auth, avatar, sex, isArtist) VALUES (7, '与众同222', '123123', 'user', null, 0, 0);
INSERT INTO artworkcms.user (id, name, pwd, auth, avatar, sex, isArtist) VALUES (9, '与众同2222', '123123', 'user', null, 0, 0);
INSERT INTO artworkcms.user (id, name, pwd, auth, avatar, sex, isArtist) VALUES (11, '1233', '4297f44b13955235245b2497399d7a93', 'user', null, 0, 0);