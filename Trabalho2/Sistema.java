package Trabalho2;

public class Sistema {
    public static void main(String[] args) throws InterruptedException {
        Loja loja1 = new Loja("Loja 1");
        Loja loja2 = new Loja("Loja 2");

        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        Funcionario funcionario3 = new Funcionario("Funcionario 3");
        Funcionario funcionario4 = new Funcionario("Funcionario 4");

        Cliente[] clientes = new Cliente[10];
        System.out.println("=== Compras dos Clientes ===");
        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1), loja1, loja2);
        }

        for (Cliente cliente : clientes) {
            cliente.start();
        }

        for (Cliente cliente : clientes) {
            cliente.join();
        }
        
       	System.out.println("\n=== Pagamentos dos Funcionários ===");
        loja1.pagarFuncionario(funcionario1);
        loja1.pagarFuncionario(funcionario2);
        loja2.pagarFuncionario(funcionario3);
        loja2.pagarFuncionario(funcionario4);
        
        System.out.printf("\n=== Saldos finais das lojas ===\n");
        System.out.println(loja1.getNome() + ": Conta com saldo: R$ " + String.format("%.2f", loja1.getConta().getSaldo()));
        System.out.println(loja2.getNome() + ": Conta com saldo: R$ " + String.format("%.2f", loja2.getConta().getSaldo()));

        System.out.println("\n=== Saldos Finais dos Funcionários ===");
        exibirSaldosFuncionarios(new Funcionario[]{funcionario1, funcionario2, funcionario3, funcionario4});
    }

    private static void exibirSaldosFuncionarios(Funcionario[] funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + ": Conta Salário com saldo: R$ " + String.format("%.2f", funcionario.getContaSalario().getSaldo()));
            System.out.println(funcionario.getNome() + ": Conta Investimento com saldo: R$ " + String.format("%.2f", funcionario.getContaInvestimento().getSaldo()));
        }
    }
}
