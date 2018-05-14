
select listagg(r, '&' ) within group (order by r) 
from (
with ct as (select rownum+1 as r from all_objects where rownum < 1000)
select r , 1 as rnk
from ct o
where r <= 1000
and not exists (select mod(o.r,i.r) from ct i  where i.r <= o.r/2 and mod(o.r,i.r)=0)
)
 group by rnk;

