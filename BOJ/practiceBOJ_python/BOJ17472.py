from collections import deque
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())
country = [list(map(int, input().split())) for _ in range(N)]
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]
queue = deque([]) # BFS에서 사용하는 큐(queue)
edge = [] # 생성 가능 다리 후보
cnt = 1 # 섬 고유번호
visit = [] # BFS 사용시 방문여부

for i in range(N):
    for j in range(M):
        if country[i][j] and (i, j) not in visit:
            queue.append((i, j))
            visit.append((i, j))
            while queue:
                r, c = queue.popleft()
                country[r][c] = cnt
                for idx in range(4):
                    nr = r + direction[idx][0]
                    nc = c + direction[idx][1]
                    if 0 <= nr < N and 0 <= nc < M:
                        if country[nr][nc] and (nr, nc) not in visit:
                            queue.append((nr, nc))
                            visit.append((nr, nc))
            cnt += 1

# 생성 가능한 다리 찾기
def checkBridge(li):
    start, cnt = 0, 0
    flag = False
    for idx in range(len(li)):
        if li[idx] and not flag:
            flag = True
            start = li[idx]
        elif not li[idx] and flag:
            cnt += 1
        elif li[idx] and flag and start != li[idx]:
            if start and cnt >= 2:
                if (start, li[idx], cnt) not in edge:
                    edge.append((start, li[idx], cnt))
            cnt = 0
            start = li[idx]
        elif start == li[idx]:
            cnt = 0

# 행
for row in country:
    if sum(row):
        checkBridge(row)

# 열
for col in list(zip(*country)):
    if sum(col):
        checkBridge(col)

edge = sorted(edge, key = lambda x:[x[2]])

parent = [i for i in range(cnt)]
rank = [1 for i in range(cnt)]
result = 0

# 크루스칼 알고리즘
def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x]) # 부모 테이블 갱신
    return parent[x]

def union(x, y, w):
    global result
    x = find(x) 
    y = find(y)

    if x == y: # 동일한 집합일 경우
        return

    result += w

    if rank[x] < rank[y]:
        rank[y] += rank[x]
        parent[x] = y
    else:
        rank[x] += rank[y]
        parent[y] = x

for e in edge:
    union(e[0],e[1],e[2])

if max(rank) == cnt-1:
    print(result)
else:
    print(-1)
