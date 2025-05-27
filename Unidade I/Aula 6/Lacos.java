public class Lacos {

    public static void main(String[] args) {

        // Laço for, repete um numero determinado de vezes

        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Valor de i: " + i);
        }

        int x = 1;
        // Laço while, repete enquanto a condição for verdadeira. Quando for falsa, sai
        // do laço

        while (x <= 10) {
            System.out.println("Valor de x: " + x);
            x++; // Incrementa x de 2 em 2
        }

        int y = 1;

        // Laço do while, repete pelo menos uma vez e depois verifica a condição

        do {
            System.out.println("Valor de y: " + y);
            y++; // Incrementa y de 1 em 1
        } while (y <= 10);
    }
}
