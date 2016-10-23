
package testaItemEquipamento;

import java.util.List;
import model.classes.ItemEquipamento;
import model.dao.ItemEquipamentoDao;


public class testaRemoveItemEquipamento {
    public static void main(String[] args) {
        ItemEquipamentoDao dao = new ItemEquipamentoDao();
        
        List<ItemEquipamento> itemEquipamentos = dao.getLista();
        
        for(ItemEquipamento itemEquipamento : itemEquipamentos){
            System.out.println("id: "+ itemEquipamento.getIdItemEquipamento());
            if(itemEquipamento.getIdItemEquipamento()==3){
                dao.remove(itemEquipamento);
                System.out.println("item Equipamento removido com sucesso");
                System.out.println("-------------");
            }else{
                System.out.println("não removido");
                System.out.println("--------");
            }
        }
    }
}
