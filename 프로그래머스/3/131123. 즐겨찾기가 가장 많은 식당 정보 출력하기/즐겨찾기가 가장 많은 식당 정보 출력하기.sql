-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info rf
where favorites = (select max(favorites) from rest_info where rf.food_type = food_type)
order by FOOD_TYPE desc

/*

음식 종류 별로 즐겨찾기 수가 가장 많은 식당 조회
음식종류: food_type
즐겨찾기: favorites
max(FAVORITES) as FAVORITES
group by 음식 종류

한식	00001	은돼지식당	734
중식	00015	만정	20
일식	00002	하이가쯔네	112
양식	00003	따띠따띠뜨	102
분식	00008	애플우스	151

한식 온돼지식당 734
일식 스시사카우스 230
분식 애플우스 151
양식 따띠따띠뜨 102
중식	00015	만정	20

*/