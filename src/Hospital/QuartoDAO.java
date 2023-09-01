package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Macário
 */
public class QuartoDAO {
    public void CadastrarQuarto(Quarto qua) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "INSERT INTO quarto(andarDoQuarto, numeroDoQuarto, tipoDeArea, estadoDeOcupacao) VALUES (?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, qua.getAndarDoQuarto());
            stmt.setInt(2, qua.getNumeroDoQuarto());
            stmt.setString(3,qua.getTipoDeArea() );
            stmt.setString(4,qua.getEstadoDeOcupacao());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public void AlterarQuarto(Quarto qua) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "UPDATE quarto SET andarDoQuarto= ?,numeroDoQuarto = ?, tipoDeArea = ?, estadoDeQuarto  = ? WHERE  idQuarto = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, qua.getAndarDoQuarto());
            stmt.setInt(2, qua.getNumeroDoQuarto());
            stmt.setString(3,qua.getTipoDeArea());
            stmt.setString(4, qua.getEstadoDeOcupacao());
            stmt.setInt(5, qua.getIdQuarto());
            stmt.executeUpdate();
            
            JOptionPane.showConfirmDialog(null, " QUARTO ALTERADO COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "ERRO AO ALTERAR QUARTO:" + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public void DeletarQuarto(Quarto qua) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "DELETE from quarto WHERE  IdQuarto = ?";
        PreparedStatement stmt = null;
        try {
            stmt.setInt(1, qua.getIdQuarto());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "ERRO AO DELETAR:" + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public ArrayList<Quarto> ListarQuarto() {
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM quarto";
        ArrayList<Quarto> quartos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Quarto quarto = new Quarto();
                quarto.setIdQuarto(rs.getInt("IdQuarto"));
                quarto.setAndarDoQuarto(rs.getInt("andarDoQuarto"));
                quarto.setNumeroDoQuarto(rs.getInt("numeroDoQuarto"));
                quarto.setTipoDeArea(rs.getString("tipoDeArea"));
                quarto.setEstadoDeOcupacao(rs.getString("estadoDeOcupacao"));
                quartos.add(quarto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return quartos;
    }
    
}
