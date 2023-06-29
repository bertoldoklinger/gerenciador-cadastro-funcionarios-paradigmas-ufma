import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GerenciadorFuncionarios implements Cadastro {
    private List<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    @Override
    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do funcionário: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1. Funcionário Efetivo");
        System.out.println("2. Funcionário Temporário");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.print("Digite o salário do funcionário efetivo: ");
            double salario = scanner.nextDouble();

            FuncionarioEfetivo funcionarioEfetivo = new FuncionarioEfetivo(nome, idade, cargo, salario);
            funcionarios.add(funcionarioEfetivo);
            System.out.println("Funcionário efetivo cadastrado com sucesso!");
        } else if (opcao == 2) {
            System.out.print("Digite a duração do contrato do funcionário temporário (em meses): ");
            int duracaoContrato = scanner.nextInt();

            FuncionarioTemporario funcionarioTemporario = new FuncionarioTemporario(nome, idade, cargo, duracaoContrato);
            funcionarios.add(funcionarioTemporario);
            System.out.println("Funcionário temporário cadastrado com sucesso!");
        } else {
            System.out.println("Opção inválida. Nenhum funcionário cadastrado.");
        }
    }

    @Override
    public void listar() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de Funcionários:");

            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    @Override
    public void atualizar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário a ser atualizado: ");
        String nome = scanner.nextLine();

        Funcionario funcionarioEncontrado = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioEncontrado = funcionario;
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            System.out.println("Funcionário encontrado. Selecione a informação a ser atualizada:");
            System.out.println("1. Nome");
            System.out.println("2. Idade");
            System.out.println("3. Cargo");
            if (funcionarioEncontrado instanceof FuncionarioEfetivo) {
                System.out.println("4. Salário");
            } else if (funcionarioEncontrado instanceof FuncionarioTemporario) {
                System.out.println("4. Duração do Contrato");
            }
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome do funcionário: ");
                    String novoNome = scanner.nextLine();
                    funcionarioEncontrado.setNome(novoNome);
                    System.out.println("Nome atualizado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a nova idade do funcionário: ");
                    int novaIdade = scanner.nextInt();
                    funcionarioEncontrado.setIdade(novaIdade);
                    System.out.println("Idade atualizada com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o novo cargo do funcionário: ");
                    String novoCargo = scanner.nextLine();
                    funcionarioEncontrado.setCargo(novoCargo);
                    System.out.println("Cargo atualizado com sucesso!");
                    break;
                case 4:
                    if (funcionarioEncontrado instanceof FuncionarioEfetivo) {
                        System.out.print("Digite o novo salário do funcionário efetivo: ");
                        double novoSalario = scanner.nextDouble();
                        ((FuncionarioEfetivo) funcionarioEncontrado).setSalario(novoSalario);
                        System.out.println("Salário atualizado com sucesso!");
                    } else if (funcionarioEncontrado instanceof FuncionarioTemporario) {
                        System.out.print("Digite a nova duração do contrato do funcionário temporário (em meses): ");
                        int novaDuracaoContrato = scanner.nextInt();
                        ((FuncionarioTemporario) funcionarioEncontrado).setDuracaoContrato(novaDuracaoContrato);
                        System.out.println("Duração do contrato atualizada com sucesso!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Nenhuma informação atualizada.");
            }
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    @Override
    public void remover() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário a ser removido: ");
        String nome = scanner.nextLine();

        Funcionario funcionarioEncontrado = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioEncontrado = funcionario;
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            funcionarios.remove(funcionarioEncontrado);
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}