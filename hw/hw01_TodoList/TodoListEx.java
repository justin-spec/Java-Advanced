package hw01_TodoList;

import java.util.Scanner;

import hw01_TodoList.TodoList;

public class TodoListEx {
	
	// outside of main so every function in the class can use it
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		// to test TodoList.java
		//testCode();
		
		//Scanner input = new Scanner(System.in);
		TodoList List = new TodoList();
		
		while (true) {
			System.out.println();
			System.out.println("Todo List:");
			List.dio();
			System.out.println();
			help();
			System.out.print("--> ");
			String option = input.nextLine();
			
			if (fld(option, "add")) {
				add(List);
			}
			
			else if (fld(option, "remove")) {
				pop(List);
			}
			/*
			else if (fld(option, "display")) {
				List.dio();
			}
			*/
			
			else if (fld(option, "clear")) {
				clear(List);
			}
			
			/*
			else if (fld(option, "help")) {
				help();
			}*/
			
			else if (fld(option, "exit")) {
				System.out.println("Shutting down...");
				input.close();
				break;
			}
			
			else {
				System.out.println("Error: Unknown command.");
				//System.out.println("Error: Unknown command. Type (h)elp to show command list.");
			}
			
		}
		
	}
	
	
		
	// COMMAND FUNCTIONS
	
	// help menu
	public static void help() {
		System.out.println("Commands:");
		//System.out.println("(d)isplay, (a)dd, (r)emove, (h)elp, (e)xit");
		System.out.println("(a)dd, (r)emove, (c)lear, (e)xit");
	}
	
	public static void add(TodoList List) {
		String add;
		while (true) {
			System.out.println("What do you want to add?");
			System.out.println("Type /b to go back to main menu.");
			System.out.print("> ");
			add = input.nextLine();
			if (add.equals("/b")) return;
			List.add(add);
			System.out.println("Added!");
		}
	}
	
	// removes item based on index number
	public static void pop(TodoList List) {
		if(List.list[0] == null) {
			System.out.println("No items to remove.");
			return;
		}
		
		String remove;
		System.out.println("Which number do you want to remove?");
		System.out.println("Type /b to go back");
		System.out.print("> ");
		remove = input.nextLine();
		//List.pop(Integer.parseInt(option));
		if (remove.equals("/b")) return;
		
		try {
			// assuming user starts at 1 and not 0
			List.pop(Integer.parseInt(remove) - 1);
		}
		catch (NumberFormatException e) {
			System.out.println("Error: input could not be parsed into a number.");
			return;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: index number is out of range.");
			return;
		}
		System.out.println("Done!");
	}
	
	public static void clear(TodoList List) {
		if(List.list[0] == null) {
			System.out.println("List is already empty.");
			return;
		}
		
		String choice;
		System.out.println("You are about to clear everything in the list.");
		while (true) {
			System.out.println("Are you sure? (y)es or (n)o");
			System.out.print("> ");
			choice = input.nextLine();
			if (fld(choice, "yes")) {
				List.clear();
				System.out.println("Clearing Complete!");
				return;
			}
			else if (fld(choice, "no")) {
				System.out.println("Returning to menu...");
				return;
			}
			else {
				System.out.println("Error: Unknown input.");
			}
		}
		
	}
	
	// first letter detector
	// returns true whether the text is the first letter, or is the whole word
	public static boolean fld(String input, String text) {
		input = input.toLowerCase();
		//System.out.println(text + " " + input + " " + text.substring(0,1));
		if (input.equals(text) || input.equals(text.substring(0,1))) {
			return true;
		}
		return false;
	}
	
	// tests the TodoList class to make sure TodoList class works
	public static void testCode() {
		System.out.println("Testing: Creat list object");
		TodoList Test = new TodoList();
		System.out.println("Complete!");
		
		System.out.println("Testing: Adding item: foobar");
		Test.add("foobar");
		System.out.println("Complete!");
		
		System.out.println("Testing: Displaying list");
		Test.dio();
		System.out.println("Complete!");
		
		System.out.println("Testing: Removing item");
		Test.pop(0);
		System.out.println("Complete!");
		
		System.out.println("Testing: Deleting object");
		Test = null;
		System.out.println("Complete!");
		
		
		System.out.println("Testing: Creating list object with the following items: foo, by, bar");
		TodoList Test1 = new TodoList("foo", "by", "bar");
		Test1.dio();
		System.out.println("Complete!");
		
	}

}
