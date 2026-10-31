import java.util.Scanner;

public class NQueens {

    static int n;
    static int[][] board;

    // Check whether a queen can be placed safely
    static boolean isSafe(int row, int col) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 1) {

                    // Same column or diagonal
                    if (j == col ||
                        Math.abs(i - row) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Backtracking function
    static boolean solve(int row) {

        // All queens placed successfully
        if (row == n) {
            return true;
        }

        // First queen is already placed
        if (board[row][0] == 1) {
            return solve(row + 1);
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {

                // Place queen
                board[row][col] = 1;

                // Place remaining queens
                if (solve(row + 1)) {
                    return true;
                }

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of queens: ");
        n = sc.nextInt();

        board = new int[n][n];

        System.out.print("Enter column for first queen (1 to " + n + "): ");
        int firstCol = sc.nextInt() - 1;

        if (firstCol < 0 || firstCol >= n) {
            System.out.println("Invalid column.");
            sc.close();
            return;
        }

        // Place first queen in the first row
        board[0][firstCol] = 1;

        if (solve(1)) {

            System.out.println("Solution:");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}
