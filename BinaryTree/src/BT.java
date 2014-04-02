
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class BT {
    
    BTNode parent;
    static BTNode root = null;    
    int size = 0;    
    
    public void addNode(BTNode node) {
        
        BTNode current;
        current = root;
        size ++;
        if(root == null) {
            
            root = node;
            current = root;
        }
        else {
            
            while(current != null) {
                
                if(node.value < current.value) {
                    
                    parent = current;
                    current = current.left;
                }
                
                else {
                    
                    parent = current;
                    current = current.right;
                }
            }
            
            if(node.value < parent.value) {
                parent.left = node;
            }
            else {
                parent.right = node;
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
            display(node.left);
            System.out.println(node.value);
            display(node.right);
        }
    }
        
        public void display2(BTNode node) {      //POST ORDER
        
        if(node != null) {           
            display(node.left);            
            display(node.right);
            System.out.println(node.value);
        }
    }
                    
        
        public void delete(int value, BTNode node) {
            
            BTNode current , parent;
            current = node;   
            parent = current;
            
            while(current!=null) {
                if(current.value==value)
                    break;
                parent=current;
                if(value<current.value) {
                    current=current.left;
                    
                }
                else
                    current=current.right;
            }

                        
            deleteNode(current , parent);
        }
        
        public void deleteNode(BTNode node, BTNode node1) {
          
            BTNode current = node;
            BTNode parent = node1;
            
            if(current.left == null && current.right == null) { //*************DELETING LEAF NODE
                
                if(current.value < parent.value) 
                    parent.left = null;
                
                else
                    parent.right = null;
            }
            
            else if(current.left == null || current.right == null) {  //********DELETING NODE WITH 1 CHILD
                
                if(current.right == null) {
                    
                    if(current == parent.left) {
                        
                        parent.left = current.left;
                        current.left = null;
                    }
                    
                    else if(current == parent.right) {
                        
                        parent.right = current.left;
                        current.left = null;
                    }
                }
                
                else if(current.left == null) {
                    
                    if(current == parent.left) {
                        
                        parent.left = current.right;
                        current.right = null;
                    }
                    
                    else if(current == parent.right) {
                        
                        parent.right = current.right;
                        current.right = null;
                    }
                }
            }
            
            else if(current.left != null && current.right != null) {  //************DELETING NODE WITH 2 CHILDREN
                
                BTNode temp = current;
                BTNode parent1;
                temp = temp.right;
                parent1 = temp;
                
                if(temp.left == null) {
                    
                    current.value = temp.value;
                    current.right = temp.right;
                    temp.right = null;
                }
                
                while(temp.left != null) {
                    parent1 = temp;
                    temp = temp.left;
                }
                
                current.value = temp.value;
                parent1.left = null;
            }
        }
        
        public int findHighest(BTNode node) {
                        
            if(node == null)
                return 0;
            else
                return 1 + Math.max(findHighest(node.left), findHighest(node.right));            
        }
        
        public int balancedOrNot(BTNode node) { // *********** CHECKS IF BST IS BALANCED OR NOT
                                                
            if(node != null)
                return ((1 + Math.max(balancedOrNot(node.left), balancedOrNot(node.right))) - (1 + Math.min(balancedOrNot(node.left), balancedOrNot(node.right))));
            else 
                return 2;
        }
        
    public static void main(String[] args) {
        
        BT n = new BT();
        int[] a = {12,9,25,5,10,20,30,35,33,36,38};

        
        for(int i=0; i <11; i++) {
            //a[i] = sc.nextInt();
            BTNode node = new BTNode(a[i]);
            n.addNode(node);           
        }
        
        n.display(root);
        
//        n.delete(25, root);
//        n.display(root);
        
//        int n1 = n.balancedOrNot(root);
//        System.out.println(n1);
//        if(n1 <=1 && n1>=-1) 
//            System.out.println("It is Balanced");
//        
//        else
//            System.out.println("It is not balanced");
        
        int f = n.findHighest(root);
        System.out.println("Height is " + f);
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
