package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}
	@Override
	public void fight() {
		System.out.println("ALL SYSTEMS READY, FIRE AWAY!");
	}
}