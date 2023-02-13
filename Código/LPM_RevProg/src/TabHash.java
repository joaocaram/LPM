/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
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
  * Demonstração de tabela hash. Código parcial: necessário implementar métodos de códificação, mapeamento e localiação
  */
public class TabHash {
    
   
    public final int TAM_HASH;      //tamanho da tabela
    public Entrada[] dados;         //dados: vetor de entradas
    
    /**
     * Constrói uma tabela de tamanho n (mínimo 10). A tabela é preenchida com n entradas-sentinela
     * @param n Tamanho total da tabela (recomenda-se nº primo maior que a quantidade de dados esperada)
     */
    public TabHash(int n){
        if(n>=10) 
            this.TAM_HASH = n;
        else 
            this.TAM_HASH = 10;
        this.dados = new Entrada[TAM_HASH];
        
        for (int i = 0; i < dados.length; i++) {
            dados[i] = new Entrada();           //"sentinelas": existe entrada, sem dados e inválida
        }
    }

    /**
     * Calcula o código hase de acordo com o método .......
     * @param chave Chave numérica para armazenamento
     * @return Código para objeto com esta chave (inteiro positivo)
     */
    public int codigoHash(String chave){
         
        //código hash simples para teste. 
        int codigo = (int)(chave.charAt(0))*3 + (int)(chave.charAt(chave.length()-2))*4; 
        ////////////////////
        return codigo;
    }

    /**
     * Faz o mapeamento de um código em uma posição válida da tabela, pelo método .....
     * @param codigo Código hash de uma chave
     * @return Posição da tabela para este código (entre 0 e TAM_HASH-1)
     */
    public int mapear(int codigo){
        //Mapeamento de código simples (divisão e resto) para a tabela. Complete a documentação acima.
        return codigo%TAM_HASH;
        //////////////
        
    }
    
    /**
     * Localiza uma entrada da tabela. Faz, consecutivamente: geração do código para a chave, mapeamento do código e varredura da tabela para colisões.
     * Colisões tratadas pelo método ..... 
     * Retorna a posição de um elemento nulo ou de um elemento existente com a chave passada.
     * @param chave Chave de armazenamento a localizar
     * @return Posição do elemento localizado, ou posição de um nulo se a chave não existir.
     */
    public int localizar(String chave){
        
        //localização: código -> mapeamento -> varredura de colisões. Complete a documentação acima.
        int pos = mapear(codigoHash(chave));
        
        while(dados[pos].dado!=null && dados[pos].chave!=chave){
            pos = (pos+1)%TAM_HASH;
        }
        
        return pos; //// retorna uma posição de entrada inválida ou de entrada com a chave do parâmetro
        
        
        
    }

    /**
     * Insere um dado (pessoa) na tabela, associando-o à sua chave numérica (matrícula). Em caso de chave duplicada, retorna o antigo dado.
     * @param chave Chave numérica associada à pessoa.
     * @param cand Objeto pessoa com todos os seus dados.
     * @return Possível objeto pessoa anteriormente armazenado com a mesma chave, ou objeto nulo se não havia aquele. 
     */
    public Candidato inserir(String chave, Candidato cand){
        Entrada nova = new Entrada(chave, cand);
        int pos = localizar(chave);

        Candidato auxRet = dados[pos].getValor();      //guarda a pessoa anterior (ou nulo) armazenada naquela posição
        dados[pos] = nova;                          //armazena/substitui com a nova pessoa na posição encontrada
       
        return auxRet;                              //retorna objeto anterior (ou nulo)
    }

    /**
     * Localiza o objeto pessoa com aquela chave na tabela. Se não houver, retorna nulo.
     * @param chave Chave de busca para a pessoa (matrícula)
     * @return Objeto pessoa encontrado, ou nulo se não existir.
     */
    public Candidato buscar(String chave){
        int pos = localizar(chave);
        return dados[pos].getValor();
    }
       

    /**
     * Imprime todo o conteúdo da tabela, na ordem de posição atual. Verifica e salta elementos nulos/inválidos 
     * @return String com dados de cada entrada válida, na ordem da tabela, separadas por \n
     */
    public String imprimir(){
        StringBuilder relat = new StringBuilder("CANDIDATOS:\n");
        for (int i = 0; i < dados.length; i++) {
            if(dados[i].valido)
                relat.append(dados[i].dado+"\n");
        }
        return relat.toString();
    }

}