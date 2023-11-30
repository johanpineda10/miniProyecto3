package controlador;
import modelo.Candidato;
import vista.App;

// Controlador.java
import java.util.ArrayList;


public class Controlador {
    private ArrayList<Candidato> candidatos = new ArrayList<>();

    public Controlador(App vista) {
    }

    public void mostrarVentanaInsertar() {
        //Agregar logica.
    }

    public void mostrarVentanaActualizar() {
        //Agregar logica.
    }

    public void mostrarVentanaEliminar() {
        //Agregar logica.
    }

    public void mostrarVentanaListar() {
        //Agregar logica.
    }

    public void mostrarVentanaResultados() {
        //Agregar logica.
    }

    public void mostrarVentanaGanador() {
        //Agregar logica.
    }

    public void mostrarCiudadesConMenosCandidatos() {
        //Agregar logica.
        }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Controlador(new App());
            }
        });
    }

    public void setVista(App app) {
    }

    public void inicializar() {
    }
}

