COMP204-14B / COMP242-14B ASSIGNMENT 2
======================================

Due on **Sunday 7th August at 11:30 pm**.


Java Objects and JUnit
======================

The main purpose of this assignment is to experiment with the Object Oriented features of Java.  The secondary
purpose is to further your experience with modern software engineering methods and tools.  Git and GitLab feature
again, but this time you will also use the Android Studio IDE and develop tests to demonstrate that your programs do as they
should.  We will use JUnit4 - a unit testing framework to manage the tests.  To facilitate testing, we will provide
Interfaces for two of your Java classes and we require you to write classes implementing those interfaces.

The Programming Tasks
=====================
When using a command line interface, users frequently find themselves using the same command more than once.  To help reduce
typing most command shells have a 'history' mechanism.  Imagine a programmer developing a Java program on a Linux computer.  
A sequence of commands they run might look like this (output not shown):

1.    gedit MyProgram.java &
1.    javac MyProgram.java
1.    java MyProgram arg1 arg2 arg3
1.    javac MyProgram.java
1.    javac MyProgram.java
1.    java MyProgram arg1 arg2 arg3

In fact the user would only need to fully type the first three lines.  The fourth line is just a repeat of line two, so the 
programmer would hit the up-arrow key twice and press 'enter' - the command history system remembers and displays the command.
If compilation failed, a single up-arrow and 'enter' would be next, 
etc.  Your first task is to write a 'command history' program which manages 'command text'.  The Java text input system
doesn't make it easy to recognise arrow key presses, so you can use full stops '.' instead.  For example, on the fourth line 
your user would type '..' and 'enter'.  An interaction with your system should look like 
this (lines 1, 2, 3, 4, 6 and 8 are typed by the user, and lines 5, 7, and 9 are generated by the program):

1.    gedit MyProgram.java &
1.    javac MyProgram.java
1.    java MyProgram arg1 arg2 arg3
1.    ..
1.    javac MyProgram.java
1.    .
1.    javac MyProgram.java
1.    ..
1.    java MyProgram arg1 arg2 arg3

As you are not processing real commands you can think of a command just being a string.  Your system will
only maintain a limited history list.  If the user types enough full stops to pass all the commands in the
system, it will wrap around and offer the first command again.  If more commands are typed than can fit
in the list, the oldest command will be deleted.  In this sense, you are developing a
'circular command history' system.

You are required to develop this program with two classes.  One is the program which accepts user input from
the keyboard and responds appropriately.  The other class is a 'collection' class to hold commands (strings),
implementing the interface we provide in the starter project.  Your history class will maintain the 'history' of 
strings.  You are also required to develop a set of 'unit tests' for the history class.  We provide two samples
to get you started.

Your *second task* is to redevelop the history class using generics.  The idea here is that the basic
mechanism for maintaining a history of commands might be useful in other programs. For example graphic
user interface programs often have 'undo / redo' command histories.  If your class could store items
from arbitrary classes instead of strings it could be used (or extended for use) in such scenarios.  Again
you will write units tests for the generic history class.


You are required to submit a zipped copy of your repository to moodle.  Please download the zip from 
GitLab using the download button in the top right of the project view rather than zipping it from the copy on 
your local hard drive.
 
Summary
=======
 
You are required to implement:
* A String Scrollback list that can store a specified number of elements.
  * Scrollback should implement the interface `ScrollbackInterface` provided.
  * Constructor should take an argument indicating the **number of elements** it should be able to hold.
    * If no size is specified, the Scrollback should **default to 10 elements**.
  * If you attempt to add a String that matches the most recent item in the Scrollback, you should **not** insert a duplicate.
  * Calls to `getLast()` should retrieve the previous command.
    * Successive calls should retrieve older values cycling back to the newest element if the Scrollback is exhausted.
    * Decide what will happen if `getLast()` is called with no suitable elements available (Use a test to demonstrate this).

