import java.util.Scanner;

public class Knapsack {

    static int knapsack(int[] weight, int[] profit, int n, int capacity) {

        // Create DP table
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                // If current item fits
                if (weight[i - 1] <= w) {

                    // Maximum of include or exclude
                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );

                } else {

                    // Do not include item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        // Input items
        for (int i = 0; i < n; i++) {

            System.out.print("Enter weight and profit of item "
                    + (i + 1) + ": ");

            weight[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        int result = knapsack(weight, profit, n, capacity);

        System.out.println("Maximum Profit = " + result);

        sc.close();
    }
}
