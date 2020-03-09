package com.kcs.example.days.second;

public class SecondTasks {

    public static void main(String[] args) {
        String text = "KOL EINU ŠUNIE LOK".replaceAll(" ", "");

        boolean isPalindrome = true;
        for (int i = 0; i < text.length(); i++) {
            char first = text.charAt(i);
            char last = text.charAt(text.length() - i - 1);
            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Polindromas");
        } else {
            System.out.println("Nepolindromas");
        }
    }
}
