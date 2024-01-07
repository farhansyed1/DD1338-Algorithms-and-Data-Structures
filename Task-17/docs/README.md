### Task 2 - Time Complexity

| Operation (BST)     | Time Complexity (worst case)        |
| ------------------- | -------------------------------     |
| search              |              O(n)                   |
| insert              |              O(n)                   |
| size                |              O(1)                   |
| height              |              O(n)                   |
| leaves              |              O(n)                   |
| toString            |              O(n)                   |

**search** is O(n) if the tree is simply a linkedList (only one branch).

**insert** is O(n) because if the tree has only one branch like a linkedList, we will have to traverse through all elements to insert the given element.

**size** is O(1) because we only need to return the size integer variable.

**height** is O(n) because we might have to go through a whole linkedList to find the height.  

**leaves** is O(n) for the same reason as height. 

**toString** is O(n) because we have to visit every node.  

