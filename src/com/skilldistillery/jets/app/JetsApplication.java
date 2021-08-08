package com.skilldistillery.jets.app;

import java.io.*;
import java.util.*;
import com.skilldistillery.jets.entities.*;

public class JetsApplication {
	private AirField af = new AirField();
	private static 
	Scanner keyboard = new Scanner(System.in);
	private String option;

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.launch();

	}

	private void launch() {
		af.loadAirField();
		int option = 0;
		while (option != 9) {
			option = userMenu();
			userChoice(option);
		}
	}

	public int userMenu() {

		System.out.println("*****************************************");
		System.out.println("*                                       *");
		System.out.println("*                -Menu-                 *");
		System.out.println("*                                       *");
		System.out.println("*  Select From the Following Options:   *");
		System.out.println("*    1. List Fleet.                     *");
		System.out.println("*    2. Fly All Jets.                   *");
		System.out.println("*    3. View Fastest Jet.               *");
		System.out.println("*    4. View Jet with Longest Range.    *");
		System.out.println("*    5. Load All Cargo Jets.            *");
		System.out.println("*    6. Dogfight!                       *");
		System.out.println("*    7. Add Jet to Fleet.               *");
		System.out.println("*    8. Remove Jet from Fleet.          *");
		System.out.println("*    9. Quit.                           *");
		System.out.println("*****************************************");
		
		
		int option = keyboard.nextInt();
		keyboard.nextLine();
		
		return option;
	}
	
	private void userChoice(int o) {
			
			switch(o) {
			
			case 1: listFleet();
			break;
			case 2: fly();
			break;
			case 3: viewFastestJet();
			break;
			case 4: viewLongestRange();
			break;
			case 5: loadCargoJets();
			break;
			case 6: fight();
			break;
			case 7: addJet();
			break;
			case 8: removeJet();
			break;
			case 9: quit();
			break;
			default:
				System.out.println("Invalid option. ");
			}
	}
		
			
//			if (option == '1') {
//				listFleet();
//			} else if (option == '2') {
//				fly();
//			} else if (option == '3') {
//				viewFastestJet();
//			} else if (option == '4') {
//				viewLongestRange();
//			} else if (option == '5') {
//				loadCargoJets();
//			} else if (option == '6') {
//				fight();
//			} else if (option == '7') {
//				addJet();
//			} else if (option == '8') {
//				removeJet();
//			} else if (option == '9') {
//				quit();
//				break;
//			}

//		} catch (InputMismatchException e) {
//			System.out.println("Invalid input. Please reenter your option.");
//			keyboard.nextLine();
//		}
//	}

	private void listFleet() {
//		List<Jet> jets = airField.getJets();
		for (Jet jet : af.getJets()) {
			System.out.println("Here are all of our current jets: " + jet);
		}
	}

	private void fly() {
		for (Jet jet : af.getJets()) {
			jet.fly();
		}
	}

	private void viewFastestJet() {
		double greatestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : af.getJets()) {
			if (jet.getSpeed() > greatestSpeed) {
				fastestJet = jet;
				greatestSpeed = fastestJet.getSpeed();
			}
		}
		System.out.println("The fastest jet is: " + fastestJet);
	}

	private void viewLongestRange() {
		int longestRange = 0;
		Jet longestRangeJet = null;
		for (Jet jet : af.getJets()) {
			if (jet.getRange() > longestRange) {
				longestRangeJet = jet;
				longestRange = longestRangeJet.getRange();
			}
		}
		System.out.println("The jet with the longest range is: " + longestRangeJet);
	}

	private void loadCargoJets() {
		for (Jet jet : af.getJets()) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	private void fight() {
		for (Jet jet : af.getJets()) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
	}

	private void addJet() {
		try {
			System.out.println("Enter the jet's model: ");
			String model = keyboard.next();
			System.out.println("Enter the jet's speed: ");
			double speed = keyboard.nextDouble();
			System.out.println("Enter the jet's range: ");
			int range = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter the jet's price: ");
			long price = keyboard.nextLong();

			af.getJets().add(new JetImpl(model, speed, range, price));
			System.out.println("Jet added to fleet!");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
			keyboard.nextLine();
		}
	}

	private void removeJet() {
		List<Jet> jets = af.getJets();
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(i + 1 + ". " + jets.get(i));
		}
		System.out.println("Delete a jet from the fleet by entering its number. ");
		try {
			int choice = keyboard.nextInt();
			if (choice < jets.size() + 1 && choice > 0) {
				System.out.println(jets.get(choice - 1).getModel() + " has been deleted.");
				jets.remove(choice - 1);
			} else {
				System.out.println("Invalid choice. ");
			}

		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Reenter the number for the jet you would like to delete. ");
		}
	}

	private void quit() {
		keyboard.close();
		System.out.println("Thank you for using the Jets Application. ");
	}

}
