
package com.mycompany.mlyt0101;

public class Radio implements DispositivoDomotico {
    private double dial;

    public Radio() {
        this.dial = 88.0;
    }
    @Override
    public boolean subir() {
        if (dial < 104.0) {
            dial += 0.1;
            return true;
        }
        return false;
    }
    @Override
    public boolean bajar() {
        if (dial > 88.0) {
            dial -= 0.1;
            return true;
        }
        return false;
    }
    @Override
    public void reset() {
        dial = 88.0;
    }
    @Override
    public String verEstado() {
        return "Radio: dial en " + dial;
    }
}