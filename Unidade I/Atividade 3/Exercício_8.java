// Exercício 8: Mínimo de uma BST

public class Exercício_8 {
    public static double menorPreco(No raiz) {
        No atual = raiz;
        while (atual.esquerdo != null) {
            atual = atual.esquerdo;
        }
        return atual.livro.preco;
    }

    public static void main(String[] args) {
        No raiz = new No(new Livro("Notebook", 3500));
        raiz.esquerdo = new No(new Livro("Celular", 1500));
        raiz.direito = new No(new Livro("Monitor", 1200));
        raiz.esquerdo.esquerdo = new No(new Livro("Mouse", 100));

        System.out.println("Menor preço encontrado: R$" + menorPreco(raiz));
    }
}