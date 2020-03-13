package com.kcs.example.days.fife;

import java.util.*;

public class CollectionExamples {

    public CollectionExamples(){
        this(3);
    }
    public CollectionExamples(int sk){

    }

    public static void main(String[] args) {
//LIST
        /*List<String> names = new ArrayList<>();
        names.add("Andrius");
        System.out.println("list size " + names.size() + " " + names.get(0));

        List<Integer> numbers = List.of(1, 4, 3, 5, 5);
        System.out.println(numbers.contains(3));

        for(int i=0 ; i <numbers.size(); i ++){
            System.out.println(numbers.get(i));
        }

        for(Integer n: numbers){
            System.out.println(n);
        }

        numbers.forEach(System.out::println);*/

        //SET

       /* Set<Integer> numbers = new TreeSet<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(2);
        numbers.add(1);
        numbers.add(5);

        numbers.forEach(System.out::println);*/

        //MAP

        Map<Integer, String> cars = new HashMap<>();
        cars.put(2, "Audi");
        cars.put(3, "BWM");
        cars.put(1, "Volvo");
        cars.forEach((k, v) -> System.out.println("key " + k + " value " + v));

        for (Integer key : cars.keySet()) {
            System.out.println("key " + key + " val :" + cars.get(key));
        }
    }
}
