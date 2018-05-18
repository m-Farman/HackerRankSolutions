
with t as(select submission_date,count(distinct hacker_id) as cn
          from Submissions s 
          where exists ( select *  from Submissions k
                          where s.hacker_id=k.hacker_id and k.submission_date < s.submission_date
                          group by k.hacker_id having count(distinct k.submission_date) = s.submission_date - to_date('01-03-2016','dd-MM-yyyy'))
          group by submission_date
          union 
          Select submission_date, count(distinct hacker_id) as cn from Submissions where submission_date=to_date('01-03-2016','dd-MM-yyyy')
          group by submission_date),
     c as(select * from(
                  select o.* ,rank() over (partition by submission_date order by h_submission_count desc,hacker_id) as my_rank
                  from(
                      select submission_date,s.hacker_id,h.name,count(*) as h_submission_count
                      from Submissions s, Hackers h
                      where
                      s.hacker_id=h.hacker_id
                      group by s.submission_date,s.hacker_id,h.name
                      ) o
                      )
            where my_rank=1)
select t.submission_date,cn,hacker_id,name 
from t,c 
where t.submission_date=c.submission_date
order by t.submission_date;
