package ListaEd;

import java.util.Scanner;

class Node {
    String action;
    Node next;

    Node(String action) {
        this.action = action;
        this.next = null;
    }
}


class UndoStack {
    private Node head;

    public UndoStack() {
        head = null;
    }

    public void push(String action) {
        Node newNode = new Node(action);
        newNode.next = head;
        head = newNode;
    }

    public String pop() {
        if (head == null) {
            return null;
        }
        String action = head.action;
        head = head.next;
        return action;
    }

    public boolean isEmpty() {
        return head == null;
    }
}


public class Exercise03 {
    private StringBuilder text;
    private UndoStack undoStack;

    public Exercise03() {
        text = new StringBuilder();
        undoStack = new UndoStack();
    }

    public void addText(String newText) {
        undoStack.push(text.toString()); //
        text.append(newText);
    }

    public void undo() {
        String lastAction = undoStack.pop();
        if (lastAction != null) {
            text = new StringBuilder(lastAction);
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void showText() {
        System.out.println("Texto atual: " + text);
    }

    public static void main(String[] args) {
        Exercise03 editor = new Exercise03();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Digite um texto (ou 'undo' para desfazer, 'exit' para sair):");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("undo")) {
                editor.undo();
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                editor.addText(command);
            }

            editor.showText();
        }

        scanner.close();
    }
}
