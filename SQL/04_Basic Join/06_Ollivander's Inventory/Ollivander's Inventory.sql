
Select w.id,wp.age,w.coins_needed,w.power from Wands w,Wands_Property wp,(select code,power,min(coins_needed) as cn from Wands group by code,power) t 
where w.code=wp.code and wp.is_evil=0
and w.coins_needed = t.cn and t.code=w.code and t.power=w.power  
order by power desc,age desc;
