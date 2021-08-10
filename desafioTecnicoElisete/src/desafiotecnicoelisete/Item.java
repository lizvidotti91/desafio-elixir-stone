/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiotecnicoelisete;

/**
 *
 * @author Liz
 */
public class Item {
    // Atributos do item
    private String nome;
    int quantidade;
    int precoUnitario;
    
    // Construtor
    public Item(String nome, int quantidade, int precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    
    // Função que mostra os dados do item na tela
    public String getItem(){
        return "Item: " + this.nome +
               "| Quant: " + this.quantidade +
               " | Preço Un.: " + this.precoUnitario + "\n";
    }
}
