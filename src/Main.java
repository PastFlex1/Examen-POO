import controller.ControladorJuego;
import model.JuegoBuscaminas;
import view.VistaConsola;

public class Main {
    public static void main(String[] args) {
        JuegoBuscaminas modelo = new JuegoBuscaminas();
        VistaConsola vista = new VistaConsola();
        ControladorJuego controlador = new ControladorJuego(modelo, vista);

        controlador.iniciarJuego();
    }
}