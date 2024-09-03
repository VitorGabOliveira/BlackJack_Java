package Baralho;

public class Carta {
    String valor; // número ou letra da carta (2-10, J, Q, K, A)
    String naipe; // naipe da carta (copas, ouros, espadas, paus)
    int valorBlackjack; // valor correspondente no blackjack

    public Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
        this.valorBlackjack = calcularValorBlackjack(valor);
    }

    private int calcularValorBlackjack(String valor) {
        switch (valor) {
            case "A":
                return 1; // Ás sempre vale 1
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(valor);
        }
    }

    public int getValorBlackjack() {
        return valorBlackjack;
    }

    public String desenharCarta() {
        String naipeFormatado = String.format("%-9s", naipe);
        String valorFormatado = String.format("%-3s", valor);
        return String.format(
                "┌─────────┐\n" +
                        "│%-9s│\n" +
                        "│         │\n" +
                        "│  %3s    │\n" +
                        "│         │\n" +
                        "│%9s│\n" +
                        "└─────────┘",
                naipeFormatado, valorFormatado.trim(), naipeFormatado.trim()
        );
    }

    @Override
    public String toString() {
        return desenharCarta();
    }
}