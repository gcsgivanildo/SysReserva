package TestarSala;

import java.util.List;
import model.classes.Sala;
import model.dao.SalaDao;

public class TestaRemoveSala {

    public static void main(String[] args) {

        SalaDao dao = new SalaDao();
        List<Sala> salas = dao.getLista();

        for (Sala sala : salas) {
            System.out.println("id: " + sala.getIdSala());
            if(sala.getIdSala()==2){
                dao.remove(sala);
                System.out.println("Removido com sucesso");
                System.out.println("--------");
            }else{
                System.out.println("Não removido");
                System.out.println("-----------");
            }
        }
    }

}
