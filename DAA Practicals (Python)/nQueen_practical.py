def is_safe(board, row, col, n):
    for i in range(n):
        if board[row][i] == 1 or board[i][col] == 1:
            return False

    for i in range(n):
        for j in range(n):
            if abs(row-i) == abs(col-j) and board[i][j] == 1:
                return False

    return True


def solve(board, row, n):
    if row == n:
        return True

    if 1 in board[row]:
        return solve(board, row+1, n)

    for col in range(n):
        if is_safe(board, row, col, n):
            board[row][col] = 1

            if solve(board, row+1, n):
                return True

            board[row][col] = 0

    return False


n = int(input("Enter N: "))
board = [[0]*n for _ in range(n)]

r = int(input(f"Enter first Queen row (0 to {n-1}): "))
c = int(input(f"Enter first Queen column (0 to {n-1}): "))

board[r][c] = 1

if solve(board, 0, n):
    print("\nFinal N-Queen Matrix:")
    for row in board:
        print(row)
else:
    print("Solution does not exist")