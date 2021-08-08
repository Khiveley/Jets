package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {
	private AirField airField = new AirField();
	Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.launch();
		jetsApp.userMenu();

	}

	public JetsApplication() {
		

	}

	public void launch() {
		airField.loadAirField();
	}

	public void userMenu() {
		int option = 0;
		while (option != '9') {
		System.out.println("Please enter the number 1-9 for your menu selection. ");
		option = keyboard.nextInt();
		keyboard.nextLine();
	
		
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
	
		if ( option == '1') {
			listFleet();
		}
		
		
		}
	}
	public void listFleet() {
		List<Jet>jets = airField.getJets();
	}

	private void getJets() {
		// TODO Auto-generated method stub
		
	}
}
