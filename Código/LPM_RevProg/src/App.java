/** 
 * MIT License
 *
 * Copyright(c) 2023 João Caram <caram@pucminas.br>
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


import java.io.File;
import java.util.Scanner;
/*
 * Solução proposta para exercício de revisões, desconsiderando muitos conceitos de modularidade e POO. 
 * Há muita coisa para melhorar (algumas propositais, outras não 😉).
 */
public class App {

    static final String ARQ_HABILIDADES = "./habilidades";
    static final String ARQ_CANDIDATOS = "./candidatos";

    static Scanner teclado = new Scanner(System.in);  // teclado para leitura de dados.

    /**
     * Carrega a lista de habilidades a partir do arquivo formatado
     * @param nomeArquivo Nome do arquivo com dados
     * @return Uma lista com habilidades (que pode estar vazia)
     * @throws Exception Genérica ⚠️ para qualquer erro no arquivo
     */
    public static ListaHabilidades carregarHabilidades(String nomeArquivo) throws Exception{
        ListaHabilidades lista = new ListaHabilidades();
        Scanner leitor = new Scanner(new File(nomeArquivo));
        while(leitor.hasNextLine()){
            String habilidade = leitor.nextLine();
            Habilidade nova = new Habilidade();
            nova.descricao = habilidade;
            nova.nivel=0;
            lista.inserir(nova);
        }

        leitor.close();
        return lista;

    }

    /**
     * Carrega a lista de candidatos e suas habilidades, a partir do arquivo formatado.
     * Para cada candidato, relaciona seu nível de habilidade do arquivo com a habilidade na lista de habilidades na posição correspondente.
     * @param nomeArquivo Nome do arquivo com dados
     * @param habilidades Lista com habilidades pré-preenchida para nomear as habilidades dos candidatos
     * @return Uma lista de candidadatos (que pode estar vazia). Cada candidato tem uma lista de habilidades (que pode estar vazia).
     * @throws Exception Genérica ⚠️ para qualquer erro no arquivo
     */
    public static ListaCandidatos carregarCandidatos(String nomeArquivo, ListaHabilidades habilidades) throws Exception{
        Scanner leitor = new Scanner(new File(nomeArquivo));
        ListaCandidatos candidatos = new ListaCandidatos();
        while(leitor.hasNextLine()){
            ElementoHabilidade auxPercorrer = habilidades.primeiro.proximo;
            
            String linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            Candidato novo = new Candidato();
            novo.nome = detalhes[0];
            for (int i = 1; i < detalhes.length; i++) {
                Habilidade habilidade = new Habilidade();
                habilidade.descricao = auxPercorrer.meuDado.descricao;
                habilidade.nivel = Integer.parseInt(detalhes[i]);
                novo.habilidades.inserir(habilidade);
                auxPercorrer = auxPercorrer.proximo;
            }
            candidatos.inserir(novo);
        }
        
        leitor.close();
        return candidatos;
    }

    /**
     * Encontra o melhor candidato para uma habilidade específica. Em caso de empate, o primeiro encontrado prevalece.
     * @param habilidade Nome da habilidade de interesse.
     * @param candidatos Lista de candidatos
     * @return Um candidato ou null, se não houver nenhum.
     */
    public static Candidato melhorCandidatoHabilidade(String habilidade, ListaCandidatos candidatos){
        ElementoCandidato auxPercorrerCandidato = candidatos.primeiro.proximo;
        Candidato melhorCandidato=null;
        Candidato atual = auxPercorrerCandidato.meuDado;
        int maiorNivel = Integer.MIN_VALUE;
       
        
        while(auxPercorrerCandidato!=null){
            atual = auxPercorrerCandidato.meuDado;
            Habilidade habilidadeCandidato = atual.habilidades.localizar(habilidade);
            if(habilidadeCandidato!=null && habilidadeCandidato.nivel > maiorNivel){
                melhorCandidato = atual;
                maiorNivel = habilidadeCandidato.nivel;
            }
            auxPercorrerCandidato = auxPercorrerCandidato.proximo;
        }
        return melhorCandidato;
    }


