package testarAula;

import java.util.List;
import model.classes.Aula;
import model.dao.AulaDao;

public class testaRemoveAula {

    public static void main(String[] args) {
        AulaDao dao = new AulaDao();
        List<Aula> aulas = dao.getLista();

        for (Aula aula : aulas) {
            if (aula.getIdAula() == 5) {//este numero (id) precisa estar cadastrado no banco
                dao.remove(aula);
                System.out.println("Aula Removida com Sucesso!");
            } else {
                System.out.println("Aula não removida!");
            }
        }
    }
}
