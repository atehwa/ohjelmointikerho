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
        sano(yhdista(jokin_asia(), "sanoo:"));
        while(ehka() || ehka() || ehka()) {
            List<String> sae;
            if (ehka() && ehka()) {
                sae = lista(poimi(lista("oli kerran kaunis tyttö",
                    "oli loitsua sisältä",
                    "suuren kerhon kauniit kasvot",
                    "mutta se haisi isältä")));
            } else {
                sae = yhdista(
                        poimi(lista("kauan sitten", "hädin tuskin",
                                        "vaaran vuoksi", "sateen alla")),
                        poimi(lista("sattui että", "ehti suojaan",
                                        "väisti sivuun", "näki kurjen")));
            }
            sano(sae);
        }
    }
    
    static List<String> jokin_asia () {
        if (ehka()) {
            return lista(poimi(listaksi("kissa ikkuna kuutio rakkaus")));
        } else {
            return yhdista(poimi(listaksi("suuri paljas terävä ihana")),
                    jokin_asia());
        }
    }
    
    public static <T> boolean samatko (T o1, T o2) {
        return o1.equals(o2);
    }
    
    public static boolean tyhjako (List ls) {
        return ls.isEmpty();
    }
    
    public static <T> boolean loytyyko (T elem, List<T> ls) {
        return ls.contains(elem);
    }
    
    public static boolean mahdollisesti (int todnakProsentti) {
        return rand.nextInt(100) < todnakProsentti;
    }
    
    public static boolean ehka () {
        return mahdollisesti(50);
    }
    
    public static int pituus (List ls) {
        return ls.size();
    }
    
    public static int pituus (String s) {
        return s.length();
    }
    
    public static <T> T eka (List<T> ls) {
        return ls.get(0);
    }
    
    public static <T> List<T> loput (List<T> ls) {
        return ls.subList(1, ls.size());
    }
    
    public static <T> T vika (List<T> ls) {
        return ls.get(ls.size() - 1);
    }
    
    public static <T> List<T> alut (List<T> ls) {
        return ls.subList(0, ls.size() - 1);
    }
    
    public static <T> List<T> yhdista (List<T>... lss) {
        List<T> result = new ArrayList<T>();
        for (List<T> ls : lss) result.addAll(ls);
        return result;
    }
    
    public static <T> List<T> yhdista (T elem, List<T> ls) {
        List<T> result = new ArrayList<T>();
        result.add(elem);
        result.addAll(ls);
        return result;
    }
    
    public static <T> List<T> yhdista (List<T> ls, T elem) {
        List<T> result = new ArrayList<T>(ls);
        result.add(elem);
        return result;
    }
    
    public static List<String> yhdista(String... ss) {
        return Arrays.asList(ss);
    }
    
    public static <T> T poimi (List<T> ls) {
        return ls.get(rand.nextInt(ls.size()));
    }
    
    public static <T> List<T> lista (T... sisalto) {
        return Arrays.asList(sisalto);
    }
    
    public static void sano(String juttu) {
        System.out.println(juttu);
    }
    
    public static void sano(List<String> jutut) {
        String sanottava = eka(jutut);
        for (String juttu : loput(jutut))
            sanottava = sanottava + " " + juttu;
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
