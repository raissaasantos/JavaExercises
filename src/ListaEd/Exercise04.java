package ListaEd;

import java.util.Scanner;

class Node {
    String action;
    Node next;
    Node prev;

    Node(String action) {
        this.action = action;
        this.next = null;
        this.prev = null;
    }
}

public class Exercise04 {
    private StringBuilder text;
    private Node current;

    public Exercise04() {
        text = new StringBuilder();
        current = null;
    }

    public void addText(String newText) {
        Node newNode = new Node(text.toString());
        newNode.prev = current;

        if (current != null) {
            current.next = newNode; // Atualiza o próximo do nó atual
        }

        current = newNode; // Atualiza o nó atual
        text.append(newText); // Adiciona o novo texto
    }

    public void undo() {
        if (current == null) {
            System.out.println("Nada para desfazer.");
            return;
        }

        current = current.prev; // Move para o nó anterior
        if (current != null) {
            text = new StringBuilder(current.action); // Restaura o texto do nó anterior
        } else {
            text = new StringBuilder(); // Se não houver anterior, zera o texto
        }
        System.out.println("Texto atual: " + text);
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nada para refazer.");
            return;
        }

        current = current.next; // Move para o próximo nó
        text = new StringBuilder(current.action); // Restaura o texto do próximo nó
        System.out.println("Texto atual: " + text);
    }

    public void showText() {
        System.out.println("Texto atual: " + text);
    }

    public static void main(String[] args) {
        Exercise04 editor = new Exercise04();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Digite um texto (ou 'undo' para desfazer, 'redo' para refazer, 'exit' para sair):");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("undo")) {
                editor.undo();
            } else if (command.equalsIgnoreCase("redo")) {
                editor.redo();
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                editor.addText(command);
                editor.showText();
            }
        }

        scanner.close();
    }
}
