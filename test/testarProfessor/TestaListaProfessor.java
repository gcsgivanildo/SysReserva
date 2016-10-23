package testarProfessor;

import java.util.List;
import model.classes.Professor;
import model.dao.ProfessorDao;

public class TestaListaProfessor {

    public static void main(String[] args) {
        ProfessorDao dao = new ProfessorDao();

        List<Professor> professores = dao.getLista();
        for (Professor professor : professores) {
            System.out.println("SIAPE: " + professor.getSiape());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("Senha: " + professor.getSenha());
            System.out.println("-----------");
        }
    }
}
