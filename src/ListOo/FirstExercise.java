/*
Encapsulamento

1. Criação de uma Classe Simples
○ Objetivo: Crie uma classe Produto que represente um produto de uma
loja. A classe deve ter atributos privados nome, preco e quantidade em
estoque. Implemente métodos públicos para acessar e modificar esses
atributos. Garanta que o preço e a quantidade não possam ser negativos.*
*/


package ListOo;

public class FirstExercise {

    public static class Produto {

        private String nome;
        private double preco;
        private int quantidadeEmEstoque;

        public Produto(String nome, double preco, int quantidadeEmEstoque) {
            this.nome = nome;
            setPreco(preco);  // Validar o preço com setter
            setQuantidadeEmEstoque(quantidadeEmEstoque);  // Validar a quantidade com setter
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public int getQuantidadeEmEstoque() {
            return quantidadeEmEstoque;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setPreco(double preco) {
            if (preco >= 0) {
                this.preco = preco;
            } else {
                System.out.println("Erro: O preço não pode ser negativo.");
            }
        }

        public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
            if (quantidadeEmEstoque >= 0) {
                this.quantidadeEmEstoque = quantidadeEmEstoque;
            } else {
                System.out.println("Erro: A quantidade em estoque não pode ser negativa.");
            }
        }

        public void exibirInformacoes() {
            System.out.println("Nome do Produto: " + nome);
            System.out.println("Preço: R$ " + preco);
            System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
        }
    }

    public static void main(String[] args) {
        Produto produto = new Produto("Camiseta", 49.99, 20);
        produto.exibirInformacoes();

        produto.setPreco(-10);
        produto.setQuantidadeEmEstoque(-5);
        produto.exibirInformacoes();
    }
}
