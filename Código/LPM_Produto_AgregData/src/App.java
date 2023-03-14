public class App {
    public static void main(String[] args) throws Exception {
        Produto prod = new Produto("Meu Produto", 12, 5, 
                                    3, new Data("12/03/2023"));
       
        
        System.out.println(prod.dadosProduto());

        
    }
}
