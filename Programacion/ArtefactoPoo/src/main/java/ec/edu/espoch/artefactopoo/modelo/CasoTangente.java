
package ec.edu.espoch.artefactopoo.modelo;


public class CasoTangente extends ProcesoResolucion {
    public String procesoTangente(){ 
        return "∫ "+getValor()+" dx";
    }
    
    public String integralTangente(){
        separarValores();
        return "In(Sec(" + getValo() + "))/" + resolverArgumento() + " +c" ;
    }   
}
