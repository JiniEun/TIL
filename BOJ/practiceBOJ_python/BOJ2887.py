import sys
import math
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

# 크루스칼 알고리즘
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

N = int(input())
point = [] 
parent = [i for i in range(N+1)]
edges = []
result = 0
cnt = 0

for i in range(N):
    x, y, z = map(int, input().split())
    point.append([x, y, z, i])

# x, y, z 별로 정렬
for i in range(3):
    point.sort(key=lambda x:x[i])#각 좌표별로 정렬
    now_p = point[0][3]
    for j in range(1, N):
        # 간선 구하기
        new_p = point[j][3]
        edges.append([abs(point[j][i]-point[j-1][i]),now_p,new_p])
        now_p = new_p

edges.sort(key = lambda x : x[0])

for e in edges:
    cost, x, y = e
    if find(x) != find(y):
        union(x, y)
        result += cost
    if cnt == N-1:
        break

print(result)
