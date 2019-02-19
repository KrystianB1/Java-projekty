package Hurtownia;

public class Klient implements Wyswietl { // klasa po ktorej dziedziczy osoba prawna i fizyczna

	private String nazwa;
	private String adres;
	private String telefon;
	private String rabat_procentowy;

	public Klient(String nazwa, String adres, String telefon, String rabat_procentowy) {
		this.nazwa = nazwa;
		this.adres = adres;
		this.telefon = telefon;
		this.rabat_procentowy = rabat_procentowy;
	}

	public String getNazwa() {
		return nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public String getRabat_procentowy() {
		return rabat_procentowy;
	}

	@Override
	public String wyswietl() {
		// TODO Auto-generated method stub
		return "Klient [nazwa=" + nazwa + ", adres=" + adres + ", telefon=" + telefon + ", rabat_procentowy="
				+ rabat_procentowy + "]";
	}

}
