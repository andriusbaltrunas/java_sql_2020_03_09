package com.kcs.example;

public class FirstExample {
    public static void main(String[] args) {
        System.out.println("Labas");

        //TODO print sum
        FirstExample firstExample = new FirstExample();
        System.out.println(firstExample.sum(10, 30));
    }

    private int sum(int numb, int secondNumb) {
        return numb + secondNumb;
    }


}
