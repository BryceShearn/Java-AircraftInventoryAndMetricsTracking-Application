package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {
	public CargoPlane(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}
	@Override
	public void loadCargo() {
	System.out.println("* LOADING CARGO PLANE *");
	System.out.println("PLEASE WAIT.. ");
	System.out.println("* PLANE LOADED SUCCESSFULLY*");
	}
}
