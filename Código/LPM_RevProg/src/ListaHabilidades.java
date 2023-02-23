/** 
 * MIT License
 *
 * Copyright(c) 2020 João Caram <caram@pucminas.br>
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
  * Classe para lista simples encadeada (com dados de Pessoa)
  */
public class ListaHabilidades {
    public ElementoHabilidade primeiro;
    public ElementoHabilidade ultimo;

    /**
     * Construtor. Cria uma lista vazia com elemento sentinela
     */
    public ListaHabilidades(){
        primeiro = new ElementoHabilidade(null);
        ultimo = primeiro;
    }
 
    /**
     * Insere uma pessoa no fim da lista
     * @param qual A pessoa a ser inserida
     */
    public void inserir(Habilidade qual){
        ElementoHabilidade novo = new ElementoHabilidade(qual);
        ultimo.proximo = novo;
        ultimo = novo;
    }

    /**
     * Verifica se a fila está vazia
     * @return Verdadeiro se fila vazia, falso caso contrário
     */
    public boolean vazia(){
        return (ultimo==primeiro);
    }


    /**
     * Método para localizar uma pessoa na lista
     * @param desc O nome da pessoa a ser localizada
     * @return Uma pessoa, ou null se não existir
     */
    public Habilidade localizar(String desc){
        //  PR                            UL
        //  xx -> RS -> RR -> PD -> VA -> JC -> null
        //                                       A                                      
        ElementoHabilidade aux = primeiro.proximo;    //posicionamos após o sentinela

        while(aux!=null){               //enquanto não chegar ao fim da fila...
            if(aux.meuDado.descricao.equals(desc))        //se o elemento for igual à string (delegação de responsabilidade)
                return aux.meuDado;     //retorna o dado
            else
                aux = aux.proximo;      //ou avança para o próximo
        }
        return null;        //se não encontrou, retorna nulo
    }

    /**
     * Método para concatenar duas listas (TO-DO)
     * @param outra A outra lista a ser anexada a esta
     */
    public void concatenar(ListaHabilidades outra){
        //  PR                UL     
        //  xx -> RS -> RR -> VA -> null
        //                     
        //                            PR                      ult
        //                            xx -> JC -> MC -> AO -> RC -> null


    }

    /**
     * Método para localizar e retirar uma pessoa da lista
     * @param desc  O nome da pessoa a ser retirada
     * @return  Uma pessoa, ou null se não existir
     */
    public Habilidade retirar(String desc){
        //  PR                UL     
        //  xx -> RS -> RR -> VA ¬      null
        //                    A  |       |              
        //                       \_______/
        
        ElementoHabilidade aux = primeiro;        //posicionamos no sentinela: olhar no elemento à frente
        while(aux.proximo!=null){       //até o fim da fila...
            if(aux.proximo.meuDado.descricao.equals(desc)){           //se o elemento da frente é o que queremos
                ElementoHabilidade retirada = aux.proximo;    //marcamos o elemento
                aux.proximo = retirada.proximo;     //pulamos o elemento
                
                if(retirada==ultimo)        //caso seja o último, voltar com o ponteiro
                    ultimo = aux;
                else retirada.proximo = null;

                return retirada.meuDado;
            }
            else
                aux = aux.proximo;  //avançar se não é o elemento
        }
        return null;
    }


}