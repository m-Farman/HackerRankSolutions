
select c.contest_id, c.hacker_id, name,sum(ts) as ts,sum(tas) as tas,sum(tv) as tv,sum(tuv) as tuv
from 
 contests c left join colleges cg
  on c.contest_id = cg.contest_id
left join challenges cl
  on cg.college_id = cl.college_id 
left join  (select challenge_id,sum(total_views) as tv ,sum(total_unique_views) as tuv from view_stats group by challenge_id) views
  on cl.challenge_id=views.challenge_id
left join  (select challenge_id,sum(total_submissions) as ts ,sum(total_accepted_submissions) as tas from submission_stats group by challenge_id) sub
  on cl.challenge_id=sub.challenge_id
group by c.contest_id,c.hacker_id, name
having (sum(ts) + sum(tas) + sum(tv) + sum(tuv)) > 0
order by c.contest_id;

