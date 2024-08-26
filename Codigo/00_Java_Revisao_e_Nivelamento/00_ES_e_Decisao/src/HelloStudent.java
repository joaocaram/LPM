import java.util.Scanner;

public class HelloStudent {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nome;

        System.out.print("Qual o seu nome, padawan? ");
        nome = leitor.nextLine();

        System.out.println("Que a força do Java esteja com você, "+nome);
        System.out.printf("Que a força do Java esteja com você, %s", nome);

        leitor.close();
    }
}
