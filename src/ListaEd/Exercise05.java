package ListaEd;

public class Exercise05 {
    public static class Carta {
        private String naipe;
        private String valor;
        private Carta anterior;
        private Carta proximo;

        public Carta(String valor, String naipe) {
            this.valor = valor;
            this.naipe = naipe;
            this.anterior = null;
            this.proximo = null;
        }

        public String getValor() {
            return valor;
        }

        public String getNaipe() {
            return naipe;
        }

        public Carta getAnterior() {
            return anterior;
        }

        public void setAnterior(Carta anterior) {
            this.anterior = anterior;
        }

        public Carta getProximo() {
            return proximo;
        }

        public void setProximo(Carta proximo) {
            this.proximo = proximo;
        }

        @Override
        public String toString() {
            return valor + " de " + naipe;
        }
    }

    public static class Mao {
        private Carta primeiro;
        private Carta ultimo;

        public Mao() {
            primeiro = null;
            ultimo = null;
        }

        public void adicionarCarta(String valor, String naipe) {
            Carta novaCarta = new Carta(valor, naipe);
            if (primeiro == null) {
                primeiro = novaCarta;
                ultimo = novaCarta;
            } else {
                ultimo.setProximo(novaCarta);
                novaCarta.setAnterior(ultimo);
                ultimo = novaCarta;
            }
        }

        public void removerCarta(Carta carta) {
            if (carta.getAnterior() != null) {
                carta.getAnterior().setProximo(carta.getProximo());
            } else {
                primeiro = carta.getProximo(); // Remover o primeiro
            }
            if (carta.getProximo() != null) {
                carta.getProximo().setAnterior(carta.getAnterior());
            } else {
                ultimo = carta.getAnterior(); // Remover o último
            }
        }

        public void reorganizarCartas() {
            Carta atual = primeiro;
            Carta anterior = null;

            while (atual != null) {
                Carta proximo = atual.getProximo();
                atual.setProximo(anterior);
                atual.setAnterior(proximo);
                anterior = atual;
                atual = proximo;
            }

            // Troca os ponteiros de primeiro e último
            Carta temp = primeiro;
            primeiro = ultimo;
            ultimo = temp;
        }

        public void exibirMao() {
            Carta atual = primeiro;
            while (atual != null) {
                System.out.print(atual + " | ");
                atual = atual.getProximo();
            }
            System.out.println();
        }

        public Carta getPrimeiro() {
            return primeiro;
        }
    }

    public class JogoDeCartas {
        public static void main(String[] args) {
            Mao mao = new Mao();

            // Adicionando cartas
            mao.adicionarCarta("As", "Copas");
            mao.adicionarCarta("Rei", "Espadas");
            mao.adicionarCarta("Dama", "Paus");
            mao.adicionarCarta("Valete", "Ouros");

            System.out.println("Mão atual:");
            mao.exibirMao();

            // Reorganizando cartas
            mao.reorganizarCartas();
            System.out.println("Mão após reorganização:");
            mao.exibirMao();

            // Removendo uma carta (primeira carta como exemplo)
            Carta cartaARemover = mao.getPrimeiro();
            mao.removerCarta(cartaARemover);
            System.out.println("Mão após remoção da primeira carta:");
            mao.exibirMao();
        }
    }

}
