
package Test;

import java.util.LinkedList;

/**
 *
 * @author Korichi Tarzi
 */
public class Test1 {
    
    
    
    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<String>();
        LinkedList<String> items2 = new LinkedList<String>();
        LinkedList<String> items3 = new LinkedList<String>();
        items.add("A"); items.add("B"); items.add("C"); items.add("D"); items.add("E"); 
        
        for (int i = 0; i < items.size()-1; i++) {
            for (int j = i+1; j < items.size(); j++) {
                items2.add(items.get(i)+"-"+items.get(j));
                System.out.println(items.get(i)+"-"+items.get(j));
            }
        }
        
        for (int i = 0; i < items.size()-2; i++) {
            for (int j = i+1; j < items.size() - 1; j++) {
                for (int k = j+1; k < items.size(); k++) {
                    items3.add(items.get(i)+"-"+items.get(j)+"-"+items.get(k));
                    System.out.println(items.get(i)+"-"+items.get(j)+"-"+items.get(k));
                }
            }
        }
        
    }
}
