package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.classes.Sala;

public class SalaDao {

    private Connection connection;

    public SalaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    //método para adiocina sala
    public void adiciona(Sala sala) {
        String sql = "insert into sala"
                + "(nome, localizacao, capacidade, tipo)"
                + "values (?,?,?,?)";

        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, sala.getNome());
            stmt.setString(2, sala.getLocalizacao());
            stmt.setInt(3, sala.getCapacidade());
            stmt.setString(4, sala.getTipo());

            //executa
            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo para listar Sala
    public List<Sala> getLista() {
        try {
            List<Sala> salas = new ArrayList<Sala>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from sala");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Equipamento
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("IdSala"));
                sala.setNome(rs.getString("nome"));
                sala.setLocalizacao(rs.getString("localizacao"));
                sala.setCapacidade(rs.getInt("capacidade"));
                sala.setTipo(rs.getString("tipo"));

                salas.add(sala);
            }
            rs.close();
            stmt.close();
            return salas;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para alterar Sala
    public void altera(Sala sala) {
        String sql = "update sala set nome=?, localizacao=?, capacidade=?, tipo=? where idSala=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setString(2, sala.getLocalizacao());
            stmt.setInt(3, sala.getCapacidade());
            stmt.setString(4, sala.getTipo());
            stmt.setInt(5, sala.getIdSala());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para remover Sala
    public void remove(Sala sala) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from sala where idSala=?");
            stmt.setInt(1, sala.getIdSala());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
