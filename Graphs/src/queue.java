/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class queue {
        
    node head = null;    
    node tail = null;     
    
    public void enqueue(node item) {
        
        if(head == null) 
            
            head = tail = item;
        
        else
            
            tail.next = item;
            tail = item;
    }
    
    public node dequeue(node item) {
        
        if(head == null)
            return null;
        
        if(head == tail) {
            node temp;
            temp = head;
            
            head = tail = null;
            return temp;
        }   
        else {
            
            node temp;
            temp = head;
            head = head.next;
            return temp;
        }       
    }
    
    public void display(node item) {
        
        while(item!= null) {
            
            System.out.println(item.value);
            item = item.next;
        }
    }
    public static void main(String[] args) {
        
        queue q = new queue();
        
        node n = new node(1);
        q.enqueue(n);
        
        node n1 = new node(2);
        q.enqueue(n1);
        
        node n2 = new node(3);
        q.enqueue(n2);
        
        node n3 = new node(4);
        q.enqueue(n3);
        
        node n4 = new node(5);
        q.enqueue(n4);
        
        node n5 = new node(6);
        q.enqueue(n5);
        
        node n6 = new node(7);
        q.enqueue(n6);
        
        q.display(n);
        
        node n7 = q.dequeue(n5);
        System.out.println(n7.value);
    }
}
