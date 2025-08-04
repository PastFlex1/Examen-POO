package model;

public class CasillaMina extends Casilla {

    @Override
    public boolean tieneMina() {
        return true;
    }

    @Override
    public String toString() {
        if (estaMarcada()) {
            return "F";
        }
        if (estaDescubierta()) {
            return "X";
        }
        return "#";
    }
}
