import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();
        Scanner scanner = new Scanner(System.in);

        String opcao ;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next();

            switch (opcao) {
                case "1":
                    gerenciador.cadastrar();
                    break;
                case "2":
                    gerenciador.listar();
                    break;
                case "3":
                    gerenciador.atualizar();
                    break;
                case "4":
                    gerenciador.remover();
                    break;
                case "5":
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }while (!opcao.equals("5"));
    }
}