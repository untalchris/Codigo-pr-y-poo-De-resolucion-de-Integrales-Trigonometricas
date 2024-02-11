package ec.edu.espoch.artefactopr.clases;

import reactor.core.publisher.Mono;

public class CasoSeno extends ProcesoResolucionReactiva{
    public CasoSeno(String valor) {
        super(valor);
    }

    public Mono<String> integralSeno() {
        return resolverArgumento().map(resultado -> "- Cos(" + getValo() + ")/" + resultado + " +c");
    }
}
