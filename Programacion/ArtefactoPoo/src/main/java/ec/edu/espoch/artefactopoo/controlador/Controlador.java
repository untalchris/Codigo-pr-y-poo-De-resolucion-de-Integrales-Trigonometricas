package ec.edu.espoch.artefactopoo.controlador;

import ec.edu.espoch.artefactopoo.modelo.CasoCoseno;
import ec.edu.espoch.artefactopoo.modelo.CasoSeno;
import ec.edu.espoch.artefactopoo.modelo.CasoTangente;
import ec.edu.espoch.artefactopoo.vista.Interfaz;

public class Controlador {
    //Atributos
    private Interfaz vista;
    private CasoCoseno casoCoseno;
    private CasoSeno casoSeno;
    private CasoTangente casoTangente;
    
    //Constructor
    public Controlador(Interfaz vista) {
        this.vista = vista;
        this.casoCoseno = new CasoCoseno();
        this.casoSeno = new CasoSeno();
        this.casoTangente = new CasoTangente();
    }
    
    //Metodos
    public void AccionResolver(){
        
        String funcion = String.valueOf(this.vista.geteFuncion());
        long inicioTiempo = System.nanoTime();
        if(funcion.contains("sen") || funcion.contains("Sen")){
            this.casoSeno.setValor(funcion);
            this.vista.mostrarResultado(this.casoSeno.procesoSeno(), this.casoSeno.integralSeno());
        }else if(funcion.contains("cos") || funcion.contains("Cos")){
            this.casoCoseno.setValor(funcion);
            this.vista.mostrarResultado(this.casoCoseno.procesoCoseno(), this.casoCoseno.integralCoseno());
        }else if(funcion.contains("tan") || funcion.contains("Tan")){
            this.casoTangente.setValor(funcion);
            this.vista.mostrarResultado(this.casoTangente.procesoTangente(), this.casoTangente.integralTangente());
        }
        long finTiempo = System.nanoTime();
        long tiempoTotal = finTiempo - inicioTiempo;
        System.out.println("La operacion tomo "+ tiempoTotal + " microsegundos.");
    }
    
}
