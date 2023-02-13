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
 * Classe 'entrada' para uma tabela hash.
 * Cada entrada tem uma chave, um dado (pessoa) e um indicador de validade.
 */
public class Entrada {
    public String chave;
    public Candidato dado;
    public boolean valido;

    /**
     * Construtor vazio: cria um 'sentinela'
     */
    public Entrada(){
        this.chave = "";
        this.dado = null;
        this.valido = false;
    }

    /**
     * Construtor completo: Entrada com chave, dado e indicador válido
     * @param chave Chave de armazenamento (nome do candidato)
     * @param novo Dado (pessoa) a armazenar
     */
    public Entrada(String chave, Candidato novo){
        this.chave = chave;
        this.dado = novo;
        this.validar();
    }

    /**
     * Torna a entrada inválida
     */
    public void invalidar(){
        this.valido = false;
    }

    /**
     * Torna a entrada válida
     */
    public void validar(){
        this.valido = true;
    }

    /**
     * Retorna a validade da entrada
     * @return True/false conforme validade
     */
    public boolean ehValido(){
        return this.valido;        
    }

    /**
     * Retorna o dado contido pela entrada
     * @return Pessoa (dado da entrada), ou nulo, se for uma entrada sentinela
     */
    public Candidato getValor(){
        return this.dado;
    }

    
    @Override
    public String toString(){
        return "Chave: "+this.chave+ " - Valor: "+this.dado.toString();
    }
}