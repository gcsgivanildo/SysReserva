
package testarEquipamento;

import model.classes.Equipamento;
import model.dao.EquipamentoDao;


public class TestaInsereEquipamento {
    public static void main(String[] args) {
        Equipamento equipamento = new Equipamento();
        equipamento.setNomeEquipamento("Caixa de Som");
        equipamento.setMarca("Sony");
        equipamento.setTipo("Som");
        equipamento.setUtilidade("aula");
        
        EquipamentoDao dao = new EquipamentoDao();
        dao.adiciona(equipamento);
        
        System.out.println("Equipamento Gravado com Sucesso!");
    }
}
