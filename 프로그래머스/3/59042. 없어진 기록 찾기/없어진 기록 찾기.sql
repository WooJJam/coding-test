-- 코드를 입력하세요
SELECT ao.ANIMAL_ID, ao.NAME
from animal_outs ao
where not exists (
    select 1
    from animal_ins ai
    where ai.animal_id = ao.animal_id
)
order by ao.animal_id 