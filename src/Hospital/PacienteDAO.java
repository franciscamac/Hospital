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
public class PacienteDAO {
    public void CadastrarPaciente(Paciente par) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "INSERT INTO paciente(Nome, Idade, RG, Telefone, causaDaInternacao) VALUES (?,?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, par.getNome());
            stmt.setInt(2, par.getIdade());
            stmt.setString(3, par.getRg());
            stmt.setString(4, par.getTelefone());
            stmt.setString(5,par.getCausaDaInternacao());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public void AlterarPaciente(Paciente pac) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "UPDATE paciente SET Nome= ?,Idade = ?, RG = ?, Telefone  = ?, causaDaInternacao =? WHERE  IdMedico = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, pac.getNome());
            stmt.setInt(2, pac.getIdade());
            stmt.setString(3, pac.getRg());
            stmt.setString(4, pac.getTelefone());
            stmt.setString(5, pac.getCausaDaInternacao());
            stmt.setInt(5, pac.getIdPaciente());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "ERRO AO ATUAIZAR:" + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public void DeletarPaciente(Paciente pac) {
        Connection conn = new ConnectionFactory().getConnection();
        String SQL = "DELETE from paciente WHERE  IdPaciente = ?";
        PreparedStatement stmt = null;
        try {
            stmt.setInt(1, pac.getIdPaciente());
            stmt.executeUpdate();
            JOptionPane.showConfirmDialog(null, "DELETADO COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "ERRO AO DELETAR:" + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);

        }
    }
    public ArrayList<Paciente> ListarPaciente() {
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM paciente";
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("IdPaciente"));
                paciente.setNome(rs.getString("Nome"));
                paciente.setIdade(rs.getInt("Idade"));
                paciente.setRg(rs.getString("RG"));
                paciente.setTelefone(rs.getString("Telefone"));
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return pacientes;
    }

}
