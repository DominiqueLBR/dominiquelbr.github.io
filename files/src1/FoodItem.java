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
 * FoodItem class is an abstract class. Super class of Fruit, Vegetable and Preserve.
 * @author Dominique Le Baud Roy
 */
public abstract class FoodItem {

	/**Unique code for items in inventory*/
	private int itemCode;	
	/**Item name*/
	private String itemName;	
	/**Quantity of items in stock*/
	private int itemQuantityInStock;
	/**Cost per item*/
	private float itemCost;
	/**Sale price per item.*/
	private float salePrice;

	/** FoodItem no argument constructor */
	public FoodItem() {
	}

	/** Method used to display the details of inventory items */
	@Override
	public String toString() {
		return String.format("Item: %d %s %d price: $%.2f cost: $%.2f ", 
				itemCode, itemName, itemQuantityInStock, salePrice, itemCost);
	}

	/**
	 * Method to update the item's stock in inventory
	 * @param amount Quantity of items
	 * @return true if successful, otherwise return false
	 */
	public boolean updateItem(int amount) {
		if (this.itemQuantityInStock + amount < 0) {
			return false;
		}
		itemQuantityInStock += amount;		
		return true;
	}

	/**
	 * Method to check if the item code being entered 
	 * @param item FoodItem 
	 * @return true
	 */
	public boolean isEqual(FoodItem item) { 
		return this.itemCode == item.itemCode;		
	}

	/**
	 * Reads input from the user to fill in the data about the item being added
	 * @param scan User input
	 * @return true if successful, otherwise returns false
	 */
	public boolean addItem (Scanner scan) {
		boolean isInputValid = false;
		int step = 1;  // Control variable for different inputs

		while (!isInputValid && step <= 4) {
			try {
				switch (step) {

				case 1:
					System.out.print("Enter the name for the item: ");
					this.itemName = scan.nextLine();
					isInputValid = true;
					break;
				case 2:
					System.out.print("Enter the quantity for the item: ");
					this.itemQuantityInStock = scan.nextInt();
					scan.nextLine();
					if (itemQuantityInStock > 0) {
						isInputValid = true;
					} else {
						System.out.println("Quantity must be a positive integer.");	                            
						isInputValid = false;
					}
					break;
				case 3:
					System.out.print("Enter the cost of the item: ");
					this.itemCost = scan.nextFloat();
					scan.nextLine();
					if (itemCost > 0) {
						isInputValid = true;
					} else {
						System.out.println("Cost must be a positive integer.");
						isInputValid = false;
					}
					break;
				case 4:
					System.out.print("Enter the sales price of the item: ");
					this.salePrice = scan.nextFloat();
					scan.nextLine();
					if (salePrice > 0) {
						isInputValid = true;
					} else {
						System.out.println("Sales price must be a positive integer.");
						isInputValid = false;
					}
					break;
				}

				if (isInputValid) {
					step++;
					isInputValid = false; // Reset for the next input
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid Entry");
				scan.nextLine(); // Clear the invalid input
				isInputValid = false; // Remain in the current step
			}
		}	
		return true;
	}

	/**
	 * Validating the item code
	 * @param scan Item code
	 * @return true if successful, otherwise returns false
	 */
	public boolean inputCode(Scanner scan) {
		boolean validItemCode = false;

		while(!validItemCode) {
			try {
				System.out.print("Enter the code for the item: ");
				itemCode = scan.nextInt();
				scan.nextLine();	
				validItemCode = true;				
			}catch (InputMismatchException e) {
				System.out.println("Invalid entry. Must be an integer.");
				scan.nextLine();
				validItemCode = false;
			}		
		}
		return true; 
	}	
}