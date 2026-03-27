-- 코드를 입력하세요
SELECT concat_ws('/', '/home/grep/src', ugb.board_id, concat(ufg.file_id, ufg.file_name, ufg.file_ext)) as FILE_PATH
from used_goods_board ugb
join used_goods_file ufg on ugb.board_id = ufg.board_id
where ugb.views = (
    select max(ugb2.views)
    from used_goods_board ugb2
)
order by ufg.file_id desc

# SELECT *
# from used_goods_board ugb
# join used_goods_file ufg on ugb.board_id = ufg.board_id
# where ugb.views = (
#     select max(ugb2.views)
#     from used_goods_board ugb2
# )

/*
USED_GOODS_BOARD와 USED_GOODS_FILE 테이블에서 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회

첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬 

기본적인 파일경로는 /home/grep/src/
게시글 ID를 기준으로 디렉토리가 구분
파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성 

조회수가 가장 높은 게시물은 하나만 존재합니다.

B0008	hong02	자전거 판매합니다	출퇴근용으로 구매했다가 사용하지 않아서 내놔요	40000	2022-10-04 00:00:00	SALE	301	IMG_000011	.png	photo	B0008
B0008	hong02	자전거 판매합니다	출퇴근용으로 구매했다가 사용하지 않아서 내놔요	40000	2022-10-04 00:00:00	SALE	301	MOV_000008	.avi	photo1	B0008


*/