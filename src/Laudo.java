import java.io.Serializable;

public class Laudo implements Impressao, Serializable {
    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    private final int codigo;
    private final Funcionario funcionario;
    private final Exame exame;
    private double valor;

    public Laudo(Funcionario funcionario, Exame exame, double valor) {
        this.codigo = ++contador;
        this.funcionario = funcionario;
        this.exame = exame;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Exame getExame() {
        return exame;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void imprimir() {
        System.out.println("Código do Laudo: " + codigo);
        System.out.println("Exame: " + exame.getNome());
        System.out.println("CID do Exame: " + exame.getCid());
        System.out.println("Funcionário:");
        funcionario.imprimir();
        System.out.println("Valor: " + valor);
        System.out.println("Resultado: " + (exame.isAlterado(valor) ? "Alterado" : "Normal"));
    }
}
