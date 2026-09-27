package com.example.myapp.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboracionId implements Serializable {
    private Long empleado;
    private Long proyecto;
}
