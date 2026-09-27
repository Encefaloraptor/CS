package com.example.myapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Todo {
    public int userId;
    public int id;
    public String title;
    public boolean completed;
}
