-- 코드를 입력하세요
SELECT b.category, sum(bs.sales) as TOTAL_SALES
from book b
join book_sales bs on b.book_id = bs.book_id 
    and bs.sales_date >= '2022-01-01' 
    and bs.sales_date <= '2022-01-31'
group by b.category
order by b.category asc

# SELECT bs.*
# from book_sales bs
# where bs.sales_date >= '2022-01-01' 
#     and bs.sales_date < '2022-02-01'
# order by bs.book_id
# join book_sales bs on b.book_id = bs.book_id 
#     and bs.sales_date >= '2022-01-01' 
#     and bs.sales_date <= '2022-01-31'
# group by b.category
# order by b.category asc

/*
2022년 1월의 카테고리 별 도서 판매량을 합산
카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 출력
카테고리명 오름차순 정렬
*/