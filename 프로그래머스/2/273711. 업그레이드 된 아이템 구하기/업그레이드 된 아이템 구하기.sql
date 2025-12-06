select ii.item_id, ii.item_name, ii.rarity
from item_info ii
join item_tree it on ii.item_id = it.item_id
where it.parent_item_id in 
    (select ii.item_id
    from item_info ii
    where ii.rarity = 'RARE')
order by ii.item_id desc;