
import java.util.Hashtable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class wrodsFrequency {
    
    public static void main(String[] args) {
        
        wrodsFrequency w = new wrodsFrequency();
        
        String[] book = {"hello", "my", "friend",".", "my", "name", "is", "srikant",".", "i", "am", "your", "friend"};
        
        Hashtable<String, Integer> table = w.setDictionary(book);
        
        String word = "friend";
        
        System.out.println("Frequency of the word is " + w.getFrequencyOfWord(table, word));
        
    }
    
    public Hashtable<String,Integer> setDictionary (String[] book) {
        
        Hashtable<String,Integer> table = new Hashtable<String,Integer>();
        
        for(String word: book) {
            
            if(word != "") {
                
                if(!table.containsKey(word))
                    table.put(word,1);
                else
                    table.put(word, table.get(word) + 1);
            }
        }
        return table;
    }
    
    public int getFrequencyOfWord(Hashtable<String, Integer> table, String word) {
        
        if(table == null || word == null)
            return -1;
        
        else {
            
            if(table.containsKey(word)) {
                
                return table.get(word);
            }
        }
        
        return table.get(word);
    }    
    
}
