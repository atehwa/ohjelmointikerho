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
        List<String> x = lista("foo!", kysy("häh?"), "baz");
        List<String> y = lista("jee", "buu");
        List<String> z = yhdista(x, lista("moi", "boing"));
        List<String> poks = yhdista(x, "jotain");
        sano(poks);
        sano("eka: " + eka(poks));
        sano("toka: " + eka(loput(poks)));
        sano("random: " + poimi(poks));
        sano("z = poks? " + samatko(z, poks));
        sano("moi in x? "  + loytyyko("moi", x));
        sano("tyhjäkö: " + tyhjako(lista()));
        sano(lista("poksin pituus", ""+pituus(poks), "ekan pituus",
                ""+pituus(eka(poks))));
        String nimi = kysy("Mikä hei on sun nimi?");
        sano(lista("Mun mielestä", nimi, "on kaunis nimi"));
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
    
    public static <T> T poimi (List<T> ls) {
        return ls.get(rand.nextInt(ls.size()));
    }
    
    public static <T> List<T> lista (T... sisalto) {
        return new ArrayList(Arrays.asList(sisalto));
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
    
    // TODO zip, map, filter, fold, crossmap
}
