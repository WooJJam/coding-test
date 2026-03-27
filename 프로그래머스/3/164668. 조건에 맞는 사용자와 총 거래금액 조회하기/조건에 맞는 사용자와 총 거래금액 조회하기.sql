-- 코드를 입력하세요
# select writer_id, title, price, status
SELECT ugu.user_id, ugu.nickname, sum(ugb.price) as total_sales
from used_goods_board ugb
join used_goods_user ugu on ugb.writer_id = ugu.user_id
where ugb.status = 'DONE'
group by ugu.user_id
having total_sales >= 700000
order by total_sales;


/*
USED_GOODS_BOARD -> 중고 거래 게시판 정보
USED_GOODS_USER -> 중고 거래 게시판 사용자 정보

완료된 중고 거래의 총금액이 70만 원 이상
사람의 회원 ID, 닉네임, 총거래금액 조회
정렬: 총 거래금액, 오름차순
*/