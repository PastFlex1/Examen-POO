package model;

public class Casilla {
    private boolean tieneMina;
    private boolean estaDescubierta;
    private boolean estaMarcada;
    private int numeroMinasAdyacentes;

    public Casilla() {
        this.tieneMina = false;
        this.estaDescubierta = false;
        this.estaMarcada = false;
        this.numeroMinasAdyacentes = 0;
    }

    public void colocarMina() {
        this.tieneMina = true;
    }

    public void descubrir() {
        this.estaDescubierta = true;
    }

    public void marcar() {
        this.estaMarcada = !this.estaMarcada;
    }

    // Getters
    public boolean tieneMina() {
        return tieneMina;
    }

    public boolean estaDescubierta() {
        return estaDescubierta;
    }

    public boolean estaMarcada() {
        return estaMarcada;
    }

    public int getNumeroMinasAdyacentes() {
        return numeroMinasAdyacentes;
    }

    // Setter
    public void setNumeroMinasAdyacentes(int numero) {
        this.numeroMinasAdyacentes = numero;
    }

    @Override
    public String toString() {
        if (estaMarcada) {
            return "F"; // F = Bandera (Flag)
        }
        if (!estaDescubierta) {
            return "#"; // # = Casilla cubierta
        }
        if (tieneMina) {
            return "X"; // X = Mina
        }
        if (numeroMinasAdyacentes > 0) {
            return String.valueOf(numeroMinasAdyacentes);
        }
        return " "; // Espacio vacío
    }
}
