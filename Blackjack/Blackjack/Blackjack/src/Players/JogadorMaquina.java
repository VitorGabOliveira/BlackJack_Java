package Players;

import Baralho.Carta;
import Baralho.Pilha;

public class JogadorMaquina extends Jogador {

    public JogadorMaquina(String name) {
        super(name);
    }

    @Override
    public void jogarTurno(Pilha baralho) {
        while (getValorMao() < 17) {
            Carta novaCarta = baralho.desempilhar();
            receberCarta(novaCarta);
            System.out.println("A maquina comprou uma nova carta. \n" +novaCarta);
        }
        System.out.println("A maquina nao comprou mais cartas." );
        System.out.println("Mão da máquina:");
        System.out.println(getMao());
    }
}