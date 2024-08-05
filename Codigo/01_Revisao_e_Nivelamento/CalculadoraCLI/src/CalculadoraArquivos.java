import java.io.File;
import java.io.FileWriter;
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
public class CalculadoraArquivos {
    static Scanner leitorTeclado;
    static Scanner leitorArquivo;

   

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
        FileWriter arqResultados = new FileWriter("resultados.txt");

        String calculo;
        String nomeArquivo;
        double resultado;

        System.out.print("Qual é o arquivo com as contas? ");
        nomeArquivo = leitorTeclado.nextLine();

        leitorArquivo = new Scanner(new File(nomeArquivo));

        while (leitorArquivo.hasNextLine()) {
            calculo = leitorArquivo.nextLine();
            if(!calculo.equals("FIM")){
                resultado = interpretarCalculo(calculo);
                System.out.println(calculo + " = "+ resultado);
                arqResultados.write(calculo + " = "+ resultado+"\n");
            }
        }
        arqResultados.close();
        leitorArquivo.close();
        leitorTeclado.close();
    }
}
