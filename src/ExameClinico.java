public class ExameClinico extends Exame {
    private final double valorMin;
    private final double valorMax;

    public ExameClinico(String cid, String nome, double valorMin, double valorMax) {
        super(cid, nome);
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }

    @Override
    public boolean isAlterado(double valor) {
        return valor < valorMin || valor > valorMax;
    }

    @Override
    public double getValorMin() {
        return valorMin;
    }

    @Override
    public double getValorMax() {
        return valorMax;
    }

    @Override
    public String toString() {
        return "Exame Clínico: " + getNome() + ", CID: " + getCid() + ", Valor Minimo: " + valorMin + ", Valor Maximo: " + valorMax;
    }
}
