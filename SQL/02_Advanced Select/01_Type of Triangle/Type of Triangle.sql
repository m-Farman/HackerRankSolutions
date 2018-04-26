
SELECT 
    case when (A+B>C AND A+C>B AND B+C>A) then
        case when (A=B AND B=C) then 'Equilateral'
        else case when (A=B OR B=C OR A=C) then 'Isosceles' else 'Scalene' end
        end
    else 'Not A Triangle'
    end 
FROM TRIANGLES;
