### Exercise Inh.1

*a) Assume that we have four classes: Person, Teacher, Student, and PhDStudent. 
Teacher and Student are both subclasses of Person. PhDStudent is a subclass of Student.*

*Which of the following assignments are legal, and why or why not?*

``Person p1 = new Student();``      
- Legal, Student is a subclass of Person so a Student object can have a reference type Person. <br> 

``Person p2 = new PhDStudent();``       
- Legal, PhDStudent is a subclass of Student which is a subclass of Person, so this declaration is valid.<br>

``PhDStudent phd1 = new Student();``
- Illegal, Student is a superclass of PhDStudent so a Student object cannot have the reference type PhDStudent.<br>

``Teacher t1 = new Person();`` 
- Illegal, Person is a superclass of Teacher so a Person object cannot have the reference type Teacher. <br> 

``Student s1 = new PhDStudent();``    
- Legal, PhDStudent is a subclass of Student so a PhDStudent object can have the reference type Student. 

*b) We have the declarations:* 

    Person p1 = new Person();
    Person p2 = new Person();
    PhDStudent phd1 = new PhDStudent();
    Teacher t1 = new Teacher();
    Student s1 = new Student();

*Based on those just mentioned, which of the following 
assignments are legal, and why or why not?* <br>

Answer: <br>
``s1 = p1;``
- Illegal, a Student reference type cannot refer to a Person object, because Student is a subclass of Person.

``s1 = p2;``
- Illegal, a Student reference type cannot refer to a Person object, because Student is a subclass of Person.

``p1 = s1;``
- Legal, a Person reference type can refer to a Student object because Person is a superclass of Student.

``t1 = s1;``
- Illegal, a Teacher reference type cannot refer to a Student object because Teacher is not a superclass of Student.

``s1 = phd1;``
- Legal, a Student reference type can refer to a PhDStudent object because Student is a superclass of PhDStudent.

``phd1 = s1;``
- Illegal, a PhDStudent reference type cannot refer to a Student object because PhDStudent is a subclass of Student. 

### Exercise Inh.3

*What behaviour happens if you removed the extends Post from the class definition 
of EventPost then call NewsFeed.addPost? Explain why you think this happens.*

- An error will occur as the addPost method will not recognise the EventPost object because EventPost does not inherit the Post class. 

*What behaviour happens if you removed super() from the constructor of EventPost then call NewsFeed.show? 
Explain why you think this happens.*

- An error will occur because the author variable will not be initialised (super() initialises it in the super class).

*What behaviour happens if you removed super.display() from the display methods EventPost? 
then call NewsFeed.show? Explain why you think this happens.*

- The information regarding who created the post and timestamps will not be displayed. This occurs because this is part of the display method which is never called.

*When we have two classes with an inheritance relationship and they have a method with the same signature, 
what is this called?*

- Method overriding. 

### Exercise Ind.1
See PDF file "Ind.1 Induction proofs"

### Exercise Ind.2
**Exercise 1**

a: 

    double expIterative(double x, int n) {
        double res = 1.0;
        
        for (int i = 0; i < n; i++) {
            //Invariant: res = x^i
            res *= x;
      }
      return res;
    }

b: The time complexity is O(n) because the for loop is linear

**Exercise 2**

a: See PDF "Ind.2.2 Induction proof"

b: Using the Master's theorem, we have:
- a = 2 because of two recursive calls
- b = 2 because we divide by 2
- c = 0 because there is no other additional work

We see that a > b<sup>c</sup> because 2 > 2<sup>0</sup> so we use the form O(n<sup>log<sub>b</sub> a</sup>) <br>
We get O(n<sup>log<sub>2</sub> 2 </sup>) = O(n)

