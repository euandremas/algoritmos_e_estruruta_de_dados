public class Objetos {
    // Atributos da classe Pessoa
    private String nome;
    private int idade;
    private float peso;

    // Construtor da classe Pessoa
    public Objetos(String nome, int idade, float peso) {
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

    public static void main(String[] args) {
        // Criação de um objeto do tipo Pessoa

        Objetos pessoa = new Objetos("André", 42, 94.5f);

        // Exibição dos valores dos atributos
        // System.out.println("Nome: " + pessoa.nome);
        // System.out.println("Idade: " + pessoa.idade);
        // System.out.println("Peso: " + pessoa.peso);
        // // Acessando os atributos diretamente (não recomendado em prática real)
        // // Criação de um novo objeto do tipo Pessoa

        Objetos pessoa2 = new Objetos("Maria", 25, 60.0f);

        // // Exibição dos valores dos atributos do segundo objeto
        // System.out.println("Nome: " + pessoa2.nome);
        // System.out.println("Idade: " + pessoa2.idade);
        // System.out.println("Peso: " + pessoa2.peso);

        // Exibindo as informações usando o método

        pessoa.exbirInfos();
        pessoa2.exbirInfos();
    }

}
