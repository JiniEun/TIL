import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
inDegree = [0 for i in range(32001)]
graph = [[] for i in range(32001)]

queue = deque()
for i in range(M):
    x, y = map(int, input().split())
    arr.append([x, y])

for a, b in arr:
    inDegree[b] += 1
    graph[a].append(b)

for i in range(1, N + 1):
    if inDegree[i] == 0:
        queue.append(i)
 
while queue:
    student = queue.popleft()
    print(student, end = ' ')
    for j in graph[student]:
        inDegree[j] -= 1
        if inDegree[j] == 0:
            queue.append(j)

