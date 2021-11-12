package com.cwiczenia;
import java.util.Scanner;

public class Main {

    //metoda do zadania 1
    public static String Student(String imie, String nazwisko) {
        String dane = imie + " " + nazwisko;
        return dane;
    }

    //metoda do zadania 2
    public static String ktoryKwartal(short miesiac, short rok, String kwartal) {
        String wynik = miesiac + "." + rok + " to " + kwartal + " kwartal " + rok + " roku";
        return wynik;
    }

    //metoda do zadania 5
    public static void playlistPrint(String firstSongTitle, int firstSongMins, int firstSongSecs, String secondSongTitle, int secondSongMins, int secondSongSecs) {
        byte firstOnPlaylist = 0;
        String firstSong = firstSongTitle + " " + firstSongMins + ":" + firstSongSecs;
        String secondSong = secondSongTitle + " " + secondSongMins + ":" + secondSongSecs;
        if (firstSongMins < secondSongMins) {
            firstOnPlaylist = 1;
        }
        else if (firstSongMins > secondSongMins) {
            firstOnPlaylist = 2;
        }
        else if (firstSongMins == secondSongMins) {
            if (firstSongSecs <= secondSongSecs) {
                firstOnPlaylist = 1;
            }
            else if (firstSongSecs > secondSongSecs) {
                firstOnPlaylist = 2;
            }
        }
        System.out.println("  _________________________________________________");
        System.out.println("  UTWORY:");
        if (firstOnPlaylist == 1) {
            System.out.println("  1. " + firstSong);
            System.out.println("  2. " + secondSong);
        }
        else if (firstOnPlaylist == 2) {
            System.out.println("  1. " + secondSong);
            System.out.println("  2. " + firstSong);
        }
        int minsSum = firstSongMins + secondSongMins;
        int secsSum = firstSongSecs + secondSongSecs;
        while (secsSum >= 60) {
            minsSum++;
            secsSum = secsSum - 60;
        }
        if (secsSum < 10) {
            System.out.println("  LACZNY CZAS TRWANIA: " + minsSum + ":0" + secsSum);
        }
        else {
            System.out.println("  LACZNY CZAS TRWANIA: " + minsSum + ":" + secsSum);
        }
        System.out.println("  _________________________________________________");
    }

    //metody do zadania 6
    public static boolean czyTrojkat(double a, double b, double c) {
        return (a + b > c && a + c > b && b + c > a);
        }

