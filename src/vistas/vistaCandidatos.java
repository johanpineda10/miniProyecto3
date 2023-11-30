package vistas;

import controlador.ControladorCandidatos;
import modelo.Ciudades;
import modelo.Partidos;

public interface vistaCandidatos {
    public void iniciar(ControladorCandidatos candidato);
    public String getNombre();
    public String getCedula();
    public Partidos getPartido();
    public Ciudades getCiudad();
    public int getIdeologia();
    public void setNombre();
    public void setCedula();
    public void setIdeologia();
    public void setPartido();
    public void setCiudades();
    
}
