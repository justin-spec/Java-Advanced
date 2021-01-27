ASSIGNMENT

Todo list Requirements

You're going to make a todo list according to the provided design. The user should be able to:

    Add tasks to the list
    See the added tasks
    Be able to clear all items

A task is defined as a string which the user enters. The program should do all this on the command line. Use a menu-driven approach to make life easier for the user.  This is an advanced class, so do sensible validation. The code should be checked into github. You must have a readme file showing how to work your program to be graded correctly. Submit only your url to the project.


HOW TO RUN
	1. Have java installed (I usee JavaSE-11 aka java openjdk 11)
	2. Download this folder (hw01_TodoList)
	
	Eclipse
	3. Download and open eclipse IDE
	4. Import the project
	5. Run or export into a .jar
	
	Terminal
	3. Open your terminal or command prompt
	4. run java -jar TodoList.jar
	
	
HOW TO USE

After launching the program, you will see an empty todo list and a list of commands
	add 	- this lets you add items to the list
	remove	- this allows you to select which item you want to remove
	clear	- clears the entire list
	exit	- exits program
	
	
DOCUMENTATION

The code is organized into two parts:

	TodoList 
This handles the TodoList class, which stores the user text into an array. It will add, remove, clear, or display elements and resize the array accordingly.

	TodoListEx
This handles main, the commandline, and functions for the user to interact and manipulate the TodoList object. It has the following commands:
	add 	- resizes the array and adds a string at the end
	remove	- resizes the array and removes the element the user chooses
	clear	- clears the entire array
	exit	- quits program
	
	Unused:
	help	- shows all available commands
		not needed because commands show by default
	display - shows the list of elements in the array 
		not needed because the list of elements appears by default
		
		
How to implement Todo into your code
	1. Change the package name to fit your project (or remove completely)
	2. (Recommended) Change the file name to something better (maybe List.java)
	NOTE: You may want to change the array to be public, protected or private

	
	Constructors:
	
Default:
The default constructor is to create an empty string array with the value null.

List(String... newlist):
clones newlist to the list in the object initialized. this function is untested as it is not needed for this assignment.

	Methods of TodoList:
	
	dio() 
	- Display In Order: this prints the array as an ordered list (1. ... 2. ...)
	- THIS ONLY WORKS ON CONSOLE. IT DOES NOT RETURN A STRING
	
	dil() 
	- Display In List: this will print as a normal list (..., ..., ...)
	- THIS ONLY WORKS ON CONSOLE. IT DOES NOT RETURN A STRING

	add(String text) 
	- Creates a new array (with one extra space) that copies everything from the first array via for loop, then adds the text to the end. The original array clones the new array.
	
	clear()
	- Creates a new array that is set to default (String, length is 1, set to null). The original array clones the new array.

	pop(int index)
	- Creates a new array with 1 less space. Copies everything over excluding the index number (Array starts at 0. If you want to remove starting from 1, you will need to subtract by 1 when using this).

	UNUSED AND UNFINISHED
	rm(String text)
	- removes all elements that equals text if applicable
	
	rmHead(String text)
	- removes one element that is specified if applicable. searches from first to last
	
	rmTail(String text)
	- removes one element that is specified if applicable. searches from last to first
	
	
THINGS TO IMPROVE IF USED IN FUTURE PROJECTS
	fix rm, rmHead, rmTail
	create a toString function
	check and test constructors
