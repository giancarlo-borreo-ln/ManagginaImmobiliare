package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tenant extends Person
{
	//VERBOTEN
	private int id;

	//Relazione verso padre appartamento
	private Apartment apartment;
	private int apartment_id;

	public Tenant(){}

	public Tenant(ResultSet row) throws SQLException
	{
		this.id = row.getInt("id");
		this.name = row.getString("name");
		this.surname = row.getString("surname");
		this.age = row.getInt("age");
		this.gender = row.getString("gender");
		this.apartment_id = row.getInt("apartment_id");
	}

	//ID
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		if (id < 1)
			throw new RuntimeException();

		this.id = id;
	}



	public Apartment getApartment()
	{
		return apartment;
	}

	public void setApartment(Apartment apartment)
	{
		if (apartment == null)
			throw new RuntimeException();
		this.apartment = apartment;
		apartment.addTenants(this);
		apartment_id = apartment.getId();
	}

	public int getApartment_id()
	{
		return apartment_id;
	}

	public void setApartment_id(int apartmet_id)
	{
		if (apartmet_id < 1)
			throw new RuntimeException();
		this.apartment_id = apartmet_id;
	}

	public String toString()
	{
		return 	super.toString()+"\n" +
				"apartment_id:"+apartment_id;

	}

}//CLOSE TENANT CLASS