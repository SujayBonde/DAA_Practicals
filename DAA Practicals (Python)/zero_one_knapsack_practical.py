def knapsack_zero_one(weight,profit,capacity):
	n = len(weight)
	
	dp = [[0 for _ in range(capacity+1)] for _ in range(n+1)]

	for i in range(1,n+1):
		for w in range(1,capacity+1):
			

			if weight[i-1]<=w:
				 dp[i][w] = max(profit[i-1]+dp[i-1][w-weight[i-1]],dp[i-1][w])
			else:
				dp[i][w] = dp[i-1][w]
	
	return dp[n][capacity]


weight = list(map(int,input("Enter a Weight: ").split(" ")))
profit = list(map(int,input("Enter a Profit: ").split(" ")))
capacity = int(input("Enter a Capacity: "))

max_profit = knapsack_zero_one(weight,profit,capacity)
print("Maximum Profit is : ", max_profit)

	