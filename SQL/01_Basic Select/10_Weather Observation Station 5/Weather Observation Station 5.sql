
select city,l from (Select city,length(city) as l from station order by length(city),city asc ) where rownum <=1; 
select city,l from (Select city,length(city) as l from station order by length(city) desc,city ) where rownum <=1; 
