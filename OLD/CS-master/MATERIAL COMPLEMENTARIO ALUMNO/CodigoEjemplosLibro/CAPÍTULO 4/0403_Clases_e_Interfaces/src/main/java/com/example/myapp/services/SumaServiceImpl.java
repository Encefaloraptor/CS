package com.example.myapp.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SumaServiceImpl implements SumaService {
    public Integer suma(Integer a, Integer b) {
        return a + b;
    }
}
