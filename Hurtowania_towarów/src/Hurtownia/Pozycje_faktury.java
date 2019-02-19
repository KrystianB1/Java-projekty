package Hurtownia;

public class Pozycje_faktury implements Wyswietl {

	private int numer_porzadkowy; // Każda pozycja faktury jest opisana atrybutami:
	private String produkt; // numer porządkowy, produkt, jednostka miary, ilość, cena netto (jedn.),
							// cena
							// brutto (jedn.), wartość netto, wartość brutto.
	private String jednostka_miar;
	private int ilosc;
	private double cena_netto;
	private double cena_brutto;
	private double wartosc_netto;
	private double wartosc_brutto;

	public Pozycje_faktury(int numer_porzadkowy, String produkt, String jednostka_miar, int ilosc, double cena_netto,
			double cena_brutto, double wartosc_netto, double wartosc_brutto) {
		this.numer_porzadkowy = numer_porzadkowy;
		this.produkt = produkt;
		this.jednostka_miar = jednostka_miar;
		this.ilosc = ilosc;
		this.cena_netto = cena_netto;
		this.cena_brutto = cena_brutto;
		this.wartosc_netto = wartosc_netto;
		this.wartosc_brutto = wartosc_brutto;
	}

	public int getNumer_porzadkowy() {
		return numer_porzadkowy;
	}

	public String getProdukt() {
		return produkt;
	}

	public String getJednostka_miar() {
		return jednostka_miar;
	}

	public int getIlosc() {
		return ilosc;
	}

	public double getCena_netto() {
		return cena_netto;
	}

	public double getCena_brutto() {
		return cena_brutto;
	}

	public double getWartosc_netto() {
		return wartosc_netto;
	}

	public double getWartosc_brutto() {
		return wartosc_brutto;
	}

	@Override
	public String wyswietl() {

		return "Pozycje_faktury{" + "numer_porzadkowy=" + numer_porzadkowy + ", produkt=" + produkt
				+ ", jednostka_miar=" + jednostka_miar + ", ilosc=" + ilosc + ", cena_netto=" + cena_netto + ","
				+ " cena_brutto=" + cena_brutto + ", wartosc_netto=" + wartosc_netto + ", wartosc_brutto="
				+ wartosc_brutto + '}';
	}

}
