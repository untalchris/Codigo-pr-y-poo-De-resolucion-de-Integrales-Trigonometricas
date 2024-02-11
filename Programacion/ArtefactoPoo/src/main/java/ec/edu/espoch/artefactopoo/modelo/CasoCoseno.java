
package ec.edu.espoch.artefactopoo.modelo;


public class CasoCoseno extends ProcesoResolucion {
    public String procesoCoseno(){
        return "∫ "+getValor()+" dx";
    }
    
    public String integralCoseno(){
        separarValores();
        return "Sen(" + getValo() + ")/" + resolverArgumento() + " +c" ;
    }   
}
