package Principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        boolean jogarNovamente = true;
        String r;
        String resposta;
        System.out.println("Bem vindo ao jogo BlackJack(21)!");
        while (jogarNovamente) {
            System.out.println("Você quer jogar (s/n)");
            r = leitura.nextLine();
            resposta = r.toLowerCase();

            while(!resposta.equals("s") && !resposta.equals("n")) {
                System.out.println("Por favor, digite apenas s ou n. S para sim e N para não");
                r = leitura.nextLine();
                resposta = r.toLowerCase();
            }
            if (resposta.equals("s")) {
                Jogo jogo = new Jogo();
                jogo.jogar();
            } else {
                System.out.println("Ok, até a próxima!");
                jogarNovamente = false; // Termina o loop caso o jogador não queira jogar novamente
            }
        }
        leitura.close();
    }
}