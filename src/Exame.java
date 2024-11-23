import java.io.Serializable;

public abstract class Exame implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String cid;
    private final String nome;

    public Exame(String cid, String nome) {
        this.cid = cid;
        this.nome = nome;
    }

    public String getCid() {
        return cid;
    }

    public String getNome() {
        return nome;
    }

    public abstract boolean isAlterado(double valor);

    public abstract double getValorMin();

    public abstract double getValorMax();
}
