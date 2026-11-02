
def knapsack_solution(w,p,c):
    n = len(w)
    items = []

    for i in range(n):
        ratio = p[i]/w[i]
        items.append((ratio,w[i],p[i]))

    
    items.sort(reverse=True)

    total_profit = 0

    for ratio,w,p in items:

        if c>=w:
            c-=w
            total_profit+=p
        else:
            total_profit+=ratio*c
            break

    return total_profit

weight = list(map(int,input("Enter a Weight: ").split(" ")))
profit = list(map(int,input("Enter a Profit: ").split(" ")))
capacity = int(input("Enter a Capacity: "))

print("Total Profit",knapsack_solution(weight,profit,capacity))

        
