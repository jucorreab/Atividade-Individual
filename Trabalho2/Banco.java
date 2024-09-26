package Trabalho2;

class Banco {
    private static Banco instance = new Banco();

    private Banco() {}

    public static Banco getInstance() {
        return instance;
    }

    public synchronized void transferir(Conta origem, Conta destino, double valor, String origemNome, String destinoNome) {
        if (origem.sacar(valor)) {
            destino.depositar(valor);
        } else {
            System.out.println("Falha na transferência de " + origemNome + " para " + destinoNome + ". Saldo insuficiente.");
        }
    }

}

