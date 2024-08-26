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

/** Classe Produto para demonstração básica dos conceitos de POO. Pode (e vai) ser muito melhorada */
public class Produto {
 
    //#region atributos
    String descricao;
    double valorUnitario;
    //#endregion

    //#region métodos
    /**
     * Registra os dados de um produto. Descrição e valor (acima de 0).
     * Valores inválidos serão registrados como R$0,10.
     * @param desc String com o nome do produto. Strings vazias resultarão em "Produto sem descrição"
     * @param valor Valor unitário do produto. Deve ser maior que 0.
     */
    void registrar(String desc, double valor){
        if(desc.length()==0)
            desc = "Produto sem descrição";
        if(valor<=0)
            valor = 0.1;
        descricao = desc;
        valorUnitario = valor;
    }

    /**
     * Retorna o valor de venda de um lote de QUANT produtos.
     * Quant deve ser maior que 0, ou será considerada a venda de uma unidade.
     * @param quant O tamanho do lote (maior que 0). Valores inválidos serão
     * considerados como lotes de 1 unidade.
     * @return Valor do lote para QUANT produtos.
     */
    double valorLote(int quant){
        if(quant < 1)
            quant = 1;
        return valorUnitario * quant;
    }

    
    /**
     * Retorna a descrição de um produto, com seu valor unitário.
     * @return Uma string no formato "DESCRICAO: R"
     */ 
    String descricaoProduto(){
        return String.format("%s: R$ %.2f", descricao, valorUnitario);
    }
   
    //#endregion
}
