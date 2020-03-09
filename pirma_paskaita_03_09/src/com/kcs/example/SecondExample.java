package com.kcs.example;

import java.util.Scanner;

public class SecondExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ivesk varda:");

        String result = scanner.nextLine();
        System.out.println("Ivestas vardas " + result + " ilgis yra " + result.length());
    }
}
