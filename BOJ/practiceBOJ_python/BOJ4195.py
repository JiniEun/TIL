import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x]) # 부모 테이블 갱신
    return parent[x]

def union(x,y):
    x = find(x)
    y = find(y)

    if x != y:
        parent[y] = x
        number[x] += number[y]
    print(number[x])

test_case = int(input())

for _ in range(test_case):
    parent = {} # dictionary
    number = {}

    f = int(input())

    for _ in range(f):
        f1,f2 = input().split()
        
        if f1 not in parent:
            parent[f1] = f1
            number[f1] = 1
        if f2 not in parent:
            parent[f2] = f2
            number[f2] = 1
        
        union (f1,f2)
