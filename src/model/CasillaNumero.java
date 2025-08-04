package model;

public class CasillaNumero extends Casilla {
    private int numeroMinasAdyacentes;

    public CasillaNumero() {
        this.numeroMinasAdyacentes = 0;
    }

    @Override
    public boolean tieneMina() {
        return false;
    }

    public int getNumeroMinasAdyacentes() {
        return numeroMinasAdyacentes;
    }

    public void setNumeroMinasAdyacentes(int numero) {
        this.numeroMinasAdyacentes = numero;
    }

    @Override
    public String toString() {
        if (estaMarcada()) {
            return "F";
        }
        if (!estaDescubierta()) {
            return "#";
        }
        if (numeroMinasAdyacentes > 0) {
            return String.valueOf(numeroMinasAdyacentes);
        }
        return " ";
    }
}
