drop table filedata;
create table filedata
(
	id integer not null,
	file_name VARCHAR(100) NOT NULL,
	file_size VARCHAR(50) NOT NULL,
	creation_time VARCHAR(50) NOT NULL,
	mime_type VARCHAR(50),
	file_path VARCHAR(255),
	primary key (id)
);
