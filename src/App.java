import controlador.ControladorCandidatos;
import modelo.Candidatos;
import vistas.vistaCandidatoConsola;
import vistas.vistaCandidatoGUI;

public class App {
    public static void main(String[] args) throws Exception {
        Candidatos candi = new Candidatos();
        //vistaCandidatoConsola vistaConsola = new vistaCandidatoConsola();
        vistaCandidatoGUI vistaGUI = new vistaCandidatoGUI();
        ControladorCandidatos control = new ControladorCandidatos(candi, vistaGUI);
        control.iniciarVista();
    }
}
