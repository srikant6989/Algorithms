/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class AnagramOrNot {
        
    static boolean isAnagram(String s1, String s2) {
        
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int[] sum1= new int[a1.length], sum2=new int[a2.length];
        int suma1 = 0, suma2 = 0;
        if(a1.length != a2.length) {
            return false;
        }
        else {
            for(int i=0;i<a1.length;i++) {
                sum1[i] = a1[i];
                sum2[i] = sum2[i];                                
        }
        }        
        
        for(int i =0; i < sum1.length;i++) {
            suma1 = suma1 + sum1[i];
            suma2 = suma2 + sum2[i];
        }
        
        if(suma1 == suma2)
            return true;
        
        return true;
    }
    public static void main(String[] args) {
        
        String s = "Helllooo";
        String s1 = "Helllo";
        
        if(isAnagram(s,s1)) {
            System.out.println("YES");
        } 
        
    }
    
}
