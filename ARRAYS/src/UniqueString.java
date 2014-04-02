/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class UniqueString {
    
    static boolean check(String s) {
                
        int len = s.length();    
        StringBuffer snew = new StringBuffer();
        String s1 = s.toUpperCase();
        
        boolean[] set = new boolean[128];
        
        for(int i=0;i<len;i++) {
            
            int val = s1.charAt(i);
            
            if(set[val])
                return false;
            else 
                set[val] = true;
                snew.append(s1.charAt(i));
        }
        
        System.out.println(snew);
        return true;
    }
    public static void main(String args[]) {
                
        String s1 = "Hhelo";
        String s2 = "Helo";
        if(check(s1)) {
            System.out.println("Unique String");
        }        
        else
            System.out.println("Not Unique");
        
        if(check(s2)) 
            System.out.println("Unique String");
        else
            System.out.println("Not Unique");
    }
}
