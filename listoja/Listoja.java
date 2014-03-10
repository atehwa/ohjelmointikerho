/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listoja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author atehwa
 */
public class Listoja {

    private static Random rand = new Random();
    private static Scanner reader = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        runo();
    }

    public static void terapeutti() {
        sano("Olen terapeutti, jeejee");
        String vastaus = kysy("Mitä voin tehdä?");
        sano("Sinä sanoit: " + vastaus);
        while (true) {
            sano(hyva_vastaus(vastaus));
            vastaus = kysy("Entä sitten?");
        }
    }

    public static String hyva_vastaus(String puhe) {
        if (puhe.contains("kuol")) {
            return "Kiehtooko kuolema sinua?";
        }
        if (puhe.contains("olen")) {
            return "oletko varma, että " + puhe + "?";
        }
        if (ehka()) {
            return "Mielenkiintoinen aihe!";
        }
        return "Olen kyllä varma että huijaat";
    }

    public static boolean jooko(String vastaus) {
        return vastaus.contains("joo")
                || vastaus.contains("on")
                || vastaus.contains("yllä")
                || vastaus.contains("ietenkin");
    }

    public static void pelineuvoja() {
        sano("Olen pelineuvoja.  Autan sua kaikissa ongelmissa.");
        String vastaus = kysy("onko sinulla ongelmia?");
        if (vastaus.contains("joo") || vastaus.contains("on")) {
            sano("Voi sinua raukkaa!  Onpas surullista.  Minkälaisia ongelmia?");
        } else {
            sano("Voi voi.  Minua käytettiin vähän turhaan?  Miksi tulit?");
        }
        while (true) {
            vastaus = kysy("");
            if (vastaus.contains("erraria")) {
                sano("Terrariassa kannattaa mennä hardmodeen");
            } else if (vastaus.contains("ario")) {
                sano("Super Mario Brosin joka maailman ensimmäisessä maassa on 1UP");
            } else if (vastaus.contains("ounter") || vastaus.contains("cs")) {
                sano("Yritä pysyä hengissä kierroksen loppuun saakka");
            } else if (vastaus.contains("irby")) {
                sano("Ime kaikki viholliset!");
            } else if (vastaus.contains("inecraft")) {
                sano("Computercraft-modilla saa aikaan mitä vain");
            } else {
                sano("Voita ja ole kovin mimmi!");
            }
            sano("Onko muita ongelmia?");
        }
    }

    public static void keskustele3() {
        sano("moi");
        sano("juusto muuten ei ole terveellistä");
        String vastaus = kysy("Mitä mieltä olet siitä?");
        sano("minunkin mielestäni " + vastaus);
        String vastaus2 = kysy("Mitä haluat tehdä?");
        if (vastaus2.contains("kesk")) {
            keskustele2();
        } else {
            runo();
        }

    }

    public static void keskustele2() {
        sano("Moi!  Mikä on nimesi?");
        String nimi = kysy("> ");
        tervehdi(nimi);
        while (true) {
            sano(vastaus(kysy("> "), nimi));
        }
    }

    public static String vastaus(String repliikki, String nimi) {
        if (repliikki.contains("olet")) {
            return "Niin olenkin :)";
        }

        if (repliikki.contains("olen")) {
            return "Niin oletkin :)";
        }
        if (repliikki.contains("juusto")) {
            return "Juusto on kyllä tooosi terveellistä";
        }
        if (repliikki.contains(nimi)) {
            return "Mutta " + nimi + " olet sinä :P";
        }
        return "Ai niinkö?  Sepä mielenkiintoista!";

    }

    public static void tervehdi(String nimi) {
        if (ehka()) {
            sano("Hauska tutustua, " + nimi);
        } else {
            sano("Minusta " + nimi + " on kaunis nimi");
        }
    }

    public static void runo() {
        int sakeita = 3;
        while (sakeita > 0) {
            String aihe = asia();
            sano(aihe + " on " + adjektiivi() + ", " + aihe + " on " + adjektiivi());
            sano(aihe + "n " + asia() + " on varsin " + adjektiivi());
            sano(aihe + "a voi " + vt() + " ja " + vt());
            sano(asia() + "lla voi " + aihe + "a " + vt());

            sakeita--;
        }
    }

    public static String vt() {
        return jokin("syödä", "maistaa", "lyödä", "paistaa",
                "tulittaa", "kutittaa", "rajoittaa", "majoittaa");

    }

    public static String adjektiivi() {
        if (ehka()) {
            if (ehka()) {
                return asia() + "mainen";
            } else {
                return asia() + "nen";
            }
        } else {
            return jokin("kaunis", "ruma", "surullinen",
                    "pinkki", "natsikas", "punainen", "hauska", "söpö",
                    "syötävä");
        }
    }

    public static String asia() {
        return jokin("kakkulapio", "teesihti", "koripallo", "läppäri",
                "kusetus", "tappio", "poni", "kissa", "alicorn",
                "kameli");
    }

    public static <T> boolean samatko(T o1, T o2) {
        return o1.equals(o2);
    }

    public static boolean tyhjako(List ls) {
        return ls.isEmpty();
    }

    public static <T> boolean loytyyko(T elem, List<T> ls) {
        return ls.contains(elem);
    }

    public static boolean mahdollisesti(int todnakProsentti) {
        return rand.nextInt(100) < todnakProsentti;
    }

    public static boolean ehka() {
        return mahdollisesti(50);
    }

    public static int pituus(List ls) {
        return ls.size();
    }

    public static int pituus(String s) {
        return s.length();
    }

    public static <T> T eka(List<T> ls) {
        return ls.get(0);
    }

    public static <T> List<T> loput(List<T> ls) {
        return ls.subList(1, ls.size());
    }

    public static <T> T vika(List<T> ls) {
        return ls.get(ls.size() - 1);
    }

    public static <T> List<T> alut(List<T> ls) {
        return ls.subList(0, ls.size() - 1);
    }

    public static <T> List<T> yhdista(List<T>... lss) {
        List<T> result = new ArrayList<T>();
        for (List<T> ls : lss) {
            result.addAll(ls);
        }
        return result;
    }

    public static <T> List<T> yhdista(T elem, List<T> ls) {
        List<T> result = new ArrayList<T>();
        result.add(elem);
        result.addAll(ls);
        return result;
    }

    public static <T> List<T> yhdista(List<T> ls, T elem) {
        List<T> result = new ArrayList<T>(ls);
        result.add(elem);
        return result;
    }

    public static List<String> yhdista(String... ss) {
        return Arrays.asList(ss);
    }

    public static <T> T jokin(List<T> ls) {
        return ls.get(rand.nextInt(ls.size()));
    }

    public static String jokin(String... ls) {
        return ls[rand.nextInt(ls.length)];
    }

    public static <T> List<T> lista(T... sisalto) {
        return Arrays.asList(sisalto);
    }

    public static void sano(String juttu) {
        System.out.println(juttu);
    }

    public static void sano(List<String> jutut) {
        String sanottava = eka(jutut);
        for (String juttu : loput(jutut)) {
            sanottava = sanottava + " " + juttu;
        }
        sano(sanottava);
    }

    public static String kysy(String kysymys) {
        System.out.print(kysymys + " ");
        return reader.nextLine();
    }

    public static int luvuksi(String mj) {
        return Integer.parseInt(mj);
    }

    public static String sanaksi(Object o) {
        return "" + o;
    }

    public static List<String> listaksi(String s) {
        return Arrays.asList(s.split("\\s+"));
    }

    // TODO zip, map, filter, fold, crossmap
}
