### Task 1 - Inheritance
#### Exercise 9.11 (11.11)
*Assume that you see the following lines of code:*

```java
Device dev = new Printer();
dev.getName();
```

*`Printer` is a subclass of `Device`. Which of these classes must have a
definition of method `getName` for this code to compile?*

**Answer:** <br> 
The getName method must be defined in the superclass Device. This is because the declaration
uses the superclass as its reference, so `dev` will only have access to methods defined in the superclass.  

#### Exercise 9.12 (11.12)
*In the same situation as in the previous exercise, if both classes have an
implementation of `getName`, which one will be executed?*

**Answer:** <br>
The overridden getName method in the subclass Printer will be executed because
the overridden method is always used regardless of the reference type.

#### Exercise 9.13 (11.13)
*Assume that you write a class `Student` that does not have a declared
superclass. You do not write a `toString` method. Consider the following lines
of code:*

```java
Student st = new Student();
String s = st.toString();
```

*Will these lines compile? If so, what exactly will happen when you try to
execute?*

**Answer:** <br>
The lines will compile. The default toString method will be used and 
when printed it will look like Student@2c7b84de 

#### Exercise 9.14 (11.14)
*In the same situation as before (class `Student`, no `toString` method), will
the following lines compile? Why?*

```java
Student st = new Student();
System.out.println(st);
```

**Answer:** <br>
Yes, they will. This is because when the compiler sees the System.out.println statement,
it will automatically use the toString method on the object i.e. it reads the line as 
`System.out.println(st.toString);` 

#### Exercise 9.15 (11.15)
*Assume that your class `Student` overrides `toString` so that it returns the
student's name. You now have a list of students. Will the following code
compile? If not, why not? If yes, what will it print? Explain in detail what
happens.*

```java
for (Object st : myList) {
    System.out.println(st);
}
```
**Answer:** <br>
Yes the code will compile. Since we have a toString method in the `Student` class, 
this method will run when we print the student objects inside the for loop because 
it overrides the default toString. As a result, the names of all the
students in list will be printed.

#### Exercise 9.16 (11.16)
*Write a few lines of code that result in a situation where a variable `x` has
the static type `T` and the dynamic type `D`.*

**Answer:** <br>
`T x = new D();`
and D is a subclass of T

### Task 2 - Linked Lists <br> 

Time complexity for the methods in LinkedList: 

- addFirst: O(1)
- addLast: O(1)
- getFirst: O(1)
- getLast: O(1)
- get: O(n)
- removeFirst: O(1)
- clear: O(1)
- size: O(1)
- isEmpty: O(1)
- toString: O(n)
