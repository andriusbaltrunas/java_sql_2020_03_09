package com.kcs.example.days.fife;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AJCodeConverter {
    public static void main(String[] args) {

    }

    private static List<String> readLetter() {
        List<String> letters = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("laiskas.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                letters.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            System.out.println("Cannot read letter file ");
        }
        return letters;
    }
}
