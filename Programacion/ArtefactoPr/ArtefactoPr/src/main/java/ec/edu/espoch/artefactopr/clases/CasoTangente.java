package ec.edu.espoch.artefactopr.clases;

import reactor.core.publisher.Mono;

public class CasoTangente extends ProcesoResolucionReactiva{
    public CasoTangente(String valor) {
        super(valor);
    }

    public Mono<String> integralTangente() {
        return resolverArgumento().map(resultado -> "In(Sec(" + getValo() + "))/ " + resultado + " +c");
    }
    
}
