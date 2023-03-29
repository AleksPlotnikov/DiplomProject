CREATE table Teachers(id SERIAL NOT NULL PRIMARY KEY,
					 name varchar (20) NOT NULL,
					 sur_name varchar (30),
					  salary varchar (10),
					  date_come_work varchar (10)
					 );
CREATE table Groups(id int NOT NULL PRIMARY KEY,
					Name varchar(10) NOT NULL,
					Rating int NOT NULL,
					Year int NOT NULL
					);
CREATE table Departments(id int NOT NULL PRIMARY KEY,
						Financing money NOT NULL,
						Name varchar(100) NOT NULL UNIQUE
						);
CREATE table Faculties(id int NOT NULL PRIMARY KEY,
					   Name varchar(100) NOT NULL UNIQUE
					   );
CREATE table EmploymentDate(date int NOT NULL,
							Name nvarchar(max) NOT NULL
							);
							.