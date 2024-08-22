import sys
input = sys.stdin.readline

def getPi(P):
    pi = [0 for _ in range(0, len(P))]
    j = 0
    
    for i in range(1, len(P)):
        while j > 0 and P[i] != P[j]:
            j = pi[j - 1]

        if (P[i] == P[j]):
            j += 1
            pi[i] = j
    return pi

N = int(input())
ptn = input()
print(N - getPi(ptn)[N-1])
