# Exercise 2: E-commerce Platform Search Function

## 1. Understand Asymptotic Notation

**Explain Big O notation and how it helps in analyzing algorithms.**  

Big O notation is a mathematical tool used to describe the upper bound of an algorithm’s time or space complexity relative to the input size `n`. It helps developers understand how an algorithm performs as the dataset grows, focusing on the scalability and efficiency of the algorithm. It ignores constants and lower-order terms to capture the growth rate.

---

**Describe the best, average, and worst-case scenarios for search operations.**  

| Algorithm       | Best Case       | Average Case     | Worst Case       |
|----------------|------------------|------------------|------------------|
| **Linear Search** | O(1)- target at the start | O(n)- target in the middle | O(n)- target at the end or not found |
| **Binary Search** | O(1)- target is the mid element | O(log n)- divide array repeatedly | O(log n)- target not found after full division |

---

## 4. Analysis

**Compare the time complexity of linear and binary search algorithms.**

| Search Algorithm | Time Complexity | Space Complexity | Requirements |
|------------------|------------------|------------------|--------------|
| **Linear Search** | O(n) | O(1) | Works on unsorted arrays |
| **Binary Search** | O(log n) | O(log n) (recursive) or O(1) (iterative) | Requires sorted arrays |

---

**Discuss which algorithm is more suitable for your platform and why.**  

Binary Search is more suitable for an e-commerce platform due to the following reasons:
- Inventories are typically large, and performance matters at scale.
- The product list can be sorted once (e.g., by `productId`) to enable fast searching.
- Binary search offers O(log n) performance, significantly better than O(n) for large datasets.
- Real-time performance is crucial in user-facing search features.

However, Linear Search can still be used for:
- Small data sets like recently viewed products.
- Situations where the data isn't sorted and quick implementation is needed.

---