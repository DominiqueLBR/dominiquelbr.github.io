/*
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Dominique Le Baud Roy
 * Student Number: 040871126 
 * Course: CST8130 - Data Structures
 * Professor: Narges Tabar
 * 
 */
import java.util.Scanner;
/**
 * Fruit class is a subclass of FoodItem, used for the fruit items specifications
 * @author Dominique Le Baud Roy
 */
public class Fruit extends FoodItem{

	/**Name of orchard*/
	private String orchardName;

	/**
	 * Reads input from the user to fill in the data about fruit items being added to inventory
	 * @param scan User input
	 * @return true if successful, otherwise returns false
	 */
	@Override
	public boolean addItem (Scanner scan) {
		if (super.addItem(scan) == false) {
			return false;
		}
		System.out.print("Enter the name of the orchard supplier: ");
		orchardName = scan.nextLine();
		return true;

	}

	/**
	 * Used to display the fruit specifications after specifications from super class
	 */
	@Override
	public String toString() {
		String results = String.format(super.toString() + "orchard supplier: %s", orchardName);
		return results;
	}
}
