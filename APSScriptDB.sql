-- Criando a database
create database aps;

-- Usando a database
use aps;

-- Criando a tabela de imagens e suas colunas
create table if not exists `images` (
  `id` integer primary key auto_increment,
  `image` longblob not null
) Engine = innodb;