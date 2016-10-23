
package testaItemEquipamento;

import java.util.List;
import model.classes.ItemEquipamento;
import model.dao.ItemEquipamentoDao;

public class TestaListaItemEquipamento {
    public static void main(String[] args) {
        ItemEquipamentoDao dao = new ItemEquipamentoDao();
        
        List<ItemEquipamento> equipamentos = dao.getLista();
        
        for(ItemEquipamento equipamento : equipamentos){
            System.out.println("Quantidade de Equipamentos: "+ equipamento.getQuantidadeUsada());
            System.out.println("id Item Equipamento: " + equipamento.getIdItemEquipamento());
            System.out.println("-------");
        }
    }
}
