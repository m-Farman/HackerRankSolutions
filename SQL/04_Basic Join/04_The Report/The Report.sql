
Select case 
        when grade > 7 then name
        else 
            'NULL'
        end as n, grade,marks from (        
                select id,name,marks,(Select grade from Grades where marks between min_mark and max_mark) as grade
                    from Students
            ) order by grade desc,n, marks asc; 
