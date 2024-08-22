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
parent = [i for i in range(N+1)]
stars = []
edges = []
result = 0

for _ in range(N):
    x, y = map(float, input().split())
    stars.append((x, y))

# 모든 별들 간에 간선, 비용 계산 저장
for i in range(N - 1):
    for j in range(i+1, N):
        edges.append((math.sqrt((stars[i][0] - stars[j][0])**2 + (stars[i][1] - stars[j][1])**2), i, j))

edges.sort()

for e in edges:
    cost, x, y = e

    if find(x) != find(y):
        union(x, y)
        result += cost

print(round(result, 2))
