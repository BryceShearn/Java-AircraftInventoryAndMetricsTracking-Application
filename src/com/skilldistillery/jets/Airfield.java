package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Airfield {


//	Airfield run = new Airfield();
	//	run.airField();
	
	private void populatePlaneInfo() {
	ArrayList <String> populatePlaneInfo = new ArrayList<>();
	try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
		String line;
		while ((line = bufIn.readLine()) != null) {
			populatePlaneInfo.add(line);
		}
	} catch (IOException e) {
		System.err.println(e);
	} 		
	}

}	

	


//private Jets: Jet[]
//public AirField()


