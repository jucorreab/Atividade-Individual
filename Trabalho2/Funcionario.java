package Trabalho2;

class Funcionario extends Thread {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(String nome) {
        this.nome = nome;
        this.contaSalario = new Conta(0);
        this.contaInvestimento = new Conta(0);
    }

    @Override
    public void run() {
    	    try {
    	        Thread.sleep(100); 
    	    } catch (InterruptedException e) {
    	        Thread.currentThread().interrupt();
    	    }
    }

    public void investir(double valor) {
        contaInvestimento.depositar(valor); 
    }

    public String getNome() {
        return nome;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }
}
