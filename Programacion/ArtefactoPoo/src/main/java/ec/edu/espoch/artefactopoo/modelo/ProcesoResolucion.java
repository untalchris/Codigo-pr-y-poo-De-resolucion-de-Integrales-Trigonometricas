package ec.edu.espoch.artefactopoo.modelo;


public class ProcesoResolucion {
    //Atributos
    private String valor;
    private String valo;
    private String[] valoresSeparados;
    
    //Contructor
    public ProcesoResolucion() {
    }
    
    //Getter y Setter
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getValo() {
        return valo;
    }
    public void setValo(String valo) {
        this.valo = valo;
    }
    
    //Metodos
    public String[] separarValores(){
        String v = this.valor;
        if (v.contains("Sen")){
            String va = v.replace("Sen","");
            String val = va.replace("(","");
            valo = val.replace(")","");
            valoresSeparados = valo.split(" ");

        }else if(v.contains("Cos")){
            String va = v.replace("Cos","");
            String val = va.replace("(","");
            valo = val.replace(")","");
            valoresSeparados = valo.split(" ");
     
        }else if(v.contains("Tan")){
            String va = v.replace("Tan","");
            String val = va.replace("(","");
            valo = val.replace(")","");
            valoresSeparados = valo.split(" ");
        }
        return valoresSeparados;
    }
    
    public String resolverArgumento(){
       
        String resultado = "";
        boolean verifivarPrimerTermino = false;

        //Coger cada termino e ir identificanto y extrayendo el valor del coefficiente y exponente
        for (String terminos : valoresSeparados) {
            int valorCoeficiente;
            int valorExponente;

            boolean valcanX = false;

            if (terminos.contains("x")) {
                valcanX = true;

                String xd = terminos.substring(0, terminos.indexOf("x"));

                if (xd.isEmpty() || xd.equals("+")) {
                    valorCoeficiente = 1;
                } else if (xd.equals("-")) {
                    valorCoeficiente = -1;
                } else {
                    valorCoeficiente = Integer.parseInt(xd);
                }

                if (terminos.contains("^")) {
                    String e = terminos.substring(terminos.indexOf("^") + 1);

                    valorExponente = Integer.parseInt(e);
                } else {
                    valorExponente = 1;
                }
            } else {
                valcanX = false;

                valorCoeficiente = Integer.parseInt(terminos);

                valorExponente = 0;
            }

            //Aplicar formula segun el caso usando estructuras condicionales
            String resultadoProceso;
            if (valcanX & valorExponente != 1 & valorExponente != 2) {
                int nuevoExponente = valorExponente - 1;

                int nuevoCoeficiente = valorCoeficiente * valorExponente;

                String nuevoCoeficienteString = String.valueOf(nuevoCoeficiente);
                String nuevoExponenteString = String.valueOf(nuevoExponente);

                resultadoProceso = nuevoCoeficienteString + "x^" + nuevoExponenteString;
            } else if (valcanX & valorExponente == 2) {

                int nuevoCoeficiente = valorCoeficiente * valorExponente;

                String nuevoCoeficienteString = String.valueOf(nuevoCoeficiente);
                resultadoProceso = nuevoCoeficienteString + "x";
            } else if (valcanX & valorExponente == 1) {
                String nuevoCoeficienteString = String.valueOf(valorCoeficiente);
                resultadoProceso = nuevoCoeficienteString;
            } else {
                resultadoProceso = "";
            }
            
            //Concatenar los valores de los terminos
            if (!verifivarPrimerTermino) {
                resultado = resultado + resultadoProceso;
                verifivarPrimerTermino = true;
            } else {
                if (valorCoeficiente > 0) {
                    resultado = resultado + "  +" + resultadoProceso;
                } else {
                    resultado = resultado + "  " + resultadoProceso;
                }
            }
        }
        return resultado;
    }
    
}  

