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
 * Preserve class is a subclass of FoodItem, used for the preserve items specifications
 * @author Dominique Le Baud Roy
 */
public class Preserve extends FoodItem{
	/**Size of jar in mL */
	private int jarSize;
	
	/**
	 * Reads input from the user to fill in the data about preserve items being added to inventory
	 * @param scan User input
	 * @return true if successful, otherwise returns false
	 */
	@Override
	public boolean addItem (Scanner scan) {
		super.addItem(scan);		
		boolean isInputValid = false;

		while(!isInputValid) {
			try {
				System.out.print("Enter the size of the jar in milliliters: ");
				jarSize = scan.nextInt();
				scan.nextLine();
				isInputValid = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Entry");			
				scan.nextLine();
			}
		}
		return true;		
	}
	
	/**
	 * Used to display the preserve specifications after specifications from super class
	 */
	@Override
	public String toString() {
		String results = String.format(super.toString() + "size: %d", jarSize) +"mL";
		return results;		
	}	
}
