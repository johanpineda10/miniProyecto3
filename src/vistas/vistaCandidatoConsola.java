package vistas;

public class vistaCandidatoConsola implements vistaCandidatos{

    @Override
    public void iniciar() {
        System.out.println("Bienvenido candidato");
        System.out.println("Ingrese la opcion deseada: ");
        System.out.println("1. Agregar candidato");
        System.out.println("2. Modificar candidato");
        System.out.println("3. Eliminar candidato");
        System.out.println("4. Listar candidato por nombre");
        System.out.println("5. Listar todos los candidatos");
        System.out.println("6. Salir");
    }

    @Override
    public String getNombre() {
        
    }

    @Override
    public String getCedula() {
        
    }

    @Override
    public String getPartido() {
        
    }

    @Override
    public String getCiudad() {
        
    }

    @Override
    public String getIdeologia() {
        
    }
    
}
