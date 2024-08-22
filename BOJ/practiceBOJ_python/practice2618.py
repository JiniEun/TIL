# 결과 type error
import sys
#sys.getrecursionlimit(1000)

N = int(sys.stdin.readline())
W = int(sys.stdin.readline())

position = [[0,0]]

for _ in range(W):
    position.append(list(map(int, input().split())))

dp=[[0 for _ in range(W+1)] for _ in range(W+1)]

def distance(t, start, end):
    x_start = position[start][0]
    y_start = position[start][1]
    x_end = position[end][0]
    y_end = position[end][1]
    if start == 0:
        if t == 1:
            x_start = y_start = 1
        else:
            x_start = y_start = N
    return abs(x_start-x_end) + abs(y_start-y_end)
            
def policeSolution(i, f, s):
    if i > W: return 0;
    if dp[f][s] != 0: return dp[f][s]

    one = policeSolution(i+1, i, s) + distance(1, f, i)
    two = policeSolution(i+1, f, i) + distance(2, s, i)

    dp[f][s] = min(one, two)
    
    return dp[f][s]
    
print(policeSolution(1, 0, 0))

firstidx = 0
secondidx = 0

for i in range(1, W+1):
    dist1 = distance(1, firstidx, i)

    if dp[firstidx][secondidx] - dist1 == dp[i][secondidx] :
        firstidx = i
        print(1)
    else:
        secondidx = i
        print(2)
