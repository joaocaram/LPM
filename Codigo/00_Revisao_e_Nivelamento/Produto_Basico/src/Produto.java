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
  * Classe (MUITO) simples "Produto" para iniciação aos conceitos de POO. 
  * Aqui ainda não temos preocupação com os aspectos de modularidade, que serão trabalhadas mais à frente na disciplina.
  */
public class Produto {
    public String descricao;                //para pensar: será boa ideia deixar estes valores como públicos?
    public double precoUnitario;            //para pensar: double é valor financeiro? podemos usar BigDecimal? Currency?
    
    /**
     * Construtor do produto: aceita qualquer descrição, inclusive vazia. O preço mínimo é R$1 (corrigido pelo construtor se necessário)
     * @param desc Descrição do produto (string sem limite de tamanho)
     * @param preco Preço unitário do produto (>=1.0)
     */
    public Produto(String desc, double preco){
        this.precoUnitario = 1d;
        if(preco>1d)
            this.precoUnitario = preco;
        this.descricao = desc;
    }

    /**
     * Informa o preço de venda de um lote do produto, com a quantidade rebecida/informada por parâmetro. Se a quantidade for inválida (isto é, não-positiva) retorna 0.0.
     * @param quantidade A quantidade de produtos do lote a ser vendido.
     * @return O valor do lote de produtos. Retorna 0.0 em caso de tamanho inválido de lote (<1).
     */
    public double valorDoLote(int quantidade){
        double valor = 0d;
        if(quantidade >=1 )
            valor =  precoUnitario * quantidade;
        return valor;
    }

}
