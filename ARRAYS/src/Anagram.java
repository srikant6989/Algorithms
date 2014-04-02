/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class Anagram {
    
    public static void printAna(String prefix, String suffix) {
        
        int n = suffix.length();
        if(n<=1) {
            System.out.println(suffix);
        }
        else if(n <=2) {
            String s1 = suffix.substring(0, 1);
            String s2 = suffix.substring(1, 2);
            String s3 = s2+s1;
            
            System.out.println(prefix+s3);
            System.out.println(prefix+suffix);
        }
        
        else {
            for(int i=0; i <n;i++) {
                
                String d1 = suffix.substring(i, i+1);
                String d2 = suffix.substring(i+1);
                String d3 = suffix.substring(0, i);
                
                printAna(prefix+d1, d3+d2);
            }
        }
    }
    public static void main(String[] args) {
        
        String s = "abc";
        String p = "";
        printAna(p,s);
        
    }
    
}
