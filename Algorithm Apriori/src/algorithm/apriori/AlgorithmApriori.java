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
public class AlgorithmApriori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Initialize init = new Initialize();
        init.affiche();
        init.readFile();
        
        LinkedList<Transaction> t = init.allTr;
        
        for (int i = 0; i < t.size(); i++) {
            t.get(i).Affiche();
        }
        System.out.println("resulata est :"+init.toArray());
    }
    
}
