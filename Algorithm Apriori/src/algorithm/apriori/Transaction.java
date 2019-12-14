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
   public String nomTr;
   private char[] items;
   private boolean accept;
           
   public Transaction(String n ,char[] i){
       this.nomTr = n;
       this.items = i;
   }

    char[] getItems() {
        return this.items;
    }
    
    
    public boolean searchForItem(String nom){
        char[] all = nom.toCharArray();
        int b = 0;
        
        for(char item :items){
            for(char c :all){
                if(item == c){
                    b++;
                }
            }
        }
        if(b == nom.length()){
            return true;
        }else
            return false;
    }
}
