
select s.name 
from
(select s.id,s.name,p.salary from Students s, Packages p where s.id=p.id) s,
(select f.id,f.friend_id,p.salary from Friends f, Packages p where f.friend_id=p.id) f
where s.id=f.id and f.salary > s.salary order by f.salary;

