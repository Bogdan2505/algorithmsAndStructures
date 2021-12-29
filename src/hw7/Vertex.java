package hw7;

import java.util.Objects;

public class Vertex {
    private final String label;
    private boolean isVisited;
    private int number;
    private boolean wereSum;

    public boolean isWereSum() {
        return wereSum;
    }

    public void setWereSum(boolean wereSum) {
        this.wereSum = wereSum;
    }

    public int getNumber() {
        return number;
    }


    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex(String label, int number, boolean wereSum) {
        this.label = label;
        this.number = number;
        this.wereSum = wereSum;
    }

    public String getLabel() {
        return label;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }
}

