package hw7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMatrix;
    private int[][] adjMatrixNumber;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
        this.adjMatrixNumber = new int[maxVertexCount][maxVertexCount];
    }


    @Override
    public void addVertex(String label, int number) {
        vertexList.add(new Vertex(label, number, false));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true;
        return false;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }


    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
      /*  int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        resetVertexVisited();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();*/

    }

    private Vertex getNearVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        //System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
      //  System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }


    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        resetVertexVisited();
        Vertex vertex = vertexList.get(startIndex);



        for (int k = 0; k < adjMatrixNumber.length; k++) {
            for (int l = 0; l < adjMatrixNumber.length; l++) {
                if (adjMatrix[k][l]) {
                    adjMatrixNumber[k][l] = vertexList.get(k).getNumber();
                }
            }
        }

        int i = indexOf(vertex.getLabel());
        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {

            vertex = getNearVertex(queue.peek());

            if (vertex != null) {

                visitVertex(queue, vertex);
                sumLength(i);
                i = indexOf(vertex.getLabel());
                adjMatrixNumber[0][0] =0;
                System.out.println(vertex.getLabel());
                print();

            }else {
                queue.remove();
            }
         /*       if (j == vertexList.size() - 1) {
                    if (result != 0) {
                        if (resultNew < result) {
                            result = resultNew;
                        }
                    } else {
                        result = adjMatrixNumber[i][j - 1];
                    }
                }*/
             /*else {
                queue.remove();
            }*/
        }
       min();
        System.out.println();
    }

    public void sumLength(int i) {
        boolean flag = false;
        for (int j = 0; j < adjMatrixNumber.length; j++) {
            if (adjMatrixNumber[i][j] != 0) {
                for (int k = 0; k < adjMatrixNumber.length; k++) {
                    if (adjMatrixNumber[j][k] != 0 &&  !vertexList.get(j).isWereSum()) {
                        adjMatrixNumber[j][k] += adjMatrixNumber[i][j];
                        flag = true;
                    }else  if (adjMatrixNumber[j][k] != 0 &&  vertexList.get(j).isWereSum()){
                        if ( adjMatrixNumber[i][j] +  vertexList.get(j).getNumber() < adjMatrixNumber[j][k] ){
                            adjMatrixNumber[j][k] =  adjMatrixNumber[i][j] +  vertexList.get(j).getNumber();
                        }
                    }
                }
                if ( flag){
                    vertexList.get(j).setWereSum(true);
                }
            }
        }
    }

    public void min() {
        int min = 100000;
        for (int i = 0; i < adjMatrixNumber.length; i++) {
            if (adjMatrixNumber[i][adjMatrixNumber.length - 1] != 0 && adjMatrixNumber[i][adjMatrixNumber.length - 1]< min ) {
                min = adjMatrixNumber[i][adjMatrixNumber.length - 1];
            }
        }
        System.out.println("мин длина = " + min);
    }

    public void print() {
        for (int i = 0; i < adjMatrixNumber.length; i++) {
            for (int j = 0; j < adjMatrixNumber.length; j++) {
                System.out.print(adjMatrixNumber[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

