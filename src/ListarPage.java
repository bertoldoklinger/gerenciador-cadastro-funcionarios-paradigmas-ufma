import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;


public class ListarPage extends JFrame {
    private List<Funcionario> funcionarios;
    private JTextArea textArea;

    public ListarPage(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;

        setVisible(true);
        setSize(800, 500);
        setTitle("Lista de Funcionários");
        setResizable(false);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(100, 50, 600, 300);
        textArea.setEditable(false);
        add(textArea);

        JButton removerButton = new JButton("Remover");
        removerButton.setBounds(200, 380, 100, 30);
        add(removerButton);
        removerButton.addActionListener(this::remover);

        JButton atualizarButton = new JButton("Atualizar");
        atualizarButton.setBounds(350, 380, 100, 30);
        add(atualizarButton);
        atualizarButton.addActionListener(this::atualizar);

        JButton fecharButton = new JButton("Fechar");
        fecharButton.setBounds(500, 380, 100, 30);
        add(fecharButton);
        fecharButton.addActionListener(this::fechar);

        exibirFuncionarios();
    }

    void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            textArea.setText("Não há funcionários cadastrados.");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Lista de Funcionários:\n\n");
            for (Funcionario funcionario : funcionarios) {
                sb.append(funcionario).append("\n");
            }
            textArea.setText(sb.toString());
        }
    }

    private void remover(ActionEvent actionEvent) {
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário a ser removido:");
        if (!nome.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Opção inválida. O nome deve conter apenas letras.");
            return;
        }

        Funcionario funcionarioEncontrado = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioEncontrado = funcionario;
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            funcionarios.remove(funcionarioEncontrado);
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
            exibirFuncionarios();
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
        }
    }

    private void atualizar(ActionEvent actionEvent) {
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário a ser atualizado:");
        if (!nome.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Opção inválida. O nome deve conter apenas letras.");
            return;
        }

        Funcionario funcionarioEncontrado = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioEncontrado = funcionario;
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            String opcaoStr = JOptionPane.showInputDialog("Funcionário encontrado. Selecione a informação a ser atualizada:\n"
                    + "1. Nome\n"
                    + "2. Idade\n"
                    + "3. Cargo\n"
                    + "4. Salário (para Funcionário Efetivo) / Duração do Contrato (para Funcionário Temporário)\n");

            try {
                int opcao = Integer.parseInt(opcaoStr);

                switch (opcao) {
                    case 1:
                        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do funcionário:");
                        if (!novoNome.matches("[a-zA-Z]+")) {
                            JOptionPane.showMessageDialog(null, "Opção inválida. O nome deve conter apenas letras.");
                            return;
                        }
                        funcionarioEncontrado.setNome(novoNome);
                        JOptionPane.showMessageDialog(null, "Nome atualizado com sucesso!");
                        exibirFuncionarios();
                        break;
                    case 2:
                        String idadeStr = JOptionPane.showInputDialog("Digite a nova idade do funcionário:");
                        int novaIdade = Integer.parseInt(idadeStr);
                        funcionarioEncontrado.setIdade(novaIdade);
                        JOptionPane.showMessageDialog(null, "Idade atualizada com sucesso!");
                        exibirFuncionarios();
                        break;
                    case 3:
                        String novoCargo = JOptionPane.showInputDialog("Digite o novo cargo do funcionário:");
                        if (!novoCargo.matches("[a-zA-Z]+")) {
                            JOptionPane.showMessageDialog(null, "Opção inválida. O cargo deve conter apenas letras.");
                            return;
                        }
                        funcionarioEncontrado.setCargo(novoCargo);
                        JOptionPane.showMessageDialog(null, "Cargo atualizado com sucesso!");
                        exibirFuncionarios();
                        break;
                    case 4:
                        if (funcionarioEncontrado instanceof FuncionarioEfetivo) {
                            String salarioStr = JOptionPane.showInputDialog("Digite o novo salário do funcionário efetivo:");
                            double novoSalario = Double.parseDouble(salarioStr);
                            ((FuncionarioEfetivo) funcionarioEncontrado).setSalario(novoSalario);
                            JOptionPane.showMessageDialog(null, "Salário atualizado com sucesso!");
                        } else if (funcionarioEncontrado instanceof FuncionarioTemporario) {
                            String duracaoStr = JOptionPane.showInputDialog("Digite a nova duração do contrato do funcionário temporário (em meses):");
                            int novaDuracaoContrato = Integer.parseInt(duracaoStr);
                            ((FuncionarioTemporario) funcionarioEncontrado).setDuracaoContrato(novaDuracaoContrato);
                            JOptionPane.showMessageDialog(null, "Duração do contrato atualizada com sucesso!");
                        }
                        exibirFuncionarios();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Nenhuma informação foi atualizada.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Deve conter apenas números.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
        }
    }

    private void fechar(ActionEvent actionEvent) {
        dispose();
    }
}
