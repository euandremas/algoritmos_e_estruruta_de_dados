public class Condicionais {

    public static void main(String[] args) {

        // Operadoes condicionais
        // == igualdade
        // != diferente
        // > maior que
        // < menor que
        // >= maior ou igual
        // <= menor ou igual

        // Operadores lógicos
        // && e (and) - ambas as condições devem ser verdadeiras
        // || ou (or) - pelo menos uma das condições deve ser verdadeira
        // ! negação (not) - inverte o valor lógico da condição

        int x = 10;
        // Estrutura condicional if

        if (x == 10) {

            System.out.println("x Verdade");
        }
        System.out.println("x Fora do teste");

        // Estrutura condicional if-else

        int y = 5;
        if (y > 10) {
            System.out.println("Verdadeiro");
        } else {
            System.out.println("Falso");
        }

        // Estrutura condicional if else elseif if encadeado

        int j = 6;
        if (j > 50) {
            System.out.println("Primeiro if");
        } else if (j < 10) {
            System.out.println("Segundo if");
        } else {
            System.out.println("Else");

        }

        // Switch case
        int opcao = 5;

        switch (opcao) {
            case 1:
                System.out.println("Opção 1");
                break;
            case 2:
                System.out.println("Opção 2");
                break;
            case 3:
                System.out.println("Opção 3");
                break;
            case 4:
                System.out.println("Opção 4");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

        // Uso de operadores lógicos && e ||

        int b = 10;
        int c = 15;

        // && e (and) - ambas as condições devem ser verdadeiras
        if (b == 10 && c == 15) {
            System.out.println("Ambas as condições são verdadeiras");
        } else {
            System.out.println("Pelo menos uma condição é falsa");
        }
        // || ou (or) - pelo menos uma das condições deve ser verdadeira
        if (b == 11 || c == 15) {
            System.out.println("Pelo menos uma condição é verdadeira");
        } else {
            System.out.println("Ambas as condições são falsas");
        }

    }
}
