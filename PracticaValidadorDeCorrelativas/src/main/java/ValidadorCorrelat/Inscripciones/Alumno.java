package ValidadorCorrelat.Inscripciones;

import java.util.List;
import java.util.Set;

public class Alumno {
    private Set<Materia> materiasAprobadas;
    public Alumno(Set<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    protected Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
}
