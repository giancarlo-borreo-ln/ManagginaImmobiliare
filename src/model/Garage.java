package model;

public class Garage
{
	//VERBOTEN
	private int id;
	//Numero + lettera, numero indica piano e lettera è A o B
	private int number;
	private double size;
	private double cost;
	//Relazione verso padre appartamento
	private Apartment apartment;
	private int apartment_id;

	public double getCost() {return cost;}

	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id)
	{
		if(id<1)
			throw new RuntimeException();

		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if(number<0)
			throw new RuntimeException();

		this.number = number;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		if(size<0)
			throw new RuntimeException();

		this.size = size;
	}

	public Apartment getApartment()
	{
		return apartment;
	}

	public void setApartment(Apartment apartment)
	{
		if(apartment==null)
			throw new RuntimeException();
		this.apartment = apartment;
		apartment.setGarage(this);
		apartment_id = apartment.getId();
	}

	public int getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(int apartmet_id)
	{
		if(apartmet_id<1)
			throw new RuntimeException();
		this.apartment_id = apartmet_id;
	}

}//CLOSE CLASS GARAGE