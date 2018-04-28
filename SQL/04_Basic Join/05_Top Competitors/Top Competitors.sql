
select h.hacker_id,h.name from Submissions s,Challenges c, Difficulty d, Hackers h 
where s.hacker_id = h.hacker_id and s.challenge_id = c.challenge_id 
and  c.difficulty_level = d.difficulty_level and d.score=s.score
group by h.hacker_id,h.name having count(s.challenge_id) >1 order by count(s.challenge_id) desc,h.hacker_id;
