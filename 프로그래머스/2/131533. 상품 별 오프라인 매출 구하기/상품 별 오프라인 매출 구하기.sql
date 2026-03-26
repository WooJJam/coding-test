SELECT p.PRODUCT_CODE, sum(os.sales_amount) * price as SALES
from product p
right join offline_sale os on p.product_id = os.product_id
group by os.product_id
order by SALES desc, p.product_code asc;