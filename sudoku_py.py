# BOJ n.2580
import sys

# 행 체크
def RowCheck(x, val):
    if val in sudoku[x]:
        return False
    return True

# 열 체크
def ColCheck(y, val):
    for i in range(9):
        if val == sudoku[i][y]:
            return False
    return True

# 3x3 체크
def Bythree(x, y, val):
    nx = x//3 * 3
    ny = y//3 * 3
    for i in range(3):
        for j in range(3):
            if val == sudoku[nx+i][ny+j]:
                return False
    return True


def DFS(index):
    if index == len(zeros):
        for row in sudoku:
            for n in row:
                print(n, end=" ")
            print()
        sys.exit(0)
    else:
        for i in range(1, 10):
            nx = zeros[index][0]
            ny = zeros[index][1]
            # 숫자 중복 검사
            if RowCheck(nx, i) and ColCheck(ny, i) and Bythree(nx, ny, i):
                sudoku[nx][ny] = i
                DFS(index+1)
                sudoku[nx][ny] = 0


sudoku = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
zeros = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]
DFS(0)
