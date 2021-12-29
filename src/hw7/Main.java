package hw7;

public class Main {
    public static void main(String[] args) {
//        testGraph();
//        testDfs();
        testBfs();
    }

/*    private static void testGraph() {

        Graph graph = new GraphImpl(7);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", "C");
        graph.addEdge("B", "C", "D");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "B", "C");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }*/

/*    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }*/

    private static void testBfs() {
        Graph graph = new GraphImpl(9);
        graph.addVertex("A",1);
        graph.addVertex("B",2);
        graph.addVertex("C",3);
        graph.addVertex("D",4);
        graph.addVertex("E",5);
        graph.addVertex("F",5);
        graph.addVertex("G",6);
        graph.addVertex("H",5);
        graph.addVertex("I",1);

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");
        graph.addEdge("H", "I");
        graph.addEdge("F", "I", "H");
        graph.addEdge("G", "I");

        graph.bfs("A");
    }
}


