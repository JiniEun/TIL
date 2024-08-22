import sys
input = sys.stdin.readline

N = int(input())
ant = {}

for i in range(N):
    name = list(input().split())
    target_dict = ant
    for j in name[1:]:
        if j not in target_dict:
            target_dict[j] = {}
        target_dict = target_dict[j]

def getResult(t, i):
    target_key = sorted(t.keys())
    for s in target_key :
        print('--'*i + s)
        getResult(t[s],i+1)

getResult(ant,0)
