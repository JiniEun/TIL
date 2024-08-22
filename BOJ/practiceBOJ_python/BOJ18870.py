import sys
input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
sort_n = sorted(list(set(numbers)))
dic = {sort_n[i] : i for i in range(len(sort_n))}

for n in numbers:
    print(dic[n], end = ' ')
