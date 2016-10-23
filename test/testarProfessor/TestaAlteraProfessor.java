
package testarProfessor;

import java.util.List;
import model.classes.Professor;
import model.dao.ProfessorDao;


public class TestaAlteraProfessor {
    public static void main(String[] args) {
        ProfessorDao dao = new ProfessorDao();
        List<Professor> professores = dao.getLista();
        
        for(Professor cont : professores){
            System.out.println("iD: " + cont.getSiape());
            if (cont.getSiape()==146) {
                Professor professor = new Professor();
                professor.setSiape(222);
                professor.setNome("maria");
                professor.setSenha("321");
                
                dao.altera(professor);
                
                System.out.println("Alterado com sucesso");
                System.out.println("-------------");
            }else{
                System.out.println("Não Alterado");
                System.out.println("---------");
            }
        }
    }
}
