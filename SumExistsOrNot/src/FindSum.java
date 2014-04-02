
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class FindSum {
    
    public static ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(-2,1,0,3,5,6,7,9,13,14));    
    public static int i = 0;
    public static int j = 9;
    
    public static void main(String[] args) {
        
        FindSum f = new FindSum();
        
        int b[] = new int[10];
        
        int sum = 108;
        
        Collections.sort(a1);
        
        for(int r=0; r<10; r++) {
            
            b[r] = a1.get(r).intValue();
        }
        
        int start = b[0];
        int end = b[b.length-1];
        
//        for(int g=0;g<10;g++)
//            System.out.println(b[g]);
         
        
        if(f.checkIfSumExists(sum, b, start, end)) {
            
            System.out.println("The sum exists");
        }
        else
            System.out.println("The sum does not exist");
    }
    
    public boolean checkIfSumExists(int sum, int[] b, int start, int end) {                                        
        
         while(start < end) {
            if(start+end == sum) {
                return true;                
            }                        
            
            else {
                if(start + end > sum) {

                    j--;
                    end = b[j]; 
                    
                    if(checkIfSumExists(sum, b, start, end))
                        return true;
                }

                else {

                    i++;
                    start = b[i];
                    
                    if(checkIfSumExists(sum, b, start, end))
                        return true;
                }
            }
            break;
         }
           return false;                     
    }
    
}
