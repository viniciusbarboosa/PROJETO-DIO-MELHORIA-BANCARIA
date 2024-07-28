import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
        banco.setNome("Meu Banco");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n1. Depositar na Conta Corrente");
            System.out.println("2. Transferir para Conta Poupança");
            System.out.println("3. Imprimir Extrato Conta Corrente");
            System.out.println("4. Imprimir Extrato Conta Poupança");
            System.out.println("5. Imprimir todas as contas do cliente");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    cc.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor para transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    cc.transferir(valorTransferencia, poupanca);
                    break;
                case 3:
                    cc.imprimirExtrato();
                    break;
                case 4:
                    poupanca.imprimirExtrato();
                    break;
                case 5:
                    banco.imprimirContasCliente(venilton);
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
	}

}
