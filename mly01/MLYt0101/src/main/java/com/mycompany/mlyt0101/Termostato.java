
package com.mycompany.mlyt0101;

import java.util.Date;

public class Termostato implements DispositivoDomotico {
    private int temperatura;
    private Date ultimaRevision;

    public Termostato() {
        this.temperatura = 20;
        this.ultimaRevision = new Date();
    }
    @Override
    public boolean subir() {
        if (temperatura < 80) {
            temperatura++;
            return true;
        }
        return false;
    }
    @Override
    public boolean bajar() {
        if (temperatura > 15) {
            temperatura--;
            return true;
        }
        return false;
    }
    @Override
    public void reset() {
        temperatura = 20;
    }
    @Override
    public String verEstado() {
        return "Termostato: " + temperatura + "ºC. Última revisión: " + ultimaRevision;
    }

    public void revisar() {
        ultimaRevision = new Date();
    }
}