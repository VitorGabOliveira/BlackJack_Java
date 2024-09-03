package Baralho;


public class Pilha {
    private No topo = null;

    public void empilhar(Carta carta) {
        No novoNo = new No(carta);
        novoNo.proximo = this.topo;
        this.topo = novoNo;
    }

    public Carta desempilhar() {
        if (topo == null) {
            return null;
        }

        Carta carta = this.topo.carta;
        this.topo = this.topo.proximo;
        return carta;
    }

    public void imprimir() {
        int i = 0;
        No noAtual = this.topo;
        while (noAtual != null) {
            i++;
            System.out.println(i + "º carta:");
            System.out.println(noAtual.carta.desenharCarta());
            noAtual = noAtual.proximo;
        }
        System.out.println("O baralho possui " + i + " cartas");
    }
}