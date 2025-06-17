import java.util.*;
public class GraphStructure {
    private Map<String, List<String>> graph;

    public GraphStructure() {
        graph = new HashMap<>();

        graph.put("Entrance", Arrays.asList("Reptile House", "Bird Sanctuary", "Mammal Zone"));
        graph.put("Reptile House", Arrays.asList("Snake Pit"));
        graph.put("Bird Sanctuary", Arrays.asList("Parrot Pavilion"));
        graph.put("Mammal Zone", Arrays.asList("Lion Den", "Elephant Enclosure"));
        graph.put("Snake Pit", new ArrayList<>());
        graph.put("Parrot Pavilion", new ArrayList<>());
        graph.put("Lion Den", new ArrayList<>());
        graph.put("Elephant Enclosure", new ArrayList<>());
    }

    public void printGraph() {
        System.out.println("Zoo Zone Connections:");
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " connects to: " + entry.getValue());
        }
    }

    
    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        System.out.println("\nDFS Traversal starting from: " + start);
        dfsHelper(start, visited);
    }

    private void dfsHelper(String current, Set<String> visited) {
        if (visited.contains(current)) return;
        visited.add(current);
        System.out.println("Visited: " + current);
        for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            dfsHelper(neighbor, visited);
        }
    }
    public static void main(String[] args) {
        GraphStructure zooGraph = new GraphStructure();
        zooGraph.printGraph();
        zooGraph.dfs("Entrance");
    }
}