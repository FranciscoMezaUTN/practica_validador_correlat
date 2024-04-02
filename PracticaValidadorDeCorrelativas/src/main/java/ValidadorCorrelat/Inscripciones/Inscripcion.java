package ValidadorCorrelat.Inscripciones;

import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasAInscribir;
    public boolean aprobada(){

        return this.materiasAInscribir.stream().allMatch(materia -> materia.cumpleCorrelatividad(alumno.getMateriasAprobadas()));
    }

    public Set<Materia> getMateriasAInscribir() {
        return materiasAInscribir;
    }

    public void setMateriasAInscribir(Set<Materia> materiasAInscribir) {
        this.materiasAInscribir = materiasAInscribir;
    }

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasAInscribir = new HashSet<>();
    }
}
