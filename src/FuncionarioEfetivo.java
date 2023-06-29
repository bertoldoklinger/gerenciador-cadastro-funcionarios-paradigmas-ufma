class FuncionarioEfetivo extends Funcionario {
    private double salario;

    public FuncionarioEfetivo(String nome, int idade, String cargo, double salario) {
        super(nome, idade, cargo);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salário: " + salario;
    }
}
