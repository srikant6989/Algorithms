
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class LLofNodes {
    
    public ArrayList<LinkedList<BTNode>> findLinkListLevel (BTNode root) {
        
        int level = 0;
        ArrayList<LinkedList<BTNode>> result = new ArrayList<LinkedList<BTNode>>();
        LinkedList<BTNode> list = new LinkedList<BTNode>();
        
        list.add(root);
        result.add(level, list);
        
        while(true) {
            
            list = new LinkedList<BTNode>();
            for(int i=0; i<result.get(level).size(); i++) {
                BTNode n = result.get(level).get(i);
                
                if(n != null) {
                    if(n.left != null)
                        list.add(n.left);
                    if(n.right != null)
                        list.add(n.right);
                }
            }
                if(list.size() > 0)
                    result.add(level+1, list);
                
                else
                    break;    
                
                level ++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        
        
    }
    
}

class BTNode {
    
    BTNode left, right;
    int value;
    
    public BTNode(int value) {
        
        left = right = null;
        this.value = value;
    }
}
