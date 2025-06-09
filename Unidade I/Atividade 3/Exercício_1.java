// Exercício 1: Implementação da Árvore Binária

class Livro {
    String titulo;

    Livro(String titulo) {
        this.titulo = titulo;
    }
}

class No {
    Livro livro;
    No esquerdo, direito;

    No(Livro livro) {
        this.livro = livro;
        this.esquerdo = null;
        this.direito = null;
    }
}

public class Exercício_1 {
    No raiz;

    public void inserir(Livro livro) {
        raiz = inserirRec(raiz, livro);
    }

    private No inserirRec(No raiz, Livro livro) {
        if (raiz == null) return new No(livro);
        if (livro.titulo.compareTo(raiz.livro.titulo) < 0)
            raiz.esquerdo = inserirRec(raiz.esquerdo, livro);
        else
            raiz.direito = inserirRec(raiz.direito, livro);
        return raiz;
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.println(no.livro.titulo);
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }

    public void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerdo);
            System.out.println(no.livro.titulo);
            emOrdem(no.direito);
        }
    }

    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerdo);
            posOrdem(no.direito);
            System.out.println(no.livro.titulo);
        }
    }

    public static void main(String[] args) {
        Exercício_1 arvore = new Exercício_1();
        arvore.inserir(new Livro("Java"));
        arvore.inserir(new Livro("Algoritmos"));
        arvore.inserir(new Livro("Estruturas de Dados"));

        System.out.println("Percurso em ordem:");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\nPercurso em pré-ordem:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nPercurso em pós-ordem:");
        arvore.posOrdem(arvore.raiz);
    }
}