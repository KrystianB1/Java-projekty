package Hurtownia;

public class Osoba_prawna extends Klient { // dziedziczenie po klasie Klient

	private String REGION;
	private String NIP;

	public Osoba_prawna(String nazwa, String adres, String telefon, String rabat_procentowy, String REGION,
			String NIP) {
		super(nazwa, adres, telefon, rabat_procentowy);
		this.REGION = REGION;
		this.NIP = NIP;
	}

	public String getREGION() {
		return REGION;
	}

	public String getNIP() {
		return NIP;
	}

}
