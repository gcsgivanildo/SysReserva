
package testarEquipamento;

import java.util.List;
import model.classes.Equipamento;
import model.dao.EquipamentoDao;


public class TestaAlteraEquipamento {
    public static void main(String[] args) {
       EquipamentoDao dao = new EquipamentoDao();
       
       List<Equipamento> equipamentos = dao.getLista();
       
       for(Equipamento cont : equipamentos){
           System.out.println("IdEquipamento: " + cont.getIdEquipamento());
           if(cont.getIdEquipamento()==1){
               Equipamento equipamento = new Equipamento();
               equipamento.setNomeEquipamento("Data Show2");
               equipamento.setMarca("HP");
               equipamento.setTipo("Projetor");
               equipamento.setUtilidade("teste");
               equipamento.setIdEquipamento(cont.getIdEquipamento());
               
               dao.altera(equipamento);
               
               System.out.println("equipamento alterado com sucesso");
               System.out.println("---------");
           }else{
               System.out.println("------------");
               System.out.println("Equipamento não Alterado");
           }
       }
    }
}
