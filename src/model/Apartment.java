package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Apartment {
    //VERBOTEN
    private int id;
    //Numero + lettera, numero indica piano e lettera è A o B
    private String number;
    private double area;
    //Relazione verso padre condominio
    private Condominium condominium;
    private int condominium_id;
    //Relazione verso figlio unico garage
    private Garage garage;
    //Relazione verso i figli tenants che saranno gli inquillini
    private ArrayList<Tenant> tenants = new ArrayList<>();

    public Apartment(ResultSet row) throws SQLException
	{
        id = row.getInt("id");
        number = row.getString("number");
        area = row.getDouble("area");
        condominium_id = row.getInt("condominium_id");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id<1)
            throw new RuntimeException();

        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String lettera = number.substring(number.length()-1);
        int numero = Integer.parseInt(number.substring(0, number.length()-1));
        if((!lettera.equals("A") && !lettera.equals("B")) || numero < 1 || numero > condominium.getFloors())
            throw new RuntimeException();
        this.number = number;
    }

    public int getFloorNumber()
    {
        return Integer.parseInt(number.substring(0,number.length()-1));
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if(area<0)
            throw new RuntimeException();

        this.area = area;
    }

    public Condominium getCondominium() {
        return condominium;
    }

    public void setCondominium(Condominium condominium) {
        if(condominium==null)
            throw new RuntimeException();
        this.condominium = condominium;
        condominium.addApartment(this);
        condominium_id = condominium.getId();

    }

    public int getCondominium_id() {
        return condominium_id;
    }

    public void setCondominium_id(int condominium_id) {
        if(condominium_id<1)
            throw new RuntimeException();
        this.condominium_id = condominium_id;
    }

    public ArrayList<Tenant> getTenants() {
        return tenants;
    }


    public void addTenants(Tenant tenant) {
        tenants.add(tenant);
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        if(garage==null)
            throw new RuntimeException();
        this.garage = garage;
    }
}
