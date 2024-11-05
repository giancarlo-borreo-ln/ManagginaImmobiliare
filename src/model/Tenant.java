package model;

public class Tenant
{
	//VERBOTEN
	private int id;
	private String name;
	private String surname;
	private int age;
	private String gender;

	//Relazione verso padre appartamento
	private Apartment apartment;
	private int apartment_id;


	//ID
	public int getId() {return id;}

	public void setId(int id)
	{
		if(id<1)
			throw new RuntimeException();

		this.id = id;
	}

	//NAME
	public String getName() {return name;}

	public void setName(String name)
	{
		if(name==null||name.isBlank())
			throw new RuntimeException();
		this.name = name;
	}

	//SURNAME
	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		if(surname==null||surname.isBlank())
			throw new RuntimeException();
		this.surname = surname;
	}


	//AGE
	public int getAge() {return age;}

	public void setAge(int age)
	{
		if(age<0)
			throw new RuntimeException();

		this.age = age;
	}


	//GENDER
	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		if(!(gender.equalsIgnoreCase("m")||gender.equalsIgnoreCase("f")||gender.equalsIgnoreCase("other")))
			throw new RuntimeException();

		this.gender = gender;
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
		apartment.addTenants(this);
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

}//CLOSE TENANT CLASS