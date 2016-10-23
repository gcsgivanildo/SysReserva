
package testarAula;

import java.util.Calendar;
import java.util.List;
import model.classes.Aula;
import model.dao.AulaDao;


public class testaAlteraAula {
    public static void main(String[] args) {
        AulaDao dao = new AulaDao();
        
        List<Aula> aulas = dao.getLista();
        
        for(Aula cont : aulas){
            System.out.println("ID: " + cont.getIdAula());
            if(cont.getIdAula() == 3){
                Aula aula = new Aula();
                aula.setData(Calendar.getInstance());
                aula.setHora(Calendar.getInstance());
                aula.setDuracao(34);
                aula.setIdSiape(123);
                aula.setIdSala(1);
                aula.setIdItemEquipamento(1);
                aula.setIdAula(cont.getIdAula());
                
                dao.altera(aula);
                System.out.println("Dados Alterados");
                System.out.println("----------------");
            }else{
                System.out.println("Dados não Alterados");
            }
        }
    }
}
