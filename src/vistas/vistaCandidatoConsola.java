package vistas;

import controlador.ControladorCandidatos;
import modelo.Ciudades;
import modelo.Partidos;
import modelo.Candidatos;

import java.util.ArrayList;
import java.util.Scanner;

public class vistaCandidatoConsola implements vistaCandidatos {

    static ArrayList<Candidatos> candidatos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    String nombre, cedula, partidoPol, ciudadOri;
    int ideologia;
    Partidos partido;
    Ciudades ciudad;

    @Override
    public void iniciar(ControladorCandidatos candidato) {

        while (true) {
            System.out.println("Bienvenido candidato");
            System.out.println("Ingrese la opcion deseada: ");
            System.out.println("1. Agregar candidato");
            System.out.println("2. Modificar candidato");
            System.out.println("3. Eliminar candidato");
            System.out.println("4. Listar candidato por nombre");
            System.out.println("5. Listar todos los candidatos");
            System.out.println("6. Salir");
            Scanner scanner = new Scanner(System.in);
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    agregarCandidato();
                    break;
                case 2:
                    modificarCandidato();
                    break;
                case 3:
                    eliminarCandidato();
                    break;
                case 4:
                    listarCandidatoPorNombre();
                    break;
                case 5:
                    listarTodosLosCandidatos();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    private void agregarCandidato() {
        System.out.println("Ingrese el nombre del candidato: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese la cedula del candidato: ");
        cedula = scanner.nextLine();
        System.out.println("Ingrese el partido del candidato: ");
        partidoPol = scanner.next();
        partido = Partidos.valueOf(partidoPol.toUpperCase());
        System.out.println("Ingrese la ciudad de origen: ");
        ciudadOri = scanner.next();
        ciudad = Ciudades.valueOf(ciudadOri.toUpperCase());
        System.out.println("Ingrese su ideologia politica (1. Izquierda - 2. Derecha)");
        ideologia = scanner.nextInt();
        scanner.nextLine();

        Candidatos nuevoCandidato = new Candidatos(nombre, cedula, partido, ciudad, ideologia);
        candidatos.add(nuevoCandidato);
        System.out.println("Candidato creado exitosamente");
    }

    private void modificarCandidato() {
        System.out.println("Ingrese el nombre del candidato a modificar: ");
        String nombreModificar = scanner.nextLine();

        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreModificar)) {
                System.out.println("Ingrese la nueva ideologia politica (1. Izquierda - 2. Derecha): ");
                int nuevaIdeologia = scanner.nextInt();
                scanner.nextLine();
                candidato.setIdeologia(nuevaIdeologia);
                System.out.println("Candidato modificado exitosamente");
                return;
            }
        }

        System.out.println("Candidato no encontrado");
    }

    private void eliminarCandidato() {
        System.out.println("Ingrese el nombre del candidato a eliminar: ");
        String nombreEliminar = scanner.nextLine();

        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreEliminar)) {
                candidatos.remove(candidato);
                System.out.println("Candidato eliminado exitosamente");
                return;
            }
        }

        System.out.println("Candidato no encontrado");
    }

    private void listarCandidatoPorNombre() {
        System.out.println("Ingrese el nombre del candidato a listar: ");
        String nombreListar = scanner.nextLine();

        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreListar)) {
                System.out.println(candidato);
                return;
            }
        }

        System.out.println("Candidato no encontrado");
    }

    private void listarTodosLosCandidatos() {
        for (Candidatos candidato : candidatos) {
            System.out.println(candidato);
        }
    }
    
    public class Candidatos {
        private String nombre;
        private String cedula;
        private Partidos partido;
        private Ciudades ciudad;
        private int ideologia;
    
        public Candidatos(String nombre, String cedula, Partidos partido, Ciudades ciudad, int ideologia) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.partido = partido;
            this.ciudad = ciudad;
            this.ideologia = ideologia;
        }
    
        // Getters
        public String getNombre() {
            return nombre;
        }
    
        public String getCedula() {
            return cedula;
        }
    
        public Partidos getPartido() {
            return partido;
        }
    
        public Ciudades getCiudad() {
            return ciudad;
        }
    
        public int getIdeologia() {
            return ideologia;
        }
    
        // Setters
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public void setCedula(String cedula) {
            this.cedula = cedula;
        }
    
        public void setPartido(Partidos partido) {
            this.partido = partido;
        }
    
        public void setCiudad(Ciudades ciudad) {
            this.ciudad = ciudad;
        }
    
        public void setIdeologia(int ideologia) {
            this.ideologia = ideologia;
        }
    
        @Override
        public String toString() {
            return "Candidato{" +
                    "nombre='" + nombre + '\'' +
                    ", cedula='" + cedula + '\'' +
                    ", partido=" + partido +
                    ", ciudad=" + ciudad +
                    ", ideologia=" + ideologia +
                    '}';
        }
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
