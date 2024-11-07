package model;

public class Electrician extends Person
{

	private int id;
	private String phone;
	private int yearsOfExperience;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public int getYearsOfExperience()
	{
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience)
	{
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public String toString()
	{
		return 	super.toString()+"\n" +
				"phone:"+phone+"\n"+
				"yoe:"+yearsOfExperience;
	}


}
