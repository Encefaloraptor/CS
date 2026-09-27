package com.example.ejercicios_tema_2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    private Integer firstNumber = null;
    private Integer secondNumber = null;
    private Integer result = null;

    private boolean isFirstValue = true;
    private boolean isSum = true;

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public Integer getResult() {
        return result;
    }

    public boolean isFirstValue() {
        return isFirstValue;
    }

    public boolean isSum() {
        return isSum;
    }

    public void insertNumber(Integer number) {
        if (isFirstValue) {
            firstNumber = number;
        } else {
            secondNumber = number;
        }
    }

    public void calculateResult() {
        if (isSum) {
            result = firstNumber + secondNumber;
        } else {
            result = firstNumber - secondNumber;
        }
    }

    public void selectOperation(String operation) {
        isFirstValue = !isFirstValue;
        isSum = operation.equals("suma");
    }

    public void clean() {
        firstNumber = null;
        secondNumber = null;
        result = null;
        isFirstValue = true;
    }
}
