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
				case "quit":
					System.out.println("Goodbye!");
				break;
				default:
					System.out.println("Invalid command");

			}

		}while(!cmd.equals("quit"));
	}

	private static void readTenantsWithAddressesORM() throws SQLException
	{
		ArrayList<Tenant> tenants = readTenantsFromDb();
		for(int i=0;i<tenants.size();i++)
		{
			Tenant t = tenants.get(i);
			System.out.println(t.getName()+" "+t.getSurname()+" abita in "+t.getApartment().getCondominium().getAddress());
		}
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
		ResultSet rsApt = dbh.executeSelect("SELECT * FROM apartment");

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
			//creare costruttore in tenants
			//collegarlo ad appartemento come sopra
			//inserirlo nella lista

		}

		return tenants;

	}
}
