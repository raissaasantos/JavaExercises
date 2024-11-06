package ListaEd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Processo {
    private int id;
    private int tempoExecucao;

    public Processo(int id, int tempoExecucao) {
        this.id = id;
        this.tempoExecucao = tempoExecucao;
    }

    public int getId() {
        return id;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void exibirProcesso() {
        System.out.println("Processo ID: " + id + " - Tempo de Execução: " + tempoExecucao + "ms");
    }
}

class FilaProcessos {
    private Queue<Processo> fila;

    public FilaProcessos() {
        fila = new LinkedList<>();
    }

    public void adicionarProcesso(Processo processo) {
        fila.add(processo);
        System.out.println("Processo ID: " + processo.getId() + " adicionado à fila.");
    }

    public void executarProximoProcesso() {
        if (!fila.isEmpty()) {
            Processo processo = fila.poll();
            System.out.print("Executando ");
            processo.exibirProcesso();
        } else {
            System.out.println("Não há processos na fila.");
        }
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila de processos está vazia.");
        } else {
            System.out.println("Processos na fila:");
            for (Processo processo : fila) {
                processo.exibirProcesso();
            }
        }
    }
}


public class Exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaProcessos filaProcessos = new FilaProcessos();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar processo à fila");
            System.out.println("2. Executar próximo processo");
            System.out.println("3. Exibir processos na fila");
            System.out.println("4. Sair");
            System.out.print("Digite a opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do processo: ");
                    int id = scanner.nextInt();
                    System.out.print("Digite o tempo de execução do processo (em ms): ");
                    int tempoExecucao = scanner.nextInt();
                    scanner.nextLine();  // Para capturar o Enter após o número
                    Processo novoProcesso = new Processo(id, tempoExecucao);
                    filaProcessos.adicionarProcesso(novoProcesso);
                    break;

                case 2:
                    filaProcessos.executarProximoProcesso();
                    break;

                case 3:
                    filaProcessos.exibirFila();
                    break;

                case 4:
                    System.out.println("Saindo do simulador...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
