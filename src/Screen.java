
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;
public class Screen extends JFrame {
    private List<Funcionario> funcionarios;
    public Screen(){
        funcionarios = new ArrayList<>();
        setVisible(true);
        setSize(800,500);
        setTitle("p3 paradigma programação");
        setResizable(false);
        setLayout(null);

        JButton jButtonCadastro = new JButton("Cadastrar Funcionário");
        jButtonCadastro.setBounds(100,95,250,50);
        add(jButtonCadastro);
        jButtonCadastro.addActionListener(e -> actionCadastro());

        JButton jButtonListar = new JButton("Listar Funcionários");
        jButtonListar.setBounds(100,155,250,50);
        add(jButtonListar);
        jButtonListar.addActionListener(this::actionListar);

        JButton jButtonSair = new JButton("Sair");
        jButtonSair.setBounds(100,320,250,50);
        add(jButtonSair);
        jButtonSair.addActionListener(e -> actionSair());
    }

    private void actionCadastro() {
        CadastroPage cadastroPage = new CadastroPage(funcionarios);
        cadastroPage.setVisible(true);
    }

    private void actionListar(ActionEvent actionEvent) {
        ListarPage listarPage = new ListarPage(funcionarios);
        listarPage.setVisible(true);
    }

    private void actionRemover() {
    }

    private void actionSair() {
        System.exit(0);
    }

}


