package com.kcs.example;

import java.util.Scanner;

public class ThirdExample {
    /**
     * Parašyti programą kuri paprašytų vartotojo įvesti žodį
     * ir jį iš karto atvaizduotų, tada vėl paprašytų įvesti
     * kitą žodį, jį atvaizduotų, ir procesą kartotų tol,
     * kol nebus įvestas žodis „pabaiga“. Patikrinkite ar įvestas žodžio ilgis yra
     * lyginis ar ne tam panaudokite % operatoriu. Jei žodis yra lyginis atspausdinkite
     * “Įvestas žodis  {įvestas_žodis} yra lyginis” ir šalia kokio ilgio yra žodis.
     * Jei nelyginis “Įvestas žodis {įvestas_žodis} nelyginis” šalia jo ilgį.
     * Taip suskaičiuokite kiek tame žodyje yra “a” raidžių.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ThirdExample example = new ThirdExample();
      /*  String name ="";
        while (!name.toLowerCase().equals("pabaiga")){
            name = sc.nextLine();
        }*/
        String name;
        do {
            System.out.println("Iveskite zodi, jei norite baigti iveskite pabaiga:");
            name = sc.nextLine();
            example.printMethodEven(name);
            //todo patikrinti ar ne pabaiga
            System.out.println("skaicius a raidziu yra " + getNumbOfLetters(name, 'a'));
        } while (!name.toLowerCase().equals("pabaiga"));
    }

    private void printMethodEven(String name) {
        if (name.toLowerCase().equals("pabaiga")) {
            return;
        }

        if (name.length() % 2 == 0){
            System.out.println(name + " yra lyginis jo ilgis " + name.length());
        }else {
            System.out.println(name + " nelyginis jo ilgis " + name.length());
        }
    }

    private static int getNumbOfLetters(String name, char letter){
        int count = 0;
        for (int i = 0; i < name.length(); i++){
            char l = name.charAt(i);
            if(l == letter){
                count++;
            }
        }
        return count;
    }
}
