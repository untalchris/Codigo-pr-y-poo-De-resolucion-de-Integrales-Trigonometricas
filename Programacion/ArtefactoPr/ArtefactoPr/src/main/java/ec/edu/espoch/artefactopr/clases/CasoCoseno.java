package ec.edu.espoch.artefactopr.clases;

import reactor.core.publisher.Mono;

public class CasoCoseno extends ProcesoResolucionReactiva{
    public CasoCoseno(String valor) {
        super(valor);
    }

    public Mono<String> integralCoseno() {
        return resolverArgumento().map(resultado -> "Sen(" + getValo() + ")/" + resultado + " +c");
    }
}
