
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srikant
 */
public class Graph {
    
    LinkedList<Node1> [] adj;
    int nodes;
    boolean[] visited;
    public static Node1 first = null;    
    queue q;
    stack s;
    Node1 child = null;
    
    public Graph(int nodes) {
        
        this.nodes = nodes;
        adj = new LinkedList [nodes+1];
        
        for(int i =1; i<=nodes;i++) {
            adj[i] = new LinkedList<Node1>();
        }
        
    }
    
    public void addEdge(Node1 from, Node1 to) {
        
        adj[from.value].add(to);
    }
    
//    public void BFS() {
//        
//        q = new queue();
//        visited = new boolean[nodes+1];
//        
//        q.enqueue(first);
//        visited[first.value] = true;
//        
//        while(q.head != null) {
//            
//            node current = q.dequeue(first);
//            System.out.println("Current --------->" + current.value);
//            
//            ListIterator it = adj[current.value].listIterator();
//            while(it.hasNext()) {
//                
//                node x;
//                x = (node)it.next();
//                
//                if(visited[x.value] ==false) {
//                    q.enqueue(x);
//                    visited[x.value] = true;
//                }
//            }
//        }
//    }
    
    public void DFS() {
        
        s = new stack();
        visited = new boolean[nodes+1];
        
        s.push(first);
        visited[first.value] = true;
        System.out.println("------> "+ first.value);
        
        while(s.head != null) {
            
            Node1 current = s.head;
            visited[current.value] = true;
                        
            child = getUnivisitedChild(current.value);
            
            if(child == null) {
                s.pop(s.head);
            }
            else {
                //s.push(child);
                System.out.println("-----> " + child.value);
            }
            
        }
    }
    
    public Node1 getUnivisitedChild(int y) {
    
        ListIterator it = adj[y].listIterator();
        
        while(it.hasNext()) {
            
            Node1 x = (Node1) it.next();
            if(visited[x.value] == false) {
                
                s.push(x);
                return x;
            }            
        }
        return null;
    }
    
    public static void main(String[] args) {
        
        Graph g = new Graph(7);
        
        first = new Node1(1);
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
        
        System.out.println("--------DFS--------");
        g.DFS();
        
    }
}
