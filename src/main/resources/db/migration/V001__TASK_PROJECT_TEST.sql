CREATE TABLE usuario (
	id 		BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome		varchar(255)		not null,
	sobrenome	varchar(255)		not null,
	cep		varchar(255)		not null,		
	localidade	varchar(255)		not null,
	bairro		varchar(255)		not null,
	logradouro	varchar(255)		not null
);


CREATE TABLE task (
	id 		BIGINT PRIMARY KEY AUTO_INCREMENT,
	usuario_id	varchar(255)		not null,
	task_nome	varchar(255)		not null,
	descricao	varchar(255)		not null,		
	status		varchar(255)		not null
);
