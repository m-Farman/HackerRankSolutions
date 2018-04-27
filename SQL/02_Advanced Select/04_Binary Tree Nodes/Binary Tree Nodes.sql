
select n, case 
        when exists(select * from BST b where b.n =m.n and b.p is null) then 'Root'
        when exists(select * from BST where m.n not in (Select distinct p from BST k where k.p is not null)) then 'Leaf'
        else
           'Inner'
        end
from BST m order by n;
