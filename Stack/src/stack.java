/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class stack {
    
    public static Node head = null;
    
    public void push(Node n) {
        
        if(head == null) {
            
            head = n;
        }
        
        else {
            
            n.next = head;
            head = n;
        }            
    }
    
    public Node pop(Node n) {
        
        if(head == null)
            return null;
        
        else{
            Node temp;
            temp = head;
            head = head.next;
            return temp;
        }
            
    }
    
    public void display(Node item) {
        
        while(item!= null) {
            
            System.out.println(item.value);
            item = item.next;
        }
    }
    
    public static void main(String[] args) {
        
        stack s = new stack();
        
        s.push(new Node(1));
        s.push(new Node(2));
        s.push(new Node(3));
        s.push(new Node(4));
        s.push(new Node(5));
        
        s.display(head);
        
        Node n1 = s.pop(head);
        System.out.println(n1.value);
        
        n1 = s.pop(head);
        System.out.println(n1.value);
    }
    
}
