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
public class Item {
    
    public String nom;
    public int occ;
    public boolean isAcc;
    
    public Item(String n){
        this.nom = n;
    }
    
    public void setOcc(int o){
        this.occ = o;
    }
    
    public void isAccept(int seuil){
        if(this.occ >= seuil){
            this.isAcc = true;
        }
    }
}
