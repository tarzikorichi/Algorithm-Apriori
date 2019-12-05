/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.apriori;

/**
 *
 * @author Korichi Tarzi
 */
public class Transaction {
    public String Nom;
    private char [] allItems;
    private Boolean accept; 
    
    public Transaction(String n, char [] allItem){
        this.Nom = n;
        this.allItems = allItem;
    }
    
    public void setAccept(){
        this.accept = true;
    }
    public void setNotAccept(){
        this.accept = false;
    }
    public boolean getAccept(){
        return this.accept;
    }
    
    public void Affiche(){
        System.out.print(this.Nom+" :");
        for (int i = 0; i < this.allItems.length; i++) {
            System.out.print(this.allItems[i]+", ");
        }
        System.out.println();
    }
}
