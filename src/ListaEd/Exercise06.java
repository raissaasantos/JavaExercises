package ListaEd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Classe Cliente representando o cliente do banco
class Cliente {
    private String nome;
    private int numeroCliente;

    public Cliente(String nome, int numeroCliente) {
        this.nome = nome;
        this.numeroCliente = numeroCliente;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }
}

// Classe Fila para gerenciar os clientes no atendimento
class Fila {
    private Queue<Cliente> filaDeAtendimento;

    public Fila() {
        filaDeAtendimento = new LinkedList<>();
    }

    // Adicionar um cliente à fila
    public void adicionarCliente(Cliente cliente) {
        filaDeAtendimento.add(cliente);
        System.out.println(cliente.getNome() + " entrou na fila.");
    }

    // Chamar o próximo cliente da fila
    public void chamarProximoCliente() {
        if (!filaDeAtendimento.isEmpty()) {
            Cliente cliente = filaDeAtendimento.poll();  // remove o primeiro da fila
            System.out.println(cliente.getNome() + " está sendo atendido.");
        } else {
            System.out.println("Nenhum cliente na fila.");
        }
    }

    // Exibir todos os clientes na fila
    public void exibirFila() {
        if (filaDeAtendimento.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Clientes na fila:");
            for (Cliente cliente : filaDeAtendimento) {
                System.out.println("Cliente " + cliente.getNumeroCliente() + ": " + cliente.getNome());
            }
        }
    }

    // Verificar se a fila está vazia
    public boolean isFilaVazia() {
        return filaDeAtendimento.isEmpty();
    }
}

// Classe principal para rodar o simulador de fila de atendimento
public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();
        int numeroCliente = 1;

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar cliente à fila");
            System.out.println("2. Chamar próximo cliente");
            System.out.println("3. Exibir clientes na fila");
            System.out.println("4. Sair");
            System.out.print("Digite a opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Para capturar o Enter após o número

            switch (opcao) {
                case 1:
                    // Adicionar um novo cliente à fila
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nome, numeroCliente++);
                    fila.adicionarCliente(novoCliente);
                    break;

                case 2:
                    // Chamar o próximo cliente
                    fila.chamarProximoCliente();
                    break;

                case 3:
                    // Exibir todos os clientes na fila
                    fila.exibirFila();
                    break;

                case 4:
                    // Sair
                    System.out.println("Saindo do simulador...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

