import sys, math
input = sys.stdin.readline
N = int(input())
M = int(input())
visit = [[0] * (N+1) for _ in range(N+1)]
dist = [[math.inf] * (N+1) for _ in range(N+1)]

for _ in range(M):
	a, b, c = map(int,input().split())
	dist[a][b] = min(dist[a][b], c)

def find_path(i, j, visit, result):
	if visit[i][j] == 0:
		result.append(i)
		if i != j:
			result.append(j)
	else:
		k = visit[i][j]
		find_path(i, k, visit, result)
		result.pop()
		find_path(k, j, visit, result)

for k in range(1, N+1):
	for i in range(1, N+1):
		for j in range(1, N+1):
			if i != j:
				if dist[i][j] > dist[i][k] + dist[k][j]:
					visit[i][j] = k
					dist[i][j] = dist[i][k] + dist[k][j]

for i in dist[1:]:
	for j in i[1:]:
		print(0 if j == math.inf else j, end = ' ')
	print()

for i in range(1, N+1):
	for j in range(1, N+1):
		if dist[i][j] == math.inf or i == j:
			print(0)
		else:
			result = []
			find_path(i, j, visit, result)
			print(len(result), *result)
