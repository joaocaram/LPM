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

public class InverterVetor{
  static Scanner leitor = new Scanner(System.in);   //objeto para leitura de teclado (entrada padrão do Sistema)
  
  /**
   * Inverte um vetor de inteiros, modificando o próprio vetor (método 'in-place')
   * @param vetor O vetor de inteiros a ser invertido. Este vetor será modificado pelo método, estando invertido em relação ao original no final da execução.
   */
  static void inverterVetor(int vetor[]) {
    int tmp;
    int oposto;
    int tamanho = vetor.length;
    for (int i = 0; i < (tamanho/2); i++) {
      oposto = (tamanho - i - 1);
      tmp = vetor[i];
      vetor[i] = vetor[oposto];
      vetor[oposto] = tmp;
    }
  }
  
  /**
   * Cria e lê do teclado um vetor do tamanho escolhido pelo usuário. O tamanho deve ser passado por parâmetro. Em caso de tamanho não positivo, o método retorna um vetor vazio de tamanho 2. 
   * ATENÇÃO: método 'acoplado' ao Console como objeto de saída e teclado como entrada (pode ser melhorado).
   * @param tamanho O tamanho do vetor a ser criado e lido. Deve ser um valor positivo (>=1).
   * @return Um vetor com o tamanho definido e valores lidos a partir do teclado ou um vetor vazio de tamanho 2, caso o tamanho informado seja inválido.
   * @throws NumberFormatException Causa um erro de formato caso o valor lido do teclado para o vetor não seja numérico.
   */
  static int[] lerVetor(int tamanho){
    int[] vetor = new int[2];
    if(tamanho>=1){
      vetor = new int[tamanho];
      for (int i = 0; i < tamanho; i++) {
        System.out.print("Digite o número na posição "+ (i + 1) +": ");
        vetor[i] = Integer.parseInt(leitor.nextLine());
      }
    }
    return vetor;
  }
  
  /**
   * Imprime um vetor passado como parâmetro. A impressão é feita em uma linha, com os valores separados por espaço em branco.
   * ATENÇÃO: método 'acoplado' ao Console como objeto de saída (pode ser melhorado).
   * @param vetor O vetor a ser impresso. 
   */
  static void imprimir(int[] vetor){
    for (int i = 0; i < vetor.length; i++)
      System.out.print(vetor[i]+" ");
  }
  
  public static void main(String[] args) throws Exception {   //atenção para modularidade e 'código limpo'
    final int TAMANHO;
    int[]  inteiros;
    
    System.out.print("Quantos números você deseja ler/armazenar? ");
    TAMANHO = Integer.parseInt(leitor.nextLine());

    inteiros = lerVetor(TAMANHO);
    inverterVetor(inteiros);
    System.out.println("\nInvertido:");
    imprimir(inteiros);
    System.out.println();
    
    System.out.println("\nFIM.\n");
	  leitor.close();
  }

  
}