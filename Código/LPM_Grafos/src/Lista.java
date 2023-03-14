import java.util.LinkedList;
/** 
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
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

 /** Classe para encapsular uma lista duplamente encadeada */
public class Lista<T> {

    private LinkedList<T> data;

    /**
     * Construtor: lista vazia
     */
    public Lista() {
        this.data = new LinkedList<>();
    }

    /**
     * Adiciona um elemento no final da lista. Retorna TRUE se foi possível adicionar. 
     * @param newElement Elemento a ser adicionado.
     * @return TRUE se pôde ser adicionado, FALSE caso contrário
     */
    public boolean add(T newElement) {
        return this.data.add(newElement);
    }

    /**
     * Retorna, em um vetor/array, todos os elementos da lista. O vetor passado
     * como parâmetro deve ser criado previamente. O retorno contém os elementos da lista.
     * @param array Vetor/array para abrigar os elementos da lista. Deve ser previamente criado.
     * @return Outro vetor/array com os elementos da lista.
     */
    public T[] allElements(T[] array) {
        T[] allData = this.data.toArray(array);
        return allData;
    }

    /**
     * Remove e retorna o elemento da lista na posição indicada. Os elementos subsequentes são "deslocados para a esquerda",
     * isto é, todos têm seu índice diminuído em 1. Retorna nulo caso a posição não exista na lista.
     * @param index Chave do elemento a ser removido.
     * @return O elemento removido, ou null se ele não existir na lista
     */
    public T remove(int index){
        T retElement = null;
        if(index>=0 && index<this.data.size())
            retElement = this.data.remove(index);
        return retElement;
    }

    /**
     * Retorna o tamanho da lista.
     * @return Quantidade de elementos da lista (int)
     */
    public int size(){
        return this.data.size();
    }

}
