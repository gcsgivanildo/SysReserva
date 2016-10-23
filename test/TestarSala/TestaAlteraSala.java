
package TestarSala;

import java.util.List;
import model.classes.Sala;
import model.dao.SalaDao;


public class TestaAlteraSala {
    public static void main(String[] args) {
        SalaDao dao = new SalaDao();
        
        List<Sala> salas = dao.getLista();
        
        for(Sala cont : salas){
            System.out.println("ID: " + cont.getIdSala());
            if(cont.getIdSala()==2){//colocar um id existente no banco
                Sala sala = new Sala();
                sala.setNome("Geografia");
                sala.setLocalizacao("C3");
                sala.setCapacidade(40);
                sala.setTipo("Lab");
                sala.setIdSala(cont.getIdSala());
                dao.altera(sala);
                
               System.out.println("alterado com sucesso");
               System.out.println("---------");
            }else{
               System.out.println(" não Alterado");
               System.out.println("-----------");
           }
        }
    }
}
