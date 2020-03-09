package com.kcs.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputExample {

    /**
     * Parašyti programą, kuri leistų vartotojui įvesti norimą skaičių ir
     * po to parašytų ar šis skaičius yra lyginis, ar nelyginis.
     * Užuomina panaudokite % operatoriu.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Iveskite skaiciu:");

        try {
            int result = sc.nextInt();

            if (result % 2 == 0) {
                System.out.println("Ivestas skaicius yra: " + result + " yra lyginis");
            } else {
                System.out.println("Ivestas skaicius yra: " + result + " yra nelyginis");
            }
        } catch (InputMismatchException e) {
            System.out.println("Blogas skaicius");
        }
    }

}
