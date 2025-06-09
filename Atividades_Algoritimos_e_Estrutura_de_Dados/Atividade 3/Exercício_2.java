// Exercício 2: Validação de BST

public class Exercício_2 {
    public static boolean ehBST(No no, String min, String max) {
        if (no == null) return true;
        if ((min != null && no.livro.titulo.compareTo(min) <= 0) ||
            (max != null && no.livro.titulo.compareTo(max) >= 0))
            return false;
        return ehBST(no.esquerdo, min, no.livro.titulo) &&
               ehBST(no.direito, no.livro.titulo, max);
    }

    public static void main(String[] args) {
        No raiz = new No(new Livro("Eletrônicos", 0));
        raiz.esquerdo = new No(new Livro("Câmeras", 0));
        raiz.direito = new No(new Livro("Informática", 0));
        raiz.esquerdo.esquerdo = new No(new Livro("Acessórios", 0));

        boolean resultado = ehBST(raiz, null, null);
        System.out.println("A árvore é uma BST válida? " + resultado);
    }
}

// Classe Livro com o construtor correto
class Livro {
    String titulo;
    int valor;
    public double preco;

    public Livro(String titulo, int valor) {
        this.titulo = titulo;
        this.valor = valor;
    }
}

// Classe No para a árvore
class No {
    Livro livro;
    No esquerdo, direito;

    public No(Livro livro) {
        this.livro = livro;
        this.esquerdo = null;
        this.direito = null;
    }
}

