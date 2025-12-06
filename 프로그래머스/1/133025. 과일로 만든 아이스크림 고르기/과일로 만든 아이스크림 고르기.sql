select fh.flavor
from first_half fh
join icecream_info ii on ii.flavor = fh.flavor
where fh.total_order > 3000
and ii.INGREDIENT_TYPE = 'fruit_based'
order by fh.total_order desc;