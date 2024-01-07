### **Exercise 1**

| Size / complexity |     log n     |       n       |    n log n    |  n<sup>2</sup>   |  n<sup>3</sup>   |   2<sup>n</sup>  |      n!          |
|-------------------|---------------|---------------|---------------|------------------|------------------|------------------|------------------|
| 1                 |      0        |       1       |      0        |       1          |       1          |      2           |       1          |
| 10                |      3.3      |       10      |      33       |       100        |       1000       |      1024        |       3.6e6      |
| 100               |      6.6      |       100     |      664      |       10000      |       1e6        |      1.3e30      |       9.3e157    |
| 1000              |      9.966    |       1000    |      9966     |       1e6        |       1e9        |      1e301       |       4e2567     |
| 10000             |      13.3     |       10000   |      1.33e5   |       1e8        |       1e12       |      2e3010      |   2.8e35659      |
| 100000            |      16.6     |       100000  |      1.66e6   |       1e10       |       1e15       |      1e30103     |    3e456573      |
| 1000000           |      19.9     |       1e6     |      1.99e7   |       1e12       |       1e18       |      9.9e301029  |      8e5565708   |


### **Exercise 2** 
| T(n)          | 1 second | 1 minute |  1 hour  |  1 day   |  1 year  |
| --------------|----------|----------|----------|----------|----------|
| log n         |    1e9   | &#x221e; |  &#x221e;| &#x221e; | &#x221e; |
| n             |    1e9   |   6e10   |  3.6e12  |   8.6e13 |   3.2e16 |
| n log n       |    4e7   |   1.9e9  |  9.8e10  |   2.1e12 |   6.5e14 |
| n<sup>2</sup> |    31623 |   244949 |  1.8e6   |   9.3e6  |   1.7e8  |
| n<sup>3</sup> |    1000  |   3914   |  15326   |   44208  |   316010 |
| 2<sup>n</sup> |    29    |   35     |  41      |   46     |   54     |
| n!            |    12    |   13     |  15      |   16     |    18    |


### **Exercise 3**
*Arrange the functions in the following list in ascending order based on their
rate of growth. That is, the function f(n) should come before the function g(n)
in the list if f(n) is O(g(n)).* 

1. f4(n) = n + 100

2. f3(n) = n log n

3. f1(n) = n<sup>1.5</sup>

4. f5(n) = 2<sup>n</sup>

5. f2(n) = 10<sup>n</sup>   

<br>

*Which of the following statements are true? Justify your answer.* 

n (n + 1) / 2 = O(n<sup>3</sup>)    True, the function never exceeds the upper bound n<sup>2</sup> 

n (n + 1) / 2 = O(n<sup>2</sup>)    True, the function does not either exceed n<sup>2</sup>. 

n (n + 1) / 2 = Θ(n<sup>3</sup>)    False, the average case cannot can be larger than the worst case. n<sup>3</sup> exceeds the worst case of n<sup>2</sup>. 

n (n + 1) / 2 = Ω(n)                True, because for smaller numbers we see that the function is linear. Thus the best case is Ω(n) 

### **Exercise 4**
*Give a tight O-estimation, as a function of n, of the worst case time
complexity of the following five loops.*

1. O(n)
2. O(n)
3. O(n<sup>2</sup>)
4. O(n<sup>2</sup>)
5. O(n<sup>4</sup>)


### **Exercise 5**

*Explain why (n+1)<sup>3</sup> is O(n<sup>3</sup>). Use the following
definition: f(n) is O(g(n)) if there exists positive constants c and
n<sub>0</sub> such that f(n) &le; c &times; g(n) for all n &ge; n<sub>0</sub>.*

We have 
- f(n) = (n+1)<sup>3</sup>
- g(n) = n<sup>3</sup>

According to the definition, the following must be true for some c and n: <br>
- (n+1)<sup>3</sup> &le; c &times; n<sup>3</sup>

Let's choose n<sub>0</sub> = 1. This gives:
- n &ge; 1 

Insert n = 1 in the inequality:
- (1+1)<sup>3</sup> &le; c &times; 1<sup>3</sup>
- (2)<sup>3</sup> &le; c &times; 1<sup>3</sup>
- 8 &le; c &times; 1
- 8 &le; c 
    - For example c = 8 satisfies the inequality

Thus, there exists positive constants c and n<sub>0</sub> that satisfy the definition. Therefore, (n+1)<sup>3</sup> is O(n<sup>3</sup>). 

### **Exercise 6.1**
*The following algorithm reverses a collection.  Answer the following:*

*What is the basic operation for this algorithm?*

- The basic operation is the nested for loop as it is run the greatest number of times 

*Describe the time complexity of this algorithm*

- The time complexity is O(n<sup>2</sup>) because of the nested for loops (n(n-1))  


### **Exercise 7**
*Insertion Sort and Selection Sort have similar worst case runtime complexity
O(n<sup>2</sup>).  Explain:*

*How they differ in best case (a sorted collection) and mostly sorted case in
terms of the runtime complexity of each algorithm*

- In the best case, the list is already sorted. In insertion sort, the time will be Ω(n) because the inner loop does not have to run if the 
list is already sorted. In selection sort the time is Ω(n<sup>2</sup>) because the algorithm still has to go through both for loops. 
In a mostly sorted list, selection sort still has to go through the list, so any level of sorting does not affect selection sort. On the other hand, 
insertion sort benefits from a mostly sorted list as the algorithm can skip sorted items. 

*Which should be preferred as a sorting algorithm with justification.*

- The preferred algorithm is insertion sort, since it is quicker than selection sort when the list is somewhat sorted.     
Additionally, insertion sort has the best case n, while selection sort has n<sup>2</sup> for worst, average and best cases. Therefore, insertion sort will often take less time than selection sort.   



