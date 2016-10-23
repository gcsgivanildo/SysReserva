
package testaItemEquipamento;

import java.util.List;
import model.classes.ItemEquipamento;
import model.dao.ItemEquipamentoDao;

public class TestaAlteraItemEquipamento {
    public static void main(String[] args) {
        ItemEquipamentoDao dao = new ItemEquipamentoDao();
        
        List<ItemEquipamento> itemEquipamentos = dao.getLista();
        
        for(ItemEquipamento cont : itemEquipamentos){
            System.out.println("ID: " + cont.getIdItemEquipamento());
            if(cont.getIdItemEquipamento()==3){
                ItemEquipamento itemEquipamento = new ItemEquipamento();
                itemEquipamento.setQuantidadeUsada(07);
                //itemEquipamento.setIdItemEquipamento(3);
                itemEquipamento.setIdItemEquipamento(cont.getIdItemEquipamento());
                dao.altera(itemEquipamento);
                
               System.out.println("Quantidade de itemEquipamento alterado com sucesso");
               System.out.println("---------");
            }else{
               System.out.println("Quantidade de itemEquipamento não Alterado");
               System.out.println("-----------");
           }
        }
    }
}
