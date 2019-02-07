package DiGraph_A5;
import java.util.*;

public class DiGraph implements DiGraphInterface {


	private Map<String, Long> vertices; // vertex {key: label; value: vertex id} 
	private Map<String, Map<String, Long[]>> edges; // edge {key: source vertex; value: destination vertices information}
	private Set<Long> vertexId;
	private Set<Long> edgeId;
	private long vertexNum;
	private long edgeNum;
	private Map<String, List<String>> graph; 
	
	public DiGraph() { // default constructor
		this.vertices = new HashMap<String, Long>();
		this.edges = new HashMap<String, Map<String, Long[]>>();
		this.vertexId = new HashSet<Long>();
		this.edgeId = new HashSet<Long>();
		this.vertexNum = 0; 
		this.edgeNum = 0;
		this.graph = new HashMap<String, List<String>>();
	}

	@Override
	public boolean addNode(long idNum, String label) {
		if (vertices.containsKey(label) || vertexId.contains(idNum) || 
				idNum < 0 || label == null) {
			return false;
		} else {
			// add vertex to vertex map and vertexId set
			vertices.put(label, idNum);
			vertexId.add(idNum);
			vertexNum++;

			// add vertex to graph
			graph.put(label, new ArrayList<String>());	
			
			// add source vertex into edges map 
			edges.put(label, new HashMap<String, Long[]>());
			return true;
		}
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		
        // returns false if source node is not in graph
        // returns false if destination node is not in graph
		// returns false if edge number is not unique or less than 0
		if (!vertices.containsKey(sLabel) || !vertices.containsKey(dLabel)
				|| edgeId.contains(idNum) || idNum < 0) {
			return false;
		}
		// return false: if there already is an edge between these 2 nodes
		if (graph.get(sLabel).contains(dLabel)) {
			return false;
		} else {
			// add destination to the graph
			graph.get(sLabel).add(dLabel);

			// add edge and destination info to edges map 
			edges.get(sLabel).put(dLabel, new Long[2]);
			edges.get(sLabel).get(dLabel)[0] = weight;
			edges.get(sLabel).get(dLabel)[1] = idNum;
			
			// add the edge id to the edgeId set
			edgeId.add(idNum);
			
			// increase the edge number
			edgeNum++;
			return true;
		}
		
	}

	@Override
	public boolean delNode(String label) {
		// return false if the vertex doesn't exist
		if (!vertices.containsKey(label)) return false;
		
		// delete edges in the graph
		// Step1: delete edges that the label is the source
		graph.remove(label);
		// Step2: delete edges that the label is the destination
		for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
			if(entry.getValue().remove(label)) {
				// decrease the edge number if remove the element successfully
				edgeNum--;
			}			 
		}
		
		// delete edges in edge map
		// Step1: delete edges that the label is the source
		edges.remove(label);
		// Step2: delete edges that the label is the destination
		for (Map.Entry<String, Map<String, Long[]>> entry : edges.entrySet()) {
			if (entry.getValue().containsKey(label)) {
				// remove edgeId in edgeId set
				edgeId.remove(entry.getValue().get(label)[1]);
				// remove the label
				entry.getValue().remove(label);
			}
		}
		
		// delete vertex in vertices map and vertex set
		vertexId.remove(vertices.get(label));
		vertices.remove(label);
		
		// decrease the vertex number
		vertexNum--;
		return true;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		// return false if any of the input doens't exist or
		if (!graph.containsKey(sLabel) || !graph.containsKey(dLabel)) return false;
		
		// delete edge in the graph
		// return false if the edge doesn't exist
		if (!graph.get(sLabel).remove(dLabel)) {
			return false;
		} else {
			// delete edge in the edgeId set
			edgeId.remove(edges.get(sLabel).get(dLabel)[1]);
			
			// delete edge in the edges map
			edges.get(sLabel).remove(dLabel);
			
			// decrease the edge number
			edgeNum--;
			return true;
		}
	}

	@Override
	public long numNodes() {
		return this.vertexNum;
	}

	@Override
	public long numEdges() {
		return this.edgeNum;
	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		// TODO Auto-generated method stub
		ShortestPathInfo[] dijkstraDistances = new ShortestPathInfo[vertices.size()];
		Map<String, Long> distances = new HashMap<String, Long>();
		Set<Long> tempId = new HashSet<Long>();
		tempId.addAll(vertexId);
		int index = 0;
		// new comparator to compare different vertices based on their weight to start vertex
		Queue<String> heap = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String destination1, String destination2) {
				long distance1 = distances.get(destination1);
				long distance2 = distances.get(destination2); 
				return (int) (distance1 - distance2);
			}});
		heap.offer(label);
		distances.put(label, (long)0);
		while (!heap.isEmpty()) {
			String curVertex = heap.peek();
			long id = vertices.get(curVertex);
			long distance = distances.get(curVertex);
			heap.poll();
			// if the node is known(id is deleted from tempId), continue to next loop
			// otherwise, mark it as known(delete from tempId)
			if (!tempId.contains(id)) continue;
			tempId.remove(id);
			
			dijkstraDistances[index++] = new ShortestPathInfo(curVertex, distances.get(curVertex));
			// iterate vertices adjacent to the minimum element in the heap
			for (Map.Entry<String, Long[]> entry : edges.get(curVertex).entrySet()) {
				// for each vertex not known yet
				if (tempId.contains(vertices.get(entry.getKey()))) {
					if (distances.get(entry.getKey()) == null || 
							distances.get(entry.getKey()) > distance + entry.getValue()[0]) {
						distances.put(entry.getKey(), distance + entry.getValue()[0]);
						heap.offer(entry.getKey());
					}					
				}
			}
		}
		// if there are some vertices that label vertex cannot access, set distance as -1
		if (!tempId.isEmpty()) {
			for (Map.Entry<String, Long> entry : vertices.entrySet()) {
				if (tempId.contains(entry.getValue())) {
					dijkstraDistances[index++] = new ShortestPathInfo(entry.getKey(), -1);
				}
			}
		}
		return dijkstraDistances;
	}

	// rest of your code to implement the various operations
	
}
