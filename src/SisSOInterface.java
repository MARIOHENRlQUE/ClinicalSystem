import java.awt.*;
import javax.swing.*;

public class SisSOInterface {

    private final SisSO sistema;

    public SisSOInterface() {
        this.sistema = new SisSO();
    }

    public void exibirMenu() {
        JFrame frame = new JFrame("Sistema SisSO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1));

        JButton btnCadastrarExameClinico = new JButton("Cadastrar Exame Clínico");
        JButton btnCadastrarExameEspecial = new JButton("Cadastrar Exame Especial");
        JButton btnCadastrarFuncionario = new JButton("Cadastrar Funcionario");
        JButton btnCadastrarLaudo = new JButton("Cadastrar Laudo");
        JButton btnGerarRelatorioFuncionarios = new JButton("Gerar Relatório de Funcionários");
        JButton btnGerarRelatorioLaudos = new JButton("Gerar Relatório de Laudos");
        JButton btnGerarRelatorioExames = new JButton("Gerar Relatório de Exames");
        JButton btnGerarRelatorioLaudosAlterados = new JButton("Gerar Relatório de Laudos Alterados");
        JButton btnCalcularCustosEmpresa = new JButton("Calcular Custos da Empresa");

        panel.add(btnCadastrarExameClinico);
        panel.add(btnCadastrarExameEspecial);
        panel.add(btnCadastrarFuncionario);
        panel.add(btnCadastrarLaudo);
        panel.add(btnGerarRelatorioFuncionarios);
        panel.add(btnGerarRelatorioLaudos);
        panel.add(btnGerarRelatorioExames);
        panel.add(btnGerarRelatorioLaudosAlterados);
        panel.add(btnCalcularCustosEmpresa);

        frame.add(panel);
        frame.setVisible(true);

        btnCadastrarExameClinico.addActionListener(e -> sistema.cadastroExameClinico());
        btnCadastrarExameEspecial.addActionListener(e -> sistema.cadastroExameEspecial());
        btnCadastrarFuncionario.addActionListener(e -> sistema.cadastroFuncionario());
        btnCadastrarLaudo.addActionListener(e -> sistema.cadastroLaudo());
        btnGerarRelatorioFuncionarios.addActionListener(e -> sistema.gerarRelatorioFuncionarios());
        btnGerarRelatorioLaudos.addActionListener(e -> sistema.gerarRelatorioLaudos());
        btnGerarRelatorioExames.addActionListener(e -> sistema.gerarRelatorioExames());
        btnGerarRelatorioLaudosAlterados.addActionListener(e -> sistema.gerarRelatorioLaudosAlterados());
        btnCalcularCustosEmpresa.addActionListener(e -> sistema.calcularCustosEmpresa());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SisSOInterface interfaceGrafica = new SisSOInterface();
            interfaceGrafica.exibirMenu();
        });
    }
}
