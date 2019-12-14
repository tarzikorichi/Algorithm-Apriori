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
        
       
        LinkedList<Item> s2 = s.search2();
        
       
        LinkedList<Item> s3 = s.search3();
        
        LinkedList<Item> s4 = s.search4();
        
        
        System.out.println("----------------------------------------");
        //init.tt("AB");
        
        init.calcul(i);
        for (int j = 0; j < i.size(); j++) {
            if(i.get(j).isAcc)
                System.out.println(i.get(j).nom+" :"+i.get(j).occ+" --------accept : "+i.get(j).isAcc);
        }
        
        
        System.out.println("----------- 2");
        init.calcul(s1);
        for (int j = 0; j < s1.size(); j++) {
            if(s1.get(j).isAcc)
                System.out.println(s1.get(j).nom+" :"+s1.get(j).occ+" --------accept : "+s1.get(j).isAcc);
        }
        System.out.println("----------- 3");
        init.calcul(s2);
         for (int j = 0; j < s2.size(); j++) {
             if(s2.get(j).isAcc)
                System.out.println(s2.get(j).nom+" :"+s2.get(j).occ+" --------accept : "+s2.get(j).isAcc);
        }
        
        System.out.println("----------- 4");
        init.calcul(s3);
         for (int j = 0; j < s3.size(); j++) {
             if(s3.get(j).isAcc)
                System.out.println(s3.get(j).nom+" :"+s3.get(j).occ+" --------accept : "+s3.get(j).isAcc);
        }
        
        System.out.println("----------- 5");
        init.calcul(s4);
         for (int j = 0; j < s4.size(); j++) {
             if(s4.get(j).isAcc)
                System.out.println(s4.get(j).nom+" :"+s4.get(j).occ+" --------accept : "+s4.get(j).isAcc);
        }
         
        System.out.println("----------------------------------- Motifs fréquents");
         
        init.calcul(i);
        for (int j = 0; j < i.size(); j++) {
            if(i.get(j).isAcc)
                System.out.println("{"+i.get(j).nom+"} = "+i.get(j).occ+" / "+init.getTrLen());
        }
        
 
        init.calcul(s1);
        for (int j = 0; j < s1.size(); j++) {
            if(s1.get(j).isAcc)
                System.out.println("{"+s1.get(j).nom+"} = "+s1.get(j).occ+" / "+init.getTrLen());
        }

        init.calcul(s2);
         for (int j = 0; j < s2.size(); j++) {
             if(s2.get(j).isAcc)
                System.out.println("{"+s2.get(j).nom+"} = "+s2.get(j).occ+" / "+init.getTrLen());
        }
         
        init.calcul(s3);
         for (int j = 0; j < s3.size(); j++) {
             if(s3.get(j).isAcc)
                System.out.println("{"+s3.get(j).nom+"} = "+s3.get(j).occ+" / "+init.getTrLen());
        }
        init.calcul(s4);
         for (int j = 0; j < s4.size(); j++) {
             if(s4.get(j).isAcc)
                System.out.println("{"+s4.get(j).nom+"} = "+s4.get(j).occ+" / "+init.getTrLen());
        }
    }
}