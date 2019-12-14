/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.apriori;

import java.util.LinkedList;

/**
 *
 * @author aryan
 */
public class Search {
    LinkedList<Item> items = new LinkedList<Item>();
    
    
    LinkedList<Item> items2 = new LinkedList<Item>();
    LinkedList<Item> items3 = new LinkedList<Item>();
    LinkedList<Item> items4 = new LinkedList<Item>();
    LinkedList<Item> items5 = new LinkedList<Item>();
    
    public Search(LinkedList<Item> i){
        this.items = i;
    }
    
        
    public LinkedList<Item> search1(){
        String R = "";
        for (int i = 0; i < items.size()-1; i++) {
            for (int j = i+1; j < items.size(); j++) {
                R += items.get(i).nom+""+items.get(j).nom+"::";
            }
        }
        String[] rr = R.split("::");
         
        for (int i = 0; i < rr.length; i++) {
            this.items2.add(new Item(rr[i]));
        }
        return this.items2;
    }
    
    public LinkedList<Item> search2(){
        String R = "";
        for (int i = 0; i < items.size()-2; i++) {
            for (int j = i+1; j < items.size() - 1; j++) {
                for (int k = j+1; k < items.size(); k++) {
                    R += items.get(i).nom+""+items.get(j).nom+""+items.get(k).nom+"::";
                }
            }
        }
        String[] rr = R.split("::");
        for (int i = 0; i < rr.length; i++) {
            this.items3.add(new Item(rr[i]));
        }
        return this.items3;
    }
    
    public LinkedList<Item> search3(){
        String R = "";
        for (int i = 0; i < items.size()-3; i++) {
            for (int j = i+1; j < items.size() - 2; j++) {
                for (int q = j+1; q < items.size() - 1; q++) {
                    for (int k = q+1; k < items.size(); k++) {
                        R += items.get(i).nom+""+items.get(j).nom+""+items.get(q).nom+""+items.get(k).nom+"::";
                    }
                }
            }
        }
        String[] rr = R.split("::");
        for (int i = 0; i < rr.length; i++) {
            this.items4.add(new Item(rr[i]));
        }
        return this.items4;
    }
    
    public LinkedList<Item> search4(){
        String R = "";
        for (int i = 0; i < items.size()-4; i++) {
            for (int j = i+1; j < items.size() - 3; j++) {
                for (int q = j+1; q < items.size() - 2; q++) {
                    for (int p = q+1; p < items.size() -1; p++) {
                        for (int k = p+1; k < items.size(); k++) {
                            R += items.get(i).nom+""+items.get(j).nom+""+items.get(q).nom+""+items.get(p).nom+""+items.get(k).nom+"::";
                        }
                    }
                }
            }
        }
        String[] rr = R.split("::");
        for (int i = 0; i < rr.length; i++) {
            this.items5.add(new Item(rr[i]));
        }
        return this.items5;
    }
}
