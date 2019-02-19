package Hurtownia;

import java.util.HashSet;
import java.util.Set;

public class Dostawcy implements Wyswietl {

	private Set<Produkt> produkty = new HashSet<Produkt>(); // użyta kolekcja set aby nie duplikować produktów

	private String nazwa;
	private String adres;
	private String telefon;
	private String osoba_kontaktowa;

	public Produkt znajdz(String nazwa) { // metoda zwraca obiekt produkt po przyjmujac parametr nazwa
		for (Produkt produkt : produkty)
			if (produkt.getNazwa().equals(nazwa))
				return produkt;
		return null;

	}

	public Set<Produkt> getProdukty() {
		return produkty;
	}

	public void setProdukty(Set<Produkt> produkty) {
		this.produkty = produkty;
	}

	public void save(Produkt produkt) {
		produkty.add(produkt);
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getOsoba_kontaktowa() {
		return osoba_kontaktowa;
	}

	public void setOsoba_kontaktowa(String osoba_kontaktowa) {
		this.osoba_kontaktowa = osoba_kontaktowa;
	}

	@Override
	public String wyswietl() {
		return "NAZWA DOSTAWCY";
	}

}
