/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class List {
    
    public static ListNode head = null;    
    public static ListNode1 head1 = null;
    public static ListNode2 head2 = null;
    int size = 0;
    
    public void addNode(ListNode node) {
        
        ListNode current;
        current = head;
        
        if(head == null) {
            head = node;
            current = head;
        }
        
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.next = null;
        }
    }
    
        public void addNode(ListNode1 node) {
        
        ListNode1 current;
        current = head1;
        
        if(head1 == null) {
            head1 = node;
            current = head1;
        }
        
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.next = null;
        }
    }
        
       public void addNode(ListNode2 node) {
        
        ListNode2 current;
        current = head2;
        
        if(head2 == null) {
            head2 = node;
            current = head2;
        }
        
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.next = null;
        }
    }
    
    public void deleteDups(ListNode node) {     //**********DELETING DUPLICATE NODES FROM 
                                                //**********A LINKED LIST USING  2 POINTERS
        ListNode current = node;        
        
        while(current != null) {
            
            ListNode runner = current;
            
            while(runner.next != null) {
                
                if(runner.next.value == current.value) {
                    runner.next = runner.next.next;
                }
                else
                    runner = runner.next;
            }
            
            current = current.next;
        }
    }
    
    public void deleteNth(int n) {              //**********FINDS Nth NODE FROM THE END AND DELETES IT
        
        ListNode p1 = head, p2 = head;
        
        for(int i=0; i<n-1;i++) {
            p2 = p2.next;
        }
        
        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
     //   System.out.println(p1.value);
        ListNode temp = p1.next.next;
        p1.value=p1.next.value;
        p1.next.next=null;
        p1.next=temp;
                        
        
    }    
    
    public void addTwoLL(ListNode node, ListNode1 node1) {        //ADDS 2 LLs AND SHOWS THE RESULT IN ANOTHER LL
        
        ListNode current = node;
        ListNode1 current1 = node1;
        
        int carry = 0;                          //*************PLACE THE CARRY PROPERLY
        
        while(current != null || current1 != null) {
            
            int sum;
            if(current == null) 
                sum = current1.value + carry;
            
            else if(current1 == null)
                sum = current.value + carry;
            
            else 
                sum = current.value + current1.value;
            int value1 = 0;
            if(sum > 9) {
                                
                value1= sum % 10 + carry;
                ListNode2 node2= new ListNode2(value1);
                addNode(node2);
                carry = sum / 10;                
            }
            
            else {
                value1 = sum + carry; 
                    if(value1 > 9) {
                                               
                        int value2= sum % 10 + carry;
                        ListNode2 node2= new ListNode2(value2);
                        addNode(node2);
                        carry = value1 / 10;                
                    }
                    else {
                        ListNode2 node2= new ListNode2(value1);
                        addNode(node2);
                    }
            }   
                    current = current.next;
                    
                    if(current1 != null)
                        current1 = current1.next;
        }
    }
    
    public void makeLoop(ListNode node) {
        
        ListNode current = node;
        ListNode loopBegin;
        current = current.next;
        loopBegin = current;
        
        while(current.next != null) {
            current = current.next;
        }
        current.next = loopBegin;
    }
    
    public void findLoop(ListNode node) {
        
        ListNode p1, p2;
        p1 = p2 = node;
        p1 = p1.next;
        p2 = p2.next.next;
        
        while(p1 != p2) {
            
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        p1 = node;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        System.out.println("The node where loop began is" + p1.value);
    }
    
    public void display(ListNode node) {
                
        if(node != null) {
            
            System.out.print(node.value + "-->");
            display(node.next);
        }
    }
    
    public void display(ListNode1 node) {
                
        if(node != null) {
            
            System.out.print(node.value + "-->");
            display(node.next);
        }
    }
    
    public void display(ListNode2 node) {
                
        if(node != null) {
            
            System.out.print(node.value + "-->");
            display(node.next);
        }
    }
    public static void main(String[] args) {
        
        List l = new List();
        
        int[] a = {3,1,5,4};
        int[] b = {5,9,2};
        
        for(int i=0; i<a.length; i++) {
            
            ListNode node = new ListNode(a[i]);
            l.addNode(node);
        }
        
        l.display(head);
        
        List q = new List();
        for(int i=0; i<b.length; i++) {
            
            ListNode1 node = new ListNode1(b[i]);
            q.addNode(node);
        }
        
        System.out.println();
        q.display(head1);
        
//        q.addTwoLL(head, head1);
//        
//        List w = new List();
//        w.display(head2);
        
        l.makeLoop(head);
        l.findLoop(head);
        
//        l.deleteDups(head);
//        
//        System.out.println();
//        l.display(head);
        
//        int n=3;
//        l.deleteNth(n);
//        System.out.println();
//        l.display(head);
    }
}
