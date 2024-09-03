package Baralho;
public class No {
    Carta carta;
    No proximo;

    public No(Carta carta) {
        this.carta = carta;
        this.proximo = null;
    }
}