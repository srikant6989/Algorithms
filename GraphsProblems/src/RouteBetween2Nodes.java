
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class RouteBetween2Nodes {
    
    
    static boolean[] visited;
    static Node1 child = null;
    LinkedList<Node1> [] adj;
    int nodes;
    Stack s;
    
    public RouteBetween2Nodes(int nodes) {
        
        this.nodes = nodes;
        adj = new LinkedList [nodes+1];
        
        for(int i =1; i<=nodes;i++) {
            adj[i] = new LinkedList<Node1>();
        }
    }
    
    public void addEdge(Node1 from, Node1 to) {
        
        adj[from.value].add(to);
    }
    
    public boolean checkRouteExistsOrNot(Node1 start1, Node1 end1) {
                
        s = new Stack();
        visited = new boolean[nodes+1];
        s.add(start1);   
        
        visited[start1.value]  = true;                                    
        Node1 current;
        
        Node1 u;
        while(! s.isEmpty()) {
            
            current = (Node1)s.peek();            
                
            child = getUnviNodes(current.value);
            
            if(child == null)
                s.pop();
            
            else {
                
                if(child == end1)
                    return true;
            }                
        }
        return false;
    }
    
    public Node1 getUnviNodes(int x) {
        
        ListIterator it = adj[x].listIterator();
        
        while(it.hasNext()) {
            
            Node1 y = (Node1) it.next();
            
            if(! visited[y.value]) {
            
                s.add(y);
                visited[y.value] = true;
                return y;
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        
        RouteBetween2Nodes g = new RouteBetween2Nodes(7);
        
        Node1 first = new Node1(1);
        Node1 n1 = new Node1(2);
        Node1 n2 = new Node1(3);
        Node1 n3 = new Node1(4);
        Node1 n4 = new Node1(5);
        Node1 n5 = new Node1(6);
        Node1 n6 = new Node1(7);
        
//        g.addEdge(first,n1);
//	g.addEdge(n1,first);
//	g.addEdge(first,n2);
//	g.addEdge(n2,first);
//	g.addEdge(n3,n1);
//	g.addEdge(n1,n3);
//	g.addEdge(n1,n4);
//	g.addEdge(n4,n1);
//	g.addEdge(n2,n3);
//	g.addEdge(n3,n2);
//	g.addEdge(n2,n6);
//	g.addEdge(n6,n2);
//	g.addEdge(n5,n4);
//	g.addEdge(n4,n5);
//	g.addEdge(n6,n5);
//	g.addEdge(n5,n6);
//	g.addEdge(n3,n6);
//	g.addEdge(n6,n3);
        
        g.addEdge(first, n1);
        g.addEdge(n1, n2);
        g.addEdge(n2, n3);
        g.addEdge(first, n4);
        g.addEdge(n6, n5);
        
        if(g.checkRouteExistsOrNot(first, n5))
            System.out.println("There is route between the two nodes");
        
        else
            System.out.println("There is no route between the two nodes");
    }
    
}
