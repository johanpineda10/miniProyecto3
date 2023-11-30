package vista;
import controlador.Controlador;

// App.java
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class App {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void iniciarInterfazGrafica() {
        JFrame frame = new JFrame("Sistema de Candidatos y Votos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 250);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JMenuBar barra = new JMenuBar();
        JMenu creacion = new JMenu("CREACION");
        creacion.setFont(new Font("Times New Roman", Font.BOLD, 20));
        JMenu visualizar = new JMenu("VISUALIZAR");
        visualizar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        JMenu votos = new JMenu("VOTOS");
        votos.setFont(new Font("Times New Roman", Font.BOLD, 20));
        JMenu salir = new JMenu("SALIR");
        salir.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JMenuItem crear = new JMenuItem("Crear candidato");
        crear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem modificar = new JMenuItem("Modificar candidato");
        modificar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem eliminar = new JMenuItem("Eliminar candidato");
        eliminar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem verNombre = new JMenuItem("Buscar candidato");
        verNombre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem verTodos = new JMenuItem("Todos los candidatos");
        verTodos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem sali = new JMenuItem("Salir");
        sali.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem canVotos = new JMenuItem("Cantidad votos");
        canVotos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem resulVotos = new JMenuItem("Resultado votos");
        resulVotos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JMenuItem conFinal = new JMenuItem("Conteo Final");
        conFinal.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        creacion.add(crear);
        creacion.add(modificar);
        creacion.add(eliminar);
        visualizar.add(verNombre);
        visualizar.add(verTodos);
        votos.add(canVotos);
        votos.add(resulVotos);
        votos.add(conFinal);
        salir.add(sali);

        barra.add(creacion);
        barra.add(visualizar);
        barra.add(votos);
        barra.add(salir);

        panel.add(barra);
        frame.add(panel);
        frame.setVisible(true);}



        // Configurar los eventos.--------------------------// No olvidar ---- 





    public void iniciarConsola() {
        // implementar la lógica para la versión de consola aquí
        // Por ahora, solo imprime un mensaje de demostración
        System.out.println("La versión de consola está en desarrollo.");
    }

    public void iniciarMenu() {
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
            iniciarInterfazGrafica();
        } else {
            iniciarConsola();
        }
    }

    public static void main(String[] args) {
        App app = new App();
        Controlador controlador = new Controlador(app);
        app.setControlador(controlador);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                app.iniciarMenu();
            }
        });
    }
}





