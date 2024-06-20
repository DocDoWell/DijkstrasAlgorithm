package algorithms;

import graph.Edge;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras {

    public void computePath(Vertex source){
       //instantiate
        source.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue(); //heap
        queue.add(source);

        while(!queue.isEmpty()){
            Vertex actual = queue.poll();
            System.out.println("actual is " + actual.getName());
            for(Edge edge : actual.getAdjacencyEdges()){
                Vertex v = edge.getTarget();
                double d = actual.getDistance() + edge.getWeight();
                if(d < v.getDistance()){
                    queue.remove(v);//O(n) - quite costly to remove as it is not fibonacci heap. O(vlogv would be better)
                    v.setDistance(d);
                    v.setPreviousVertextOnShortestPath(actual);
                    queue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPath(Vertex vertex){
        List<Vertex> path = new ArrayList<>();

        while(vertex != null){
            path.add(vertex);
            vertex = vertex.getPreviousVertextOnShortestPath();
        }

        Collections.sort(path);
        return path;
    }
}
