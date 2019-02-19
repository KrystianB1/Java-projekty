package Hurtownia;

public class Osoba_fizyczna extends Klient { // dziedziczenie po klasie Klient
	private String numer_pesel;

	public Osoba_fizyczna(String nazwa, String adres, String telefon, String rabat_procentowy, String numer_pesel) {
		super(nazwa, adres, telefon, rabat_procentowy); // odwołanie do zmiennych w klasie Klient
		this.numer_pesel = numer_pesel;
	}

	public String getNumer_pesel() {
		return numer_pesel;
	}

}
