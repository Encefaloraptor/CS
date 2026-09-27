package com.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> lineasFichero=null;
        try {
            Path path = Paths.get("path/file.txt");
            lineasFichero = Files.readAllLines(path, StandardCharsets.UTF_8);
            //Si fichero en formato ANSI:StandardCharsets.ISO_8859_1
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        System.out.println(lineasFichero);
    }
}