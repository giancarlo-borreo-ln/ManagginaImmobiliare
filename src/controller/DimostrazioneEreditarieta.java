package controller;

import model.Electrician;
import model.Tenant;

public class DimostrazioneEreditarieta
{
	public static void main(String[] args)
	{
		Electrician e = new Electrician();
		e.setName("Caarlo");
		e.setSurname("Rubinetti");
		e.setAge("27/08/1993");
		e.setGender("M");
		e.setPhone("3898272664");
		e.setYearsOfExperience(5);

		Tenant t = new Tenant();
		t.setName("Ginetto");
		t.setSurname("Rubinetti");
		t.setAge(380,"mesi");
		t.setGender("M");
		t.setApartment_id(2);

		System.out.println(e.toString()+"\n\n");
		System.out.println(t.toString());
	}
}
