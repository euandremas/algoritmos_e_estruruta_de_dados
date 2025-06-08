public class Pessoa2 {
    private String nome;
    private int idade;
    private float peso;
    private float altura;
    private boolean habilitada;

    public Pessoa2(String nome, int idade, float peso, float altura, boolean habilitada) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.habilitada = habilitada; // Inicializando habilitado, mas não está sendo usado
    }

    public void exibirInfos() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("Habilitado: " + habilitada);
    }

    public void testarAltura(float alturaPessoa) {
        if (alturaPessoa <= this.altura) {
            System.out.println("Acesso Autorizado!");
        } else {
            System.out.println("Acesso Negado!");
        }
    }

    public void testarIdade() {
        if (this.idade >= 18) {
            System.out.println("Maior de idade, pode beber!");
        } else {
            System.out.println("Menor de idade, não pode beber!");
        }
    }

    public float testeIMC() {
        float IMC = this.peso / (this.altura * this.altura);

        // Classificação do IMC
        if (IMC < 18.5) {
            System.out.println("Abaixo do peso");
        } else if (IMC > 18.5 && IMC < 24.9) {
            System.out.println("Peso normal");
        } else if (IMC < 25 && IMC < 29.9) {
            System.out.println("Sobrepeso");
        } else if (IMC < 30 && IMC < 34.9) {
            System.out.println("Obesidade grau 1");
        } else if (IMC < 35 && IMC < 39.9) {
            System.out.println("Obesidade grau 2");
        } else if (IMC >= 40) {
            System.out.println("Obesidade grau 3");
        }
        return IMC;
    }

    public void testeHabilitacao() {
        if (this.habilitada) {
            System.out.println("Pessoa habilitada.");
        } else {
            System.out.println("Pessoa não habilitada.");
        }
    }

    public static void main(String[] args) {
        Pessoa2 pessoa = new Pessoa2("João", 16, 94.7f, 1.76f, false); // Criando uma instância de Pessoa2

        pessoa.exibirInfos();
        pessoa.testarAltura(1.80f); // Testando com altura maior que a de João
        pessoa.testarIdade(); // Testando com idade maior que a de João
        float imc = pessoa.testeIMC(); // Calculando o IMC
        System.out.println("IMC: " + imc); // Exibindo o IMC calculado
        pessoa.testeHabilitacao(); // Verificando se a pessoa está habilitada
    }

}
