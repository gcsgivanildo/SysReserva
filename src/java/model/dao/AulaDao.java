
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.classes.Aula;


public class AulaDao {
    
    //a conexao com o banco de dados
    private Connection connection;
    
    public AulaDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //metodo para adicionar Aula
    public void adiciona(Aula aula){
        String sql = "insert into aula"
                + "(data, hora, duracao, idSiape, idSala, idItemEquipamento)"
                + "values (?,?,?,?,?,?)";
        
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            //seta os valores
            stmt.setDate(1, new Date(aula.getData().getTimeInMillis()));
            stmt.setTime(2, new Time(aula.getHora().getTimeInMillis()));
            stmt.setInt(3, aula.getDuracao());
            stmt.setInt(4, aula.getIdSiape());
            stmt.setInt(5, aula.getIdSala());
            stmt.setInt(6, aula.getIdItemEquipamento());
            
            //executa
            stmt.execute();
            stmt.close();
                    
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //Metodo para listar aula
    public List<Aula> getLista(){
        try {
            List<Aula> aulas = new ArrayList<Aula>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from aula");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                //criando o objeto Aula
                Aula aula = new Aula();
                aula.setIdAula(rs.getInt("IdAula"));
                //montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                aula.setData(data);
                
                Calendar hora = Calendar.getInstance();
                hora.setTime(rs.getTime("hora"));
                aula.setHora(hora);
                
                aula.setDuracao(rs.getInt("duracao"));
                aula.setIdSiape(rs.getInt("idSiape"));
                aula.setIdSala(rs.getInt("idSala"));
                aula.setIdItemEquipamento(rs.getInt("idItemEquipamento"));
                
                aulas.add(aula);
            }
            rs.close();
            stmt.close();
            return aulas;           
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //metodo para alterar aula
    public void altera(Aula aula){
        String sql = "update aula set data=?, hora=?, duracao=?, idSiape=?, idSala=?, idItemEquipamento=? where idAula=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, new Date(aula.getData().getTimeInMillis()));
            stmt.setTime(2, new Time(aula.getHora().getTimeInMillis()));
            stmt.setInt(3, aula.getDuracao());
            stmt.setInt(4, aula.getIdSiape());
            stmt.setInt(5, aula.getIdSala());
            stmt.setInt(6, aula.getIdItemEquipamento());
            stmt.setInt(7, aula.getIdAula());
            
            stmt.execute();
            stmt.close();
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //metodo para remover aula
    public void remove(Aula aula){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                        "delete from aula where idAula=?");
            stmt.setInt(1, aula.getIdAula());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    //metodo para recuperar idItemEquipamento relacionado ao nome do equipamento
     public List<Aula> getListaEquip(){
        try {
            List<Aula> aulas = new ArrayList<Aula>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("SELECT * FROM aula natural join itemEquipamento join equipamento on idItemEquipamento = idEquipamento where idEquipamento=?");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                //criando o objeto Aula
                Aula aula = new Aula();
                aula.setIdAula(rs.getInt("IdAula"));
                //montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                aula.setData(data);
                
                Calendar hora = Calendar.getInstance();
                hora.setTime(rs.getTime("hora"));
                aula.setHora(hora);
                
                aula.setDuracao(rs.getInt("duracao"));
                aula.setIdSiape(rs.getInt("idSiape"));
                aula.setIdSala(rs.getInt("idSala"));
                aula.setIdItemEquipamento(rs.getInt("idItemEquipamento"));
                
                aulas.add(aula);
            }
            rs.close();
            stmt.close();
            return aulas;           
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
