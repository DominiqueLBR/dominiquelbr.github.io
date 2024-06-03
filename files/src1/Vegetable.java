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
 * Vegetable class is a subclass of FoodItem, used for the vegetable items specifications
 * @author Dominique Le Baud Roy
 */
public class Vegetable extends FoodItem{
	
	/**Name of farm*/
	private String farmName;
	
	/**
	 * Reads input from the user to fill in the data about vegetable items being added to inventory
	 * @param scan User input
	 * @return true if successful, otherwise returns false
	 */
	@Override
	public boolean addItem (Scanner scan) {
		super.addItem(scan);
		System.out.print("Enter the name of the farm supplier: ");
		farmName = scan.nextLine();
		return true;		
	}
	
	/**
	 * Used to display the vegetable specifications after specifications from super class
	 */
	@Override
	public String toString() {		
		String results = String.format(super.toString() + "farm supplier: %s", farmName);		
		return results;		
	}
}