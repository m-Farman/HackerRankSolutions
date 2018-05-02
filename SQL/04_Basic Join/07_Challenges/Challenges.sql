
with t as (select h.hacker_id,name,count(challenge_id) as cn from  Hackers h, Challenges c 
where h.hacker_id=c.hacker_id 
group by h.hacker_id,name order by count(challenge_id) desc,h.hacker_id)
select * from t where cn not in (select cn from t where cn < (select max(cn) from t) group by cn having count(hacker_id) > 1);

