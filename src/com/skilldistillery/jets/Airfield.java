package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Airfield {

	private ArrayList<Jet> aircraft;

	public Airfield(String textFile) {
		aircraft = new ArrayList<>();
		BufferedReader reader = null;
		String aircraftString = null;
		try {
			reader = new BufferedReader(new FileReader(textFile));
			Jet aircraftFromFile = null;
			while ((aircraftString = reader.readLine()) != null) {
				String[] aircraftFileInfo = aircraftString.split(",");
				if (aircraftFileInfo[0].contains("CargoPlane")) {
					aircraftFromFile = new CargoPlane(aircraftFileInfo[0], aircraftFileInfo[1], Double.parseDouble(aircraftFileInfo[2]),
							Integer.parseInt(aircraftFileInfo[3]), Long.parseLong(aircraftFileInfo[4]));
				}
				else if (aircraftFileInfo[0].contains("FighterJet")) {
					aircraftFromFile = new FighterJet(aircraftFileInfo[0], aircraftFileInfo[1], Double.parseDouble(aircraftFileInfo[2]),
							Integer.parseInt(aircraftFileInfo[3]), Long.parseLong(aircraftFileInfo[4]));
				}
				else {
					aircraftFromFile = new JetImplementation(aircraftFileInfo[0], aircraftFileInfo[1], Double.parseDouble(aircraftFileInfo[2]),
							Integer.parseInt(aircraftFileInfo[3]), Long.parseLong(aircraftFileInfo[4]));
				}
				aircraft.add(aircraftFromFile);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void listFleet() {
		for (Jet jetArrIdx : aircraft) {
			System.out.println(jetArrIdx);
		}
	}
	public void flyAllJets() {
		for (Jet jetArrIdx : aircraft) {
			jetArrIdx.fly();
		}
	}
	public void DisplayFastestAircraft() {
		double fastestAircraft = 0;
		for (Jet jetArrIdx : aircraft) {
			if (fastestAircraft < jetArrIdx.getSpeed()) {
				fastestAircraft = jetArrIdx.getSpeed();
			}
		}
		for (Jet jetArrIdx : aircraft) {
			if (fastestAircraft == jetArrIdx.getSpeed()) {
				System.out.println("Fastest: " + jetArrIdx.toString());
			}
		}
	}

	public void LongestRangeAircraft() {
		double longestRangeAircraft = 0;
		for (Jet jetArrIdx : aircraft) {
			if (longestRangeAircraft < jetArrIdx.getRange()) {
				longestRangeAircraft = jetArrIdx.getRange();
			}
		}
		for (Jet jetArrIdx : aircraft) {
			if (longestRangeAircraft == jetArrIdx.getRange()) {
				System.out.println("Longest Range Aircraft: " + jetArrIdx.toString());
			}
		}
	}

	public void loadCargoJets() {
		int numberDisplay = 1;
		for (Jet jetArrIdx : aircraft) {
			if (jetArrIdx instanceof CargoPlane) {
				((CargoPlane) jetArrIdx).loadCargo();
				System.out.println(numberDisplay + ": " + ((CargoPlane)jetArrIdx).toString());
				numberDisplay++;
			}
		}
	}

	public void dogfight() {
		for (Jet jetArrIdx : aircraft) {
			if (jetArrIdx instanceof FighterJet) {
				System.out.println(((FighterJet) jetArrIdx).toString());
				((FighterJet) jetArrIdx).fight();
			}
		}
	}

	public void addAircraft(Scanner sc) {
		System.out.println("TYPE: ENTER CargoPlane OR FighterJet OR ADD A NEW AIRCRAFT TYPE");
		sc.nextLine();
		String type = sc.nextLine();
		System.out.println("MODEL: ");
		String model = sc.nextLine();
		System.out.println("SPEED:MPH: ");
		double speed = sc.nextDouble();
		System.out.println("RANGE:MILES: ");
		int range = sc.nextInt();
		System.out.println("PRICE:");
		long price = sc.nextLong();
		sc.nextLine();
		Jet userGeneratedAircraft = null;
		if (type.contains("CargoPlane")) {
			userGeneratedAircraft = new CargoPlane(type, model, speed, range, price);
		} else if (type.contains("FighterJet")) {
			userGeneratedAircraft = new FighterJet(type, model, speed, range, price);
		} else {
			userGeneratedAircraft = new JetImplementation(type, model, speed, range, price);
		}
		aircraft.add(userGeneratedAircraft);
	}

	public void removeAircraft(Scanner sc) {
		System.out.println("SELECT AIRCRAFT TO REMOVE WITH COORESPONDING NUMBER");
		int aircraftNumber = 1;
		for (Jet jetArrIdx : aircraft) {
			System.out.println("[" + aircraftNumber + "]" + jetArrIdx.toString());
			aircraftNumber++;
		}
		int userSelection1 = sc.nextInt();
		if (userSelection1 != 0 && userSelection1 <= aircraft.size()) {
			aircraft.remove(userSelection1 - 1);
		} else {
			System.err.println("Invalid input.");
		}
	}
}
