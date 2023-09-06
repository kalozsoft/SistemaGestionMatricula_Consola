package clases;
import java.util.ArrayList;
import java.util.List;

public class Ciclo {
    private int numero;
    private List<Curso> cursos;

    public Ciclo(int numero) {
        this.numero = numero;
        cursos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

}
