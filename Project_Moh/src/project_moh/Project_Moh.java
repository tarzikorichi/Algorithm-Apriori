package project_moh;

import java.util.HashMap;

/**
 *
 * @author KORICHI TARZI
 */
public class Project_Moh {

    public static void main(String[] args) {
        ReadFromFile rd = new ReadFromFile();
        
        rd.Calcul();
        System.err.println("------ Result");
        HashMap<String, Double> Result = new HashMap<String, Double>();
        Result = rd.getResult();
        
        for (String i : Result.keySet()) {
            System.out.println("Key:"+i+" - Value:"+Result.get(i));
        }
    }   
}
