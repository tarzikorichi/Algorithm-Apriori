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
    LinkedList<Transaction> allTr = new LinkedList<Transaction>();
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
}
