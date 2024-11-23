import java.io.*;
import java.util.*;

class BaseDados implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Exame> exames = new ArrayList<>();
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final List<Laudo> laudos = new ArrayList<>();

    public List<Exame> getExames() {
        return exames;
    }

    public void adicionarExame(Exame exame) {
        exames.add(exame);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Laudo> getLaudos() {
        return laudos;
    }

    public void adicionarLaudo(Laudo laudo) {
        laudos.add(laudo);
    }

    public Exame procurarExamePorCid(String cid) {
        for (Exame exame : exames) {
            if (exame.getCid().equals(cid)) {
                return exame;
            }
        }
        return null;
    }

    public double calcularCustos() {
        double total = 0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.getSalario();
        }
        for (Exame exame : exames) {
            if (exame instanceof ExameEspecial) {
                total += 100; // Supondo um custo fixo de 100 para exames especiais
            }
        }
        return total;
    }

    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.bin"))) {
            oos.writeObject(this);
            System.out.println("Dados armazenados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.bin"))) {
            BaseDados dadosRecuperados = (BaseDados) ois.readObject();
            exames.clear();
            exames.addAll(dadosRecuperados.getExames());
            funcionarios.clear();
            funcionarios.addAll(dadosRecuperados.getFuncionarios());
            laudos.clear();
            laudos.addAll(dadosRecuperados.getLaudos());
            System.out.println("Dados recuperados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
