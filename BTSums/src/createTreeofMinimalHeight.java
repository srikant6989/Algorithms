/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class createTreeofMinimalHeight {
        
    public static BTNode root = null;
    
    public static BTNode createTree(int[] b, int start, int end) {
        
        if(end < start)
            return null;
        
        int mid = (start+end)/2;
        BTNode n = new BTNode(b[mid]);
        
        if(root == null)
            root = n;
        
        n.left = createTree(b, start, mid-1);
        n.right = createTree(b, mid+1, end);
        
        return n;
        
    }
    
    public void display(BTNode node) {      //PRE ORDER
        
        if(node != null) {
            System.out.println(node.value);
            display(node.left);            
            display(node.right);
        }
        
        
    }
    
    public static void main(String[] args) {
        
        createTreeofMinimalHeight h = new createTreeofMinimalHeight();
        int[] a = {1,2,3,4,5,6,7};                 
        
        createTree(a, 0, a.length-1);
        
        System.out.println("The tree has been constructed as :");
        System.out.println();        
        h.display(root);
        
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
