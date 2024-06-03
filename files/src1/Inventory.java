/*
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Dominique Le Baud Roy
 * Student Number: 040871126 
 * Course: CST8130 - Data Structures
 * Professor: Narges Tabar
 * 
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Inventory class, updates, verifies and displays the inventory
 * @author Dominique Le Baud Roy
 */
public class Inventory {
	/** Array to store the inventory */
	private FoodItem[] inventory;
	/** Number of items in inventory */
	private int numItems;
	
	/** No argument Inventory constructor */
	public Inventory() {
		inventory = new FoodItem[20];
		numItems = 0;
	}

	/** Display inventory */
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (FoodItem item : inventory) {
			if(item != null) {				
				result.append(item.toString()).append("\n");
			}
		}
		return result.toString();
	}

	/**
	 * Finds the index for the FoodItem in the array, item already exists if method returns index
	 * @param item FoodItem
	 * @return returns index if successful, otherwise returns -1
	 */
	public int alreadyExists(FoodItem item) {
		for (int i = 0; i < numItems; i++) {
			if (inventory[i].isEqual(item)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Reads input from the user to fill in the data about items being added to inventory
	 * @param scan User input
	 * @param item FoodItem
	 * @return true if successful, otherwise returns false
	 */
	public boolean addItem(Scanner scan, FoodItem item) {
		//Verifying if item code already exists in the inventory
		if (alreadyExists(item) != -1) {
			System.out.println("Item code already exists. \n"); 
			return false;
		}
		//Verifying that the number of item does not go above 20
		if (numItems >= 20) {
			System.out.println("Inventory is full. \n");
			return false;
		}
		//Adding item to inventory
		if (item.addItem(scan)) {
			inventory[numItems++] = item;			
		} 
		return true;
	}

	/**
	 * Updates quantity when the user buys or sells items
	 * @param scan Reads the item code from the scanner
	 * @param buyOrSell True when user wants to buy and false when user wants to sell
	 * @return true if successful, otherwise returns false
	 */
	public boolean updateQuantity(Scanner scan, boolean buyOrSell) {
		// Checking if the inventory is empty		
		if (numItems == 0) {
			return false;
		} 		

		int index;		


		try {
			//itemCode = scan.nextInt();
			FoodItem tempItem = new Fruit();
			tempItem.inputCode(scan);
			//scan.nextLine();
			//Finding item in inventory
			index = alreadyExists(tempItem);
			if (index == -1 ) {
				System.out.println("Code not found in inventory.");	

				return false;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid item code.");	
			scan.nextLine();
			return false;
		}

		int quantity = 0;	
		try {
			//If true user is buying
			if (buyOrSell == true) {
				System.out.print("Enter valid quantity to buy: ");
				quantity = scan.nextInt();
				scan.nextLine();	

				//Check that quantity is above 0
				if (quantity <= 0) {
					System.out.println("Must be a positive integer.");
					return false;
				}					

				//If false user is selling	
			} else if (buyOrSell == false) {
				System.out.print("Enter valid quantity to sell: ");
				quantity = scan.nextInt();
				scan.nextLine();

				//Check that quantity is above 0
				if (quantity <= 0) {
					System.out.println("Must be a positive integer.");
					return false;
				} 
				quantity = -quantity; //Setting quantity to negative for selling
			}				

			// Updating quantity
			FoodItem item = inventory[index];
			if (!item.updateItem(quantity)) {
				System.out.println("Insufficient quantity to sell.");
				return false;
			}
			return true;

		}catch (InputMismatchException e) {
			System.out.println("Invalid quantity.");
			scan.nextLine();
			return false;
		}		

	}
}
