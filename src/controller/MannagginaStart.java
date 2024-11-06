package controller;

import helpers.DbHelper;
import model.Apartment;
import model.Condominium;
import model.Tenant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MannagginaStart
{
	static Scanner sc = new Scanner(System.in);
	static DbHelper dbh = new DbHelper("mannaginaimmobiliare");


	public static void main(String[] args) throws SQLException
	{
		String cmd = "";

		do
		{
			System.out.println("Enter command: ");
			cmd = sc.nextLine();

			switch (cmd)
			{
				case "1":
					readTenantsWithAddressesORM();
				break;
				case "2":
					readTenantsWithAddressesNonORM();
					break;
				case "3":
					readTenantsFirstCondominiumNonORM();
					break;
				case "4":
					//readTenantsFirstCondominiumORM();
					break;
				case "quit":
					System.out.println("Goodbye!");
				break;
				default:
					System.out.println("Invalid command");

			}

		}while(!cmd.equals("quit"));
	}

	private static void readTenantsFirstCondominiumNonORM() throws SQLException
	{

		ResultSet rs = dbh.executeSelect("SELECT name,surname,number FROM tenant " +
												"JOIN apartment ON tenant.apartment_id=apartment.id " +
				"								WHERE condominium_id=1");

		while(rs.next())
		{
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String number = rs.getString("number");
			int floor = Integer.parseInt(number.substring(0,number.length()-1));

			System.out.println(name + " " + surname + " vive al piano: " + floor);
		}
	}

	private static void readTenantsFirstCondominiumORM() throws SQLException
	{
		ArrayList<Tenant> tenants = readTenantsFromDb();
		for(Tenant t : tenants)
		{
			if(t.getApartment().getCondominium_id()==1)
				System.out.println(t.getName()+" "+t.getSurname()+" abita in "+t.getApartment().getFloorNumber());
		}
	}



	private static void readTenantsWithAddressesORM() throws SQLException
	{
		ArrayList<Tenant> tenants = readTenantsFromDb();
		for(Tenant t : tenants)
			System.out.println(t.getName()+" "+t.getSurname()+" abita in "+t.getApartment().getCondominium().getAddress());
	}

	private static void readTenantsWithAddressesNonORM() throws SQLException
	{

		ResultSet rs = dbh.executeSelect("SELECT name,surname,address" +
				" FROM tenant" +
				" JOIN apartment   ON tenant.apartment_id      = apartment.id" +
				" JOIN condominium ON apartment.condominium_id = condominium.id;");

		while(rs.next())
		{
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String address = rs.getString("address");

			System.out.println(name + " " + surname + " vive in: " + address);
		}
	}

	private static ArrayList<Tenant> readTenantsFromDb() throws SQLException
	{
		//1 leggo i NONNI (condomini) e li salvo in una lista
		HashMap<Integer,Condominium> mappaCondomini = new HashMap<>();
		ResultSet rsCon = dbh.executeSelect("SELECT * FROM condominium");


		while(rsCon.next())
		{
			Condominium trasformatoConOrm = new Condominium(rsCon);
			mappaCondomini.put(trasformatoConOrm.getId(),trasformatoConOrm);
		}

		HashMap<Integer, Apartment> mappaAppartamenti = new HashMap<>();
		String generataMetodoClasse = Apartment.generaSelect();
		ResultSet rsApt = dbh.executeSelect(generataMetodoClasse);

		while (rsApt.next())
		{
			Apartment trasformatoApartment = new Apartment(rsApt);
			int chiaveEsternaVersoCondominio = trasformatoApartment.getCondominium_id();
			Condominium padre = mappaCondomini.get(chiaveEsternaVersoCondominio);
			trasformatoApartment.setCondominium(padre);

			mappaAppartamenti.put(trasformatoApartment.getId(),trasformatoApartment);
		}

		ArrayList<Tenant> tenants = new ArrayList<>();
		ResultSet rsTen = dbh.executeSelect("SELECT * FROM tenant");

		while(rsTen.next())
		{
			Tenant t = new Tenant(rsTen);
			int fkT = t.getApartment_id();
			Apartment padre = mappaAppartamenti.get(fkT);
			t.setApartment(padre);

			tenants.add(t);
		}

		return tenants;

	}
}
