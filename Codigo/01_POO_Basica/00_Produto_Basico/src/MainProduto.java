import java.util.Scanner;

/** 
 * MIT License
 *
 * Copyright(c) 2024 João Caram <caram@pucminas.br>
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

 /**
  * App-demo simples para iniciação aos conceitos de POO.
  */
public class MainProduto {
 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Produto chaComGas = new Produto("Chá mate com gás", 3.49);
        int quantidade;

        System.out.println("Uma lata de chá com gás está custando R$ "+chaComGas.precoUnitario);      //por que isso não está bom?
        System.out.print("Quer comprar quantas latas? ");
        quantidade = Integer.parseInt(teclado.nextLine());
        System.out.println(quantidade + " latas de chá com gás custam R$ "+ chaComGas.valorDoLote(quantidade));

        teclado.close();
    }
}
