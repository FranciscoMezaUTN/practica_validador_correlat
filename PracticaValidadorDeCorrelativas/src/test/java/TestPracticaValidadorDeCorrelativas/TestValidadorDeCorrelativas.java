package TestPracticaValidadorDeCorrelativas;

import ValidadorCorrelat.Inscripciones.Alumno;
import ValidadorCorrelat.Inscripciones.Inscripcion;
import ValidadorCorrelat.Inscripciones.Materia;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
public class TestValidadorDeCorrelativas {
    @Test
    public void materiaSinCorrelatAprobada() {
        Materia inglesI = new Materia(new HashSet<>());

        Set<Materia> materiasAprobadas = new HashSet<>();
        Alumno alumno = new Alumno(materiasAprobadas);

        Inscripcion inscripParaInglesI = new Inscripcion(alumno);

        inscripParaInglesI.getMateriasAInscribir().add(inglesI);

        Assert.assertTrue("Inscripcion a ingles I aprobada", inscripParaInglesI.aprobada());
    }

    @Test
    public void materiasConCorrelatAprobada() {
        Materia inglesI = new Materia(new HashSet<>());
        Materia algoritmos = new Materia(new HashSet<>());
        Materia algebra = new Materia(new HashSet<>());

        Set<Materia> correlativas = Set.of(algoritmos);
        Set<Materia> materiasAprobadas = Set.of(algoritmos, algebra);

        Materia paradigmas = new Materia(correlativas);

        Alumno alumno = new Alumno(materiasAprobadas);

        Inscripcion inscripParaPdPeIngles = new Inscripcion(alumno);
        inscripParaPdPeIngles.setMateriasAInscribir(Set.of(paradigmas, inglesI));

        Assert.assertTrue("Inscripcion a paradigmas e ingles I aprobada", inscripParaPdPeIngles.aprobada());
    }

    @Test
    public void materiasConCorrelatRechazada() {
        Materia fisicaI = new Materia(new HashSet<>());
        Materia analisisI = new Materia(new HashSet<>());
        Materia sistemas = new Materia(new HashSet<>());

        Set<Materia> correlativas = Set.of(fisicaI, analisisI);
        Materia fisicaII = new Materia(correlativas);

        Set<Materia> materiasAprobadas = Set.of(analisisI, sistemas);
        Alumno alumno = new Alumno(materiasAprobadas);

        Inscripcion inscripParaFisicaII = new Inscripcion(alumno);
        inscripParaFisicaII.setMateriasAInscribir(Set.of(fisicaII));

        Assert.assertFalse("Inscripcion a fisica II rechazada", inscripParaFisicaII.aprobada());
    }

    @Test
    public void InscripcionVaciaAprobada(){
        Materia discreta = new Materia(new HashSet<>());

        Set<Materia> materiasAprobadas = Set.of(discreta);
        Alumno alumno = new Alumno(materiasAprobadas);

        Inscripcion noInscripcion = new Inscripcion(alumno);
        noInscripcion.setMateriasAInscribir(new HashSet<>());

        Assert.assertTrue("El alumno no se inscribio a materia alguna", noInscripcion.aprobada());
    }
}
