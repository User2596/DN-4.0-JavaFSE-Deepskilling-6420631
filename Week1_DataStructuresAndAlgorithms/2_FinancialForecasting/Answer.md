# Exercise 7: Financial Forecasting

## 1. Understand Recursive Algorithms

**Explain the concept of recursion and how it can simplify certain problems.**  

Recursion is a programming technique in which a method calls itself to solve a smaller instance of the same problem. Each recursive call simplifies the problem, bringing it closer to a base case, a condition that stops the recursion.

In financial forecasting, recursion can be used to model repetitive growth calculations, such as compound interest, by breaking down the future value computation into repeated steps based on the same formula. This makes the code concise and easier to understand for problems with natural repetitive structure.

---

## 4. Analysis

**Discuss the time complexity of your recursive algorithm.**  

The recursive `futureForecast` method computes the future value by making one recursive call for each year (time period). Hence, the time complexity is:

- **Time Complexity**: O(n), where `n` is the number of years (`timePeriod`)
- **Space Complexity**: O(n), due to the recursive call stack growing linearly with each call

Each recursive call performs a constant amount of work and then calls itself with a smaller `timePeriod`, decrementing by 1 each time until reaching 0.

---

**Explain how to optimize the recursive solution to avoid excessive computation.**  

While the current recursion is straightforward and efficient for small to moderate values of `timePeriod`, it can be optimized using an iterative approach to avoid the overhead of deep recursion and stack usage.

In iterative approach the recursion is replaced with a loop that multiplies the present value step by step over the number of years. This reduces space complexity to O(1). In most practical forecasting tools, an iterative approach is preferred for its better performance and stack safety, especially when forecasting over long time periods.

---