
package com.mycompany.mlyt0101;

public class Ascensor implements DispositivoDomotico {
    private int planta;

    public Ascensor() {
        this.planta = 0;
    }
   @Override
    public boolean subir() {
        if (planta < 8) {
            planta++;
            return true;
        }
        return false;
    }
   @Override
    public boolean bajar() {
        if (planta > 0) {
            planta--;
            return true;
        }
        return false;
    }
   @Override
    public void reset() {
        planta = 0;
    }
   @Override
    public String verEstado() {
        return "Ascensor: planta " + planta;
    }
}
