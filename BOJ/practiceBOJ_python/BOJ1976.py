import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input()) # 노드 수 
M = int(input()) # 정점 수 
parent = [i for i in range(N+1)]

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x]) # 부모 테이블 갱신
    return parent[x]

def union(x, y): 
    x = find(x) 
    y = find(y) 

    if x == y: # 동일한 집합일 경우
        return

    if x < y:
        parent[y] = x 
    else: 
        parent[x] = y 

for y in range(1, N+1): 
    maps = list(map(int, input().split())) 
    for x in range(1, len(maps)+1): # y 도시 연결 정보 추출
        if maps[x-1] == 1: # x 도시와 연결되어 있으면
            union(y, x) 
check = True
tour = list(map(int, input().split())) # 여행 계획 정보
result = set([find(i) for i in tour]) 
if len(result) != 1: # set 2개 이상이면 두 개의 집합 존재
    print('NO')
else:
    print('YES') # set 1이면 한 개의 집합 존재
