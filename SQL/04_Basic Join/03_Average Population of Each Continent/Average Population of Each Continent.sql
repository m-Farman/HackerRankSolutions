
select Continent,FLOOR(avg(ci.population)) from CITY ci,COUNTRY co where ci.countrycode= co.code group by Continent;
