import sys
from heapq import heappop, heappush
import copy
input = sys.stdin.readline
INF = int(1e9)

# 다익스트라 함수
def dijkstra(start):
    dis = [INF] * (N + 1) 
    dis[start] = 0 
    que = []
    heappush(que, (0, start)) 

    while que:
        now_cost, now_way = heappop(que)

        if dis[now_way] < now_cost:
            continue

        path[now_way].append(now_way)

        if now_way == end:
            return dis[end]

        # 최단 거리 수정
        for new_cost, new_way in graph[now_way]:
            if dis[new_way] > new_cost + now_cost:
                dis[new_way] = new_cost + now_cost
                heappush(que, (dis[new_way], new_way))
                # 최단 거리 수정으로 인해 최단 경로 수정                
                path[new_way] = copy.deepcopy(path[now_way])
               

N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)] # 인접 리스트
path = [[] for _ in range(N + 1)] # 경로 저장

# 그래프
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))

start, end = map(int, input().split())
print(dijkstra(start)) # 최소 비용 출력
print(len(path[end])) # 경로 길이
print(*path[end]) # 경로 출력
