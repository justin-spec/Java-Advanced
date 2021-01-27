package hw01_TodoList;

public class TodoList {
	String[] list = new String[1];
	
	// default constructor
	public TodoList(){
		list[0] = null;
	}
	
	/*
	// using an array
	public TodoList(String[] newlist) {
		// NOTE: double check to make sure it's not a shadow copy
		String[] list = newlist.clone();
	}*/
	
	// using multiple strings
	public TodoList(String... newlist) {
		// NOTE: double check to make sure it's not a shadow copy
		list = newlist.clone();
	}
	
	// display in order (1. 2. 3...)
	public void dio() {
		if (list.length == 1 && list[0] == null) {
			System.out.println("Empty");
			return;
		}
		for (int i = 1; i < list.length + 1; i++) {
			System.out.print(i + ". " + list[i - 1]);
			System.out.println();
		}
		
	}
	
	// display in list separated by commas
	public void dil() {
		if (list.length == 1 && list[0] == null) {
			System.out.println("Empty");
			return;
		}
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
			if (i == list.length-1) {
				break;
			}
			System.out.print(", ");
		}
		System.out.println();
		
	}
	
	// adds item to the main list
	public void add(String text) {
		// if list is {null}
		if (list.length == 1 && list[0] == null) {
			list[0] = text;
			return;
		}
		
		
		String[] newlist = new String [list.length + 1];
		
		// copies old to new
		for (int i = 0; i < list.length; i++) {
			newlist[i] = list[i];
		}
		// adds new
		newlist[list.length] = text;
		list = newlist.clone();
		
	}
	
	public void clear() {
		String[] newlist = {null};
		list = newlist.clone();
	}
	
	// removal by index number
	public void pop(int index) {
		// checks to see if index number is valid
		// this is commented out because TodoListEx handles the error exceptions
		/*
		if (!(index > 0 && index < list.length)) {
			System.out.println("Error: index number is out of range.");
			return;
		}*/
		
		// creates new list
		String[] newlist = new String[list.length-1];
		int c = 0;
		// skips item from list index when copying
		for (int i = 0; i < list.length; i++) {
			if (i == index) continue;
			newlist[c++] = list[i];
		}
		list = newlist.clone();
	}
	
	
	
	
	// CODE BELOW THIS POINT IS UNUSED AND NEEDS MORE TESTING
	// IT IS NOT REQUIRED FOR THIS ASSIGNMENT AND NOT NEEDED
	// I'M KEEPING THIS HERE IN THE EVENT THE SOFTWARE NEEDS TO BE SCALED UP
	
	// removes item from the main list as well as duplicates
	// TODO: fix issues with code
	public void rm(String text) {
		// checks if the list has any items to remove
		if (list.length == 0) {
			System.out.println("No items in list to remove.");
			return;
		}
		
		// checks if list has only one item
		if (list.length == 1) {
			if (list[0] == null) {
				System.out.println("No items in list to remove.");
			}
			
			else if (text.equals(list[0])) {
				list[0] = null;
			}
			return;
		}
		
		
		// counts total items to be removed
		int totalCount = 0;
		for (String item: list) {
			if (item.equals(text)) {
				totalCount++;
			}
		}
		
		if (totalCount <= 0) {
			System.out.println("Error: item not found");
			return;
		}
		
		System.out.println("Removing...");
		
		// if removing causes the list to become empty
		if (list.length - totalCount == 0) {
			String[] newlist = {null};
			list = newlist.clone();
			return;
		}
		
		// removing the item from the list
		
		String[] newlist = new String[list.length - totalCount];
		// counter for newlist
		int c = 0;
		// copies old to new without item that the user wants to remove
		// TODO: fix
		for (int i = 0; i < list.length; i++) {
			//System.out.println(list[i]);
			if (list[i].equals(text)) {
				//System.out.println("skipped!");
				continue;
			}
			//System.out.println(c + " " + i);
			newlist[c++] = list[i];
		}
		
		list = newlist.clone();

	}
	
	// removes first element found
	// TODO
	public void rmHead(String text) {
		// checks if the list has any items to remove
		if (list.length == 0) {
			System.out.println("No items in list to remove.");
			return;
		}
		
		// checks if list has only one item
		if (list.length == 1) {
			if (list[0] == null) {
				System.out.println("No items in list to remove.");
			}
			
			else if (text.equals(list[0])) {
				list[0] = null;
			}
			return;
		}
		
		
		// checks to see if the string must be removed
		boolean remove = false;
		for (String item: list) {
			if (item.equals(text)) {
				remove = true;
				break;
			}
		}
		
		if (!remove) {
			System.out.println("Error: item not found");
			return;
		}
		
		System.out.println("Removing...");
		
		// removing the item from the list
		
		String[] newlist = new String[list.length - 1];
		// counter for newlist
		int c = 0;
		// copies old to new without item that the user wants to remove
		for (int i = 0; i < list.length; i++) {
			if (list[i] == text) {
				continue;
			}
			newlist[c] = list[i];
		}
		
		list = newlist.clone();
			
		
		
		//return ;
	}
	
	// removes last element found
	// TODO
	public void rmTail(String text) {
		// checks if the list has any items to remove
		if (list.length == 0) {
			System.out.println("No items in list to remove.");
			return;
		}
		
		// checks if list has only one item
		if (list.length == 1) {
			if (list[0] == null) {
				System.out.println("No items in list to remove.");
			}
			
			else if (text.equals(list[0])) {
				list[0] = null;
			}
			return;
		}
		
		
		// checks to see if the string must be removed
		boolean remove = false;
		for (String item: list) {
			if (item.equals(text)) {
				remove = true;
				break;
			}
		}
		
		if (!remove) {
			System.out.println("Error: item not found");
			return;
		}
		
		System.out.println("Removing...");
		
		// removing the item from the list
		
		String[] newlist = new String[list.length - 1];
		// counter for newlist
		int c = 0;
		// copies old to new without item that the user wants to remove
		for (int i = 0; i < list.length; i++) {
			if (list[i] == text) {
				continue;
			}
			newlist[c] = list[i];
		}
		
		list = newlist.clone();

	}
	
}
