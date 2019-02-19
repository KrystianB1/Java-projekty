package Hurtownia;

import java.util.HashMap;
import java.util.Map;

public class Baza_Klientow implements baza_klient_interfejs {

	private HashMap<String, Osoba_fizyczna> osoby_fizyczne_kolekcja = new HashMap<String, Osoba_fizyczna>();// kolekcja
																											// dla osób
																											// fizycznych

	private HashMap<String, Osoba_prawna> osoby_prawne_kolekcja = new HashMap<String, Osoba_prawna>();// kolekcja dla
																										// osób
																										// prawnych

	public void dodaj_osoba_prawna(String numer, Osoba_prawna osoba_prawna) {
		osoby_prawne_kolekcja.put(numer, osoba_prawna); // dodawanie osob prawnych do kolekcji

	}

	public void dodaj_osoba_fizyczna(String numer, Osoba_fizyczna osoba_fizyczna) {
		osoby_fizyczne_kolekcja.put(numer, osoba_fizyczna);// dodawanie osob fizycznych do kolekcji

	}

	public void wyswietl_osoby_prawne() {// wyświetlanie osob prawnych
		System.out.println("=========================");
		System.out.println("OSOBY PRAWNE :");
		System.out.println("=========================");
		for (Map.Entry<String, Osoba_prawna> entry : osoby_prawne_kolekcja.entrySet()) {
			System.out.println("\t---------------------");
			System.out.println("ID : "+entry.getKey());
			Osoba_prawna osoba = entry.getValue();
			System.out.println("\n\t NAZWA: " + osoba.getNazwa() + "\n\t ADRES: " + osoba.getAdres() + "\n\t RABAT "
					+ osoba.getRabat_procentowy() + "\n\t TELEFON: " + osoba.getTelefon() + "\2n\t NIP: " + osoba.getNIP()
					+ "\n\t REGON: " + osoba.getREGION());

		}
	}

	public void wyswietl_osoby_fizycznee() {// wyświetlanie osob fizycznych
		System.out.println("=========================");
		System.out.println("OSOBY FIZYCZNE :");
		System.out.println("=========================");
		for (Map.Entry<String, Osoba_fizyczna> entry : osoby_fizyczne_kolekcja.entrySet()) {
			System.out.println("\t---------------------");
			System.out.println("ID : "+entry.getKey());
			Osoba_fizyczna osoba = entry.getValue();
			System.out.println("\n\t NAZWA: " + osoba.getNazwa() + "\n\t ADRES: " + osoba.getAdres() + "\n\t NUMER_PESEL: "
					+ osoba.getNumer_pesel() + "\n\t RABAT: " + osoba.getRabat_procentowy() + " %" + "\n\t TELEFON: "
					+ osoba.getTelefon());

		}
	}

	public Osoba_fizyczna szukaj_po_osobie_fizyczna(String id)// metoda przyjmuje parametr id i zwraca obiekt osoba
																// fizyczna

	{
		for (Map.Entry<String, Osoba_fizyczna> entry : osoby_fizyczne_kolekcja.entrySet()) {
			if (entry.getKey().equals(id)) {
				Osoba_fizyczna osoba = entry.getValue();
				return osoba;
			}
		}
		return null;
	}

	public Osoba_prawna szukaj_po_osoba_prawna(String id) {// metoda przyjmuje parametr id i zwraca obiekt osoba prawna

		for (Map.Entry<String, Osoba_prawna> entry : osoby_prawne_kolekcja.entrySet()) {
			if (entry.getKey().equals(id)) {
				Osoba_prawna osoba = entry.getValue();
				return osoba;
			}
		}
		return null;

	}
}
