import javax.swing.JOptionPane;

import controlador.ControladorCandidatos;
import modelo.Candidatos;
import vistas.vistaCandidatoConsola;
import vistas.vistaCandidatoGUI;

public class App {
    public static void main(String[] args) throws Exception {
        Candidatos candi = new Candidatos();
        vistaCandidatoConsola vistaConsola = new vistaCandidatoConsola();
        vistaCandidatoGUI vistaGUI = new vistaCandidatoGUI();
        
        
        String[] opciones = {"Interfaz Gráfica (GUI)", "Consola"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Selecciona la forma de ejecución:",
                "Ejecutar en",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion == 0) {
            ControladorCandidatos control = new ControladorCandidatos(candi, vistaGUI);
            control.iniciarVista();
        } else {
            ControladorCandidatos control = new ControladorCandidatos(candi, vistaConsola);
            control.iniciarVista();
        }
    }
}
