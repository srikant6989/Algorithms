
import java.util.Scanner;

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
            display(node.left);            
            display(node.right);
            System.out.println(node.value);
        }
    }
                    
        
        public BTNode findAncestor(BTNode node1, BTNode node2) {
            
            if(node1.value < current1.value && current1.value < node2.value) {
                
                return current1;
            }
            
            else {
                
                if(node1.value < current1.value && node2.value < current1.value) {
                    
                    current1 = current1.left;
                    findAncestor(node1, node2);
                }
                
                else if(node1.value > current1.value && node2.value > current1.value) {
                    
                    current1 = current1.right;
                    findAncestor(node1, node2);
                }
            }
            
            return current1;
        }
        

        
        
        
    public static void main(String[] args) {
        
        BT n = new BT();
        int[] a = {12,9,25,5,10,20,15,30,35,33,36,38};
        //Scanner sc = new Scanner(System.in);
        
        //System.out.println("Enter values");
        
        for(int i=0; i <12; i++) {
            //a[i] = sc.nextInt();
            BTNode node = new BTNode(a[i]);
            n.addNode(node);           
        }
        
        //n.display1(root);
        
//        n.delete(25, root);
//        n.display(root);
        
//        int n1 = n.balancedOrNot(root);
//        System.out.println(n1);
//        if(n1 <=1 && n1>=-1) 
//            System.out.println("It is Balanced");
//        
//        else
//            System.out.println("It is not balanced");
        
//        int f = n.findHighest(root);
//        System.out.println("Height is " + f);
        
        BTNode new1 = n.findAncestor(root.right.left.left, root.right.right);
        System.out.println("The first common ancestor is: " + new1.value);

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
