package com.example.ejercicios_tema_2.service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class MatematicasService {

    private Set<Integer> numbers = new LinkedHashSet<>();
    private Random random = new Random();

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public Random getRandom() {
        return random;
    }

    public void addRandomNumber() {
        boolean added;
        do {added = numbers.add(random.nextInt(100) + 1);} while (!added);
    }

    public void removeNumber(int num) {
        numbers.remove(num);
    }

}