package com.kcs.example.days.fife;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AJCodeConverter {
    private static final String TARPAS = "tarpas";
    private static final String EMPTY = " ";

    public static void main(String[] args) {
        Map<String, String> code = readCode();
        StringBuilder sb = new StringBuilder();
        for (String item : readLetter()) {
            String translation = code.get(item);
            if (TARPAS.equals(translation)) {
                translation = " ";
            }
            sb.append(translation);
        }

        System.out.println("Isverstas laisvas");
        System.out.println(sb.toString());

        encryptText(code);
    }

    private static void encryptText(Map<String, String> code) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.nextLine();
        //Labas man tinka
        for (int i = 0; i < line.length(); i++) {
            String item = String.valueOf(line.charAt(i));
            if (EMPTY.equals(item)) {
                item = TARPAS;
            }
            String decrypt = code.get(item);
            sb.append(decrypt).append(EMPTY);
        }
        String result = sb.toString().trim();
    }

    private static Map<String, String> readCode() {
        Map<String, String> code = new HashMap<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("code.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] items = line.split(EMPTY);
                if (items.length == 2) {
                    code.put(items[0], items[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot read code");
        }

        return code;
    }

    private static List<String> readLetter() {
        List<String> letters = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("laiskas.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                letters.addAll(Arrays.asList(line.split(EMPTY)));
            }
        } catch (IOException e) {
            System.out.println("Cannot read letter file ");
        }
        return letters;
    }
}
