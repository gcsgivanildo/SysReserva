package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.classes.ItemEquipamento;

public class ItemEquipamentoDao {

    private Connection connection;

    public ItemEquipamentoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(ItemEquipamento itemEquipamento) {
        String sql = "insert into itemEquipamento"
                + "(idItemEquipamento, quantidadeUsada) values(?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, itemEquipamento.getIdItemEquipamento());
            stmt.setInt(2, itemEquipamento.getQuantidadeUsada());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemEquipamento> getLista() {
        try {
            List<ItemEquipamento> itemEquipamentos = new ArrayList<ItemEquipamento>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from itemEquipamento");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemEquipamento itemEquipamento = new ItemEquipamento();

                itemEquipamento.setIdItemEquipamento(rs.getInt("idItemEquipamento"));
                itemEquipamento.setQuantidadeUsada(rs.getInt("quantidadeUsada"));

                itemEquipamentos.add(itemEquipamento);
            }
            rs.close();
            stmt.close();
            return itemEquipamentos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(ItemEquipamento itemEquipamento) {
        String sql = "update itemEquipamento set idItemEquipamento=?, quantidadeUsada=? where idItemEquipamento=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itemEquipamento.getIdItemEquipamento());
            stmt.setInt(2, itemEquipamento.getQuantidadeUsada());
            stmt.setInt(3, itemEquipamento.getIdItemEquipamento());
            
            
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void remove(ItemEquipamento itemEquipamento){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from itemEquipamento where idItemEquipamento=?");
            stmt.setInt(1, itemEquipamento.getIdItemEquipamento());
            
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
