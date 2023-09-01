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
public class MedicoDAO {
    public void CadastrarMedico(Medico med) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "INSERT INTO medico(NOME,ESPECIALIDADE, CIM, CBO) VALUES (?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getEspecialidade());
            stmt.setString(3, med.getCim());
            stmt.setString(4, med.getCbo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public void AlterarMedico(Medico med) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "UPDATE medico SET Nome= ?,Especialidade = ?, CIM = ?, CBO  = ? WHERE  IdMedico = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getEspecialidade());
            stmt.setString(3, med.getCim());
            stmt.setString(4, med.getCbo());
            stmt.setInt(5, med.getIdMedico());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "ERRO AO ATUAIZAR:" + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public void DeletarMedico(Medico med) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "DELETE from medico WHERE  IdMedico = ?";
        PreparedStatement stmt = null;
        try {
            stmt.setInt(1, med.getIdMedico());
            stmt.executeUpdate();
            JOptionPane.showConfirmDialog(null, "DELETADO COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "ERRO AO DELETAR:" + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public ArrayList<Medico> ListarMedico() {
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM medico";
        ArrayList<Medico> medicos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setIdMedico(rs.getInt("IdMedico"));
                medico.setNome(rs.getString("Nome"));
                medico.setEspecialidade(rs.getString("Especialidade"));
                medico.setCim(rs.getString("CIM"));
                medico.setCbo(rs.getString("CBO"));
                medicos.add(medico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return medicos;
    }

 }