
package testarAula;



import java.text.SimpleDateFormat;
import java.util.List;
import model.classes.Aula;
import model.dao.AulaDao;

public class testaListaAula {
    public static void main(String[] args) {
        AulaDao dao = new AulaDao();
        
        List<Aula> aulas = dao.getLista();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat sdfh = new SimpleDateFormat("hh:mm");
        
        for (Aula aula : aulas){
            System.out.println("Data: " + sdf.format(aula.getData().getTime()));
            System.out.println("Hora: " + sdfh.format(aula.getHora().getTime()));
            System.out.println("Duração: " + aula.getDuracao());
            System.out.println("idSiape: " + aula.getIdSiape());
            System.out.println("idSala: " + aula.getIdSala());
            System.out.println("idItemEquipamento: " + aula.getIdItemEquipamento());
        
            System.out.println("-----------------------");
        }
    }
    
}
