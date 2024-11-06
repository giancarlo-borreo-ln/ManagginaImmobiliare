package controller;

import java.util.HashMap;

public class EsempioMappe
{

	public static void main(String[] args)
	{
		HashMap<Integer,String> idToStringa = new HashMap<>();

		idToStringa.put(1,"ciao");
		idToStringa.put(7,"wilcommen");
		idToStringa.put(2,"hello");


		System.out.println(idToStringa.get(7));

		HashMap<String,String> stringToStringa = new HashMap<>();

		stringToStringa.put("hello","ciao");
		//"hello","ciao" -> Coppia CHIAVE-VALORE, nome formale ENTRY
		stringToStringa.put("hi","ciao");
		stringToStringa.put("bye","arrivederci");

		System.out.println(stringToStringa.get("hello"));
	}



















}
