import controller.ControladorJuego;
import model.JuegoBuscaminas;
import view.VistaConsola;
import view.IVista;

public class Main {
    public static void main(String[] args) {
        JuegoBuscaminas modelo = new JuegoBuscaminas();
        IVista vista = new VistaConsola(); // Uso de la interfaz
        ControladorJuego controlador = new ControladorJuego(modelo, vista);

        controlador.iniciarJuego();
    }
}