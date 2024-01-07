import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author Farhan Syed
 * @version 2022.02.19
 */
public class Graph {
    /**
     * The map edges[v] contains the key-value pair (w, c) if there is an edge from
     * v to w; c is the cost assigned to this edge.
     */
    private final Map<Integer, Integer>[] edges;

    /** Number of edges in the graph. */
    private int numEdges;

    /** Number of vertices in the graph. */
    private int numVertices;

    /**
     * Constructs a HashGraph with n vertices and no edges. Time complexity: O(n)
     *
     * @throws IllegalArgumentException if n < 0
     */
    public Graph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n = " + n);

        // The array will contain only Map<Integer, Integer> instances created
        // in addEdge(). This is sufficient to ensure type safety.
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] a = new HashMap[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new HashMap<>();
        }
        numVertices = a.length;
        edges = a;
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.add(0,1,100);
        g.add(1,2,200);
        g.add(2,1,200);
        System.out.println(g);
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int numVertices() {
        return numVertices;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int numEdges() {
        return numEdges;
    }

    /**
    * Helper function that determines if v is a valid vertex in the graph.
    *
    * @param v vertex
    * @return boolean result for presence of vertex v
    */
    private boolean validEdge(int v) {
        return v >= 0 && v < edges.length;
    }

    /**
     * Returns the outdegree of vertex v.
     *
     * @param v vertex
     * @return the outdegree of vertex v
     * @throws IllegalArgumentException if v is out of range
     */
    public int degree(int v) throws IllegalArgumentException {
        if (!validEdge(v))
            throw new IllegalArgumentException();

        return edges[v].size();
    }

    /**
     * Returns an iterator of vertices adjacent to v.
     *
     * @param v vertex
     * @return an iterator of vertices adjacent to v
     * @throws IllegalArgumentException if v is out of range
     */
    public Iterator<Integer> neighbors(int v) {
        if (!validEdge(v))
            throw new IllegalArgumentException();

        return edges[v].keySet().iterator();
    }

    /**
     * Returns true if there is an edge (from, to).
     *
     * @param v vertex
     * @param w vertex
     * @return true if there is an edge (from, to).
     * @throws IllegalArgumentException if from or to are out of range
     */
    public boolean hasEdge(int v, int w) {
        if(!validEdge(v) || !validEdge(w))
            throw new IllegalArgumentException();
        else return edges[v].containsKey(w);
    }

    /**
     * Returns the edge cost if from and to are adjacent, otherwise -1.
     *
     * @param v vertex
     * @param w vertex
     * @return edge cost if available, -1 otherwise
     * @throws IllegalArgumentException if from or to are out of range
     */
    public int cost(int v, int w) throws IllegalArgumentException {
        if(!validEdge(v) || !validEdge(w))
            throw new IllegalArgumentException();
        else if(edges[v].get(w) != null){                   //edge with cost
            return edges[v].get(w);
        }
        return -1;                                      //edge without cost
    }

    /**
     * Inserts an edge with edge cost c.
     *
     * @param c edge cost, c >= 0
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if from or to are out of range
     */
    public void add(int v, int w, int c) {
        //Checks if vertices are in the graph
        if(!validEdge(v) || !validEdge(w))
            throw new IllegalArgumentException();
        //Create edge if there does not already exist one. Overwrite cost if edge already exists
        else if(!hasEdge(v,w)){
            numEdges++;             //only increased if new edge is created
        }
        edges[v].put(w,c);
        edges[w].put(v,c);
    }

    /**
     * Removes the edges between v and w.
     *
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if v or w are out of range
     */
    public void remove(int v, int w) {
        //Checks if vertex is in the graph
        if(!validEdge(v) || !validEdge(w))
            throw new IllegalArgumentException();
        else if(hasEdge(v,w)){
            edges[v].remove(w);
            edges[w].remove(v);
            numEdges--;
        }
    }

    /**
     * Returns a string representation of this graph.
     *
     * Should represent the graph in terms of edges (order does not matter). For
     * example, if a graph has edges (2,3,0) and (1,0,0), the
     * representaiton should be:
     *
     * "{(1,0,0), (2,3,0)}" or "{(2,3,0), (1,0,0)}"
     *
     * An empty graph is just braces:
     *
     * "{}"
     *
     * @return a String representation of this graph
     */
    @Override
    public String toString() {
        if(edges.length == 0) return "{}";
        StringBuilder graphString = new StringBuilder("{");
        boolean[][] added = new boolean[numVertices][numVertices];

        //Iterate through each vertex
        for (int v = 0; v < numVertices; v++) {
            //Iterate through each Key belonging to the vertex
            for (int w: edges[v].keySet()) {
                //Edge already printed -> go to next v vertex
                if(added[v][w] || added[w][v]){
                    break;
                }
                graphString.append("(" + v)             //adding "from" vertex v
                        .append("," )
                        .append(w)                      //adding "to" vertex
                        .append("," )
                        .append(edges[v].get(w))        //adding cost
                        .append(")" )
                        .append(", ");                  //comma separating edges
                added[v][w] = true;
            }
        }
        graphString.setLength(graphString.length() - 2);    //removing the extra comma at the end
        graphString.append("}");

        return graphString.toString();
    }
}
