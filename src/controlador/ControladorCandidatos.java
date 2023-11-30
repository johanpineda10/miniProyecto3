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
            if(e.getSource() == vistaCandidatoGUI.modificar){
                mostrarVentanaActualizar();
            }
            if(e.getSource() == vistaCandidatoGUI.eliminar){
                mostrarVentanaEliminar();
            }
            if(e.getSource()== vistaCandidatoGUI.verNombre){
                mostrarVentanaBuscar();
            }
            if(e.getSource() == vistaCandidatoGUI.verTodos){
                mostrarVentanaListar();
            }
            if(e.getSource() == vistaCandidatoGUI.canVotos){
                mostrarVentanaVotos();
            }
            if(e.getSource() == vistaCandidatoGUI.resulVotos){
                mostrarVentanaResultados();
            }
            if(e.getSource() == vistaCandidatoGUI.conFinal){
                mostrarVentanaGanador();
            }
            if(e.getSource() == vistaCandidatoGUI.sali){
            vistaCandidatoGUI.frame.setVisible(false);
            vistaCandidatoGUI.frame.dispose();
            }
        }

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
        for (Candidatos candidato : candidatos) {
            String votosStr = JOptionPane.showInputDialog("Ingrese la cantidad de votos para " + candidato.getNombre() + ":");
            if (votosStr == null) {
                return;
            }

            try {
                int votosIngresar = Integer.parseInt(votosStr);
                candidato.setVotos(votosIngresar);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero de votos valido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        mostrarMensaje("Votos ingresados exitosamente.");
    }

    public void mostrarVentanaResultados() {
        candidatos.sort((c1, c2) -> Integer.compare(c2.getVotos(), c1.getVotos()));
        StringBuilder resultados = new StringBuilder("Resultados de las Elecciones (de mayor a menor número de votos):\n");
    
        for (Candidatos candidato : candidatos) {
            resultados.append("Nombre: ").append(candidato.getNombre()).append("\n");
            resultados.append("Cédula: ").append(candidato.getCedula()).append("\n");
            resultados.append("Partido Político: ").append(candidato.getPartido()).append("\n");
            resultados.append("Votos: ").append(candidato.getVotos()).append("\n\n");
        }
    
        JTextArea textArea = new JTextArea(resultados.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
    
        JFrame resultadosFrame = new JFrame("Resultados de las Elecciones");
        resultadosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultadosFrame.getContentPane().add(scrollPane);
        resultadosFrame.pack();
        resultadosFrame.setVisible(true);

        mostrarCiudadesConMenosCandidatos();
    }

    public void mostrarVentanaGanador() {
        Candidatos ganador = candidatos.get(0);
    
        StringBuilder mensajeGanador = new StringBuilder("Ganador de las Elecciones:\n");
        mensajeGanador.append("Nombre: ").append(ganador.getNombre()).append("\n");
        mensajeGanador.append("Cédula: ").append(ganador.getCedula()).append("\n");
        mensajeGanador.append("Partido Político: ").append(ganador.getPartido()).append("\n");
    
        JOptionPane.showMessageDialog(null, mensajeGanador.toString(), "Ganador de las Elecciones", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showOptionDialog(null, mensaje, "Mensaje", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, "OK");
    }

    public void mostrarCiudadesConMenosCandidatos() {
        Map<String, Integer> ciudadCandidatosCount = new HashMap<>();

        for (Candidatos candidato : candidatos) {
            String ciudad = candidato.getCiudad();
            ciudadCandidatosCount.put(ciudad, ciudadCandidatosCount.getOrDefault(ciudad, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedCiudades = ciudadCandidatosCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        int numCiudadesAMostrar = Math.min(3, sortedCiudades.size());

        StringBuilder ciudadesConMenosCandidatos = new StringBuilder("Ciudades con menos candidatos inscritos:\n");

        for (int i = 0; i < numCiudadesAMostrar; i++) {
            String ciudad = sortedCiudades.get(i).getKey();
            int candidatosCount = sortedCiudades.get(i).getValue();
            ciudadesConMenosCandidatos.append(ciudad).append(": ").append(candidatosCount).append(" candidatos\n");
        }

        JOptionPane.showMessageDialog(null, ciudadesConMenosCandidatos.toString());
    }

}
