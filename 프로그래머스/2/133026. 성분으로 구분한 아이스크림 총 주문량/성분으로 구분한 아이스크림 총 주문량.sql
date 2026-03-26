-- 코드를 입력하세요
select ii.ingredient_type, sum(fh.total_order) as TOTAL_ORDER
from icecream_info ii
join FIRST_HALF fh on ii.flavor = fh.flavor
group by ii.ingredient_type
order by TOTAL_ORDER asc;
