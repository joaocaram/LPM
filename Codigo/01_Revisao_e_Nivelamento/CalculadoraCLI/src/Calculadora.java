import java.util.Scanner;

/** 
 * MIT License
 *
 * Copyright(c) 2022-24 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class Calculadora {
    static Scanner leitorTeclado;

    private static String lerCalculo() {
        System.out.println("Digite a expressão no formato <valor> <operador> <valor> ou 'FIM' para terminar");
        return leitorTeclado.nextLine();
    }

    private static double interpretarCalculo(String calculo){
        String[] componentes;
        double resultado;

        componentes = calculo.split(" ");
        if(componentes.length != 3){
            resultado = 0d;
        }
        else{
            componentes[0] = componentes[0].replace(',', '.');
            componentes[2] = componentes[2].replace(',', '.');
            double valor1 = Double.parseDouble(componentes[0]);
            double valor2 = Double.parseDouble(componentes[2]);
            switch (componentes[1]) {
                case "+" -> resultado = valor1+valor2;
                case "-" -> resultado = valor1-valor2;
                case "/" -> resultado = valor1/valor2;
                case "*" -> resultado = valor1*valor2;
                default -> resultado = 0d;
            }
        }
        return resultado;
    }

    public static void main(String[] args) throws Exception {
        leitorTeclado = new Scanner(System.in);
        String calculo;
        double resultado;

        calculo = lerCalculo();
        while (!calculo.equals("FIM")) {
            resultado = interpretarCalculo(calculo);
            System.out.println(calculo + " = "+ resultado);
            calculo = lerCalculo();    
        }
        
        leitorTeclado.close();
    }

    
}
