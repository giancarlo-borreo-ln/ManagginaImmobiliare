package controller;

import java.util.ArrayList;

public class EsempioForEach
{
	public static void main(String[] args)
	{
		ArrayList<String> testi = new ArrayList<>();
		testi.add("ciao sono un testo");
		testi.add("anche io");
		testi.add("io sono il terzo");

		for(int i=0;i<testi.size();i+=2)             //for(String s : testi)
		{											//
			String s = testi.get(i);				//equivale a queste 3 righe
			System.out.println(s);
		}

		//scorri ogni elemento iesimo all'interno della lista 'testi'
		//chiamandolo s
		for(String s : testi)
		{
			System.out.println(s);
			//non posso assolutamente aggiungere o rimuovere elementi
			//dalla collezione che sto for-eachando
			//NO MAI testi.add("ciao");
		}


	}
}
