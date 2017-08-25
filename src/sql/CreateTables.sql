drop table Centro;
drop table Localidad;
drop table Ayuntamiento;
drop table Provincia;

create table Provincia (
	id int primary key auto_increment,
	nombre varchar(64) not null
);

create table Ayuntamiento (
	id int primary key auto_increment,
	nombre varchar(64) not null,
	idProvincia int not null,
	foreign key (idProvincia) references Provincia(id)
);

create table Localidad (
	id int primary key auto_increment,
	nombre varchar(64) not null,
	codigo varchar(64) not null,
	idAyuntamiento int not null,
	foreign key (idAyuntamiento) references Ayuntamiento(id)
);

create table Centro (
	id int primary key auto_increment,
	codigo varchar(64) not null,
	nombre varchar(64) not null,
	direccion varchar(256) not null,
	idLocalidad int null,
	foreign key (idLocalidad) references Localidad(id),
	idAyuntamiento int not null,
	foreign key (idAyuntamiento) references Ayuntamiento(id),
	codigoPostal varchar(64) not null,
	telefono varchar(64) not null,
	coordenadaX varchar(64) not null,
	index (coordenadaX),
	coordenadaY varchar(64) not null,
	index (coordenadaY)
);
