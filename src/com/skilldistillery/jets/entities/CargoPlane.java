package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	
	
	public CargoPlane() {
		super();
		
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + " is loading its cargo. ");
		
	}
	
	

}
