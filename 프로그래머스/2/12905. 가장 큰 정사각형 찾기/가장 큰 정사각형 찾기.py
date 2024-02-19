def solution(board):
    N = len(board)
    M = len(board[0])
    for i in range(1, N):
        for j in range(1, M):
            if board[i][j] == 1:
                board[i][j] = min(board[i-1][j-1], board[i-1][j], board[i][j-1]) + 1
                
    result = 0
    
    for i in board:
        max_ = max(i)
        result = max(result, max_)
    answer = result * result
    return answer