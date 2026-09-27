package com.example.myapp.services;

import org.springframework.stereotype.Service;

@Service
public class SumaServiceImplPositivos implements SumaService {
    public Integer suma(Integer a, Integer b) {
        if (a < 0 || b < 0)
            return -1;
        return a + b;
    }
}
