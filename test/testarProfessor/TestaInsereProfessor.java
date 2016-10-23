package testarProfessor;

import java.util.List;
import model.classes.Professor;
import model.dao.ProfessorDao;

public class TestaInsereProfessor {

    public static void main(String[] args) {

        ProfessorDao dao = new ProfessorDao();

        Professor professor = new Professor(); 
                professor.setSiape(194);
                professor.setNome("teste2");
                professor.setSenha("1232541");
            
                dao.adiciona(professor);
                System.out.println("Professor " + professor.getNome() + " Adicionado com sucesso");
            
                }
        }
    

