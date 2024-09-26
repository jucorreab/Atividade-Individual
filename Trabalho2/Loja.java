package Trabalho2;

class Loja {
    private String nome;
    private Conta conta;

    public Loja(String nome) {
        this.nome = nome;
        this.conta = new Conta(0);
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }

    public synchronized boolean pagarFuncionario(Funcionario funcionario) {
        double salario = 1400.00;
        if (conta.getSaldo() >= salario) {
            Banco.getInstance().transferir(conta, funcionario.getContaSalario(), salario, nome, funcionario.getNome());

            double investimento = salario * 0.20; 
            funcionario.investir(investimento);  

            System.out.println("Transferência de R$ " + String.format("%.2f", salario) + 
                               " de " + nome + " para " + funcionario.getNome() + " realizada com sucesso.");
            System.out.println(funcionario.getNome() + " recebeu o salário de R$ " + String.format("%.2f", salario));
            System.out.println(funcionario.getNome() + " investiu R$ " + String.format("%.2f", investimento));
            return true;
        } else {
            System.out.println("Loja " + nome + " não tem saldo suficiente para pagar o salário de " + funcionario.getNome());
            return false;
        }
    }

}




