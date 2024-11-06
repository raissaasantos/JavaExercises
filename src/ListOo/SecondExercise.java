package ListOo;

class DescontoInvalidoException extends Exception {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

public class SecondExercise {

    public static class Produto {

        private String nome;
        private double preco;
        private int quantidadeEmEstoque;

        public Produto(String nome, double preco, int quantidadeEmEstoque) {
            this.nome = nome;
            setPreco(preco);
            setQuantidadeEmEstoque(quantidadeEmEstoque);
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

        public void aplicarDesconto(double porcentagem) throws DescontoInvalidoException {
            if (porcentagem < 0 || porcentagem > 50) {
                throw new DescontoInvalidoException("Desconto inválido! O desconto não pode ser maior que 50%.");
            }
            double desconto = (preco * porcentagem) / 100;
            preco -= desconto;
            System.out.println("Desconto aplicado: " + porcentagem + "%");
        }

        public void exibirInformacoes() {
            System.out.println("Nome do Produto: " + nome);
            System.out.println("Preço: R$ " + preco);
            System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
        }
    }

    public static void main(String[] args) {
        try {
            Produto produto = new Produto("Camiseta", 49.99, 20);
            produto.exibirInformacoes();

            produto.aplicarDesconto(20);
            produto.exibirInformacoes();
            produto.aplicarDesconto(60);

        } catch (DescontoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}

