package Hospital;

/**
 *
 * @author Macário
 */
public class Quarto {
    private int idQuarto;
    private int andarDoQuarto;
    private int numeroDoQuarto;
    private String tipoDeArea;
    private String estadoDeOcupacao;
    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(int numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public int getAndarDoQuarto() {
        return andarDoQuarto;
    }

    public void setAndarDoQuarto(int andarDoQuarto) {
        this.andarDoQuarto = andarDoQuarto;
    }

    public String getEstadoDeOcupacao() {
        return estadoDeOcupacao;
    }

    public void setEstadoDeOcupacao(String estadoDeOcupacao) {
        this.estadoDeOcupacao = estadoDeOcupacao;
    }
    
    public String getTipoDeArea() {
        return tipoDeArea;
    }

    public void setTipoDeArea(String tipoDeArea) {
        this.tipoDeArea = tipoDeArea;
    }    
}
