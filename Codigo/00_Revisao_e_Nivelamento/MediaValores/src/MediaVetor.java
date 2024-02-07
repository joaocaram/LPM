import java.util.Scanner;

public class MediaVetor {

    public static double[] criarVetor(Scanner teclado){
        int tamanhoVetor;

        System.out.print("Qual o tamanho do vetor a ser lido? ");
        
        tamanhoVetor = Integer.parseInt(teclado.nextLine());
        return new double[tamanhoVetor];
    }

    public static void lerVetor(double[] vetor, Scanner teclado){
        for (int i = 0; i < vetor.length; i++){
            System.out.print("Digite o valor " + (i + 1) + ": ");
            vetor[i] = Double.parseDouble(teclado.nextLine());
        }
        
    }

    public static double somarVetor(double[] vetor){
        double soma = 0d;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return soma;
    }

    public static double mediaValores(double[] vetor){
        return somarVetor(vetor) / vetor.length;
    }


    public static void main(String[] args) throws Exception {
        Scanner teclado;
        double[] vetor;

        teclado = new Scanner(System.in);
        vetor = criarVetor(teclado);
        System.out.println();
        lerVetor(vetor, teclado);
        System.out.println("O vetor tem "+vetor.length+" elementos. A soma dos elementos é "+somarVetor(vetor));
        System.out.println("A média dos valores do vetor é de " + String.format("%.2f",  mediaValores(vetor)));
        
        teclado.close();
    }
}
