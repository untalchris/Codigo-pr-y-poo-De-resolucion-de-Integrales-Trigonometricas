
package ec.edu.espoch.artefactopoo.modelo;


public class CasoSeno extends ProcesoResolucion {
    public String procesoSeno(){
        return "∫ "+getValor()+" dx";
    }
    
    public String integralSeno(){
        separarValores();
        return "- Cos(" + getValo() + ")/" + resolverArgumento() + " +c" ;
    }
    
}
