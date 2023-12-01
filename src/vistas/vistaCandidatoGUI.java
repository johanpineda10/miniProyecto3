package vistas;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controlador.ControladorCandidatos;
import java.awt.Font;
import modelo.Ciudades;
import modelo.Partidos;

public class vistaCandidatoGUI extends JFrame implements vistaCandidatos{

    public static JFrame frame;
    private String[] ciudades = {"Cali", "Buga", "Palmira", "Tulua", "Cartago", "Bugalagrande", "Buenaventura", "Yumbo"};
    private String[] partidos = {"Partido Liberal", "Partido Conservador", "Liga", "AICO", "Partido Verde", "Union Patriótica", "Centro Democratico", "Partido de la U", "Cambio Radical"};
    private JMenuBar barra;
    private JMenu creacion, visualizar, votos, salir;
    public static JMenuItem crear, modificar, eliminar, verNombre, verTodos, sali, canVotos, resulVotos, conFinal;

    public vistaCandidatoGUI(){
        frame = new JFrame("Sistema de Candidatos y Votos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 250);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        
        barra = new JMenuBar();
        creacion = new JMenu("CREACION");
        creacion.setFont(new Font("Times New Roman", Font.BOLD, 20));
        visualizar = new JMenu("VISUALIZAR");
        visualizar.setFont(new Font("Times New Roman", Font.BOLD, 20));

        votos = new JMenu("VOTOS");
        votos.setFont(new Font("Times New Roman", Font.BOLD, 20));
        salir = new JMenu("SALIR");
        salir.setFont(new Font("Times New Roman", Font.BOLD, 20));

        crear = new JMenuItem("Crear candidato");
        crear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        modificar = new JMenuItem("Modificar candidato");
        modificar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        eliminar = new JMenuItem("Eliminar candidato");
        eliminar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        verNombre = new JMenuItem("Buscar candidato");
        verNombre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        verTodos = new JMenuItem("Todos los candidatos");
        verTodos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        sali = new JMenuItem("Salir");
        sali.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        canVotos = new JMenuItem("Cantidad votos");
        canVotos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        resulVotos = new JMenuItem("Resultado votos");
        resulVotos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        conFinal = new JMenuItem("Conteo Final");
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
        
    }

    public void iniciar(ControladorCandidatos candidato) {
        crear.addActionListener(candidato);
        modificar.addActionListener(candidato);
        eliminar.addActionListener(candidato);
        sali.addActionListener(candidato);
        verNombre.addActionListener(candidato);
        verTodos.addActionListener(candidato);
        canVotos.addActionListener(candidato);
        resulVotos.addActionListener(candidato);
        conFinal.addActionListener(candidato);
        frame.setVisible(true);
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    @Override
    public String getCedula() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCedula'");
    }

    @Override
    public Partidos getPartido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPartido'");
    }

    @Override
    public Ciudades getCiudad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCiudad'");
    }

    @Override
    public int getIdeologia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdeologia'");
    }

    @Override
    public void setNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    @Override
    public void setCedula() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCedula'");
    }

    @Override
    public void setIdeologia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIdeologia'");
    }

    @Override
    public void setPartido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPartido'");
    }

    @Override
    public void setCiudades() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCiudades'");
    }