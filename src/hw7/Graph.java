package hw7;

public interface Graph {

    void addVertex(String label, int number);

    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

}