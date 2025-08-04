package model;

import java.io.Serializable;

// Clase base para las casillas. Implementa Serializable para la persistencia.
public abstract class Casilla implements Serializable {
    private boolean estaDescubierta;
    private boolean estaMarcada;

    public Casilla() {
        this.estaDescubierta = false;
        this.estaMarcada = false;
    }

    public void descubrir() {
        this.estaDescubierta = true;
    }

    public void marcar() {
        this.estaMarcada = !this.estaMarcada;
    }

    public boolean estaDescubierta() {
        return estaDescubierta;
    }

    public boolean estaMarcada() {
        return estaMarcada;
    }

    public abstract boolean tieneMina();

    // Método abstracto para la representación en String
    @Override
    public abstract String toString();
}
