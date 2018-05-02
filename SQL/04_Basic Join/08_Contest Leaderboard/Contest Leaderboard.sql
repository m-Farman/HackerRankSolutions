
select h.hacker_id,name,sum(ms) as sc from hackers h, (select hacker_id, challenge_id,max(score) as ms from submissions group by hacker_id, challenge_id) s where h.hacker_id = s.hacker_id 
group by h.hacker_id,name having sum(ms) > 0 order by sc desc,hacker_id;


