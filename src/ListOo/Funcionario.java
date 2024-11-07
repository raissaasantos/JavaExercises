package ListOo;

public class Funcionario {

    // Atributos comuns a todos os funcionários
    protected String nome;
    protected double salario;

    
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    
    public double calcularBonus() {
        return 0; 
    }
    
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$ " + salario);
    }
}
