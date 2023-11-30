package vistas;

import java.util.Scanner;

import controlador.ControladorCandidatos;
import modelo.Ciudades;
import modelo.Partidos;

public class vistaCandidatoConsola implements vistaCandidatos{

    String nombre, cedula, partidoPol, ciudadOri; 
    int ideologia;  
    Partidos partido;
    Ciudades ciudad;
    
    @Override
    public void iniciar(ControladorCandidatos candidato) {
        System.out.println("Bienvenido candidato");
        System.out.println("Ingrese la opcion deseada: ");
        System.out.println("1. Agregar candidato");
        System.out.println("2. Modificar candidato");
        System.out.println("3. Eliminar candidato");
        System.out.println("4. Listar candidato por nombre");
        System.out.println("5. Listar todos los candidatos");
        System.out.println("6. Salir");
        Scanner scaner = new Scanner(System.in);
        int opc = scaner.nextInt();
        scaner.nextLine(); 

        switch (opc) {
            case 1:
                System.out.println("Ingrese el nombre del candidato: ");
                nombre = scaner.nextLine();
                System.out.println("Ingrese la cedula del candidato: ");
                cedula = scaner.nextLine();
                System.out.println("Ingrese el partido del candidato: ");
                partidoPol = scaner.next();
                partido = Partidos.valueOf(partidoPol.toUpperCase());
                System.out.println("Ingrese la ciudad de origen: ");
                ciudadOri = scaner.next();
                ciudad = Ciudades.valueOf(ciudadOri.toUpperCase());
                System.out.println("Ingrese su ideologia politica (1. Izquierda - 2. Derecha)");
                ideologia = scaner.nextInt();
                scaner.nextLine();
                System.out.println("Candidato creado exitosamente");
                break;
        
            default:
                System.out.println("Opcion no valida");
        }
        candidato.actionPerformed(null);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getCedula() {
        return cedula;
    }

    @Override
    public Partidos getPartido() {
        return partido;
    }

    @Override
    public Ciudades getCiudad() {
        return ciudad;
    }

    @Override
    public int getIdeologia() {
        return ideologia;
    }

    @Override
    public void setNombre() {
    }

    @Override
    public void setCedula() {
        
    }

    @Override
    public void setIdeologia() {
        
    }

    @Override
    public void setPartido() {
        
    }

    @Override
    public void setCiudades() {
        
    }
    
}
