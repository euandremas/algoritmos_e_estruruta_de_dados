// Exercício 10: Ordenação de produtos por vendas (Bubble Sort)

public class Exercício_10 {
    public static void main(String[] args) {
        String[] produtos = {"Notebook", "Mouse", "Teclado", "Monitor"};
        int[] vendas = {150, 300, 200, 250};

        for (int i = 0; i < vendas.length - 1; i++) {
            for (int j = 0; j < vendas.length - i - 1; j++) {
                if (vendas[j] < vendas[j + 1]) {
                    int tempVenda = vendas[j];
                    vendas[j] = vendas[j + 1];
                    vendas[j + 1] = tempVenda;

                    String tempProduto = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = tempProduto;
                }
            }
        }

        System.out.println("Produtos mais vendidos:");
        for (int i = 0; i < produtos.length; i++) {
            System.out.println(produtos[i] + ": " + vendas[i] + " vendas");
        }
    }
}