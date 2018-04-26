
select CONCAT( name, '('||substr(occupation,1,1)||')') from OCCUPATIONS order by name;
select 'There are a total of '||count(*)||' '||LOWER(occupation)||'s.' from OCCUPATIONS group by occupation order by count(*),occupation;
