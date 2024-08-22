from collections import deque
import sys

input = sys.stdin.readline

def bfs(x, mode):
    que = deque()
    que.append(x)
    arr = [-1 for _ in range(N)]
    arr[x] = 0
    while que:
        x = que.popleft()
        for w, nx in tree[x]:
            if arr[nx] == -1:
                arr[nx] = arr[x] + w
                que.append(nx)
    if mode == 1:
        return arr.index(max(arr))
    else:
        return max(arr)

N = int(input())
tree = [[] for _ in range(N)]

for i in range(N-1):
    x, y, w = map(int, input().split())
    tree[x-1].append([w, y-1])
    tree[y-1].append([w, x-1])
print(bfs(bfs(0, 1), 2))
