import java.util.Scanner;

public class MaiorDeTres {
    
    public static double maiorDeTres(double num1, double num2, double num3){
        double maior = num1;

        if(num2 > maior ){
            maior = num2;
        }

        if(num3 > maior){
            maior = num3;
        }

        return maior;
    }

    public static void main(String[] args) {
        double num1, num2, num3;
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite três números separados por espaço: ");
        num1 = teclado.nextDouble();
        num2 = teclado.nextDouble();
        num3 = teclado.nextDouble();

        System.out.printf("O maior dos três é %f.", maiorDeTres(num1, num2, num3));
        teclado.close();
    }
}
