import sys
input = sys.stdin.readline
V = int(input())
graph = [[] for _ in range(V+1)]
for i in range(V):
    path = list(map(int, input().split()))

    # 각 입력 Line의 정보를 받고 graph에 연결 정보 저장
    path_len = len(path)
    for i in range(1, path_len//2):
        graph[path[0]].append([path[2*i-1], path[2*i]])

# 첫 번째 DFS 결과
first_result = [0 for _ in range(V+1)]

def DFS(start, result):
    for e, d in graph[start]:
        if result[e] == 0:
            result[e] = result[start] + d
            DFS(e, result)

DFS(1, first_result) 
first_result[1] = 0

tmpmax = 0 # 최댓값 구하기
index = 0 # 최장경로 노드

for i in range(len(first_result)):
    if tmpmax < first_result[i]:
        tmpmax = first_result[i]
        index = i

# 최장경로 노드에서 다시 DFS를 통해 트리의 지름을 구함
result_final = [0 for _ in range(V+1)]
DFS(index, result_final)
result_final[index] = 0
print(max(result_final))
