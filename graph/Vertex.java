package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private List<Edge> adjacencyEdges;
    private double distance;
    private Vertex previousVertextOnShortestPath;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyEdges = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getAdjacencyEdges() {
        return adjacencyEdges;
    }

    public void addEdge(Edge edge) {
        this.adjacencyEdges.add(edge);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPreviousVertextOnShortestPath() {
        return previousVertextOnShortestPath;
    }

    public void setPreviousVertextOnShortestPath(Vertex previousVertextOnShortestPath) {
        this.previousVertextOnShortestPath = previousVertextOnShortestPath;
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.getDistance());
    }

    @Override
    public String toString() {
        return name +" - "+ (int) distance;
    }
}
