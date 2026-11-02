
import java.util.*;

class Item {

    int profit, weight;
    double ratio;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = (double) profit / weight;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        // Input profit and weight
        for (int i = 0; i < n; i++) {

            System.out.print("Enter profit and weight of item "
                    + (i + 1) + ": ");

            int profit = sc.nextInt();
            int weight = sc.nextInt();

            if (profit < 0 || weight <= 0) {
                System.out.println("Invalid profit or weight.");
                sc.close();
                return;
            }

            items[i] = new Item(profit, weight);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        if (capacity < 0) {
            System.out.println("Invalid capacity.");
            sc.close();
            return;
        }

        // Sort by profit/weight ratio (descending)
        Arrays.sort(items, (a, b)
                -> Double.compare(b.ratio, a.ratio));

        double maxProfit = 0;

        // Select items using greedy approach
        for (int i = 0; i < n; i++) {

            if (capacity == 0) {
                break;
            }

            if (items[i].weight <= capacity) {

                // Take complete item
                maxProfit += items[i].profit;
                capacity -= items[i].weight;

            } else {

                // Take fractional part
                maxProfit += items[i].ratio * capacity;
                capacity = 0;
            }
        }

        System.out.println("Maximum Profit = " + maxProfit);

        sc.close();
    }
}
