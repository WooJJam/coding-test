def search(board, h, w, dx, dy):
    
    count = 0
    
    for i in range(4):
        nextY = dy[i] + h
        nextX = dx[i] + w
        
        if 0 <= nextY < len(board) and 0 <= nextX < len(board) and board[h][w] == board[nextY][nextX]:
            count += 1
    
    return count

def solution(board, h, w):
    
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    answer = search(board, h, w, dx, dy)
    
    return answer