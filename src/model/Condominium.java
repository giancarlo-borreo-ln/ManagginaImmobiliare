package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Condominium
{
	private static final String[] VALID_ENERGY_VALUES = {"A","B","C","D"};


	private int id;
	private String address;
	private int floors;
	private String energyEfficencyClass;
	private double smp;
	private double fixedCost;
	//Relazione verso i figli tenants che saranno gli inquillini
	private ArrayList<Apartment> apartments = new ArrayList<>();

	public Condominium(ResultSet row) throws SQLException
	{
		id = row.getInt("id");
		address = row.getString("address");
		floors = row.getInt("floors");
		smp = row.getDouble("smp");
		energyEfficencyClass = row.getString("energyEfficencyClass");
		fixedCost = row.getDouble("fixedCost");
	}


	//ID
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		if(id<1)
			throw new RuntimeException();

		this.id = id;
	}

	//SQUARE METERS PRICE
	public double getSMP() {return smp;}

	public void setSMP(double smp)
	{
		if(smp<0)
			throw new RuntimeException();

		this.smp = smp;
	}

	//ADDRESS
	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		if(address==null||address.isBlank())
			throw new RuntimeException();

		this.address = address;
	}

	//FIXED COST
	public double getFixedCost() {return fixedCost;}

	public void setFixedCost(double fixedCost)
	{
		if(fixedCost<0)
			throw new RuntimeException();

		this.fixedCost = fixedCost;
	}


	//ENERGY CLASS
	public String getEnergyEfficencyClass() {return energyEfficencyClass;}

	public void setEnergyEfficencyClass(String energyEfficencyClass)
	{
		boolean isValid = false;
		for(String v: VALID_ENERGY_VALUES)
			if(v.equals(energyEfficencyClass))
				isValid = true;

		if(!isValid)
			throw new RuntimeException();

		this.energyEfficencyClass = energyEfficencyClass;
	}

	//FLOORS
	public int getFloors()
	{
		return floors;
	}

	public void setFloors(int floors)
	{
		if(floors<0)
			throw new RuntimeException();

		this.floors = floors;
	}

	public ArrayList<Apartment> getApartments()
	{
		return apartments;
	}
	public void addApartment(Apartment apartment)
	{
		apartments.add(apartment);
	}

	public double getSmp()
	{
		return smp;
	}

	public void setSmp(double smp)
	{
		this.smp = smp;
	}


}