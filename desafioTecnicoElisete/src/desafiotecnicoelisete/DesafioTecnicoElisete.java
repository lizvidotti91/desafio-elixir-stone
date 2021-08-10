package desafiotecnicoelisete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Liz
 */
public class DesafioTecnicoElisete {

    public static void main(String[] args) {
        // Instanciando os objetos Item
        Item arroz = new Item("arroz",1,100);
        Item feijao = new Item("feijao",20,599);
        Item macarrao = new Item("macarrao",40,165);
        Item oleo = new Item("oleo",12,619);
        Item leite = new Item("leite",3,371);
        
        // Instanciando uma lista de Itens
        // Adicionando cada Item na Lista
        List<Item> lista = new ArrayList<>();
        lista.add(arroz);
        lista.add(feijao);
        lista.add(macarrao);
        lista.add(oleo);
        lista.add(leite);
        
        // Instanciando uma lista de E-mails
        // Adicionando cada e-mail na lista
        List<String> listaEmails = new ArrayList<>();
        listaEmails.add("email-1");
        listaEmails.add("email-2");
        listaEmails.add("email-3");
        listaEmails.add("email-4");
        listaEmails.add("email-5");
        listaEmails.add("email-6");
        listaEmails.add("email-7");
        
        // Instanciando um Mapa, que recebe o retorno da função calcLista()
        Map<String, Integer> res = DesafioTecnicoElisete.calcLista(lista, listaEmails);
        
        // Exibindo na tela o Mapa
        System.out.println(res);
    }
    
    
    // Função que recebe as listas de Itens e de E-mails, calcula o preço total e divide entre o número de E-mails da lista
    private static Map<String, Integer> calcLista(List<Item> lista, List<String> listaEmails){
        // Inicializando o Mapa
        Map<String, Integer> divisaoLista = new HashMap<>();
        
        // Validações
        // A função estaVazia() verifica se a lista de itens ou de e-mails está vazia (return true)
        // A função stringVazia() verifica se algum item da lista de e-mails possui uma string vazia
        // Para condição verdadeira, a função retorna que Há dados sem preenchimento
        // Caso contrário, é executado o que está dentro do else
        if(DesafioTecnicoElisete.estaVazia(lista, listaEmails) || DesafioTecnicoElisete.stringVazia(listaEmails)){
            divisaoLista.put("Há dados sem preenchimento. Verifique novamente.",1);
        } else{
            // Cálculo do Preço Total
            int precoTotal = 0;
            for(int i=0; i<lista.size(); i++){
                precoTotal += lista.get(i).quantidade * lista.get(i).precoUnitario;
            }
            
            // Cálculo da divisão do Preço por Pessoa
            int precoPorPessoa = precoTotal / listaEmails.size();
            // Cálculo do resto da divisão entre o preço total e o número de E-mails
            int resto = precoTotal % listaEmails.size(); 
            
            // Passando a chave do mapa (email) e o valor da chave (preço por pessoa) para o mapa
            for(int i=0; i<listaEmails.size(); i++){
                divisaoLista.put(listaEmails.get(i), precoPorPessoa);
            }
           
            // Verificação
            // Caso o valor do resto da divisão seja diferente que zero, é feita distribuição desse valor
            // Vamos acrescentando 1 a cada elemento do mapa, e diminuindo 1 do valor do resto, até que o resto seja zero
            if(resto != 0){
                for(int i=resto; i>0; i--){
                    divisaoLista.put(listaEmails.get(i), precoPorPessoa + 1);
                }
            }
        }
        
        // Quando há e-mails repetidos na Lista de E-mails, o Mapa só considera como 1 e-mail, reduzindo a quantidade de elementos na lista, causando a divergência de valores
        if(divisaoLista.size() != listaEmails.size()){
            Map<String, Integer> res = new HashMap<>();
            res.put("ATENÇÃO: Há e-mails repetidos na lista! ",1);
            return res;
        } else{
           return divisaoLista;
        }
    }
    
    // Função que verifica se uma das listas está vazia
    private static boolean estaVazia(List<Item> lista, List<String> listaEmails){
        if(lista.size() == 0 || listaEmails.size() == 0){
            return true;
        } else {
            return false;
        }
    }
    
    // Verificação se algum elemento da lista é uma string vazia
    private static boolean stringVazia(List<String> listaEmails){
        boolean condicao = false;
        for(int i=0; i<listaEmails.size(); i++){
            if(listaEmails.get(i).length() == 0){
                condicao = true;
                break;
            } else {
                condicao = false;
            }
        }
        return condicao;
    }
}
