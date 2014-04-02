
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class BT {
        
    static BTNode root = null;    
    int size = 0;
    static BTNode current1;
    
    public void addNode(BTNode node) {
        
        BTNode current;
        current = root;
        size ++;
        if(root == null) {
            
            root = node;
            current = root;
            current1 = root;
            root.parent = null;
        }
        else {
            
            while(current != null) {
                
                if(node.value < current.value) {
                    
                    node.parent = current;
                    current = current.left;
                }
                
                else {
                    
                    node.parent = current;
                    current = current.right;
                }
            }
            
            if(node.value < node.parent.value) {
                node.parent.left = node;
            }
            else {
                node.parent.right = node;
            }
        }
                
    }
    
    public void display(BTNode node) {      //PRE ORDER
        
        if(node != null) {
            System.out.println(node.value);
            display(node.left);            
            display(node.right);
        }
        
        
    }
    
        public void display1(BTNode node) {      //IN ORDER
        
        if(node != null) {           
            display1(node.left);
            System.out.println(node.value);
            display1(node.right);
        }
    }
        
        public void display2(BTNode node) {      //POST ORDER
        
        if(node != null) {           
            display2(node.left);            
            display2(node.right);
            System.out.println(node.value);
        }
    }
                    
    public boolean isSub(BTNode t1, BTNode t2) {
        
        if(t1.value == t2.value) {
            
            if (matchTree(t1,t2))
                return true;
            
        }
        return (isSub(t1.left,t2) || isSub(t1.right, t2));
    } 
    
    public boolean matchTree(BTNode n1, BTNode n2) {
        
        if(n1 == null && n2 == null) {
            
            return true;
        }
        
        if(n1 == null || n2 == null) {
            
            return false;
        }
        
        if(n1.value != n2.value) {
            
            return false;
        }
        
        return (matchTree(n1.left,n2.left) && matchTree(n1.right, n2.right));
    }
        
    public static void main(String[] args) {
        
        BT n = new BT();
        int[] a = {12,9,25,5,10,20,15,30,35,33,36,38};
        
        for(int i=0; i <12; i++) {            
            BTNode node = new BTNode(a[i]);
            n.addNode(node);           
        }
        
    }
}

class BTNode {
    
    BTNode left, right;
    BTNode parent;
    int value;
    
    public BTNode(int value) {
        
        left = right = null;
        parent = null;
        this.value = value;
    }
}
