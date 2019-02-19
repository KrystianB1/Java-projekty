package Hurtownia;

public interface baza_klient_interfejs { // interfejs dla bazy faktury

	public void dodaj_osoba_fizyczna(String numer, Osoba_fizyczna osoba_fizyczna);

	public void dodaj_osoba_prawna(String numer, Osoba_prawna osoba_prawna);

	public void wyswietl_osoby_prawne();

	public void wyswietl_osoby_fizycznee();

	public Osoba_fizyczna szukaj_po_osobie_fizyczna(String id);

	public Osoba_prawna szukaj_po_osoba_prawna(String id);
}
