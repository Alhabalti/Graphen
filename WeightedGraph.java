
package graph;

import java.util.*;

public class WeightedGraph {
    private final Map<String, List<Edge>> adjList = new HashMap<>();

    public void addVertex(String id) {
        adjList.putIfAbsent(id, new LinkedList<>());
    }

    public void addEdge(String from, String to, int weight) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).add(new Edge(to, weight));
    }

    public List<Edge> getNeighbors(String vertex) {
        return adjList.getOrDefault(vertex, new LinkedList<>());
    }

    public int getWeight(String from, String to) {
        return adjList.getOrDefault(from, new LinkedList<>())
                      .stream()
                      .filter(edge -> edge.to.equals(to))
                      .map(edge -> edge.weight)
                      .findFirst()
                      .orElse(Integer.MAX_VALUE);
    }

    public Set<String> getVertices() {
        return adjList.keySet();
    }

    public static class Edge {
        String to;
        int weight;
        public Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
