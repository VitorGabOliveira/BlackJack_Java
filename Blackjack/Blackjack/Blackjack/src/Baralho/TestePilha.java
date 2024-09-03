package Baralho;
import java.util.Collections;
import java.util.List;

import static Principal.Jogo.criarBaralho;


public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        // Criar e embaralhar o baralho
        List<Carta> baralho = criarBaralho();
        Collections.shuffle(baralho);

        // Empilhar as cartas embaralhadas
        for (Carta carta : baralho) {
            pilha.empilhar(carta);
        }

        // Imprimir a pilha de cartas
        pilha.imprimir();

        // Desempilhar uma carta e imprimir o estado da pilha
        System.out.println("Desempilhando: " + pilha.desempilhar());
        pilha.imprimir();
    }
}