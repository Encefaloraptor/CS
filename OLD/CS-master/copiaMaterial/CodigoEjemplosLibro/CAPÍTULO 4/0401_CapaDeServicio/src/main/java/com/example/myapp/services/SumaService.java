package com.example.myapp.services;

import org.springframework.stereotype.Service;

@Service
public class SumaService {
    public Integer suma(Integer a, Integer b) {
        return a + b;
    }
}
