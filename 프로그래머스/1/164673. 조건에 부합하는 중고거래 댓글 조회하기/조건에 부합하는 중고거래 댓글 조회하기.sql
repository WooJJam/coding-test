select ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, date_format(ugr.created_date, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD ugb
join USED_GOODS_REPLY ugr on ugb.board_id = ugr.board_id
where ugb.created_date between '2022-10-01' and '2022-10-31'
order by ugr.created_date, ugb.title;

# SELECT board.title title, board.board_id board_id, reply.reply_id reply_id, reply.writer_id writer_id, reply.contents contents, DATE_FORMAT(reply.created_date, '%Y-%m-%d') created_date
# FROM used_goods_board board
# INNER JOIN used_goods_reply reply
# ON board.board_id = reply.board_id
# WHERE YEAR(board.created_date) = 2022
# AND MONTH(board.created_date) = 10
# ORDER BY reply.created_date, board.title