    public static boolean czyProstokatny(double a, double b, double c) {
        if (a > b && a > c) {
            return (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2));
        }
        else if (b > a && b > c) {
            return (Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2));
        }
        else if (c > a && c > b) {
            return (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2));
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner wczytaj = new Scanner(System.in);

        //zadanie 1
        System.out.println("____________________________________________");
        System.out.println("Zadanie 1");
        System.out.println("");
        System.out.print("Podaj imię: ");
        String imie = wczytaj.nextLine();
        System.out.print("Podaj nazwisko: ");
        String nazwisko = wczytaj.nextLine();
        System.out.print("Podaj płeć (kobieta/mężczyzna): ");
        String plec = wczytaj.nextLine();
        if (plec.equalsIgnoreCase("kobieta")) {
            System.out.println("Studentka: " + Student(imie, nazwisko));
        } else if (plec.equalsIgnoreCase("mężczyzna") || plec.equalsIgnoreCase("męzczyzna") || plec.equalsIgnoreCase("meżczyzna") || plec.equalsIgnoreCase("mezczyzna")) {
            System.out.println("Student: " + Student(imie, nazwisko));
        } else {
            System.out.println("Wprowadzono niepoprawne dane.");
        }

        //zadanie 2
        System.out.println("____________________________________________");
        System.out.println("Zadanie 2");
        System.out.println("");
        System.out.print("Podaj miesiąc: ");
        String miesiac = wczytaj.nextLine();
        System.out.print("Podaj rok: ");
        String rok = wczytaj.nextLine();
        short miesiacShort = Short.parseShort(miesiac);
        short rokShort = Short.parseShort(rok);

        if (miesiacShort >= 1 && miesiacShort <= 3) {
            System.out.println(ktoryKwartal(miesiacShort, rokShort, "I"));
        }
        else if (miesiacShort >= 4 && miesiacShort <= 6) {
            System.out.println(ktoryKwartal(miesiacShort, rokShort, "II"));
        }
        else if (miesiacShort >= 7 && miesiacShort <= 9) {
            System.out.println(ktoryKwartal(miesiacShort, rokShort, "III"));
        }
        else if (miesiacShort >= 10 && miesiacShort <= 12) {
            System.out.println(ktoryKwartal(miesiacShort, rokShort, "IV"));
        }
        else {
            System.out.println("Wprowadzono niepoprawne dane");
        }

        //zadanie 3
        System.out.println("____________________________________________");
        System.out.println("Zadanie 3");
        System.out.println("");
        System.out.print("Podaj rok, a ja powiem czy jest przestępny: ");
        String rokPrzestepny = wczytaj.nextLine();
        int rokInt = Integer.parseInt(rokPrzestepny);
        if (rokInt % 4 == 0 && rokInt % 100 != 0 || rokInt % 400 == 0){
            System.out.println("Rok " + rokInt + " jest przestępny.");
        }
        else {
            System.out.println("Rok " + rokInt + " nie jest przestępny.");
        }

        //zadanie 4
        System.out.println("____________________________________________");
        System.out.println("Zadanie 4");
        System.out.println("");
        System.out.print("Wprowadź liczbę sztuk zakupionego towaru: ");
        String ileSztuk = wczytaj.nextLine();
        int ileSztukInt = Integer.parseInt(ileSztuk);
        double cena = 10;
        System.out.print("Czy jest promocja? (y/n) ");
        String czyPromocja = wczytaj.nextLine();
        if (czyPromocja.equalsIgnoreCase("y") && ileSztukInt > 10) {
                cena = cena / 2.0;
        }
        else if (czyPromocja.equalsIgnoreCase("n")) {
                cena = cena * 1.1;
        }

        //zadanie 5
        System.out.println("____________________________________________");
        System.out.println("Zadanie 5");
        System.out.println("");
        System.out.print("Podaj tytuł pierwszego utworu: ");
        String firstSongTitle = wczytaj.nextLine();
        System.out.print("Podaj czas trwania pierwszego utworu (minuty): ");
        String firstSongLengthMins = wczytaj.nextLine();
        int firstSongLengthMinsInt = Integer.parseInt(firstSongLengthMins);
        System.out.print("Podaj czas trwania pierwszego utworu (sekundy): ");
        String firstSongLengthSecs = wczytaj.nextLine();
        int firstSongLengthSecsInt = Integer.parseInt(firstSongLengthSecs);
        while (firstSongLengthSecsInt >= 60) {
            System.out.print("Minuta ma 60 sekund! Wprowadź poprawną wartość: ");
            firstSongLengthSecsInt = wczytaj.nextInt();
        }
        System.out.println("");
        System.out.print("Podaj tytuł drugiego utworu: ");
        String secondSongTitle = wczytaj.nextLine();
        System.out.print("Podaj czas trwania drugiego utworu (minuty): ");
        String secondSongLengthMins = wczytaj.nextLine();
        int secondSongLengthMinsInt = Integer.parseInt(secondSongLengthMins);
        System.out.print("Podaj czas trwania drugiego utworu (sekundy): ");
        String secondSongLengthSecs = wczytaj.nextLine();
        int secondSongLengthSecsInt = Integer.parseInt(secondSongLengthSecs);
        while (secondSongLengthSecsInt >= 60) {
            System.out.print("Minuta ma 60 sekund! Wprowadź poprawną wartość: ");
            secondSongLengthSecsInt = wczytaj.nextInt();
        }
        playlistPrint(firstSongTitle, firstSongLengthMinsInt, firstSongLengthSecsInt, secondSongTitle, secondSongLengthMinsInt, secondSongLengthSecsInt);

        //zadanie 6
        System.out.println("____________________________________________");
        System.out.println("Zadanie 6");
        System.out.println("");
        System.out.print("Podaj długość pierwszego odcinka: ");
        double a = wczytaj.nextDouble();
        System.out.print("Podaj długość drugiego odcinka: ");
        double b = wczytaj.nextDouble();
        System.out.print("Podaj długość trzeciego odcinka: ");
        double c = wczytaj.nextDouble();
        System.out.println("");
        if (czyTrojkat(a, b, c)) {
            System.out.print("Wybrane odcinki tworzą trójkąt");
            if (a == b || b == c || a == c) {
                System.out.print(" równoramienny.");
            }
            else if (a == b && b == c && a == c) {
                System.out.print(" równoboczny.");
            }
            else if (czyProstokatny(a, b, c)) {
                System.out.print(" prostokątny.");
            }
            else {
                System.out.print(".");
            }
        }
        else {
            System.out.println("Wybrane odcinki nie tworzą trójkąta. :(");
        }
    }
}


