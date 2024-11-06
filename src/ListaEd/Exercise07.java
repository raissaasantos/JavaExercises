package ListaEd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TrabalhoImpressao {
    private String nomeDocumento;
    private int numeroPaginas;

    public TrabalhoImpressao(String nomeDocumento, int numeroPaginas) {
        this.nomeDocumento = nomeDocumento;
        this.numeroPaginas = numeroPaginas;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}

class FilaImpressao {
    private Queue<TrabalhoImpressao> fila;

    public FilaImpressao() {
        fila = new LinkedList<>();
    }


    public void adicionarTrabalho(TrabalhoImpressao trabalho) {
        fila.add(trabalho);
        System.out.println(trabalho.getNomeDocumento() + " foi adicionado à fila.");
    }

    public void processarProximoTrabalho() {
        if (!fila.isEmpty()) {
            TrabalhoImpressao trabalho = fila.poll();
            System.out.println("Processando: Documento " + trabalho.getNomeDocumento() + " com " + trabalho.getNumeroPaginas() + " páginas.");
        } else {
            System.out.println("Não há trabalhos na fila.");
        }
    }


    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila de impressão está vazia.");
        } else {
            System.out.println("Trabalhos na fila de impressão:");
            for (TrabalhoImpressao trabalho : fila) {
                System.out.println("Documento: " + trabalho.getNomeDocumento() + " - Páginas: " + trabalho.getNumeroPaginas());
            }
        }
    }
}


public class Exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaImpressao filaImpressao = new FilaImpressao();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar trabalho à fila de impressão");
            System.out.println("2. Processar próximo trabalho");
            System.out.println("3. Exibir trabalhos na fila");
            System.out.println("4. Sair");
            System.out.print("Digite a opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do documento: ");
                    String nomeDocumento = scanner.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    int numeroPaginas = scanner.nextInt();
                    scanner.nextLine();  // Para capturar o Enter após o número
                    TrabalhoImpressao novoTrabalho = new TrabalhoImpressao(nomeDocumento, numeroPaginas);
                    filaImpressao.adicionarTrabalho(novoTrabalho);
                    break;

                case 2:
                    filaImpressao.processarProximoTrabalho();
                    break;

                case 3:
                    filaImpressao.exibirFila();
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

