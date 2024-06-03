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
 * Main class, start of the program
 * @author Dominique Le Baud Roy
 */
public class Assign1 {
	/** Main method
	 * @param args main
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		Inventory inventory = new Inventory();
		FoodItem item = null;

		do {
			try { // Main menu 
				System.out.println("\nPlease select one of the following:");
				System.out.println("1: Add Item to Inventory");
				System.out.println("2: Display Current Inventory");
				System.out.println("3: Buy Item(s)");
				System.out.println("4: Sell Item(s)");
				System.out.println("5: To Exit");
				System.out.print("> ");
				int choice = scan.nextInt();
				scan.nextLine();

				switch (choice) { //Switch for main menu
				case 1:		
					boolean validItemType = false;
					while(!validItemType) { //Loop until user enters a valid item type
						System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
						String itemType = scan.nextLine();	
						//Nested switch for item type
						switch (itemType.toLowerCase()) { 
						case "f":
							item = new Fruit();
							item.inputCode(scan);
							inventory.addItem(scan, item);
							validItemType = true; // to exit loop
							break;
						case "v":
							item = new Vegetable();
							item.inputCode(scan);
							inventory.addItem(scan, item);
							validItemType = true;
							break;
						case "p":
							item = new Preserve();
							item.inputCode(scan);
							inventory.addItem(scan, item);
							validItemType = true;
							break;
						default:
							System.out.println("Invalid entry");				                
							break;
						} //End of nested switch
					}
					break;
				case 2:
					System.out.println("Inventory:");							
					System.out.print(inventory.toString());				
					break;
				case 3:				
					if (inventory.updateQuantity(scan, true) == false) {
						System.out.println("Error. Could not buy item.");
					}
					break;
				case 4:
					if (inventory.updateQuantity(scan, false) == false) {
						System.out.println("Error. Could not sell item.");
					}
					break;
				case 5:
					System.out.println("Exiting program.");
					loop = false;
					break;
				default:
					System.out.println("Invalid input. Please try again.");
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println("Invalid input. Please try again.");
				scan.nextLine(); //Clear input stream
			}
		}while(loop);
	}
}
