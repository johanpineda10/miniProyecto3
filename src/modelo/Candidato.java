package modelo;

// Candidato.java
import java.util.Objects;

public class Candidato {
    private String nombre;
    private int cedula;
    private String ciudad;
    private String partido;
    public int votos;

    public Candidato(String nombre, int cedula, String ciudad, String partido) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.partido = partido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return cedula == candidato.cedula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
