package ListaEd;

import java.util.Scanner;

class Carta {
    private String valor;
    private String naipe;

    public Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public String getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public void exibirCarta() {
        System.out.println(valor + " de " + naipe);
    }
}

class Node {
    Carta carta;
    Node anterior;
    Node proximo;

    public Node(Carta carta) {
        this.carta = carta;
        this.anterior = null;
        this.proximo = null;
    }
}


class Mao {
    private Node primeiro;
    private Node ultimo;
    private int tamanho;

    public Mao() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionarCarta(Carta carta) {
        Node novoNode = new Node(carta);
        if (tamanho == 0) {
            primeiro = novoNode;
            ultimo = novoNode;
        } else {
            ultimo.proximo = novoNode;
            novoNode.anterior = ultimo;
            ultimo = novoNode;
        }
        tamanho++;
    }

    public void removerCarta(Carta carta) {
        Node atual = primeiro;
        while (atual != null) {
            if (atual.carta == carta) {
                // Caso o node a ser removido não seja o primeiro
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    primeiro = atual.proximo; // Atualiza o primeiro
                }
                // Caso o node a ser removido não seja o último
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    ultimo = atual.anterior; // Atualiza o último
                }
                tamanho--;
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Carta não encontrada.");
    }


    public void exibirMao() {
        if (tamanho == 0) {
            System.out.println("A mão está vazia.");
            return;
        }
        Node atual = primeiro;
        while (atual != null) {
            atual.carta.exibirCarta();
            atual = atual.proximo;
        }
    }

    public void reorganizar() {
        if (tamanho <= 1) return;

        Node atual = primeiro;
        Node temp;
        while (atual != null) {
            temp = atual.proximo;
            atual.proximo = atual.anterior;
            atual.anterior = temp;
            atual = atual.anterior;
        }

        temp = primeiro;
        primeiro = ultimo;
        ultimo = temp;
    }

    public int getTamanho() {
        return tamanho;
    }
}

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mao mao = new Mao();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar carta");
            System.out.println("2. Remover carta");
            System.out.println("3. Reorganizar cartas");
            System.out.println("4. Exibir a mão");
            System.out.println("5. Sair");
            System.out.print("Digite a opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da carta (ex: Ás, Rei, Dama): ");
                    String valor = scanner.nextLine();
                    System.out.print("Digite o naipe da carta (ex: Copas, Espadas, Paus, Ouros): ");
                    String naipe = scanner.nextLine();
                    Carta novaCarta = new Carta(valor, naipe);
                    mao.adicionarCarta(novaCarta);
                    System.out.println("Carta adicionada à mão.");
                    break;

                case 2:
                    System.out.print("Digite o valor da carta a remover (ex: Ás, Rei, Dama): ");
                    valor = scanner.nextLine();
                    System.out.print("Digite o naipe da carta a remover (ex: Copas, Espadas, Paus, Ouros): ");
                    naipe = scanner.nextLine();
                    Carta cartaRemover = new Carta(valor, naipe);
                    mao.removerCarta(cartaRemover);
                    break;

                case 3:
                    mao.reorganizar();
                    System.out.println("Mão reorganizada (invertida).");
                    break;

                case 4:
                    System.out.println("Cartas na mão:");
                    mao.exibirMao();
                    break;

                case 5:
                    System.out.println("Saindo do jogo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
