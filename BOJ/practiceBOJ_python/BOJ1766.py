import sys
import heapq
input = sys.stdin.readline

N,M = map(int,input().split())
arr = [[] for _ in range(N+1)]
indegree=[0 for _ in range(N+1)]

heap = []
result = []

for _ in range(M): 
    s, e = map(int,input().split())
    arr[s].append(e)
    indegree[e]+=1

for i in range(1,N+1):
    if indegree[i] == 0:
        heapq.heappush(heap, i)

while heap:
    node = heapq.heappop(heap)
    result.append(node)
    for i in arr[node]:
        indegree[i]-=1 
        if indegree[i] == 0:
            heapq.heappush(heap, i)

for r in result:
    print(r , end=' ')
