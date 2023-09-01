package Hospital;

/**
 *
 * @author Macário
 */
public class Paciente {
    private int idPaciente;
    private String nome;
    private int idade;
    private String rg;
    private String telefone;
    private String causaDaInternacao;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCausaDaInternacao() {
        return causaDaInternacao;
    }

    public void setCausaDaInternacao(String causaDaInternacao) {
        this.causaDaInternacao = causaDaInternacao;
    }
    
    
}
