import java.util.*;

public class SisSO {
    private BaseDados baseDados = new BaseDados();

    public BaseDados getBaseDados() {
        return baseDados;
    }

    public void imprimeMenu() {
        System.out.println("=======================================");
        System.out.println("        Sistema de Saúde Ocupacional    ");
        System.out.println("=======================================");
        System.out.println("1 - Cadastrar Exame Clínico");
        System.out.println("2 - Cadastrar Exame Especial");
        System.out.println("3 - Cadastrar Funcionário");
        System.out.println("4 - Cadastrar Laudo");
        System.out.println("5 - Gerar Relatório de Funcionários");
        System.out.println("6 - Gerar Relatório de Laudos");
        System.out.println("7 - Gerar Relatório de Exames");
        System.out.println("8 - Gerar Relatório de Laudos Alterados");
        System.out.println("9 - Ordenar Funcionários");
        System.out.println("10 - Calcular Custos da Empresa");
        System.out.println("11 - Procurar Exame por CID");
        System.out.println("12 - Armazenar Dados em Arquivo");
        System.out.println("13 - Recuperar Dados de Arquivo");
        System.out.println("14 - Sair");
        System.out.println("=======================================");
        System.out.print("Digite a opção desejada: ");
    }

    public void cadastroExameClinico() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("CID: ");
            String cid = scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Valor Mínimo: ");
            double valorMin = scanner.nextDouble();
            System.out.print("Valor Máximo: ");
            double valorMax = scanner.nextDouble();
            ExameClinico exame = new ExameClinico(cid, nome, valorMin, valorMax);
            baseDados.adicionarExame(exame);
            System.out.println("Exame Clínico cadastrado com sucesso!");
        }
    }

    public void cadastroExameEspecial() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("CID: ");
            String cid = scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            ExameEspecial exame = new ExameEspecial(cid, nome);
            baseDados.adicionarExame(exame);
            System.out.println("Exame Especial cadastrado com sucesso!");
        }
    }

    public void cadastroFuncionario() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo);
            baseDados.adicionarFuncionario(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        }
    }

    public void cadastroLaudo() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Matrícula do Funcionário: ");
            String matricula = scanner.nextLine();
            Funcionario funcionario = baseDados.getFuncionarios().stream()
                                        .filter(f -> f.getCpf().equals(matricula))
                                        .findFirst().orElse(null);
            if (funcionario == null) {
                System.out.println("Funcionário não encontrado!");
                return;
            }
            System.out.print("CID do Exame: ");
            String cid = scanner.nextLine();
            Exame exame = baseDados.procurarExamePorCid(cid);
            if (exame == null) {
                System.out.println("Exame não encontrado!");
                return;
            }
            System.out.print("Valor: ");
            double valor = scanner.nextDouble();
            Laudo laudo = new Laudo(funcionario, exame, valor);
            baseDados.adicionarLaudo(laudo);
            System.out.println("Laudo cadastrado com sucesso!");
        }
    }

    public void gerarRelatorioFuncionarios() {
        for (Funcionario funcionario : baseDados.getFuncionarios()) {
            funcionario.imprimir();
        }
    }

    public void gerarRelatorioLaudos() {
        for (Laudo laudo : baseDados.getLaudos()) {
            laudo.imprimir();
        }
    }

    public void gerarRelatorioExames() {
        for (Exame exame : baseDados.getExames()) {
            System.out.println("CID: " + exame.getCid() + ", Nome: " + exame.getNome());
        }
    }

    public void gerarRelatorioLaudosAlterados() {
        for (Laudo laudo : baseDados.getLaudos()) {
            if (laudo.getExame().isAlterado(laudo.getValor())) {
                laudo.imprimir();
            }
        }
    }

    public void ordenarFuncionarios() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1 - Ordem Alfabética");
            System.out.println("2 - Ordem Decrescente de Salário");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                baseDados.getFuncionarios().sort(Comparator.comparing(Funcionario::getNome));
            } else if (opcao == 2) {
                baseDados.getFuncionarios().sort(Comparator.comparing(Funcionario::getSalario).reversed());
            } else {
                System.out.println("Opção inválida!");
                return;
            }
            gerarRelatorioFuncionarios();
        }
    }

    public void calcularCustosEmpresa() {
        double totalCusto = baseDados.calcularCustos();
        System.out.println("Custo total da empresa: " + totalCusto);
    }

    public void procurarExamePorCid() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o CID do exame: ");
            String cid = scanner.nextLine();
            Exame exame = baseDados.procurarExamePorCid(cid);
            if (exame == null) {
                System.out.println("Exame não encontrado!");
            } else {
                System.out.println("CID: " + exame.getCid() + ", Nome: " + exame.getNome());
            }
        }
    }

    public void armazenarDadosEmArquivo() {
        baseDados.salvarDados();
    }

    public void recuperarDadosDeArquivo() {
        baseDados.carregarDados();
    }

    public static void main(String[] args) {
        SisSO sistema = new SisSO();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                sistema.imprimeMenu();
                int opcao = scanner.nextInt();
                scanner.nextLine(); // consumir a nova linha
                switch (opcao) {
                    case 1 -> sistema.cadastroExameClinico();
                    case 2 -> sistema.cadastroExameEspecial();
                    case 3 -> sistema.cadastroFuncionario();
                    case 4 -> sistema.cadastroLaudo();
                    case 5 -> sistema.gerarRelatorioFuncionarios();
                    case 6 -> sistema.gerarRelatorioLaudos();
                    case 7 -> sistema.gerarRelatorioExames();
                    case 8 -> sistema.gerarRelatorioLaudosAlterados();
                    case 9 -> sistema.ordenarFuncionarios();
                    case 10 -> sistema.calcularCustosEmpresa();
                    case 11 -> sistema.procurarExamePorCid();
                    case 12 -> sistema.armazenarDadosEmArquivo();
                    case 13 -> sistema.recuperarDadosDeArquivo();
                    case 14 -> {
                        System.out.println("Saindo do sistema...");
                        return;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            }
        }
    }
}
