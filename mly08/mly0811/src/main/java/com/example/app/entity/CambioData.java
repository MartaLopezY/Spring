package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CambioData {
    private float amount;
    private String base;
    private String date;
    private HashMap<String, Float> rates;
}
