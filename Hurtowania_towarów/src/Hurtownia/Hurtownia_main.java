package Hurtownia;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hurtownia_main {

	private static HashMap<String, Dostawcy> dostawcy_kolekcja = new HashMap<String, Dostawcy>();// baza dostawców

	public static Produkt produkt; // pole Produkt
	public static int szt = 0; // zmienna pomocnicza dla ustawienia ilości sztuk produktu ( wykorzystana do
								// celów pokazowych działania programu)
	public static String id_klient = null; // zmienna pomocnicza ustawiająca id klienta dla którego jest wygenerowana
											// faktura ( wykorzystana do celów pokazowych działania programu)
	public static String produkt_nazwa = ""; // zmienna pomocnicza dla nazwy produktu ( wykorzystana do celów
												// pokazowych
												// działania programu)
	public static Produkt produkt_1; // pole Produkt
	public static Dostawcy dostawca = new Dostawcy(); // obiekt Dostawcy
	public static Dostawcy dostawca1 = new Dostawcy();// obiekt Dostawcy
	public static Osoba_fizyczna osoba_fizyczna; // obiekt osoba fizyczna
	public static Osoba_prawna osoba_prawna;// obiekt osoba prawna
	public static Pozycje_faktury pozycje_faktury; // obiekt pozycje faktury
	public static Pozycje_faktury pozycje_faktury1;// obiekt pozycje faktury
	public static Baza_faktur baza_faktur = new Baza_faktur(); // baza faktur
	public static Baza_Klientow baza_Klientow = new Baza_Klientow(); // baza klientów

	public static void main(String[] args) {

		stworz_dostawce_i_produkt();// Tworzony jest produkty oraz dostawcy dla hurtowni
		dodaj_osoba_fizyczna(); // tworzone są przykładowe osoby fizyczne(Klient)
		dodaj_osoby_prawne();// tworzone są przykładowe osoby prawne(Klient)
		menu(); // wyswietlane menu
	}

	public static void dodaj_osoby_prawne() {

		osoba_prawna = new Osoba_prawna("Lotos", "Kolejkowa 34  Warszawa", "345123432", "3", "23511332857188", "123-456-32-18");
		baza_Klientow.dodaj_osoba_prawna("4", osoba_prawna);
		osoba_prawna = new Osoba_prawna("Sklep-narzedzia MARIO", "Mazurowa 23  Warszawa", "345123432", "3", "13544332857186",
				"715-18-01-126");
		baza_Klientow.dodaj_osoba_prawna("5", osoba_prawna);

	}

	public static void dodaj_osoba_fizyczna() {

		osoba_fizyczna = new Osoba_fizyczna("Marek ", "Polowa 2  Warszawa", "678098456 ", "10", "91091386283 ");
		baza_Klientow.dodaj_osoba_fizyczna("1", osoba_fizyczna);
		osoba_fizyczna = new Osoba_fizyczna("Jacek ", "Opalowa 2  Warszawa ", "456789345 ", "4", "71051386283 ");
		baza_Klientow.dodaj_osoba_fizyczna("2", osoba_fizyczna);
		osoba_fizyczna = new Osoba_fizyczna("Krystian ", "Dworcowa 3  Warszawa ", "888068456 ", "3 ", "96091386283 ");
		baza_Klientow.dodaj_osoba_fizyczna("3", osoba_fizyczna);

	}

	public static void stworz_dostawce_i_produkt() {

		produkt = new Produkt("Kalfior", "Polska", 23.5, 30.0, 1.23);
		dostawca.save(produkt);
		produkt = new Produkt("Pomarancza", "Hiszpania", 20.5, 35.0, 1.23);
		dostawca.save(produkt);
		produkt = new Produkt("Pomidor", "Polska", 13.5, 34.0, 1.23);
		dostawca.save(produkt);
		produkt = new Produkt("Ogorek", "Polska", 21.5, 38.0, 1.23);
		dostawca.save(produkt);

		dostawca.setNazwa("Levitane ,");
		dostawca.setAdres("Ogrodowa 1 , Warszawa");
		dostawca.setOsoba_kontaktowa("Marek Siwiec ,");
		dostawca.setTelefon("798765434 ,");
		dostawcy_kolekcja.put("1 ", dostawca);

		produkt_1 = new Produkt("Opona", "Samochodowa", 100.5, 155.0, 1.23);
		dostawca1.save(produkt_1);
		produkt_1 = new Produkt("Kolo", "Rowerowe", 130.5, 160.0, 1.23);
		dostawca1.save(produkt_1);

		dostawca1.setNazwa("Oponki.pl ,");
		dostawca1.setAdres("Kaliskiego 23, Warszawa ");
		dostawca1.setOsoba_kontaktowa("Mariusz Kowalski ,");
		dostawca1.setTelefon("345678098 ,");
		dostawcy_kolekcja.put("2", dostawca1);

	}

	private static void wyswietl_zawartosc_Hurtowni() {

		System.out.println("ZAWARTOSC HURTOWNI");
		System.out.println("-------------------");
		for (Map.Entry<String, Dostawcy> entry : dostawcy_kolekcja.entrySet()) {
			System.out.println("----------");
			System.out.println("ID:" +entry.getKey());
			Dostawcy dostawcy_obiekt = entry.getValue();
			System.out.println(dostawca.wyswietl() + " :" + dostawcy_obiekt.getNazwa() + "\n\t ADRES: "
					+ dostawcy_obiekt.getAdres() + " \n\t OSOBA: " + dostawcy_obiekt.getOsoba_kontaktowa() + "\n\t TELEFON: "
					+ dostawcy_obiekt.getTelefon());// dostawcy
			System.out.println("\n Lista towarów : ");
			dostawcy_obiekt.getProdukty().stream()
					.forEach(s -> System.out.println( "\n\t NAZWA TOWARU: "+s.getNazwa() + " " + s.getOpis() + "\n\t BARCODE: "+s.hashCode()+ "\n\t CENA ZAKUPU: "
							+ s.getCena_zakupu() + " zł" + "\n\t CENA SPRZEDAŻY: " + s.getCena_sprzedazy() + "zł")); // Wyświetla
			// zawartosc
			// Hurtowni
			System.out.println("----------");
		}
		System.out.println("-------------------");
	}

	private static void menu() {
		int wybor;
		Scanner odczyt = new Scanner(System.in);

		System.out.println("\n Witaj w Hurtowni Towarów\n");
		System.out.println("Wybierz:\n" + "1 Wyswietl zawartosc Hurtowni\n" + "2 Wyswietl Klientow\n"
				+ "3 Wyswietl wszystkie faktury\n" + "4 Zakoncz działanie programu\n\r");

		wybor = odczyt.nextInt();// zczytywanie z klawiatury znaków
		if (wybor == 1) {
			
			wyswietl_zawartosc_Hurtowni();// wyswietla zawartośc hurtowni(dostawcy i produkty)
			
			menu();
		} else if (wybor == 2) {

			baza_Klientow.wyswietl_osoby_prawne();// wyswietlanie Klientów (osoby prawne)
			baza_Klientow.wyswietl_osoby_fizycznee();// wyswietlanie Klientów (osoby fizyczne)
			menu();
		} else if (wybor == 3) {
			wystaw_fakture();
			menu();
		} else if (wybor == 4) {
			System.out.println("Do zobaczenia!");
			odczyt.close();
			System.exit(0); // zamykanie programu System.out.print("\f");
		} else {
			System.err.println("Błędnie wprowadzone dane!");
			menu();
		}

	}

	private static Double rabat_klienta(String rabat) {
		Double r = Double.parseDouble(rabat);
		return r; // zwraca rabat dla klienta
	}

	private static double cena_netto_osoba_fizyczna(double rabat) {
		Double suma_szt_i_ceny_netto = dostawca.znajdz(produkt_nazwa).getCena_sprzedazy();
		Double roznica = rabat / 100;
		Double procent = roznica * suma_szt_i_ceny_netto;
		return suma_szt_i_ceny_netto - procent; // zwraca cene netto dla osoby fizycznej
	}

	private static double cena_netto_prawna(double rabaty) {
		Double suma = dostawca1.znajdz(produkt_nazwa).getCena_sprzedazy();
		Double roznica = rabaty / 100;
		Double procent = roznica * suma;
		return suma - procent; // zwraca cene netto dla osob prawnych
	}

	private static double wartosc_netto(int szt, double cena_netto) {
		return szt * cena_netto; // zwraca wartosc netto

	}

	private static double wartosc_brutto(int szt, double cena_brutto) {
		return szt * cena_brutto; // zwraca wartosc brutto
	}

	private static double cena_brutto(double cena_netto) {
		return cena_netto * dostawca.znajdz(produkt_nazwa).getStawka_Vat(); // zwraca cene brutto na osoby fizycznej
	}

	private static double cena_brutto_prawna(double cena_netto) {
		return cena_netto * dostawca1.znajdz(produkt_nazwa).getStawka_Vat(); // zwraca cene brutto dla osoby prawnej
	}

	public static void wystaw_fakture() {

		id_klient = "1"; // FAKTURA dla klienta o ID 1
		Faktura faktura = new Faktura(1, "Polesie", "2019-03-09", "2019-03-09", "Juzek",
				" \nNAZWA KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getNazwa()+
				 " \nADRES KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getAdres()+
				 " \n RABAT KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()+"% "+
				" \nTELEFON "+ baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getTelefon()+
				" \nPESEL "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getNumer_pesel(), "Karta");
		baza_faktur.save("1", faktura); // zapisuje fakture

		produkt_nazwa = "Pomidor"; // Klient kupuje produkt pomidor
		pozycje_faktury = new Pozycje_faktury(1, dostawca.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 1,
				cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())) // cena
																													// netto
																													// produktu
				, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // cena
																													// brutto
																													// produktu
				, wartosc_netto(szt, cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // wartosc
																													// netto
																													// produktu
				, wartosc_brutto(szt, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))))); // wartosc
																														// brutto
																														// produktu
		faktura.save(pozycje_faktury); // produkt dodany do faktury

		produkt_nazwa = "Pomarancza"; // klient kupuje produkt pomarancza
		pozycje_faktury = new Pozycje_faktury(2, dostawca.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 3,
				cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())) // cena
																													// netto
																													// produktu
				,
				cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))),
				wartosc_netto(szt, cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // wartosc
																													// netto
																													// produktu
				, wartosc_brutto(szt, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())))));// wartosc
																													// brutto
																													// produktu
		faktura.save(pozycje_faktury); // produkt dodany do faktury

		produkt_nazwa = "Kalfior"; // klient kupuje produkt kalafior
		pozycje_faktury = new Pozycje_faktury(3, dostawca.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 3,
				cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())) // cena
																													// netto
																													// produktu
				,
				cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))),
				wartosc_netto(szt, cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // wartosc
																													// netto
																													// produktu
				, wartosc_brutto(szt, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())))));// wartosc
																													// brutto
																													// produktu
		faktura.save(pozycje_faktury); // produkt dodany do faktury
		faktura.setKwota(faktura.suma_kosztow()); // suma kosztów produktu wstawiona do faktury

		faktura.wyswietl_zawartosc(); // wyswietla fakture
		faktura.wyswietlanie_pozycji_faktury();// wyswietlenie pozycji faktury

		id_klient = "2"; // FAKTURA dla klienta o ID 2
		Faktura faktura1 = new Faktura(2, "polesie", "201-05-10", "2019-05-25", "Adam",
				" \nNAZWA KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getNazwa()+
				 " \nADRES KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getAdres()+
				 " \n RABAT KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()+"% "+
				" \nTELEFON "+ baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getTelefon()+
				" \nPESEL "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getNumer_pesel(), "Gotówka");
		baza_faktur.save("2", faktura1);

		produkt_nazwa = "Ogorek"; // Klient kupuje produkt ogorek
		pozycje_faktury = new Pozycje_faktury(1, dostawca.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 2,
				cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())) // cena
																													// netto
																													// produktu
				, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // cena
																													// brutto
																													// produktu
				, wartosc_netto(szt, cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // wartosc
																													// netto
																													// produktu
				, wartosc_brutto(szt, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))))); // wartosc
																														// brutto
																														// produktu
		faktura1.save(pozycje_faktury); // produkt dodany do faktury

		produkt_nazwa = "Kalfior"; // Klient kupuje produkt kalfior
		pozycje_faktury = new Pozycje_faktury(2, dostawca.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 2,
				cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())) // cena
																													// netto
																													// produktu
				, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // cena
																													// brutto
																													// produktu
				, wartosc_netto(szt, cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // wartosc
																													// netto
																													// produktu
				, wartosc_brutto(szt, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))))); // wartosc
																														// brutto
																														// produktu
		faktura1.save(pozycje_faktury); // produkt dodany do faktury

		faktura1.setKwota(faktura1.suma_kosztow()); // suma kosztów produktu wstawiona do faktury
		faktura1.wyswietl_zawartosc(); // wyswietla fakture
		faktura1.wyswietlanie_pozycji_faktury();// wyswietlenie pozycji faktury

		id_klient = "3";// FAKTURA dla klienta o ID 3
		Faktura faktura2 = new Faktura(3, "Polesie", "2019-03-09", "2019-03-09", "Jonasz",
				" \nNAZWA KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getNazwa()+
				 " \nADRES KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getAdres()+
				 " \n RABAT KLIENTA "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()+"% "+
				" \nTELEFON "+ baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getTelefon()+
				" \nPESEL "+baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getNumer_pesel(), "Karta");
		baza_faktur.save("3", faktura2);

		produkt_nazwa = "Ogorek"; // Klient kupuje produkt ogorek
		pozycje_faktury = new Pozycje_faktury(1, dostawca.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 2,
				cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy())) // cena
																													// netto
																													// produktu
				, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // cena
																													// brutto
																													// produktu
				, wartosc_netto(szt, cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))) // wartosc
																													// netto
																													// produktu
				, wartosc_brutto(szt, cena_brutto(cena_netto_osoba_fizyczna(
						rabat_klienta(baza_Klientow.szukaj_po_osobie_fizyczna(id_klient).getRabat_procentowy()))))); // wartosc
																														// brutto
																														// produktu
		faktura2.save(pozycje_faktury); // produkt dodany do faktury
		faktura2.setKwota(faktura2.suma_kosztow()); // suma kosztów produktu wstawiona do faktury
		faktura2.wyswietl_zawartosc(); // wyswietla fakture
		faktura2.wyswietlanie_pozycji_faktury();// wyswietlenie pozycji faktury

		// Faktury dla klienta (Osoby prawne)

		id_klient = "4";
		Faktura faktura3 = new Faktura(4, "Wolen", "2019-03-09", "2019-03-09", "Eliasz",
				" \nNAZWA_KLIENTA "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getNazwa()+
				 " \nADRES_KLIENTA "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getAdres()+
				 " \nRABAT_KLIENTA "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()+"% "+
				" \nTELEFON "+ baza_Klientow.szukaj_po_osoba_prawna(id_klient).getTelefon()+
				" \nNIP "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getNIP()+
				" \nREGON "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getREGION(), "Karta");// FAKTURA dla klienta o ID 4(Osoba
																						// prawna)
		baza_faktur.save("4", faktura3);
		produkt_nazwa = "Kolo"; // Klient kupuje produkt kolo
		pozycje_faktury = new Pozycje_faktury(1, dostawca1.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 5,
				cena_netto_prawna(rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy())) // cena
																														// netto
																														// produktu
				, cena_brutto_prawna(cena_netto_prawna(
						rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()))) // cena
																												// brutto
																												// produktu
				, wartosc_netto(szt, cena_netto_prawna(
						rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()))) // wartosc
																												// netto
																												// produktu
				, wartosc_brutto(szt, cena_brutto_prawna(cena_netto_prawna(
						rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()))))); // wartosc
																													// brutto
																													// produktu
		faktura3.save(pozycje_faktury); // produkt dodany do faktury
		faktura3.setKwota(faktura3.suma_kosztow()); // suma kosztów produktu wstawiona do faktury
		faktura3.wyswietl_zawartosc(); // wyswietla fakture
		faktura3.wyswietlanie_pozycji_faktury();// wyswietlenie pozycji faktury

		id_klient = "5";
		Faktura faktura4 = new Faktura(5, "Solec", "2019-03-09", "2019-03-10", "Sławomir",
				" \nNAZWA_KLIENTA "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getNazwa()+
				 " \nADRES_KLIENTA "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getAdres()+
				 " \nRABAT_KLIENTA "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()+"% "+
				" \nTELEFON "+ baza_Klientow.szukaj_po_osoba_prawna(id_klient).getTelefon()+
				" \nNIP "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getNIP()+
				" \nREGON "+baza_Klientow.szukaj_po_osoba_prawna(id_klient).getREGION(), "karta");// FAKTURA dla klienta o ID 4(Osoba
																						// prawna)
		baza_faktur.save("5", faktura4);
		produkt_nazwa = "Opona"; // Klient kupuje produkt opona
		pozycje_faktury = new Pozycje_faktury(1, dostawca1.znajdz(produkt_nazwa).getNazwa(), "szt", szt = 2,
				cena_netto_prawna(rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy())) // cena
																														// netto
																														// produktu
				, cena_brutto_prawna(cena_netto_prawna(
						rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()))) // cena
																												// brutto
																												// produktu
				, wartosc_netto(szt, cena_netto_prawna(
						rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()))) // wartosc
																												// netto
																												// produktu
				, wartosc_brutto(szt, cena_brutto_prawna(cena_netto_prawna(
						rabat_klienta(baza_Klientow.szukaj_po_osoba_prawna(id_klient).getRabat_procentowy()))))); // wartosc
																													// brutto
																													// produktu
		faktura4.save(pozycje_faktury); // produkt dodany do faktury
		faktura4.setKwota(faktura4.suma_kosztow()); // suma kosztów produktu wstawiona do faktury
		faktura4.wyswietl_zawartosc(); // wyswietla fakture
		faktura4.wyswietlanie_pozycji_faktury();// wyswietlenie pozycji faktury

	}

}
