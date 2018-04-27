
select CEIL(avg(salary)-avg(to_number(replace(to_char(salary),'0','')))) from EMPLOYEES;
