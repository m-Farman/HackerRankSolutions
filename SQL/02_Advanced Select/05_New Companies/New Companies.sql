
select company_code,founder,
    (select count(distinct lead_manager_code) from Lead_Manager l where l.company_code=c.company_code),
    (select count(distinct senior_manager_code) from Senior_Manager s where s.company_code=c.company_code),
    (select count(distinct manager_code) from Manager m where m.company_code=c.company_code),
    (select count(distinct employee_code) from Employee e where e.company_code=c.company_code)
from Company c order by company_code;
