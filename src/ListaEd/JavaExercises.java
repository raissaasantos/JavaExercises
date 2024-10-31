package ListaEd;

import java.util.Scanner;

public class JavaExercises {
    static class HistoryNode {
        String url;
        HistoryNode next;

        public HistoryNode(String url) {
            this.url = url;
            this.next = null;
        }
    }

    static class BrowserHistory {
        private HistoryNode head;
        private int size;
        private int maxSize;

        public BrowserHistory(int maxSize) {
            this.head = null;
            this.size = 0;
            this.maxSize = maxSize;
        }

        public void addUrl(String url) {
            HistoryNode newNode = new HistoryNode(url);
            if (size == maxSize) {
                removeOldestUrl();
            }
            newNode.next = head;
            head = newNode;
            size++;
        }

        private void removeOldestUrl() {
            if (head == null) return;

            head = head.next;
            size--;
        }


        public void displayHistory() {
            if (head == null) {
                System.out.println("Histórico vazio.");
                return;
            }

            HistoryNode current = head;
            System.out.println("Histórico de Navegação:");
            while (current != null) {
                System.out.println(current.url);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número máximo de URLs no histórico: ");
        int maxSize = scanner.nextInt();
        scanner.nextLine();

        BrowserHistory history = new BrowserHistory(maxSize);
        String command;

        do {
            System.out.println("\nComandos disponíveis:");
            System.out.println("1: Adicionar URL");
            System.out.println("2: Exibir histórico");
            System.out.println("0: Sair");
            System.out.print("Escolha um comando: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Digite a URL: ");
                    String url = scanner.nextLine();
                    history.addUrl(url);
                    break;

                case "2":
                    history.displayHistory();
                    break;

                case "0":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Comando inválido. Tente novamente.");
                    break;
            }
        } while (!command.equals("0"));

        scanner.close();
    }
}
