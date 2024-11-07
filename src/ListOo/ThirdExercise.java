package ListOo;


class Gerente extends Funcionario {
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }
    public double calcularBonusGerente() {
        return salario * 0.20;
    }
}


class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    public double calcularBonusDesenvolvedor() {
        return salario * 0.10;
    }
}

public class ThirdExercise {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Carlos", 5000.00);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Ana", 4000.00);

        System.out.println("Informações do Gerente:");
        gerente.exibirInformacoes();
        System.out.println("Bônus do Gerente: R$ " + gerente.calcularBonusGerente());

        System.out.println("\nInformações do Desenvolvedor:");
        desenvolvedor.exibirInformacoes();
        System.out.println("Bônus do Desenvolvedor: R$ " + desenvolvedor.calcularBonusDesenvolvedor());
    }
}
