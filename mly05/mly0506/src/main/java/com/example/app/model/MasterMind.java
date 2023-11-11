package com.example.app.model;

import java.util.ArrayList;

public class MasterMind {
    private String numeroSecreto;
    private ArrayList<Intento> listaIntentos;
    private EstadoJuego estadoJuego;

    public static int getMaxIntentos() {
        return MAX_INTENTOS;
    }

    public static void setMaxIntentos(int maxIntentos) {
        MAX_INTENTOS = maxIntentos;
    }

    public static  int TAM_NUMERO;

    public static int getTamNumero() {
        return TAM_NUMERO;
    }

    public static void setTamNumero(int tamNumero) {
        TAM_NUMERO = tamNumero;
    }

    public static  int MAX_INTENTOS;

    public MasterMind() {
        listaIntentos = new ArrayList<>();
    }

    public String getNumeroSecreto() {
        return numeroSecreto;
    }

    public void setNumeroSecreto(String numeroSecreto) {
        this.numeroSecreto = numeroSecreto;
    }

    public ArrayList<Intento> getListaIntentos() {
        return listaIntentos;
    }

    public void setListaIntentos(ArrayList<Intento> listaIntentos) {
        this.listaIntentos = listaIntentos;
    }

    public EstadoJuego getEstadoJuego() {
        return estadoJuego;
    }

    public void setEstadoJuego(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

}
