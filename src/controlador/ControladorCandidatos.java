package controlador;

import modelo.Candidatos;
import vistas.vistaCandidatoGUI;
import vistas.vistaCandidatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCandidatos  implements ActionListener{
    
    Candidatos candidato;
    vistaCandidatos vista;

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
}
