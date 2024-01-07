import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for solving graph problems.
 *
 * @author Farhan Syed
 * @version 2022.02.21
 */
public class GraphAlgorithms {

    /**
    * Determines if a component has a cycle.
    *
    * @param g the graph to search
    * @param v the node to start at
    * @param visited boolean array keeping track of visited nodes
    * @param parent parent node of v
    * @return true if component has cycle, false otherwise
    */
    private static boolean DFS(Graph g, int v, boolean[] visited, int parent) {
        Iterator<Integer> neighborsIterator = g.neighbors(v);
        visited[v] = true;

        //If the vertex has neighbours, we will iterate through them
        while(neighborsIterator.hasNext()){
            int nextNeighbor = neighborsIterator.next();
            if(!visited[nextNeighbor]){                         //check if we have visited the neighbour
               if(DFS(g,nextNeighbor,visited,v)) return true;
            }
            else if(nextNeighbor != parent){
                return true;
            }
        }
        return false;
    }

    /**
    * Determine if there is a cycle in the graph. Implement using DFS.
    *
    * @param g the graph to search
    * @return true if there exists at least one cycle in the graph, false otherwise
    */
    public static boolean hasCycle(Graph g) {
        boolean[] visited = new boolean[g.numVertices()];
        //Going through each vertex
        for (int v = 0; v < g.numVertices(); v++) {
            if(!visited[v]) {
                if(DFS(g,v,visited,-1)) return true;     //we use a non-existent parent
            }
        }
        return false;
    }

    /**
    * Determine if there is a path between two vertices. Implement using
    * BFS.
    *
    * @param v vertex
    * @param w vertex
    * @param g the graph to search
    * @return true if there is a path between v and w, false otherwise
    */
    public static boolean hasPath(Graph g, int v, int w) {
        boolean[] visited = new boolean[g.numVertices()];
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);
        while(!q.isEmpty()){
            v = q.remove();
            Iterator<Integer> neighborsIterator = g.neighbors(v);
            while(neighborsIterator.hasNext()){
                int nextNeighbor = neighborsIterator.next();
                if(nextNeighbor == w) {
                    return true;
                }
                else if(!visited[nextNeighbor]){
                    visited[nextNeighbor] = true;
                    q.add(nextNeighbor);
                }
            }
        }
        return false;
    }
}
