class FuncionarioTemporario extends Funcionario {
    private int duracaoContrato;

    public FuncionarioTemporario(String nome, int idade, String cargo, int duracaoContrato) {
        super(nome, idade, cargo);
        this.duracaoContrato = duracaoContrato;
    }

    public int getDuracaoContrato() {
        return duracaoContrato;
    }

    public void setDuracaoContrato(int duracaoContrato) {
        this.duracaoContrato = duracaoContrato;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duração do Contrato: " + duracaoContrato + " meses";
    }
}