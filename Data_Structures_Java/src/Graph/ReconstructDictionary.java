package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructDictionary {

	public static void main(String[] args) {
		
		List<List<String>> tickets = new ArrayList<>();		
		
		List<String> l1 = new ArrayList<>();
		l1.add("JFK" );
		l1.add("KUL");
		tickets.add(l1);
		
		List<String> l2 = new ArrayList<>();
		l2.add("JFK" );
		l2.add("NRT");
		tickets.add(l2);
		
		List<String> l3 = new ArrayList<>();
		l3.add("NRT" );
		l3.add("JFK");
		tickets.add(l3);
		
		List<String> result = findItinerary(tickets);
		System.out.println(result);
		
	}

	  public static List<String> findItinerary(List<List<String>> tickets) {
	      
		    // Its not a topological sort because cycle might be present 
		        // We will Map<String,PriorityQueue<String>> to populate the graph(because we want to traverse in lexical order)
		      // We have to traverse each edge exactly once 
		     
		      // Reuslt data structure
		        List<String> result = new ArrayList<>();  
		        
		       // Check null condition 
		      if(tickets==null || tickets.size()==0)
		          return result;
		        
		        
		       Map<String,PriorityQueue<String>> graph = new HashMap<>(); 
		        
		      // Populate Graph  
		       
		      for(List<String> edge:tickets){
		          
		          String from = edge.get(0);
		          String to = edge.get(1);
		          
		          if(!graph.containsKey(from)){
		              graph.put(from,new PriorityQueue<String>());
		          }
		          graph.get(from).offer(to);
		          
		      }  
		       
		        
		    
		        Queue<String> bfs = new LinkedList<String>();
		        
		       bfs.offer("JFK");
		      
		        while(!bfs.isEmpty())
		    {
		        
		            String current = bfs.poll();
		            result.add(current);
		            PriorityQueue<String> pq = graph.get(current);
		          if(pq!=null)  
		          while(!pq.isEmpty()) {
		        	  String next = pq.poll();
		        	  bfs.offer(next);
		          }
		            
		            
		    }  
		        
		        
		      return result;  
		        
		    }
	
}
