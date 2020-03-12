package com.kcs.example.days.third;

import com.kcs.example.days.third.UzduotisPenkta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskFifeReadFromFile {

    public static void main(String[] args) {

        UzduotisPenkta uzduotisPenkta = new UzduotisPenkta();

        try (BufferedReader bf = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            String carName = "";
            double bestCarAvg = 0;
            while ((line = bf.readLine()) != null) {
                String[] elements = line.split(" ");
                double average = uzduotisPenkta.average(Double.parseDouble(elements[1]), Double.parseDouble(elements[2]));
                if (bestCarAvg == 0 || bestCarAvg > average) {
                    bestCarAvg = average;
                    carName = elements[0];
                }
                System.out.println(elements[0] + " " + average);
            }
            System.out.println("Optimaliasias automobilis " + carName + " " + bestCarAvg);
        } catch (IOException e) {
            System.out.println("Failo nuskaityti nepavyko");
        }
    }
}
