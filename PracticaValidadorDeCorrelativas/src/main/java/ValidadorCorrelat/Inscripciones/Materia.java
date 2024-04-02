package ValidadorCorrelat.Inscripciones;

import java.util.Set;

public class Materia {
    private Set<Materia> correlativas;

    public Materia(Set<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public boolean cumpleCorrelatividad(Set<Materia> materiasAprobadas) {
        return correlativas.isEmpty() || materiasAprobadas.containsAll(correlativas);
    }
}
