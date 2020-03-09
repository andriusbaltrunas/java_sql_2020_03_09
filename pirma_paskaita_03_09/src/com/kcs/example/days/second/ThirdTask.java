package com.kcs.example.days.second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThirdTask {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int select = -1;
        while (select != 0) {
            System.out.println("Pasirinkite kokios figuros plota skaiciuosite:");
            System.out.println("1. Statusis trikampis\n2. Staciakampis\n3. Kvadratas\n4. Apskritimas\n0. Pabaiga");

            select = getCorrectValue(sc);
            switch (select) {
                case 1:
                    triangle(sc);
                    break;
                case 2:
                    System.out.println("Staciakampis");
                    break;
                case 3:
                    System.out.println("Kvadratas");
                    break;
                case 4:
                    System.out.println("Apskritimas");
                    break;
                case 0:
                    System.out.println("End");
                    break;
                default:
                    System.out.println("Nerasta");
                    break;
            }
        }
    }

    private static int getCorrectValue(Scanner scanner) {
        while (true) {
            try {
                int result = scanner.nextInt();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("Blogai iveskas skaiciu pakartokite");
                scanner.nextLine();
            }
        }
    }

    private static void triangle(Scanner sc) {
        System.out.println("Iveskite pirma statini");
        int a = getCorrectValue(sc);
        System.out.println("Iveskite antra statini");
        int b = getCorrectValue(sc);
        System.out.println("Trikampio plotas yra " + (a * b) / 2);
    }
}
