use inventario;

create table software
(

	codigo_maquina int not null,
    codigo_software int not null,
    nome varchar(30),
    arquitetura varchar(10),
    data_instalacao varchar(20),
    primary key(codigo_maquina,codigo_software)
);
    


    
