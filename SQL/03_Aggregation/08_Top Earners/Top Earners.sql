
Select (months*salary),count(employee_id) from Employee where (months*salary) =(select max(months*salary) from Employee)
group by (months*salary);
