drop table season;
CREATE TABLE season (
     id int NOT NULL AUTO_INCREMENT,
     name CHAR(10) NOT NULL UNIQUE,
     PRIMARY KEY (id)
);

drop table animal;
CREATE TABLE animal (
     id int NOT NULL AUTO_INCREMENT,
     name CHAR(25) NOT NULL UNIQUE,
     PRIMARY KEY (id)
);

drop table hunt_type;
CREATE TABLE hunt_type (
     id int NOT NULL AUTO_INCREMENT,
     type CHAR(15) NOT NULL UNIQUE,
     PRIMARY KEY (id)
);

drop table hunter;
CREATE TABLE hunter (
     guid CHAR(36) not null,
     first_name varchar(30),
     middle_initial varchar(1),
     last_name varchar(30),
     cin varchar(15),
     email varchar(255),
     cell_number varchar(10),
     day_number varchar(10),
     user_name varchar(30),
     passwd varchar(50),
     address varchar(255),
     city varchar(255),
     home_state varchar(50),
     zip varchar(8),
     dob DATE,
     social varchar(4),
     sex varchar(1),
     height INT,
     weight INT,
     hair_color varchar(25),
     eye_color varchar(25),
     PRIMARY KEY (guid)
);

drop table hunt;
CREATE TABLE hunt (
     guid CHAR(36) not null,
     client_guid CHAR(36),
     season CHAR(10),
     year SMALLINT,
     animal CHAR(25),
     hunt_type CHAR(15),
     PRIMARY KEY (guid),
     FOREIGN KEY(client_guid) references hunter(guid),
     FOREIGN KEY (season) references season(name),
     FOREIGN KEY (animal) references animal(name),
     FOREIGN KEY (hunt_type) references hunt_type(type)
);

