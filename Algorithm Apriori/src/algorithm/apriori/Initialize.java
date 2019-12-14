/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.apriori;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Korichi Tarzi
 */
public class Initialize {
    private int seuil;
    private String file;
    private String allItems;
    LinkedList<Transaction> allTr = new LinkedList<Transaction>();
    
    LinkedList<Item> items = new LinkedList<Item>();
    public char [] tmp;
    
    Transaction t;
    
    Scanner input = new Scanner(System.in); 
    public Initialize(){
        System.out.println("use this file :C:\\Users\\aryan\\OneDrive\\Documents\\NetBeansProjects\\Algorithm-Apriori\\Algorithm Apriori\\src\\algorithm\\apriori\\File.txt");
        this.seuil = this.getSeuil();
        this.file  = this.getPath();
        
    }
    
    private final int getSeuil(){
        System.out.print("Entrez la valeur de seuil :");
        this.seuil = this.input.nextInt();
        return this.seuil;
    }
    
    public int getS(){
        return this.seuil;
    }

    
    private String getPath() {
        System.out.print("Entrez le chemin du fichier :");
        this.input.useDelimiter("\n");
        this.file = this.input.next();
        return this.file;
    }
    
    public void readFile(){
        File Rfile = new File(this.file); 
        try{
            Scanner sc = new Scanner(Rfile); 
            int i = 1; // for name Transaction
            char[] tab;
            while (sc.hasNextLine()){ 
              tab = sc.nextLine().toCharArray();
              this.allTr.add(new Transaction("T"+i, tab));
              i++;
            }
        }catch(FileNotFoundException ex){
            System.err.println("File not found : "+ex.getMessage());
        }
    }
    
    public void aff(){
        for (int i = 0; i < allTr.size(); i++) {
            System.out.print(allTr.get(i).nomTr+" :");
            for (int j = 0; j < allTr.get(i).getItems().length; j++) {
                System.out.print(" "+allTr.get(i).getItems()[j]);
            }
            System.out.println();
        }
    }
    
    public LinkedList<Item> toItems(){
        char[] t;
        String R = "";
        t = allTr.get(0).getItems();
        for (int i = 0; i < t.length; i++) {
            R += t[i]+"";
        }

        for (int i = 1; i < allTr.size(); i++) {
            t = allTr.get(i).getItems();
            for (int j = 0; j < t.length; j++) {
                if(!R.contains(t[j]+"")){
                    R += t[j]+"";
                }
            }
        }
        System.out.println("resulat is: "+R);
        for (int i = 0; i < R.length(); i++) {
            this.items.add(new Item(R.charAt(i)+""));
        }
        return this.items;
    }
 
    // C:\Users\aryan\OneDrive\Documents\NetBeansProjects\Algorithm-Apriori\Algorithm Apriori\src\algorithm\apriori\File.txt
    
    
    
    public void calcul(LinkedList<Item> itm){
        // all Transaction in : allTr :
        // all items          : item  :
        int a;
        for(Item it :itm){
            a = 0;
            for(Transaction t: this.allTr){
                if(t.searchForItem(it.nom)){
                    a++;
                }
            }
            it.setOcc(a);
        }
        
        for(Item it : itm){
            it.isAccept(this.seuil);
        }
        
    }
    
    public void tt(String n){
        for(Transaction t : allTr){
            System.out.println("for "+t.nomTr+":"+n+" est :"+t.searchForItem(n));
        }
    }
    
    
}