    /**
     * Encontra o melhor candidato considerando uma habilidade obrigatória e uma importante. 
     * É feito um cálculo ponderado atribuindo 75% do peso à obrigatória. 
     * O candidato com o maior valor, desde que não tenha 0 na obrigatória, será retornado. Em caso de empate, o primeiro encontrado prevalece.
     * Pode ser retornado um candidato que possua somente a habilidade obrigatória; no entanto, não será retornado um candidato que possui somente a importante.
     * @param habilidades Vetor de strings: primeiro, o nome da habilidade obrigatória, depois o nome da importante.
     * @param candidatos Lista de candidatos
     * @return Um candidato ou null, se não houver nenhum.
     */
    public static Candidato melhorCandidatoHabilidadeObrigatoria(String[] habilidades, ListaCandidatos candidatos){
        String habilidadeObrigatoria = habilidades[0];
        String habilidadeImportante = habilidades[1];
        ElementoCandidato auxPercorrerCandidato = candidatos.primeiro.proximo;
        Candidato melhorCandidato=null;
        Candidato atual = auxPercorrerCandidato.meuDado;
        double maiorPontuacao = Double.MIN_VALUE;
        
        while(auxPercorrerCandidato!=null){
            atual = auxPercorrerCandidato.meuDado;
            Habilidade habilidadeObrigatoriaCandidato = atual.habilidades.localizar(habilidadeObrigatoria);
            Habilidade habilidadeImportanteCandidato = atual.habilidades.localizar(habilidadeImportante);
            
            if(habilidadeObrigatoriaCandidato!=null){
                double pontuacaoAtual = habilidadeObrigatoriaCandidato.nivel*0.75 + (habilidadeImportanteCandidato!=null?habilidadeImportanteCandidato.nivel*0.25:0); 
                if(habilidadeObrigatoriaCandidato.nivel > 0 && pontuacaoAtual > maiorPontuacao){
                    maiorPontuacao = pontuacaoAtual;
                    melhorCandidato = atual;
                }
            }
            auxPercorrerCandidato = auxPercorrerCandidato.proximo;
        }
        return melhorCandidato;
    }

    /**
     * Retorna o candidato com a melhor nota considerando todas as habilidades. A nota é calculada com base em todas as habilidades, havendo um bônus para cada habilidade
     * de nível máximo (5) possuída pelo candidato.
     * @param candidatos Lista com todos os candidatos.
     * @return O candidato com a melhor nota calculada, ou null se nao houver nenhum
     */
    public static Candidato melhorCandidatoGeral(ListaCandidatos candidatos){
        ElementoCandidato auxPercorrerCandidato = candidatos.primeiro.proximo;
        Candidato melhorCandidato=null;
        Candidato atual; 
        double maiorPontuacao = Double.MIN_VALUE;
        while(auxPercorrerCandidato!=null){
            atual = auxPercorrerCandidato.meuDado;
            double pontosCandidato=0;
            int notasMaximas=0;
            ListaHabilidades habilidadesCandidato = atual.habilidades;
            ElementoHabilidade auxPercorrerHabilidades = habilidadesCandidato.primeiro.proximo;
            while(auxPercorrerHabilidades!=null){
                int nivel = auxPercorrerHabilidades.meuDado.nivel;
                if(nivel==5)
                    notasMaximas++;
                pontosCandidato+= nivel;
                auxPercorrerHabilidades = auxPercorrerHabilidades.proximo;
            }
            pontosCandidato = pontosCandidato*0.8*(1+notasMaximas); 
            if(pontosCandidato > maiorPontuacao){
                maiorPontuacao = pontosCandidato;
                melhorCandidato = atual;
            }
            auxPercorrerCandidato = auxPercorrerCandidato.proximo;
        }
        return melhorCandidato;
    }

    /**
     * Exibe menu de opções e lê opção do usuário (número inteiro). O menu deve ser criado com números inteiros não negativos.
     * @return Inteiro com opção do usuário. Retonna -1 em caso de opção inválida.
     */
    public static int menu(){
        int opcao=-1;
        String escolha;

        System.out.println("\n\n\n");
        System.out.println("------======------");
        System.out.println("1 - Melhor candidato para habilidade.");
        System.out.println("2 - Melhor candidato com obrigatória e importante.");
        System.out.println("3 - Melhor candidato geral.");
        System.out.println("0 - Sair. ");
        System.out.print("Sua escolha: ");
        escolha = teclado.nextLine();
        if(escolha.matches("[0-3]")){
            opcao = Integer.parseInt(escolha);
        }
    
        return opcao;
        

    }
    public static void main(String[] args) throws Exception {
        ListaHabilidades listaHabilidades = carregarHabilidades(ARQ_HABILIDADES);
        ListaCandidatos candidatos = carregarCandidatos(ARQ_CANDIDATOS, listaHabilidades);
        int opcao = 0;
        Candidato escolhido = null;
        do{
            opcao = menu();
            switch(opcao){
                case 1: System.out.print("Qual habilidade você deseja? ");
                        String habilidade = teclado.nextLine();
                        escolhido = melhorCandidatoHabilidade(habilidade, candidatos);        
                    break;
                case 2: System.out.print("Qual é a habilidade obrigatória? ");
                        String obrigatoria = teclado.nextLine();
                        System.out.print("Qual é a habilidade importante? ");
                        String importante = teclado.nextLine();
                        String[] habilidades = {obrigatoria,importante};
                        escolhido = melhorCandidatoHabilidadeObrigatoria(habilidades, candidatos);        
                    break;
                
                case 3: escolhido = melhorCandidatoGeral(candidatos);
                    break;
            }
            if(escolhido!=null)
                System.out.println("Eu sugiro "+escolhido.nome);
            else
                System.out.println("Não temos candidatos adequados para estes requisitos.");
            System.out.println("------======------");

        }while(opcao!=0);

        
        System.out.println();
        teclado.close();
    }
}
