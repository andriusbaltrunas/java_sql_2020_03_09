package com.kcs.example.days.third;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("example.txt"));
        bw.write("Simple example write to file");

        bw.flush();
        bw.close();
    }
}
