create table usuarioDeMaquina
(
	login_responsavel varchar(30) not null primary key,
    nome varchar(30) not null,
    departamento varchar(30),
    funcao varchar(30)
);

create table maquina
(
    codigo_maquina varchar(20) not null ,
    hostname varchar(30) not null unique,
    patrimonio varchar(15),
    modelo varchar(15),
    fabricante varchar(15),
    numero_serie varchar(20),
    login_responsavel varchar(30),
    tipo varchar(15),
    primary key (codigo_maquina)
);	

create table processador
(	
    codigo_maquina varchar(20) not null ,
    nome varchar(30) not null,
    numero_de_nucleos varchar(2),
    frequenciaMaxima varchar(15),
    numero_de_processadores_logicos varchar(6),
    fabricante varchar(15),
    status_processador varchar(5),
    primary key(codigo_maquina)
    
);	

create table unidadeArmazenamento
(
    codigo_maquina varchar(30) not null ,
    codigo_hd int not null,
    nome varchar(30),
    tamanho varchar(30),
    tipo_de_interface varchar(10),
    tipo_de_midea varchar(15),
    status_drive varchar(5),
    primary key(codigo_maquina,codigo_hd)
);
   

create table software
(
	codigo_maquina varchar(30) not null,
    nome varchar(40) not null,
    arquitetura varchar(10),
    data_instalacao varchar(12),
    primary key(codigo_maquina,nome)
);


create table placaMae
(
    codigo_maquina varchar(20) not null ,
    modelo varchar(15),
    fabricante varchar(15),
    serial_placa varchar(15),
    status_drive varchar(5),
    primary key(codigo_maquina)
);    

create table sistemaOperacional(

codigo_maquina varchar(20) not null ,

    nome varchar(20) not null,
    arquitetura varchar(10),
    versao varchar(10),
    atualizacao varchar(15),
    primary key(codigo_maquina,codigo_sistema));

create table licencas 
(
    codigo_maquina varchar(25) not null, 
    software varchar(35) not null,
    chave varchar(35),
    data_expiracao varchar(15),
    primary key(codigo_maquina,software)
);

alter table memorias change codigo_maquina codigo_maquina varchar(20) not null;

create table maquina(
codigo_maquina varchar(30) not null primary key,
hostname varchar(30) not null unique,
patrimonio varchar(15),
numero_serie varchar(20),
fabricante varchar(20),
modelo_equipamento varchar(20),
responsavel varchar(30),
departamento_responsavel varchar(15),
login_responsavel varchar(15) not null,
email_reponsavel varchar(30),
telefone_responsavel varchar(20)

);

create table usuarios
(
	nome_usuario varchar(30) not null primary key,
	acesso varchar(30) not null,
	grupo_acesso varchar(8) not null,
	email varchar(40),
	telefone varchar(20)
); 

alter table sistemaOperacional add dataInstalacao varchar(20)
alter table sistemaOperacional add  hostname varchar(20) not null unique after codigo_maquina;    

create table adaptadoresDeRede
(
	codigo_maquina varchar(30) not null,
    nome varchar(30),
    mac_address varchar(20) not null,
    indice varchar(5) not null,
    ultimo_boot varchar(15),
    velocidade varchar(10),
    estatus varchar(10),
    fabricante varchar(30),
    descricao varchar(30),
    primary key(codigo_maquina,indice));



