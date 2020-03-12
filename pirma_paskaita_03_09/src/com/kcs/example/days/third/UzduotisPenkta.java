package com.kcs.example.days.third;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UzduotisPenkta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UzduotisPenkta uzduotisPenkta = new UzduotisPenkta();
        System.out.println("Ivesk nuvaziuota atstuma");
        double atstumas = uzduotisPenkta.getValue(sc);
        System.out.println("Ivesk kuro sanaudas");
        double sanaudos = uzduotisPenkta.getValue(sc);
        System.out.println("Vidurkis yra: " + uzduotisPenkta.average(atstumas, sanaudos));

    }

    protected double average(double nuvaziuotasAtstumas, double kuroSanaudos) {
        return (kuroSanaudos * 100) / nuvaziuotasAtstumas;
    }

    private double getValue(Scanner sc) {
        Double value = null;
        while (value == null) {
            try {
                value = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Neteisinga reiksme, pakartokite");
                sc.nextLine();
            }
        }
        return value;
    }
}
