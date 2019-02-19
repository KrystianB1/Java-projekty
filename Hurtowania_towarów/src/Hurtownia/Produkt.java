package Hurtownia;

public class Produkt implements Wyswietl {

	private String nazwa; // Każdy produkt jest opisany za pomocą atrybutów:
	private String opis; // nazwa, opis, cena zakupu, cena sprzedaży (katalogowa), stawka VAT.
	private double cena_zakupu;
	private double cena_sprzedazy;
	private double stawka_Vat;

	public Produkt(String nazwa, String opis, double cena_zakupu, double cena_sprzedazy, double stawka_Vat) {
		this.nazwa = nazwa;
		this.opis = opis;
		this.cena_zakupu = cena_zakupu;
		this.cena_sprzedazy = cena_sprzedazy;
		this.stawka_Vat = stawka_Vat;
	}

	public String getNazwa() {
		return nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public double getCena_zakupu() {
		return cena_zakupu;
	}

	public double getCena_sprzedazy() {
		return cena_sprzedazy;
	}

	public double getStawka_Vat() {
		return stawka_Vat;
	}

	@Override
	public String wyswietl() {

		return "Produkt [nazwa=" + nazwa + ", opis=" + opis + ", cena_zakupu=" + cena_zakupu + ", cena_sprzedazy="
				+ cena_sprzedazy + ", stawka_Vat=" + stawka_Vat + "]";
	}

}
