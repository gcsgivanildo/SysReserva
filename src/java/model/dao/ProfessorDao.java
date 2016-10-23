
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.classes.Professor;


public class ProfessorDao {
    
    private Connection connection;
    
    public ProfessorDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //metodo para adicionar Professor
    public void adiciona(Professor professor){
        String sql = "insert into professor "
                + "(SIAPE, Nome, Senha) values (?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
           
            
            stmt.setInt(1, professor.getSiape());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getSenha());
            
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    
    //metodo para listar professor
    public List<Professor> getLista(){
        try {
            List<Professor> professores = new ArrayList<Professor>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from professor");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Professor professor = new Professor();
                professor.setSiape(rs.getInt("SIAPE"));
                professor.setNome(rs.getString("Nome"));
                professor.setSenha(rs.getString("Senha"));
                
                professores.add(professor);
            }
            rs.close();
            stmt.close();
            return professores;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    
    //metodo para alterar Professor
    public void altera(Professor professor){
        String sql = "update professor set SIAPE=?, Nome=?, Senha=? where SIAPE=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, professor.getSiape());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getSenha());
            stmt.setInt(4, professor.getSiape());
            
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    
    //metodo para remover Professor
    public void remove(Professor professor){
            try {
                PreparedStatement stmt = connection.prepareStatement(
                        "delete from professor where SIAPE=?");
                stmt.setInt(1, professor.getSiape());
                stmt.execute();
                stmt.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
    }
}
