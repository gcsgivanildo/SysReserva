package testarEquipamento;

import java.util.List;
import model.classes.Equipamento;
import model.dao.EquipamentoDao;

public class TestaListaEquipamento {

    public static void main(String[] args) {

        EquipamentoDao dao = new EquipamentoDao();

        List<Equipamento> equipamentos = dao.getLista();

        for (Equipamento equipamento : equipamentos) {
            System.out.println("Nome do Equipamento: " + equipamento.getNomeEquipamento());
            System.out.println("Marca: " + equipamento.getMarca());
            System.out.println("Tipo: " + equipamento.getTipo());
            System.out.println("Utilidade: " + equipamento.getUtilidade());
            System.out.println("-------------------");
        }
    }
}
