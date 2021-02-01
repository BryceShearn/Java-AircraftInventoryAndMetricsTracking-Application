package com.skilldistillery.jets;

import java.util.Scanner;
public class JetsApplication {
	private Airfield newAirField;
	private Scanner sc = new Scanner(System.in);
		public JetsApplication() {
		}
		public static void main(String[] args) {
			JetsApplication newJetsApplication = new JetsApplication();
			String textFile = "jets.txt";
			newJetsApplication.newAirField = new Airfield(textFile);
			newJetsApplication.run(textFile);
		}
		private void run(String textFile) {
			System.out.println("");
			boolean start = true;
			while (start) {
				displayUserMenu();
				start = userInputMenu(textFile);
			}
			System.out.println("SECURE LINK TERMINATED, EXITING");
			System.exit(0);
		}
		private void displayUserMenu() {
			System.out.println();
			System.out.println("SECURE OPERATIONS MENU:");
			System.out.println("LIST FLEET [1]");
			System.out.println("FLY ALL JETS [2]");
			System.out.println("VIEW FASTEST JET [3]");
			System.out.println("VIEW JET WITH LONGEST RANGE [4]");
			System.out.println("LOAD ALL THE CARGO JETS [5]");
			System.out.println("DOGFIGHT! [6]");
			System.out.println("ADD A JET TO THE FLEET [7]");
			System.out.println("REMOVE A JET FROM FLEET [8]");
			System.out.println("QUIT [9]");
		}
		private boolean userInputMenu(String textFile) {

			int userSelection = sc.nextInt();
			System.out.println();

			switch (userSelection) {
			case 1:
				newAirField.listFleet();
				break;
			case 2:
				newAirField.flyAllJets();
				break;
			case 3:
				newAirField.DisplayFastestAircraft();
				break;
			case 4:
				newAirField.LongestRangeAircraft();
				break;
			case 5:
				newAirField.loadCargoJets();
				break;
			case 6:
				newAirField.dogfight();
				break;
			case 7:
				newAirField.addAircraft(sc);
				break;
			case 8:
				newAirField.removeAircraft(sc);
				break;
			case 9:
				return false;
			default:
				System.err.println("INCORRECT ENTRY. ENTER VALID ENTRY" + userSelection);
				break;
			}
			return true;
		}
	}