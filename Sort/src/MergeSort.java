/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class MergeSort {
    
    public static int[] array = new int[] {7,15,6,4,88,126,11,2,11};
    
    public static void main(String args[]) {
        
        
        int[] sorted = mergeSort(array);
        for(int i=0;i<sorted.length;i++){
            System.out.print(" "+sorted[i]);
        }
        System.out.println("");
    }

    public static int[] mergeSort(int[] array) {
        
        if(array.length == 1) {
            return array;
        }
        else {
            int[] finalArray;
            int n = array.length/2;
            int n1 = array.length - n;
            int[] first = new int[n];
            int[] second = new int[n1];

            int i = 0;
            for(i=0;i<n;i++){
                first[i] = array[i];
            }

            int j=0;
            for(;i<array.length;i++){
                second[j] = array[i];
                j++;
            }
            int[] firstSorted = mergeSort(first);
            int[] secondSorted = mergeSort(second);

            finalArray = merge(firstSorted, secondSorted);

            return finalArray;
    }
}

    public static int[] merge(int[] firstSorted, int[] secondSorted) {
        
        int[] final_sorted = new int[firstSorted.length+secondSorted.length];

        int i = 0; int j=0; int k =0;
        while(i <firstSorted.length && j<secondSorted.length) {
            
            if(firstSorted[i] > secondSorted[j]) {
                //int temp =0;
                
                //temp = firstSorted[i];
                //firstSorted[i] = secondSorted[j];
                //secondSorted[j] = temp;
                final_sorted[k] = secondSorted[j];
                j++;
                k++;
            }
            else {
                final_sorted[k] = firstSorted[i];
                i++;
                k++;
            }
        }
            while( i < firstSorted.length) {
                final_sorted[k] = firstSorted[i];
                k++;
                i++;
            }
            
            while( j < secondSorted.length) {
                final_sorted[k] = secondSorted[j];
                k++;
                j++;
            }
            
      
        
        return final_sorted;
    }
}