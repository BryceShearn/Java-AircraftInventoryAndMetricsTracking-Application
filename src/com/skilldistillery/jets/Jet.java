package com.skilldistillery.jets;
							//	JetImpl,  extend this class
public abstract class Jet {
	//jet itself is an abstract based class.

	
private String model;	
private double speed;
private  int range;
private long price;

//	private model:String
//	private speed:Double
//	private range:int
//	private price:long
	
public Jet(String model, double speed, int range, long price) {
this.model = model;
this.speed = speed;
this.range = range;
this.price = price;
}	
	
	
	
	
	//Jet(String,double,int,long)  from Plane1
	//fly():void	<--when called to fly the jets?
	//getSpeedInMach():double <-----?

	
	
	
	//	all jets must have a model, speed, range , and price. 
// speed is in MPH BUT your jet can also output the speed in mach.
	
	//jets have  a fly() method that prints out the jet details and
// the amount of time the jet can fly until it runs out of fuel (based on speed and range).
//
	

	
	
	

}
