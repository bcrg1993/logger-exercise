create table logger_tbl(
	id					int					not null	auto_increment, 
	message				varchar(1000)		not null,
	level				varchar(30)			not null,
	execution_time		varchar(50)			not null,
	primary key (id)
);