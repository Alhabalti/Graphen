package graph;

import graph.GraphReader;
import graph.WeightedGraph;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class GraphReaderTest {

    @Test
    void testReadFromFile() throws IOException {
        // Arrange: create a temporary file with graph data
        File tempFile = File.createTempFile("graph", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("A B,2 C,3");
            writer.println("B C,1");
        }

        // Act
        WeightedGraph graph = GraphReader.readFromFile(tempFile.getAbsolutePath());

        // Assert: check edges
        assertTrue(graph.hasEdge("A", "B"));
        assertTrue(graph.hasEdge("A", "C"));
        assertTrue(graph.hasEdge("B", "C"));
        assertEquals(2, graph.getWeight("A", "B"));
        assertEquals(3, graph.getWeight("A", "C"));
        assertEquals(1, graph.getWeight("B", "C"));

        // Clean up
        tempFile.delete();
    }
}