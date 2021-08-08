package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.FighterJet;

public class JetsApplication {
	private AirField airField = new AirField();
	Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.launch();

	}

	public JetsApplication() {
//		airField = new AirField();

	}

	public void launch() {
		airField.loadAirField();
	}

	public void userMenu() {
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
		System.out.println("*										*");
		System.out.println("*****************************************");
	}
}
