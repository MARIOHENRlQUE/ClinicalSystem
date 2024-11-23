public class ExameEspecial extends Exame {

    public ExameEspecial(String cid, String nome) {
        super(cid, nome);
    }

    @Override
    public boolean isAlterado(double valor) {
        return valor == 1;
    }

    @Override
    public double getValorMin() {
        return 0; // Não aplicável para ExameEspecial
    }

    @Override
    public double getValorMax() {
        return 0; // Não aplicável para ExameEspecial
    }

    @Override
    public String toString() {
        return "Exame Especial: " + getNome() + ", CID: " + getCid();
    }
}
