

select distinct city from station 
where SUBSTR(city,1,1) not in ('A','E','I','O','U','a','e','i','o','u') or 
    SUBSTR(city,-1,1) not in ('a','e','i','o','u','A','E','I','O','U');

