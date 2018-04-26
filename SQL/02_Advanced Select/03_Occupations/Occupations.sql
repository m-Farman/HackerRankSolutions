
SELECT d.Name, p.Name, s.Name, a.Name FROM 
(SELECT Name, rank() over(order by name) as num FROM Occupations WHERE Occupation = 'Doctor') d 
full join 
(SELECT Name, rank() over(order by name) as num FROM Occupations WHERE Occupation = 'Professor') p on d.num = p.num 
full join 
(SELECT Name, rank() over(order by name) as num FROM Occupations WHERE Occupation = 'Singer') s on d.num = s.num or p.num = s.num 
full join 
(SELECT Name, rank() over(order by name) as num FROM Occupations WHERE Occupation = 'Actor') a on d.num = a.num or p.num = a.num or s.num = a.num;

