package ListaEd;

import java.util.Scanner;

public class Exercise01 {
    static class TaskNode {
        String description;
        boolean completed;
        TaskNode next;

        public TaskNode(String description) {
            this.description = description;
            this.completed = false;
            this.next = null;
        }
    }

    static class TaskManager {
        private TaskNode head;

        public TaskManager() {
            this.head = null;
        }

        public void addTask(String description) {
            TaskNode newTask = new TaskNode(description);
            if (head == null) {
                head = newTask;
            } else {
                TaskNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newTask;
            }
        }

        public boolean removeTask(String description) {
            TaskNode current = head;
            TaskNode previous = null;

            while (current != null) {
                if (current.description.equals(description)) {
                    if (previous != null) {
                        previous.next = current.next;
                    } else {
                        head = current.next;
                    }
                    return true; // Tarefa removida
                }
                previous = current;
                current = current.next;
            }
            return false; // Tarefa não encontrada
        }

        public boolean markTaskCompleted(String description) {
            TaskNode current = head;
            while (current != null) {
                if (current.description.equals(description)) {
                    current.completed = true;
                    return true; // Tarefa marcada como concluída
                }
                current = current.next;
            }
            return false; // Tarefa não encontrada
        }

        public void displayTasks() {
            TaskNode current = head;
            if (current == null) {
                System.out.println("Nenhuma tarefa encontrada.");
                return;
            }

            while (current != null) {
                String status = current.completed ? "✔️" : "❌";
                System.out.println("[" + status + "] " + current.description);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("\nComandos disponíveis: ");
            System.out.println("1: Adicionar tarefa");
            System.out.println("2: Marcar tarefa como concluída");
            System.out.println("3: Remover tarefa");
            System.out.println("4: Exibir tarefas");
            System.out.println("0: Sair");
            System.out.print("Escolha um comando: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Descrição da tarefa: ");
                    String description = scanner.nextLine();
                    manager.addTask(description);
                    break;

                case "2":
                    System.out.print("Descrição da tarefa a ser marcada como concluída: ");
                    String completedTask = scanner.nextLine();
                    manager.markTaskCompleted(completedTask);
                    break;

                case "3":
                    System.out.print("Descrição da tarefa a ser removida: ");
                    String taskToRemove = scanner.nextLine();
                    if (manager.removeTask(taskToRemove)) {
                        System.out.println("Tarefa removida.");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case "4":
                    System.out.println("Tarefas:");
                    manager.displayTasks();
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
