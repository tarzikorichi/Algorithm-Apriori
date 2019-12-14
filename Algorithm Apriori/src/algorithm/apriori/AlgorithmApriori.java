/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.apriori;

import java.io.FileNotFoundException;
import java.util.LinkedList;


/**
 *
 * @author Korichi Tarzi
 */
public class AlgorithmApriori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Initialize init = new Initialize();
        
        init.readFile();
        init.aff();
        LinkedList<Item> i = init.toItems();
        
        for (int j = 0; j < i.size(); j++) {
            System.out.println(i.get(j).nom+" :"+i.get(j).occ);
        }
        
        Search s = new Search(i);
        
        LinkedList<Item> s1 = s.search1();
        
        for (int j = 0; j < s1.size(); j++) {
            System.out.println(s1.get(j).nom+" :"+s1.get(j).occ);
        }
        
        LinkedList<Item> s2 = s.search2();
        
        for (int j = 0; j < s2.size(); j++) {
            System.out.println(s2.get(j).nom+" :"+s2.get(j).occ);
        }
        
        System.out.println("----------------------------------------");
        //init.tt("AB");
        
        init.calcul(i);
        for (int j = 0; j < i.size(); j++) {
            if(i.get(j).isAcc)
                System.out.println(i.get(j).nom+" :"+i.get(j).occ+" --------accept : "+i.get(j).isAcc);
            else
                System.err.println(i.get(j).nom+" :"+i.get(j).occ+" --------accept : "+i.get(j).isAcc);
        }
        System.out.println("----------- 2");
        init.calcul(s1);
        for (int j = 0; j < s1.size(); j++) {
            if(s1.get(j).isAcc)
                System.out.println(s1.get(j).nom+" :"+s1.get(j).occ+" --------accept : "+s1.get(j).isAcc);
            else
                System.err.println(s1.get(j).nom+" :"+s1.get(j).occ+" --------accept : "+s1.get(j).isAcc);
        }
        System.out.println("----------- 3");
        init.calcul(s2);
         for (int j = 0; j < s2.size(); j++) {
             if(s2.get(j).isAcc)
                System.out.println(s2.get(j).nom+" :"+s2.get(j).occ+" --------accept : "+s2.get(j).isAcc);
             else
                 System.err.println(s2.get(j).nom+" :"+s2.get(j).occ+" --------accept : "+s2.get(j).isAcc);
        }
    }
}