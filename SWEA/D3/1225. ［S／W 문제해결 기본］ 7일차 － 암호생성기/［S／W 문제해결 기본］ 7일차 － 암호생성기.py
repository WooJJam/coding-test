from collections import deque

def solve():
    while True:
        for i in range(1, 6):
            x = queue.popleft()
            x -= i
            if x <= 0:
                x = 0
                queue.append(x)
                return
            queue.append(x)


for test_case in range(1, 11):
    _ = int(input())
    queue = deque(list(map(int, input().split())))
    solve()
    print(f"#{test_case}", end=" ")
    print(*queue)