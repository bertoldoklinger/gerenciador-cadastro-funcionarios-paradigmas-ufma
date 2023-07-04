import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CadastroPage extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField cargoField;

    private List<Funcionario> funcionarios;
    private ListarPage listarPage;

    public CadastroPage(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
        setVisible(true);
        setSize(800, 500);
        setTitle("Pagina de Cadastro");
        setResizable(false);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome do funcionário:");
        nomeLabel.setBounds(100, 50, 200, 20);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(300, 50, 200, 20);
        add(nomeField);

        JLabel idadeLabel = new JLabel("Idade do funcionário:");
        idadeLabel.setBounds(100, 100, 200, 20);
        add(idadeLabel);

        idadeField = new JTextField();
        idadeField.setBounds(300, 100, 200, 20);
        add(idadeField);

        JLabel cargoLabel = new JLabel("Cargo do funcionário:");
        cargoLabel.setBounds(100, 150, 200, 20);
        add(cargoLabel);

        cargoField = new JTextField();
        cargoField.setBounds(300, 150, 200, 20);
        add(cargoField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(300, 200, 100, 30);
        add(cadastrarButton);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });

        listarPage = new ListarPage(funcionarios);
    }

    public void cadastrar() {
        String nome = nomeField.getText();
        String idadeText = idadeField.getText();
        String cargo = cargoField.getText();

        if (!nome.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Opção inválida. O nome deve conter apenas letras.");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opção inválida. A idade deve ser um número válido.");
            return;
        }

        if (!cargo.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Opção inválida. O cargo deve conter apenas letras.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Selecione o tipo de funcionário:\n1. Funcionário Efetivo\n2. Funcionário Temporário");
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção:"));

        if (opcao == 1) {
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário efetivo:"));
            FuncionarioEfetivo funcionarioEfetivo = new FuncionarioEfetivo(nome, idade, cargo, salario);
            funcionarios.add(funcionarioEfetivo);
            JOptionPane.showMessageDialog(null, "Funcionário efetivo cadastrado com sucesso!");
            listarPage.exibirFuncionarios();

        } else if (opcao == 2) {
            int duracaoContrato = Integer.parseInt(JOptionPane.showInputDialog("Digite a duração do contrato do funcionário temporário (em meses):"));
            FuncionarioTemporario funcionarioTemporario = new FuncionarioTemporario(nome, idade, cargo, duracaoContrato);
            funcionarios.add(funcionarioTemporario);
            JOptionPane.showMessageDialog(null, "Funcionário temporário cadastrado com sucesso!");

            listarPage.exibirFuncionarios();
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida. Informe um número válido.");
        }
    }
}

