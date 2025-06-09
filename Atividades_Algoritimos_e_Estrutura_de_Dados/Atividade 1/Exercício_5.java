// Avaliação de Notas dos Alunos

public class Exercício_5 {
  

    public static void main(String[] args) {

        double[][] notas = {
                { 8.5, 7.0, 9.0 },
                { 6.5, 8.0, 7.5 },
                { 9.5, 10.0, 8.0 }
        };
        double maiorNota = 0.0;
        int aluno = 0;
        int prova = 0;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] > maiorNota) {
                    maiorNota = notas[i][j];
                    aluno = i + 1; // +1 para exibir o número do aluno começando de 1
                    prova = j + 1; // +1 para exibir o número da prova começando de 1
                }
            }
        }
        System.out.println("==== Avaliação de Notas dos Alunos ====");
        System.out.println("A maior nota da turma é: " + maiorNota);
        System.out.println("Aluno: " + aluno + ", Prova: " + prova);
        System.out.println("==== Fim da Avaliação ====");

    }
}