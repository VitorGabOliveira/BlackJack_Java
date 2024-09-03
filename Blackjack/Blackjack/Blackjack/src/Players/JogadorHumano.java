package Players;

import Baralho.Carta;
import Baralho.Pilha;

import java.util.Scanner;

public class JogadorHumano extends Jogador {
    private Scanner scanner;

    public JogadorHumano(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public void jogarTurno(Pilha baralho) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Sua mão: ");
            System.out.println(getMao());
            System.out.println("Deseja comprar outra carta? (s/n)");
            String r = scanner.nextLine();
            String resposta = r.toLowerCase();
            if (resposta.equalsIgnoreCase("s")) {
                Carta novaCarta = baralho.desempilhar();
                receberCarta(novaCarta);
                System.out.println("Você comprou: " + "\n" + novaCarta.desenharCarta());
                if (getValorMao() == 21){
                    continuar = false;
                }
                else if (getValorMao() > 21) {
                    System.out.println("Você estourou!");
                    continuar = false;
                }
            } else {
                continuar = false;
            }
        }
    }
}
