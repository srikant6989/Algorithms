
import javax.swing.tree.TreeNode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class FindNextNode {
    
    public BTNode findNext(BTNode node1) {
        
        BTNode node2;
        
        if(node1 != null) {
            
            if(node1.right != null || node1.parent == null) {
                
                node2 = findLeftMostNode(node1.right);
            
            }
            
            else {
                
                while((node2 = node1.parent) != null) {
                    
                    if(node1 == node2.left)
                        break;
                    
                    else
                        node1 = node2;
                }
                
            }
            return node2;
        }
        return null;
    }
    
    public BTNode findLeftMostNode (BTNode node) {
        
        if(node == null)
            return null;
        while(node.left != null)
            node = node.left;
        
        return node;
    }
    
}

