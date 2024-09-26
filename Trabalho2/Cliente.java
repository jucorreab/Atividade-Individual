package Trabalho2;

class Cliente extends Thread {
    private String nome;
    private Conta conta;
    private Loja loja1;
    private Loja loja2;

    public Cliente(String nome, Loja loja1, Loja loja2) {
        this.nome = nome;
        this.conta = new Conta(2000.00);
        this.loja1 = loja1;
        this.loja2 = loja2;
    }

    @Override
    public void run() {
    	    realizarCompra(loja1);
    	    realizarCompra(loja2);  
    	    realizarCompra(loja1);
    	    realizarCompra(loja2);
    	}

    private void realizarCompra(Loja loja) {
        double valorCompra = 200 + Math.random() * 300;  
        synchronized (conta) {
            if (conta.getSaldo() >= valorCompra) {
                Banco.getInstance().transferir(conta, loja.getConta(), valorCompra, nome, loja.getNome());
                System.out.println(nome + " comprou na " + loja.getNome() + " por R$ " + String.format("%.2f", valorCompra));
            } else {
                System.out.println(nome + " não conseguiu comprar. Saldo insuficiente.");
            }
        }
    }


}
