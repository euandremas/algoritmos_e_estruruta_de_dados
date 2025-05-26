import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private float peso;

    // Construtor da classe Pessoa
    public Pessoa(String nome, int idade, float peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    // Métodos
    public void exbirInfos() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Peso: " + peso);
    }

    public void aniversario() {
        this.idade = this.idade + 1;
        // Alternativa:
        // this.idade += 1;
    }

    // getters e setters

    public String getNome() { // Método getter para obter o nome
        return this.nome;
    }

    public void setNome(String nome) { // Método setter para definir o nome
        this.nome = nome;
    }

    public int getIdade() { // Método getter para obter a idade
        return this.idade;
    }

    public void setIdade(int idade) { // Método setter para definir a idade
        this.idade = idade;
    }

    public float getPeso() { // Método getter para obter o peso
        return this.peso;
    }

    public void setPeso(float peso) { // Método setter para definir o peso
        this.peso = peso;
    }

    // Método main para testar a classe Pessoa

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criação de um objeto Pessoa e teste dos métodos

        Pessoa pessoa = new Pessoa("João", 30, 70.5f);

        pessoa.exbirInfos();
        pessoa.aniversario();
        pessoa.exbirInfos();

        pessoa.setNome("Maria");
        pessoa.setIdade(25);
        pessoa.setPeso(60.0f);
        System.out.println("Após modificações:");
        pessoa.exbirInfos();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o peso: ");
        Float peso = Float.parseFloat(scanner.nextLine());
        scanner.close();

        Pessoa pessoa2 = new Pessoa(nome, idade, peso);

        pessoa2.exbirInfos();

    }
}
