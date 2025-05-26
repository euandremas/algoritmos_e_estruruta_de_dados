public class DadosNPrimitivos {
    public static void main(String[] args) {

        // Tipo Caracter PRIMITIVO

        char valorChar = 'A'; // 2 bytes = 0 a 65535

        String nome = "Hello, World!"; // 2 bytes por caractere

        nome = "André"; // Alterando o valor da variável nome

        // Tipo enum (não primitivo)
        enum DiaSemana {
            DOMINGO, SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SÁBADO
        }

        DiaSemana dia = DiaSemana.DOMINGO;

        // tipo array (não primitivo)

        int[] numeros = { 1, 2, 3, 4, 5 }; // Array de inteiros

        System.out.println(nome);
        System.out.println(dia);
        System.out.println(numeros[0]); // Acessando o primeiro elemento do array
    }

}
