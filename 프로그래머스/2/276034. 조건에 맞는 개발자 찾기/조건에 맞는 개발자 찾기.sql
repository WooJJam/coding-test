select d.id, d.email, d.first_name, d.last_name
from developers d
where 
    d.skill_code & (select s.code from skillcodes s where s.name = 'Python')
    or d.skill_code & (select s.code from skillcodes s where s.name = 'C#')
order by d.id asc;