-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
    case 
        when STATUS = 'SALE' then '판매중'
        when STATUS = 'DONE' then '거래완료'
        when STATUS = 'RESERVED' then '예약중'
    end as STATUS
from used_goods_board
where created_date = '2022-10-05'
order by board_id desc;