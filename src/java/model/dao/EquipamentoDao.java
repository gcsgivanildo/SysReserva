
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.classes.Equipamento;


public class EquipamentoDao {
    
    //a conexao com o banco de dados
    private Connection connection;
    
    public EquipamentoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //metodo para adicionar Equipamento
    public void adiciona(Equipamento equipamento){
        String sql = "insert into equipamento"
                + "(nomeEquipamento, marca, tipo, utilidade)"
                + "values (?,?,?,?)";
        
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            //seta os valores
           
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getMarca());
            stmt.setString(3, equipamento.getTipo());
            stmt.setString(4, equipamento.getUtilidade());
            
            //executa
            stmt.execute();
            stmt.close();
                    
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //Metodo para listar Equipamento
    public List<Equipamento> getLista(){
        try {
            List<Equipamento> equipamentos = new ArrayList<Equipamento>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from equipamento");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                //criando o objeto Equipamento
                Equipamento equipamento = new Equipamento();
                equipamento.setIdEquipamento(rs.getInt("IdEquipamento"));
                equipamento.setNomeEquipamento(rs.getString("nomeEquipamento"));
                equipamento.setMarca(rs.getString("marca"));
                equipamento.setTipo(rs.getString("tipo"));
                equipamento.setUtilidade(rs.getString("utilidade"));
                
                equipamentos.add(equipamento);
            }
            rs.close();
            stmt.close();
            return equipamentos;           
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //metodo para alterar Equipamento
    public void altera(Equipamento equipamento){
        String sql = "update equipamento set nomeEquipamento=?, marca=?, tipo=?, utilidade=? where idEquipamento=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getMarca());
            stmt.setString(3, equipamento.getTipo());
            stmt.setString(4, equipamento.getUtilidade());
            stmt.setInt(5, equipamento.getIdEquipamento());
            
            stmt.execute();
            stmt.close();
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //metodo para remover Equipamento
    public void remove(Equipamento equipamento){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                        "delete from equipamento where idEquipamento=?");
            stmt.setInt(1, equipamento.getIdEquipamento());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
