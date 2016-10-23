
package testarAula;

import java.util.Calendar;
import model.classes.Aula;
import model.dao.AulaDao;


public class testaInsereAula {
    
    public static void main(String[] args) {
        Aula aula = new Aula();
        aula.setData(Calendar.getInstance());
        aula.setHora(Calendar.getInstance());
        aula.setDuracao(80);
        aula.setIdSiape(123);
        aula.setIdSala(1);
        aula.setIdItemEquipamento(1);
        
        AulaDao dao = new AulaDao();
        
        dao.adiciona(aula);
        
        System.out.println("Gravado com sucesso!");
        
    }
}
