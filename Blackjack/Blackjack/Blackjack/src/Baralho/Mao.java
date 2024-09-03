package Baralho;

import java.util.ArrayList;
import java.util.List;

public class Mao {
    private List<Carta> cartas;

    public Mao() {
        this.cartas = new ArrayList<>();
    }

    public void addCarta(Carta carta) {
        cartas.add(carta);
    }

    public int calcularValorMao() {
        int valorTotal = 0;

        for (Carta carta : cartas) {
            valorTotal += carta.getValorBlackjack();
        }

        return valorTotal;
    }

    public int getValor() {
        return calcularValorMao();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas) {
            sb.append(carta.desenharCarta()).append("\n");
        }
        sb.append("Valor total da mão: ").append(this.getValor()).append("\n");
        sb.append("----------------\n");
        return sb.toString();
    }

    public List<Carta> getCartas() {
        return new ArrayList<>(cartas);
    }
}