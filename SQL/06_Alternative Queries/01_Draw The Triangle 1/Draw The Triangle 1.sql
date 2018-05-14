

select trim(lpad(' ',rownum*2,'* ')) as l
from all_objects
where rownum <=20
order by l desc;

