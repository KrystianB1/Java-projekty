package Hurtownia;

import java.util.HashMap;
import java.util.Map;

public class Baza_faktur {
	private HashMap<String, Faktura> faktury = new HashMap<String, Faktura>();// kolekcja faktur

	public void save(String id, Faktura faktura) { // zapis faktur
		faktury.put(id, faktura);
	}

	public void wyswietl_faktury() {// wyswietlanie wszystkich faktur

		for (Map.Entry<String, Faktura> entry : faktury.entrySet()) {
			System.out.println(entry.getKey());
			Faktura faktura = entry.getValue();
			System.out.println(faktura.getNumer() + " " + faktura.getData_sprzedazy() + faktura.getData_wystawienia()
					+ faktura.getSprzedawca() + faktura.getNabywca() + faktura.getKwota()
					+ faktura.getSposob_platnosci());

		}
	}
}