* An interactive console that allows you to interface with your Scrollback implementation.
  * When started, your console should print a usage message indicating the commands used.
  * The console should loop until an exit condition is encountered (Document the method of exiting in the usage message)
  * When a period is provided as input, this should retrieve a previously inputted command.
    * The number of periods specified should indicate how far back in history to retrieve. eg, `.` will retrieve the last 
    inputted command and `...` will pick the command 3^(rd) in the scrollback.

An example session could appear as follows.

```
Welcome to the AssignmentTwo interactive console!

Type items followed by return to add them to the scrollback.
Special commands:
  .    - Retrieve and add the last command. Multiple periods will look back further in the scrollback
  show - Print details about the scrollback
  rst  - Reset the scrollback
  quit - Exit this console
  
Please enter a scrollback size (default = 10)
> 15
Created Scrollback of size 15

> test
Ok.

> bob
Ok.

> Geoff
Ok.

> COMP204
Ok.

> COMP204
Ok.

> show
Scrollback capacity: 15
Current elements: 4
-> test
-> bob
-> Geoff
-> COMP204

> .
COMP204

> show
Scrollback capacity: 15
Current elements: 4
-> test
-> bob
-> Geoff
-> COMP204

> ...
bob

> show
Scrollback capacity: 15
Current elements: 5
-> test
-> bob
-> Geoff
-> COMP204
-> bob

> rst
Scrollback reset

> show
Scrollback capacity: 15
Current elements: 0

> exit
```

* A Generic Scrollback list that can store a specified number of elements.
  * Scrollback should implement the interface `GenericScrollbackInterface` provided.
  * Other than being Generic, this scrollback should behave in the same way as your String implementation.
    
* Write a series of tests to demonstrate your program functionality
  * **Exactly 10 tests** covering your **String** Scrollback implementation written in the `ScrollbackTest` file. Try to test the class 
  as thoroughly as you can with your 10 tests, the grade allocation will take into account how thoroughly your tests cover the functionality.
  * **Exactly 12 tests** covering your **Generic** Scrollback implementation written in the `GenericScrollbackTest` file. 10 of the tests 
  should be reimplementations of the tests written for the String Scrollback, while the remaining 2 should test using the provided `PokemonEncounter` class.



Instructions
============

1. Fork this repository using the button at the top of the page.
  * Set the visibility level of the project to Private.
2. Clone your new repository to your computer using Git.
3. Using Android Studio or IntelliJ IDEA, open the project by selecting the `Open` option on the IDE launch screen, then selecting the repository directory.
4. Ensure the program has run correctly by running the two main files for the application.
  * In the project pane, find the `AssignmentTwo` file, right-click it and select `Run 'AssignmentTwo.main()` from the context menu. If successful, you should 
  see `Code your user interface class here` printed to the output pane.
  * In the project pane, find the `AssignmentTwoTestSuite` file, right-click it and select `Run 'AssignmentTwoTestSuite` from the context menu. If successful,
  you should see a test pane showing that `PokemonEncounterTest` and `PokemonTest` have succeeded, while `GenericScrollbackTest` and `ScrollbackTest` have failed.
* In `Scrollback.java`, implement the String Scrollback as described above
  * Write tests as you go in the `ScrollbackTest.java` file
  * Remember to stage/commit/push your work regularly
* In `AssignmentTwo.java`, implement your interactive console as described above
* In `GenericScrollback.java`, implement the Generic Scrollback as described above
  * Write tests as you go in the `GenericScrollbackTest.java` file
  * Remember to stage/commit/push your work regularly
* Push your changes to your GitLab repository. Ensure that you can see your changes on GitLab.
* Upload a zipped copy of your repository to [moodle in the assignment submission](https://elearn.waikato.ac.nz/mod/assign/view.php?id=561656). 
Please download the zip from GitLab using the download button in the top right of the project view rather than zipping it from the copy on 
your local hard drive.
 

Grading
=======
| Weighting | Allocated to |
|:----------:|------|
| 10% | Correct repository usage and settings |
| 50% | Programming scrollback implementaions |
| 40% | Creation of tests in appropriate number and quality |