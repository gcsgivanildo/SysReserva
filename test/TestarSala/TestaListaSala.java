package TestarSala;

import java.util.List;
import model.classes.Sala;
import model.dao.SalaDao;

public class TestaListaSala {

    public static void main(String[] args) {

        SalaDao dao = new SalaDao();
        List<Sala> salas = dao.getLista();

        for (Sala sala : salas) {
             System.out.println("Nome: " + sala.getNome());
             System.out.println("Localização: " + sala.getLocalizacao());
             System.out.println("Capacidade: " + sala.getCapacidade());
             System.out.println("Tipo: " + sala.getTipo());
             System.out.println("-----------");
        }
    }
}
