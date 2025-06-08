// Exercício 2: Remoção de Elementos Duplicados em uma lista
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Exercício_2 {
    public static void main(String[] args) {
        ArrayList<String> usuarios = new ArrayList<>();
        usuarios.add("Ana");
        usuarios.add("Carlos");
        usuarios.add("Ana");
        usuarios.add("Bruno");
        usuarios.add("Carlos");

        LinkedHashSet<String> usuariosUnicos = new LinkedHashSet<>(usuarios);

        System.out.println("Lista sem duplicados:");
        for (String nome : usuariosUnicos) {
            System.out.println(nome);
        }
    }
}