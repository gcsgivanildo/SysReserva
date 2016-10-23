
package testaItemEquipamento;

import model.classes.ItemEquipamento;
import model.dao.ItemEquipamentoDao;


public class TestaInsereItemEquipamento {
    public static void main(String[] args) {
        ItemEquipamento itemEquipamento = new ItemEquipamento();
        itemEquipamento.setIdItemEquipamento(3);
        itemEquipamento.setQuantidadeUsada(12);
        
        ItemEquipamentoDao dao = new ItemEquipamentoDao();
        dao.adiciona(itemEquipamento);
        
        System.out.println("Adicionado com sucesso!!!");
    }
}
