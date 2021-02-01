package com.skilldistillery.jets;
							
public abstract class Jet {
private String type;
private String model;	
private double speed;
private  int range;
private long price;

public Jet () {}

public Jet(String type,String model, double speed, int range, long price) {
this.type = type;
this.model = model;
this.speed = speed;
this.range = range;
this.price = price;
}
public void fly() {
	System.out.println("[" + this.model + "] HOURS FLOWN: " + flightTime(speed,range) + "SPEED:MACH:[" + getSpeedInMach(speed) + "]");
}
public double flightTime(double speed, int range) {
	//D=ST Distance = Speed * Time
	return (range / speed);
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public double getSpeed() {
	return speed;
}
public void setSpeed(double speed) {
	this.speed = speed;
}
public int getRange() {
	return range;
}
public void setRange(int range) {
	this.range = range;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}	
public double getSpeedInMach(double speed) {
	return speed /767.269;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((model == null) ? 0 : model.hashCode());
	result = prime * result + (int) (price ^ (price >>> 32));
	result = prime * result + range;
	long temp;
	temp = Double.doubleToLongBits(speed);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Jet other = (Jet) obj;
	if (model == null) {
		if (other.model != null)
			return false;
	} else if (!model.equals(other.model))
		return false;
	if (price != other.price)
		return false;
	if (range != other.range)
		return false;
	if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Jet-[TYPE:");
	builder.append(type);
	builder.append("]-[MODEL:");
	builder.append(model);
	builder.append("]-[SPEED:");
	builder.append(speed);
	builder.append("MPH]-[RANGE:");
	builder.append(range);
	builder.append("MI.]-[PRICE:$");
	builder.append(price);
	builder.append("]");
	return builder.toString();
}
}