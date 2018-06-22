create table Employee(ID int not null identiy(1,1), FirstName varchar(255) not null, LastName varchar(255) not null, EmailAddress varchar(255) not null unique, primary key(ID));

create table Asset(ID int not null identity(1,1), SerialNumber varchar(255) not null, Vendor varchar(255) not null, DisposalDate date, Notes varchar(255), primary key(ID));

create table Loan(ID not null identity(1,1), EmployeeID int, AssetID int, StartDate date not null, EndDate date, primary key(ID), foreign key(EmployeeID) references Employee(ID), foreign key(AssetID) references Asset(ID));

