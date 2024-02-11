package ec.edu.espoch.artefactopr.clases;

import ec.edu.espoch.artefactopr.igu.Interfaz;
import reactor.core.publisher.Mono;

public class ProcesoResolucionReactiva {
    Mono<String> valorMono;
    String valo;

    public String getValo() {
        return valo;
    }

    
    
    public ProcesoResolucionReactiva(String valor) {
        this.valorMono = Mono.just(valor);
    }

    public Mono<String[]> separarValores() {
        return valorMono.map(v -> {

            if (v.contains("Sen")) {
                String va = v.replace("Sen", "");
                String val = va.replace("(", "");
                valo = val.replace(")", "");
                return valo.split(" ");
            } else if (v.contains("Cos")) {
                String va = v.replace("Cos", "");
                String val = va.replace("(", "");
                valo = val.replace(")", "");
                return valo.split(" ");
            } else if (v.contains("Tan")) {
                String va = v.replace("Tan", "");
                String val = va.replace("(", "");
                valo = val.replace(")", "");
                return valo.split(" ");
            }
            return new String[]{};
        });
    }

    public Mono<String> resolverArgumento() {
        return separarValores().map(valores -> {
            String resultado = "";
            boolean verificarPrimerTermino = false;

            // Coger cada término e ir identificando y extrayendo el valor del coeficiente y exponente
            for (String terminos : valores) {
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

                // Aplicar la fórmula según el caso usando estructuras condicionales
                String resultadoProceso;
                if (valcanX && valorExponente != 1 && valorExponente != 2) {
                    int nuevoExponente = valorExponente - 1;

                    int nuevoCoeficiente = valorCoeficiente * valorExponente;

                    String nuevoCoeficienteString = String.valueOf(nuevoCoeficiente);
                    String nuevoExponenteString = String.valueOf(nuevoExponente);

                    resultadoProceso = nuevoCoeficienteString + "x^" + nuevoExponenteString;
                } else if (valcanX && valorExponente == 2) {

                    int nuevoCoeficiente = valorCoeficiente * valorExponente;

                    String nuevoCoeficienteString = String.valueOf(nuevoCoeficiente);
                    resultadoProceso = nuevoCoeficienteString + "x";
                } else if (valcanX && valorExponente == 1) {
                    String nuevoCoeficienteString = String.valueOf(valorCoeficiente);
                    resultadoProceso = nuevoCoeficienteString;
                } else {
                    resultadoProceso = "";
                }

                // Concatenar los valores de los términos
                if (!verificarPrimerTermino) {
                    resultado = resultado + resultadoProceso;
                    verificarPrimerTermino = true;
                } else {
                    if (valorCoeficiente > 0) {
                        resultado = resultado + "  +" + resultadoProceso;
                    } else {
                        resultado = resultado + "  " + resultadoProceso;
                    }
                }
            }
            return resultado;
        });
    }
    public Mono<String> Res(Interfaz vista) {
        if (vista.geteFuncion().contains("Sen")) {
            CasoSeno casoSeno = new CasoSeno(vista.geteFuncion());
            return casoSeno.integralSeno();
        } else if (vista.geteFuncion().contains("Cos")) {
            CasoCoseno casoCoseno = new CasoCoseno(vista.geteFuncion());
            return casoCoseno.integralCoseno();
        } else if (vista.geteFuncion().contains("Tan")) {
            CasoTangente casoTangente = new CasoTangente(vista.geteFuncion());
            return casoTangente.integralTangente();
        }
        return Mono.empty();
    }
}
