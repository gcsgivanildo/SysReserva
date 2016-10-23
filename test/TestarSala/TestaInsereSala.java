
package TestarSala;

import model.classes.Sala;
import model.dao.SalaDao;


public class TestaInsereSala {
    public static void main(String[] args) {
        Sala sala = new Sala();
        sala.setNome("Física");
        sala.setLocalizacao("B2");
        sala.setCapacidade(45);
        sala.setTipo("Laboratóri");
        
        SalaDao dao = new SalaDao();
        dao.adiciona(sala);
        
        System.out.println("Adicionado com sucesso");
    }
}
