package model;

public class Person
{
	String name;
	String surname;
	int age;
	String gender;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if (name == null || name.isBlank())
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
		if (surname == null || surname.isBlank())
			throw new RuntimeException();
		this.surname = surname;
	}


	//AGE
	public int getAge()
	{
		return age;
	}


	/**
	 * valori di unita consentiti: anni /  mesi
	 * @param age
	 * @param unita
	 */
	public void setAge(int age,String unita)
	{
		//anni
		//mesi
		switch (unita)
		{
			case "anni":
				this.age = age;
			break;
			case "mesi":
				this.age = age / 12;
			break;
			default:
				throw new RuntimeException();
		}
	}

	/**
	 * age in anni
	 * @param age
	 */
	public void setAge(int age)
	{
		if (age < 0)
			throw new RuntimeException();

		this.age = age;
	}

	/**
	 * data di nascita in formato eu
	 * @param dataNascita
	 */
	public void setAge(String dataNascita)
	{
		//0   1  2
		//27/08/1995
		String[] dataSplittata = dataNascita.split("/");

		if(dataSplittata.length != 3)
			throw new RuntimeException();

		int year = Integer.parseInt(dataSplittata[2]);

		this.age = 2024-year;
	}

	//GENDER
	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		if (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("other")))
			throw new RuntimeException();

		this.gender = gender;
	}

	public String toString()
	{
		return 	"name: "+name+"\n"+
				"surname: "+surname+"\n"+
				"gender: "+gender+"\n"+
				"age: "+age;
	}














}
