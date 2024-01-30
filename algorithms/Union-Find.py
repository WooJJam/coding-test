# 서로수 집합 자료구조: 경로 압축
# 합집합 (Union) : 2개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산
# 찾기 (Find) : 특정한 원소가 속한 집합이 어떤 집합인지 알려주는 연산

# 특정 원소가 속한 집합을 찾기
def find(parent, x):
    # 루트 노드를 찾을 때까지 재귀 호출
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# 노드의 개수와 간선(Union 연산)의 개수 입력 받기
v,e = map(int, input().split())
parent = [0] * (v + 1) # 부모 테이블 초기화 하기

# 부모 테이블 상에서, 부모를 자기 자신으로 초기화
for i in range(1, v+1):
    parent[i] = i

# Union 연산을 각각 수행
for i in range(e):
    a, b = map(int, input().split())
    union(parent, a, b)

# 각 원소가 속한 집합 출력
print("각 원소가 속한 집합: ", end='')
for i in range(1, v+1):
    print(find(parent, i), end=' ')

print()

# 부모 테이블 출력
print("부모 테이블: ", end='')
for i in range(1, v + 1):
    print(parent[i], end=' ')