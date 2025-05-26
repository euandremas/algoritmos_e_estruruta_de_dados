public class Dados_Primitivos {
    public static void main(String[] args) {

        // Números inteiros

        byte valorByte = 127; // 1 byte = -127 a 127
        short valorShort = 32767; // 2 bytes = -32768 a 32767
        int valorInt = 2147483647; // 4 bytes = -2147483648 a 2147483647
        long valorLong = 9223372036854775807L; // 8 bytes = -9223372036854775808 a 9223372036854775807

        // Números flutuantes

        float valorFloat = 3.40282347E+38F; // 4 bytes = -3.40282347E+38 a 3.40282347E+38
        double valorDouble = 1.7976931348623157E+308; // 8 bytes = -1.7976931348623157E+308 a 1.7976931348623157E+308

        // Tipo Caracter

        char valorChar = 'A'; // 2 bytes = 0 a 65535

        // Tipo Lógico
        boolean veradeiro = true; // 1 byte = true ou false
        boolean falso = false; // 1 byte = true ou false

        // número PI

        final float PI = 3.1415f; // 4 bytes

        // Tipo Texto
        String valorString = "Hello, World!"; // 2 bytes por caractere

        // Exibindo os valores
        System.out.println("Valor Byte: " + valorByte);
        System.out.println("Valor Short: " + valorShort);
        System.out.println("Valor Int: " + valorInt);
        System.out.println("Valor Long: " + valorLong);
        System.out.println("Valor Float: " + valorFloat);
        System.out.println("Valor Double: " + valorDouble);
        System.out.println("Valor Char: " + valorChar);
        System.out.println("Valor Boolean: " + veradeiro);
        System.out.println("Valor Boolean: " + falso);
        System.out.println("Valor String: " + valorString);
        System.out.println("Valor PI: " + PI);
        // Exibindo o tamanho dos tipos primitivos

    }
}
