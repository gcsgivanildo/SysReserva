
package testarProfessor;

import java.util.List;
import model.classes.Professor;
import model.dao.ProfessorDao;


public class TestaRemoveProfessor {
    public static void main(String[] args) {
        ProfessorDao dao = new ProfessorDao();
        List<Professor> professores = dao.getLista();
        
        for(Professor professor : professores){
            System.out.println("iD: " + professor.getSiape());
            if(professor.getSiape()==126){
                dao.remove(professor);
                
                System.out.println("Removido com sucesso");
                System.out.println("-------");
                
            }else{
                System.out.println("Não removido");
                System.out.println("---------");
            }
        }
    }
        
    
    
}

