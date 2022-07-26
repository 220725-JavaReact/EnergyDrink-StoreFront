import java.util.ArrayList;
import java.util.Scanner;
import models.EnergyDrink;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userInput = "";
		Scanner scanner = new Scanner(System.in);
		
		// Starting Energy Drink List
		ArrayList<EnergyDrink> drinkList = new ArrayList<EnergyDrink>();
		drinkList.add(new EnergyDrink("Red Bull", 2.00));
		drinkList.add(new EnergyDrink("Monster", 3.00));
		drinkList.add(new EnergyDrink("Bang", 1.99));
		drinkList.add(new EnergyDrink("5 Hours", 3.50));
		drinkList.add(new EnergyDrink("Kickstarter", 2.25));
		
		// menu interface
		// while the userInput is not "x" we loop, we present the menu again
		do {
			System.out.println("======================================");
			System.out.println("Welcome to the Energy Drink Store!");
			System.out.println("[1] Display List");
			System.out.println("[2] Create and Add an Energy Drink to the list");
			System.out.println("[x] Exit Store");
			
			userInput = scanner.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println("The Energy Drinks currently listed are:");
				System.out.println();
				for(EnergyDrink currentDrink: drinkList) {
					//System.out.println(currentDrink.getName() + " priced at: " + currentDrink.price);
					System.out.printf("%s priced at: $%.2f \n", currentDrink.getName(), currentDrink.price);
				}
				System.out.println();
				break;
			case "2":
				// Get User's Drink Name
				System.out.println("Enter new Energy Drink name: ");
				String name = scanner.nextLine();
				
				// Get User's Drink Price
				System.out.println("Enter the Energy Drink's price: ");
				String priceString = scanner.nextLine();
				try {
					double priceDouble = Double.parseDouble(priceString);//Integer.parseInt(priceString);
					if(priceDouble > 0) {
						EnergyDrink newDrink = new EnergyDrink(name, priceDouble);
						drinkList.add(newDrink);
						System.out.println("Drink successfully added!");
					} else {
						System.out.println("Invalid Price, try again please.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

				break;
			case "x":
				System.out.println("Closing Store, Goodbye!");
				scanner.close();
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while(!(userInput.equals("x")));

	}

}
