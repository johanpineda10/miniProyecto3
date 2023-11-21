package modelo;

public class Candidatos {
    private String nombre, cedula;
    private int ideologia;
    private Ciudades ciudades;
    private Partidos partido;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public int getIdeologia() {
        return ideologia;
    }
    public void setIdeologia(int ideologia) {
        this.ideologia = ideologia;
    }
    public Ciudades getCiudades() {
        return ciudades;
    }
    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }
    public Partidos getPartido() {
        return partido;
    }
    public void setPartido(Partidos partido) {
        this.partido = partido;
    }

    
}
