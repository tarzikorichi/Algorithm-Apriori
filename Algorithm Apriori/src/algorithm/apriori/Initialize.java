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
    public char [] tmp;
    
    Transaction t;
    
    Scanner input = new Scanner(System.in); 
    public Initialize(){
        this.seuil = this.getSeuil();
        this.file  = this.getPath();
    }
    
    private final int getSeuil(){
        System.out.print("Entrez la valeur de seuil :");
        this.seuil = this.input.nextInt();
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
    
    public LinkedList<Transaction> get(){
        return this.allTr;
    }
    
    public void affiche(){
        System.out.println(" Seuil :"+this.seuil);
        System.out.println(" File :"+this.file);
    } 
    // C:\Users\aryan\OneDrive\Documents\NetBeansProjects\Algorithm-Apriori\Algorithm Apriori\src\algorithm\apriori\File.txt
    public String toArray(){
        String tmp6 = "";
        for (int i = 0; i < allTr.size(); i++) {
            this.tmp = this.allTr.get(i).allItems;                                      
            for (int j = 0; j < this.tmp.length; j++) {                                  
                //this.allTrArray.add(this.tmp[j]+"");                                     
                tmp6 += this.tmp[j];
            }                                                                            
        }
        char[] tmp1 = tmp6.toCharArray();
        char[] tmp2 = tmp6.toCharArray();
        
        for (int i = 0; i < tmp1.length; i++) {
            for (int j = i+1; j < tmp2.length; j++) {
                if(tmp1[i] == tmp2[j]){
                    tmp2[j] = 'n'; // n for null
                }
            }
        }
        tmp6="";
        for (int i = 0; i < tmp2.length; i++) {
            if(tmp2[i] != 'n'){
                tmp6 += tmp2[i];
            }
        }
        this.allItems = tmp6;
        return tmp6;
    } 
}
