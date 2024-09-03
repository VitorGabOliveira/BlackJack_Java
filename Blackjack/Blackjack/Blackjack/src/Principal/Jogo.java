package Principal;

import Baralho.Carta;
import Baralho.Pilha;
import Players.Jogador;
import Players.JogadorHumano;
import Players.JogadorMaquina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private Pilha baralho;
    private Jogador jogador;
    private Jogador maquina;
    private Scanner scanner;

    public Jogo() {
        this.baralho = new Pilha();
        this.scanner = new Scanner(System.in);

        // Cria e embaralha o baralho
        List<Carta> cartas = criarBaralho();
        Collections.shuffle(cartas);
        for (Carta carta : cartas) {
            baralho.empilhar(carta);
        }

        // Cria jogadores
        this.jogador = new JogadorHumano("Jogador", scanner);
        this.maquina = new JogadorMaquina("Máquina");
    }

    public static List<Carta> criarBaralho() {
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipes = {"copas", "ouros", "espadas", "paus"};

        List<Carta> baralho = new ArrayList<>();
        for (String naipe : naipes) {
            for (String valor : valores) {
                baralho.add(new Carta(valor, naipe));
            }
        }
        return baralho;
    }

    public void distribuirCartasIniciais() {
        jogador.receberCarta(baralho.desempilhar());
        maquina.receberCarta(baralho.desempilhar());
        jogador.receberCarta(baralho.desempilhar());
        maquina.receberCarta(baralho.desempilhar());
    }

    public void mostrarCartas() {
        System.out.println("Mão do jogador:");
        System.out.println(jogador.getMao());
        System.out.println("Mão da máquina:");
        System.out.println(maquina.getMao().getCartas().get(0).desenharCarta() + " e [CARTA OCULTA]");
    }

    public void determinarVencedor() {
        int valorJogador = jogador.getValorMao();
        int valorMaquina = maquina.getValorMao();

        System.out.println("Valor do jogador: " + valorJogador);
        System.out.println("Valor da máquina: " + valorMaquina);

        if (valorJogador > 21) {
            System.out.println("Você estourou! Máquina vence.");
        } else if(valorJogador == 21 && valorMaquina != 21){
            System.out.println("21, Você ganha!");
        }
        else if (valorMaquina > 21) {
            System.out.println("Máquina estourou! Você vence.");
        } else if (valorJogador > valorMaquina) {
            System.out.println("Você vence!");
        } else if (valorJogador < valorMaquina) {
            System.out.println("Máquina vence.");
        } else {
            System.out.println("Empate!");
        }

        // Mostrar a carta oculta da máquina
        System.out.println("Carta oculta da máquina: " + "\n" + maquina.getMao().getCartas().get(1).desenharCarta());
    }

    public void jogar() {
        distribuirCartasIniciais();
        mostrarCartas();
        jogador.jogarTurno(baralho);
        if (jogador.getValorMao() <= 21) {
            maquina.jogarTurno(baralho);
        }
        determinarVencedor();
    }
}