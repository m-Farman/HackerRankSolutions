
select start_date, ed from (
    select s.start_date, min(e.end_date) as ed
    from
    (select start_date from projects where start_date not in (select end_date from projects)) s,
    (select end_date from projects where end_date not in (select start_date from projects)) e
    where start_date < end_date
    group by s.start_date
)
order by (trunc(ed)-trunc(start_date)), start_date;
