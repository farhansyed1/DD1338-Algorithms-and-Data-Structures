### Task 2 - Time Complexities for Data Structures

| Operation         | Sorted Array | Unsorted Singly Linked List | Hashtable (average) | Hashtable (worst) |
| :-----------------| :------------| :---------------------------| :-------------------| :-----------------|
| Search for key X  |      O(n)    |              O(n)           |          O(1)       |        O(n)       |
| Insert X          |      O(n)    |              O(1)           |          O(1)       |        O(n)       |
| Remove X          |      O(n)    |              O(1)           |          O(1)       |        O(n)       |

Sorted Array
- **Search** is O(n) because we might have to go through all elements to find X
- **Insert** is O(n) because we might have to shift all elements to insert X
- **Remove** is O(n) because we might have to shift all elements to remove X

Unsorted Singly Linked List
- **Search** is O(n) because we might have to go through all elements to find X
- **Insert** is O(1) because we don't have to loop through the list to insert. We only need to link the element to the previous and next element.
- **Remove** is O(1) because we don't have to loop through the list to remove. We only need to link together the previous and next elements

Hashtable average
- **Search** is O(1) because elements will most often be hashed to different buckets so we dont have to go through any linked lists
- **Insert** is O(1) because we just need to add the element to the end of a linkedList. 
- **Remove** is O(1) because we just need to remove an element from a linkedList.

Hashtable worst
- **Search** is O(n) because if all  elements are placed in the same bucket, we will have to search through a linked list. 
- **Insert** is O(n) because if we try to insert a duplicate element, the program has to check through the whole table to see if the element is duplicated.  
- **Remove** is O(n) because if we try to insert a duplicate element, the program has to check through the whole table to see if the element is duplicated.

### Task 3 - Dynamic Tables
1. What is the initial capacity of an `ArrayList`'s internal array?
- 10

2. Starting with the `add(E e)` method (ln:442), find the line number for the conditional statement used to determine that the internal array needs to grow.
- Line 443 
- ensureCapacityInternal(size + 1);

3. Looking at the `grow(int minCapacity)` method (ln:237), which operator is used to decide the new size of the internal array?
- Line 240: `int newCapacity = oldCapacity + (oldCapacity >> 1);`
- The addition and >> operators
- ">>" is the same as multiplying by 0.5

4. What is the scaling factor for growth of the internal array?
- The scaling factor is 1.5 

5. If 20 elements had been added to an empty ArrayList, what would the size of the internal array be?
- We will have to scale the array twice. We start with the initial capacity 10. 
  - 1st time: 10 + 5 = 15 
    - 10 * 0.5 = 7
  - 2nd time: 15 + 7 = 22.      
    - 15 * 0.5 ≈ 7
  - Answer: 22

6. What is the worst, average, and best-case time complexity of the `add(E e)` method of `Arraylist`?
- Worst: O(n) because it may have to resize
- Average: O(1) because we add an element to the end of the list
- Best: O(1)  because we add an element to the end of the list