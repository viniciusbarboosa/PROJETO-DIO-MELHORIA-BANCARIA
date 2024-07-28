
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	//verificação antes de sacar
	@Override
	public void sacar(double valor) {
		if (valor <= 0) {
			System.out.println("Valor inválido para saque.");
			return;
		}
		if (saldo >= valor) {
			saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	//NAO DEPOSITAR VALOR NEGATIVO OU 0
	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            saldo += valor;
        }
	}

	//VERIFICAÇÕES DO VALOR DA CONTA
	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
