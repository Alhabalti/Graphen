
package graph;

import java.io.*;
import java.util.*;

public class GraphReader {
    public static WeightedGraph readFromFile(String filename) throws IOException {
        WeightedGraph graph = new WeightedGraph();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String from = parts[0];
            for (int i = 1; i < parts.length; i++) {
                String[] targetWeight = parts[i].split(",");
                String to = targetWeight[0];
                int weight = Integer.parseInt(targetWeight[1]);
                graph.addEdge(from, to, weight);
            }
        }
        reader.close();
        return graph;
    }
}
