package Hurtownia;

import java.util.ArrayList;
import java.util.List;

public class Faktura implements Faktury_interface, Wyswietl {

	private int numer;
	private String miejscowosc;
	private String data_sprzedazy;
	private String data_wystawienia;
	private String sprzedawca;
	private String nabywca;
	private double kwota;
	private String sposob_platnosci;

	private List<Pozycje_faktury> pozycje_faktury = new ArrayList<Pozycje_faktury>(); // lista pozycji w fakturze

	public Faktura(int numer, String miejscowosc, String data_sprzedazy, String data_wystawienia, String sprzedawca,
			String nabywca, String sposob_platnosci) {
		super();
		this.numer = numer;
		this.miejscowosc = miejscowosc;
		this.data_sprzedazy = data_sprzedazy;
		this.data_wystawienia = data_wystawienia;
		this.sprzedawca = sprzedawca;
		this.nabywca = nabywca;
		this.sposob_platnosci = sposob_platnosci;

	}

	public void wyswietlanie_pozycji_faktury() { // metoda wyĹ›wietla pozycje dnaje faktury
		for (Pozycje_faktury pozycje_faktury2 : pozycje_faktury) {
			System.out.println("---------------------------------");
			System.out.println(pozycje_faktury2.getNumer_porzadkowy() + " \t ID Produktu: " + pozycje_faktury2.getProdukt()
					+ "\t Jednostka miar: " + pozycje_faktury2.getJednostka_miar() 
					+ "\t Ilosc: "+ pozycje_faktury2.getIlosc() 
					+ "\n\t Cena szt netto : "+ String.format("%.2f%n", pozycje_faktury2.getCena_netto()) 
					+ "\t Cenna szt brutto: "+ String.format("%.2f%n", pozycje_faktury2.getCena_brutto())
					+ "\t Wartość netto: "+ String.format("%.2f%n", pozycje_faktury2.getWartosc_netto())
					+ "\t Wartość brutto: "	+ String.format("%.2f%n", pozycje_faktury2.getWartosc_brutto()));

		}
	}

	public double suma_kosztow() { // metoda sumuje koszty produktĂłw
		Double suma = 0.00;
		for (Pozycje_faktury pozycje_faktury2 : pozycje_faktury) {
			suma = suma + pozycje_faktury2.getWartosc_brutto();
		}
		return suma;
	}

	public void save(Pozycje_faktury faktury) {// metoda zapisuje do faktury pozycje faktur
		pozycje_faktury.add(faktury);

	}

	public int getNumer() {
		return numer;
	}

	public String getNabywca() {
		return nabywca;
	}

	public String getData_sprzedazy() {
		return data_sprzedazy;
	}

	public String getData_wystawienia() {
		return data_wystawienia;
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public String getSprzedawca() {
		return sprzedawca;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public String getSposob_platnosci() {
		return sposob_platnosci;
	}

	public List<Pozycje_faktury> getPozycje_faktury() {
		return pozycje_faktury;
	}

	public void setPozycje_faktury(List<Pozycje_faktury> pozycje_faktury) {
		this.pozycje_faktury = pozycje_faktury;
	}

	@Override
	public String wyswietl() {
		return "Faktura{" + "numer=" + numer + ", miejscowosc=" + miejscowosc + ", data_sprzedazy=" + data_sprzedazy
				+ ", data_wystawienia=" + data_wystawienia + ", sprzedawca=" + sprzedawca + ", " + ", kwota=" + kwota
				+ ", sposob_platnosci=" + sposob_platnosci + ", pozycje_faktury=" + pozycje_faktury + '}';
	}

	@Override
	public void wyswietl_zawartosc() { // metoda wyĹ›wietlajaca Faktury
		System.out.println("======================================");
		System.out.println("		FAKTURA	NR : " + Faktura.this.numer);
		System.out.println("======================================");
		System.out.println("Dane do faktury :");
		System.out.println("MIEJSCOWOSC: " + Faktura.this.miejscowosc
				+ "\t DATA_SPRZEDAŻY: " + Faktura.this.data_sprzedazy + "\t DATA_WYSTAWIENIA: "
				+ Faktura.this.data_wystawienia + "\t SPRZEDAWCA: " + Faktura.this.sprzedawca + "\t\n NABYWCA: "
				+ Faktura.this.nabywca + "\t SUMA FAKTURY: " + String.format("\"%.2f%n\"", Faktura.this.kwota)
				+ "\t SPOSÓB_PŁATNOŚCI: " + Faktura.this.sposob_platnosci);

	}
}
