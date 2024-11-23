package ListOo;

// 1. Criação de uma Classe Simples
class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
    }
}

// 2. Melhorando a Classe com Validação
class ProdutoComDesconto extends Produto {

    public ProdutoComDesconto(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new IllegalArgumentException("O desconto deve estar entre 0% e 50%.");
        }
        setPreco(getPreco() * (1 - porcentagem / 100));
    }
}

// 3. Criação de uma Hierarquia de Classes
class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularBonus() {
        return salario * 0.1; // Base genérica
    }
}

class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.2; // 20% para Gerente
    }
}

class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.1; // 10% para Desenvolvedor
    }
}

// 4. Sobrescrita de Métodos
class FuncionarioBase {
    public void trabalhar() {
        System.out.println("Funcionário está trabalhando.");
    }
}

class GerenteNovo extends FuncionarioBase {
    @Override
    public void trabalhar() {
        System.out.println("Gerente está gerenciando a equipe.");
    }
}

class DesenvolvedorNovo extends FuncionarioBase {
    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor está escrevendo código.");
    }
}

// 5. Polimorfismo com Interfaces
interface IMeioTransporte {
    void acelerar();
    void frear();
}

class Carro implements IMeioTransporte {
    @Override
    public void acelerar() {
        System.out.println("Carro acelerando.");
    }

    @Override
    public void frear() {
        System.out.println("Carro freando.");
    }
}

class Bicicleta implements IMeioTransporte {
    @Override
    public void acelerar() {
        System.out.println("Bicicleta pedalando.");
    }

    @Override
    public void frear() {
        System.out.println("Bicicleta parando.");
    }
}

class Trem implements IMeioTransporte {
    @Override
    public void acelerar() {
        System.out.println("Trem acelerando nos trilhos.");
    }

    @Override
    public void frear() {
        System.out.println("Trem freando nos trilhos.");
    }
}

// 6. Polimorfismo com Classes Abstratas
abstract class Animal {
    public abstract void emitirSom();
}

class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Cachorro: Au au!");
    }
}

class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Gato: Miau!");
    }
}

class Vaca extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Vaca: Muu!");
    }
}

// 7. Abstração em um Sistema de Pagamentos
abstract class FormaPagamento {
    public abstract void processarPagamento(double valor);
    public abstract void validarPagamento();
}

class CartaoCredito extends FormaPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " processado no cartão de crédito.");
    }

    @Override
    public void validarPagamento() {
        System.out.println("Validação de pagamento via cartão de crédito realizada.");
    }
}

class Boleto extends FormaPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " processado via boleto.");
    }

    @Override
    public void validarPagamento() {
        System.out.println("Validação de pagamento via boleto realizada.");
    }
}

class Pix extends FormaPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " processado via Pix.");
    }

    @Override
    public void validarPagamento() {
        System.out.println("Validação de pagamento via Pix realizada.");
    }
}

// 8. Sistema de Gestão de Funcionários
class Estagiario extends Funcionario {
    public Estagiario(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.05; // 5% para estagiários
    }
}

