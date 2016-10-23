
package testarEquipamento;

import java.util.List;
import model.classes.Equipamento;
import model.dao.EquipamentoDao;


public class TestaRemoveEquipamento {
    public static void main(String[] args) {
        EquipamentoDao dao = new EquipamentoDao();
        List<Equipamento> equipamentos = dao.getLista();
        
        for(Equipamento equipamento : equipamentos){
            if(equipamento.getIdEquipamento() == 3){
                dao.remove(equipamento);
                System.out.println("equipamentos removido");
                System.out.println("-------");
            }else{
                System.out.println("Equipamento são removido");
                System.out.println("------------");
                
            }
        }
    }
}
