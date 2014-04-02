/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class stack {
    
    public static Node1 head = null;
    
    public void push(Node1 n) {
        
        if(head == null) {
            
            head = n;
        }
        
        else {
            
            n.next = head;
            head = n;
        }            
    }
    
    public Node1 pop(Node1 n) {
        
        if(head == null)
            return null;
        
        else{
            Node1 temp;
            temp = head;
            head = head.next;
            return temp;
        }
            
    }
    
    public void display(Node1 item) {
        
        while(item!= null) {
            
            System.out.println(item.value);
            item = item.next;
        }
    }
    
    public static void main(String[] args) {
        
        stack s = new stack();
        
        s.push(new Node1(1));
        s.push(new Node1(2));
        s.push(new Node1(3));
        s.push(new Node1(4));
        s.push(new Node1(5));
        
        s.display(head);
        
        Node1 n1 = s.pop(head);
        System.out.println(n1.value);
        
        n1 = s.pop(head);
        System.out.println(n1.value);
    }
    
}
