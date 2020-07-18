GO;
create database Odin;
GO;

use Odin;

Create Table TipoPessoa(
	id int IDENTITY(1,1) PRIMARY KEY,
	nome varchar(100) not null,
);

Insert into  TipoPessoa(nome) values ('teste_a');

Create Table Pessoa (
    id int IDENTITY(1,1) PRIMARY KEY,
	nome varchar(100) not null,
	rg varchar(11) not null,
	tipo int not null,

	FOREIGN KEY (tipo) REFERENCES TipoPessoa(id),

);

Insert into Pessoa( nome, rg, tipo) values ('teste_a', 'test_a', 1);

Create Table Apartamento (
	id int IDENTITY(1,1) PRIMARY KEY,
	andar varchar(10) not null,
	bloco varchar(10) not null,
	predio varchar(10) not null,
	numero varchar(10) not null,
);


Insert into  Apartamento ( andar, bloco, predio, numero) values ('teste_a', 'test_a', 'test_a', '1');

Create Table ApartamentoPessoa(
	id int IDENTITY(1,1) PRIMARY KEY,
	pessoa_id int not null,
	apartamento_id int not null,
	FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id),
	FOREIGN KEY (apartamento_id) REFERENCES Apartamento(id)
);

Create Table Historico(
	id int IDENTITY(1,1) PRIMARY KEY,
	pessoa_id int not null,
	DataEvento Datetime not null,
	descricaoEvento varchar(200) not null,
	apartamento_id int not null,
	tipoAcao int not null,
	entrou bit not null,
	entrega varchar(300),
	FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id),
	FOREIGN KEY (apartamento_id) REFERENCES Apartamento(id)
);

Insert into  Historico(pessoa_id, DataEvento, descricaoEvento, apartamento_id, tipoAcao, entrou, entrega) 
values (1,GETDATE(),'teste_a',1, 1, 1, null);