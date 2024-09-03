package Players;

import Baralho.Carta;
import Baralho.Mao;
import Baralho.Pilha;

public abstract class Jogador {
    protected String nome;
    protected Mao mao;

    public Jogador(String name) {
        this.nome = nome;
        this.mao = new Mao();
    }

    public String getName() {
        return nome;
    }

    public Mao getMao() {
        return mao;
    }

    public void receberCarta(Carta carta) {
        mao.addCarta(carta);
    }

    public int getValorMao() {
        return mao.getValor();
    }

    public abstract void jogarTurno(Pilha baralho);

    @Override
    public String toString() {
        return nome + " mão: " + mao.toString() + " (valor: " + getValorMao() + ")";
    }
}
