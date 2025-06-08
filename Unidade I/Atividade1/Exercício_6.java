// Exercício 6: Números primos entre 1 e 100

public class Exercício_6 {


    public static void main(String[] args) {
        System.out.println("Números primos entre 1 e 100:");
        for (int i = 2; i <= 100; i++) {
            boolean primo = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) System.out.print(i + " ");
        }
    }
}