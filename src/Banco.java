import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	//CONSTRUTOR
	public Banco() {
        this.contas = new ArrayList<>(); 
    }

	//add conta
	public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	//ENCONTRAR CONTAS POR NUMERO DA CONTA
	public Conta encontrarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }


	//VER LISTA POR CLIETES
	public List<Conta> encontrarContasPorCliente(Cliente cliente) {
        List<Conta> contasCliente = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.cliente.equals(cliente)) {
                contasCliente.add(conta);
            }
        }
        return contasCliente;
    }

	//imprimir contas do cliente
	public void imprimirContasCliente(Cliente cliente) {
        List<Conta> contasCliente = encontrarContasPorCliente(cliente);
        System.out.println(String.format("Cliente: %s", cliente.getNome()));
        for (Conta conta : contasCliente) {
            conta.imprimirExtrato();
        }
    }

}
