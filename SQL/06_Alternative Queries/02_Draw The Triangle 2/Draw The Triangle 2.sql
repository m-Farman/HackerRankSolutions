select trim(lpad(' ',rownum*2,'* '))
from all_objects
where rownum <=20;
