package project_moh;

/**
 *
 * @author KORICHI TARZI
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap; // import the HashMap class
import java.util.Scanner;

public class ReadFromFile {
    private String path_Arb = "C:\\Users\\aryan\\OneDrive\\Documents\\NetBeansProjects\\Algorithm-Apriori\\Project_Moh\\src\\project_moh\\Arb.txt";
    private String path_Arb2 = "C:\\Users\\aryan\\OneDrive\\Documents\\NetBeansProjects\\Algorithm-Apriori\\Project_Moh\\src\\project_moh\\Arb2.txt";
    
    private HashMap<String, String> Tree = new HashMap<String, String>();
    private HashMap<String, String> Tree_Help = new HashMap<String, String>();
    private HashMap<String, Double> Result = new HashMap<String, Double>();
    private void read(){
        File Arbfile = new File(this.path_Arb); 
        File Arb2file = new File(this.path_Arb2); 
        try{
            Scanner sc_arb = new Scanner(Arbfile);
            Scanner sc_arb2 = new Scanner(Arb2file);
            String help[] = new String[2];
            int i = 0;
            while (sc_arb2.hasNextLine()){ 
              help = sc_arb2.nextLine().split("//");
              this.Tree.put(help[0], help[1]);
              i++;
            }
            int j = 0;
            while (sc_arb.hasNextLine()){ 
              help = sc_arb.nextLine().split("//");
              if(help.length == 1){
                this.Tree_Help.put(help[0], "");
              }else{
                this.Tree_Help.put(help[0], help[1]);
              }
              
              i++;
            }
            
        }catch(FileNotFoundException ex){
            System.err.println("File not found : "+ex.getMessage());
        }
    }
    
    
    public void Calcul(){
        read();
        String val[] = new String[3];
        double val_int[] = new double[6];
        double val_c = 0.0;
        for (String i : Tree_Help.keySet()) {
            val_c = 0.0;
            if("".equals(Tree_Help.get(i))){
                val = Tree.get(i).split(",");
                int y = 0;
                for (String val1 : val) {
                    // 0-0,1 1-
                    if (y <= 5) {
                        val_int[y] = Double.parseDouble(val1.split("-")[0]); //0-2-4
                        val_int[y+1] = Double.parseDouble(val1.split("-")[1]); //1-3-5
                    }
                    y++; //0-1:2-3:4-5; //1-3-6
                    y++; //2-4-7
                }
                /*
                System.out.println("+"+i+"************************");
                System.out.println(" 1- "+val_int[0] +" * "+val_int[1]+" + "+ val_int[2]+" * "+val_int[3]+" + "+ val_int[4]+ " * "+val_int[5]);
                System.out.println("************************");
*/
                for (int j = 0; j < val_int.length; j = j+2) {
                    val_c += val_int[j] * val_int[j+1]; // 0-1:2-3:4-5
                }
                Result.put(i, val_c);
                
            }
        }
        for (String i : Tree_Help.keySet()) {
            val_c = 0.0;
            if(!"".equals(Tree_Help.get(i))){
                val = Tree.get(i).split(",");
                int y = 0;
                for (String val1 : val) {
                    // 0-0,1 1-
                    if (y <= 5) {
                        val_int[y] = Double.parseDouble(val1.split("-")[0]); //0-2-4
                        val_int[y+1] = "NO".equals(val1.split("-")[1]) ? (Result.get("A3")+Result.get("A4")) : Double.parseDouble(val1.split("-")[1]);
                    }
                    y++; //0-1:2-3:4-5; //1-3-6
                    y++; //2-4-7
                }
                /*
                System.out.println("+"+i+"************************");
                System.out.println(" 1- "+val_int[0] +" * "+val_int[1]+" + "+ val_int[2]+" * "+val_int[3]+" + "+ val_int[4]+ " * "+val_int[5]);
                System.out.println("************************");
*/
                for (int j = 0; j < val_int.length; j = j+2) {
                    val_c += val_int[j] * val_int[j+1]; // 0-1:2-3:4-5
                }
                Result.put(i, val_c);
                
            }
        }
 
    }
    
    public void aff_Tree(){
        for (String i : Tree.keySet()) {
            System.out.println("Key:"+i+" - Value:"+Tree.get(i));
        }
    }
    
    public void aff_Tree_help(){
        for (String i : Tree_Help.keySet()) {
            System.out.println("Key:"+i+" - Value:"+Tree_Help.get(i));
        }
    }
    
    public void Aff_result(){
        for (String i : Result.keySet()) {
            System.out.println("Key:"+i+" - Value:"+Result.get(i));
        }
    }
    
    public HashMap getResult(){
        return this.Result;
    }
    
}
