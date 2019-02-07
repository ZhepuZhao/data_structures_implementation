package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
//      System.out.println(d.delEdge("f", "s"));
//      
//      d.addNode(1, "f");
//      d.addNode(3, "s");
//      System.out.println(d.addEdge(0, "f", "s", 1, null));
//      System.out.println(d.delEdge("f", "s"));
//      
//      System.out.println(d.delEdge("f", "s"));
//      
//      System.out.println(d.addEdge(0, "f", "s", 1, null));
//      System.out.println(d.delEdge("f","s"));
      
      d.addNode(1, "a");
      System.out.println(d.addNode(1, "a"));
      d.addNode(3, "b");
      d.addNode(7, "c");
      d.addEdge(0, "a", "b", 3, null);
      System.out.println(d.addEdge(34, "a", "a", 3, null));
      d.addEdge(1, "b", "c", 4, null);
      d.addEdge(2, "a", "c", 5, null);
//      d.addEdge(3, "fo", "fi", 0, null);
//      d.addEdge(4, "fi", "si", 0, null);
      ShortestPathInfo[] distance = d.shortestPath("a");
      for (ShortestPathInfo s : distance) {
    	  System.out.println(s.getDest() +" " + s.getTotalWeight());
      }
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
    }
    public static void printGraph(DiGraph graph) {
    	
    }
}
