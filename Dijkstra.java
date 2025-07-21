
package graph;

import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> findShortestPaths(WeightedGraph graph, String start) {
        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (String vertex : graph.getVertices()) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            String u = pq.poll().getKey();
            for (WeightedGraph.Edge edge : graph.getNeighbors(u)) {
                int alt = dist.get(u) + edge.weight;
                if (alt < dist.get(edge.to)) {
                    dist.put(edge.to, alt);
                    pq.add(new AbstractMap.SimpleEntry<>(edge.to, alt));
                }
            }
        }

        return dist;
    }
}
