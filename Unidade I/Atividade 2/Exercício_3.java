// Exercício 3: Mesclar listas intercalando elementos
import java.util.ArrayList;

public class Exercício_3 {
    public static void main(String[] args) {
        ArrayList<String> lista1 = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();

        lista1.add("João");
        lista1.add("Maria");
        lista1.add("Carlos");

        lista2.add("Ana");
        lista2.add("Bruno");
        lista2.add("Diana");

        ArrayList<String> intercalada = new ArrayList<>();

        for (int i = 0; i < lista1.size(); i++) {
            intercalada.add(lista1.get(i));
            intercalada.add(lista2.get(i));
        }

        System.out.println("Lista intercalada:");
        for (String nome : intercalada) {
            System.out.println(nome);
        }
    }
}