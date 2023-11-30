package controlador;

import modelo.Candidatos;
import vistas.vistaCandidatoGUI;
import vistas.vistaCandidatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControladorCandidatos  implements ActionListener{

    private String[] ciudades = {"Cali", "Buga", "Palmira", "Tulua", "Cartago", "Bugalagrande", "Buenaventura", "Yumbo"};
    private String[] partidos = {"Partido Liberal", "Partido Conservador", "Liga", "AICO", "Partido Verde", "Union Patriótica", "Centro Democratico", "Partido de la U", "Cambio Radical"};
    
    Candidatos candidato;
    vistaCandidatos vista;

    private ArrayList<Candidatos> candidatos = new ArrayList<>();

    public ControladorCandidatos(Candidatos candidato, vistaCandidatos vista) {
        this.candidato = candidato;
        this.vista = vista;

    }

    public void iniciarVista(){
        vista.iniciar(this);
    
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e != null){
            if(e.getSource() == vistaCandidatoGUI.crear){
                mostrarVentanaInsertar();
            }
            if(e.getSource() == vistaCandidatoGUI.sali){
            vistaCandidatoGUI.frame.setVisible(false);
            vistaCandidatoGUI.frame.dispose();
            System.out.println("Si");
            }
        }

        /*candidato.setNombre(vista.getNombre());
        candidato.setCedula(vista.getCedula());
        candidato.setIdeologia(vista.getIdeologia());
        candidato.setCiudades(""+vista.getCiudad());
        candidato.setPartido(""+vista.getPartido());*/

    }
    public void mostrarVentanaInsertar() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del candidato:");
        if (nombre == null) {
            return;
        }

        int cedula;
        while (true) {
            String cedulaStr = JOptionPane.showInputDialog("Ingrese el numero de cedula:");
            if (cedulaStr == null) {
                return;
            }
            try {
                cedula = Integer.parseInt(cedulaStr);
                boolean cedulaRepetida = false;
                for (Candidatos candidato : candidatos) {
                    if (candidato.getCedula() == cedula) {
                        cedulaRepetida = true;
                        break;
                    }
                }
                if (!cedulaRepetida) {
                    break;
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "La cedula ya esta registrada. ¿Desea ingresar una cedula diferente?", "Cedula Repetida", JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.NO_OPTION) {
                        return;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero de cedula valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String ciudad = (String) JOptionPane.showInputDialog(null, "Elija la ciudad:",
                "Ciudad", JOptionPane.QUESTION_MESSAGE, null, ciudades, ciudades[0]);

        String partido = (String) JOptionPane.showInputDialog(null, "Elija el partido politico:",
                "Partido Politico", JOptionPane.QUESTION_MESSAGE, null, partidos, partidos[0]);

        candidatos.add(new Candidatos(nombre, cedula, ciudad, partido));
        mostrarMensaje("Candidato ingresado exitosamente.");
    }

    public void mostrarVentanaActualizar() {
        if (candidatos.isEmpty()) {
            mostrarMensaje("No hay candidatos ingresados.");
            return;
        }

        int cedulaActualizar;
        while (true) {
            String cedulaStr = JOptionPane.showInputDialog("Ingrese la cedula del candidato a actualizar:");
            if (cedulaStr == null) {
                return;
            }
            try {
                cedulaActualizar = Integer.parseInt(cedulaStr);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero de cedula valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        Candidatos candidatoAActualizar = null;

        for (Candidatos candidato : candidatos) {
            if (candidato.getCedula() == cedulaActualizar) {
                candidatoAActualizar = candidato;
                break;
            }
        }

        if (candidatoAActualizar != null) {
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
            if (nuevoNombre == null) {
                return;
            }

            String nuevaCiudad = (String) JOptionPane.showInputDialog(null, "Elija la nueva ciudad:",
                    "Ciudad", JOptionPane.QUESTION_MESSAGE, null, ciudades, candidatoAActualizar.getCiudad());
            if (nuevaCiudad == null) {
                return;
            }

            String nuevoPartido = (String) JOptionPane.showInputDialog(null, "Elija el nuevo partido politico:",
                    "Partido Politico", JOptionPane.QUESTION_MESSAGE, null, partidos, candidatoAActualizar.getPartido());
            if (nuevoPartido == null) {
                return;
            }

            candidatoAActualizar.setNombre(nuevoNombre);
            candidatoAActualizar.setCiudad(nuevaCiudad);
            candidatoAActualizar.setPartido(nuevoPartido);
            mostrarMensaje("Candidato actualizado exitosamente.");
        } else {
            mostrarMensaje("Candidato no encontrado.");
        }
    }

    public void mostrarVentanaEliminar() {
        if (candidatos.isEmpty()) {
            mostrarMensaje("No hay candidatos ingresados.");
            return;
        }

        int cedulaEliminar;
        while (true) {
            String cedulaStr = JOptionPane.showInputDialog("Ingrese la cedula del candidato a eliminar:");
            if (cedulaStr == null) {
                return;
            }
            try {
                cedulaEliminar = Integer.parseInt(cedulaStr);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero de cedula valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        Candidatos candidatoAEliminar = null;

        for (Candidatos candidato : candidatos) {
            if (candidato.getCedula() == cedulaEliminar) {
                candidatoAEliminar = candidato;
                break;
            }
        }

        if (candidatoAEliminar != null) {
            candidatos.remove(candidatoAEliminar);
            mostrarMensaje("Candidato eliminado exitosamente.");
        } else {
            mostrarMensaje("Candidato no encontrado.");
        }
    }

    public void mostrarVentanaBuscar() {
        if (candidatos.isEmpty()) {
            mostrarMensaje("No hay candidatos ingresados.");
            return;
        }

        int cedulaBuscar;
        while (true) {
            String cedulaStr = JOptionPane.showInputDialog("Ingrese la cedula del candidato a buscar:");
            if (cedulaStr == null) {
                return;
            }
            try {
                cedulaBuscar = Integer.parseInt(cedulaStr);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número de cedula valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        Candidatos candidatoABuscar = null;

        for (Candidatos candidato : candidatos) {
            if (candidato.getCedula() == cedulaBuscar) {
                candidatoABuscar = candidato;
                break;
            }
        }

        if (candidatoABuscar != null) {
            mostrarMensaje("Candidato encontrado:\nNombre: " + candidatoABuscar.getNombre() + "\nCedula: " + candidatoABuscar.getCedula() + "\nCiudad: " + candidatoABuscar.getCiudad() + "\nPartido Político: " + candidatoABuscar.getPartido());
        } else {
            mostrarMensaje("Candidato no encontrado.");
        }
    }

    public void mostrarVentanaListar() {
        if (candidatos.isEmpty()) {
            mostrarMensaje("No hay candidatos ingresados.");
        } else {
            StringBuilder listaCandidatos = new StringBuilder("Lista de todos los candidatos:\n");

            for (Candidatos candidato : candidatos) {
                listaCandidatos.append("Nombre: ").append(candidato.getNombre()).append("\n");
                listaCandidatos.append("Cedula: ").append(candidato.getCedula()).append("\n");
                listaCandidatos.append("Ciudad: ").append(candidato.getCiudad()).append("\n");
                listaCandidatos.append("Partido Politico: ").append(candidato.getPartido()).append("\n");
                listaCandidatos.append("--------------------\n");
            }

            JTextArea textArea = new JTextArea(listaCandidatos.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(null, scrollPane);
        }
    }

    public void mostrarVentanaVotos() {
        //logica
    }

    public void mostrarVentanaResultados() {
        //logica
    }

    public void mostrarVentanaGanador() {
        //logica
    }
    public void mostrarCiudadesConMenosCandidatos() {
        //logica
    }
    

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showOptionDialog(null, mensaje, "Mensaje", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, "OK");
    }

}
