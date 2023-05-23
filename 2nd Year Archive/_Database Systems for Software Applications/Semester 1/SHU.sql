drop table vehicle;
create table vehicle (VehicleType char(10), CurrentValue number(8,2));
insert into vehicle values ('Bus', 12500.00);
insert into vehicle values ('Car', 9987);
select * from vehicle;
