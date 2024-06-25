package algorithms;

import graph.Vertex;
import graph.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    //algorithm
    public void run(Vertex source){
        source.setDistance(0);

        //V-1 iterations (in WC longest path contains V vertices)
        for(int i=0;i<vertexList.size()-1;i++){
            //Relaxation
            for(Edge edge: edgeList){
                Vertex start = edge.getStart();
                Vertex target = edge.getTarget();
                if(start.getDistance()+edge.getWeight() < target.getDistance()){
                    target.setDistance(start.getDistance()+edge.getWeight());
                    target.setPreviousVertextOnShortestPath(start);
                }
            }
        }
        //one more relaxation for negative cycles
        for(Edge edge: edgeList){
            if(edge.getStart().getDistance() != Double.MAX_VALUE){
                if(hasCycle(edge)){
                    System.out.println("There is a negative cycle!!!");
                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge edge){
        return edge.getStart().getDistance() + edge.getWeight() < edge.getTarget().getDistance();
    }

    public List<Vertex> getShortestPathTo(Vertex target){
        if(target.getDistance() == Double.MAX_VALUE){
            System.out.println("There is no path from start to "+ target.getName());
            return new ArrayList<>();
        }

        List<Vertex> path = new ArrayList<>();

        while(target != null){
            path.add(target);
            target = target.getPreviousVertextOnShortestPath();
        }

        Collections.sort(path);
        return path;
    }

}
