package main;

import algorithms.BellmanFord;
import algorithms.Dijkstras;
import graph.Edge;
import graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args){
        System.out.println("Dijkstras Algorithm");
        Map<String, Vertex> dijkstraGraph =  makeDijstrasGraph();
        Vertex source = dijkstraGraph.get("a");
        Vertex target = dijkstraGraph.get("g");
        Dijkstras dijkstras = new Dijkstras();
        long startDijkstra = System.currentTimeMillis();
        dijkstras.computePath(source);
        System.out.println("Dijkstra shortest path: "+dijkstras.getShortestPath(target));
        long finishDijkstra = System.currentTimeMillis();
        long elapsedDijkstra = finishDijkstra-startDijkstra;
        System.out.println("Dijkstra Alg took "+ elapsedDijkstra +"ms to complete.");
        System.out.println(" ");
        System.out.println("--------------------------------");
        System.out.println(" ");

        System.out.println("Bellman-Ford Algorithm");
        BellmanFord bellmanFord = makeBellmanFord();
        long startBell = System.currentTimeMillis();
        bellmanFord.run(bellmanFord.getVertexList().get(0));
        System.out.println("BellmanFord shortest path: "+bellmanFord.getShortestPathTo(bellmanFord.getVertexList().get(6)));
        long finishBell = System.currentTimeMillis();
        long elapsedBell= finishBell-startBell;
        System.out.println("Bellman Alg took "+ elapsedBell +"ms to complete.");
        System.out.println(" ");
        System.out.println("--------------------------------");
        System.out.println(" ");
    }

    static BellmanFord makeBellmanFord() {
        List<Vertex> vetices = new ArrayList();
        List<Edge> edges = new ArrayList();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        vetices.add(a);
        vetices.add(b);
        vetices.add(c);
        vetices.add(d);
        vetices.add(e);
        vetices.add(f);
        vetices.add(g);
        vetices.add(h);

        edges.add(new Edge(5,a,b));
        edges.add(new Edge(9,a,e));
        edges.add(new Edge(8,a,h));
        edges.add(new Edge(12,b,c));
        edges.add(new Edge(15,b,d));
        edges.add(new Edge(4,b,h));
        edges.add(new Edge(3,c,d));
        edges.add(new Edge(11,c,g));
        edges.add(new Edge(9,d,g));
        edges.add(new Edge(4,e,f));
        edges.add(new Edge(20,e,g));
        edges.add(new Edge(5,e,h));
        edges.add(new Edge(1,f,c));
        edges.add(new Edge(13,f,g));
        edges.add(new Edge(7,h,c));
        edges.add(new Edge(6,h,f));

        return new BellmanFord(vetices,edges);
    }

    static Map<String, Vertex> makeDijstrasGraph(){
        Map<String, Vertex> output = new HashMap<>();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        //edges
        a.addEdge(new Edge(5,a,b));
        a.addEdge(new Edge(9,a,e));
        a.addEdge(new Edge(8,a,h));

        b.addEdge(new Edge(12,b,c));
        b.addEdge(new Edge(15,b,d));
        b.addEdge(new Edge(4,b,h));

        c.addEdge(new Edge(3,c,d));
        c.addEdge(new Edge(11,c,g));

        d.addEdge(new Edge(9,d,g));

        e.addEdge(new Edge(4,e,f));
        e.addEdge(new Edge(20,e,g));
        e.addEdge(new Edge(5,e,h));

        f.addEdge(new Edge(1,f,c));
        f.addEdge(new Edge(13,f,g));

        h.addEdge(new Edge(7,h,c));
        h.addEdge(new Edge(6,h,f));

        output.put("a",a);
        output.put("b",b);
        output.put("c",c);
        output.put("d",d);
        output.put("e",e);
        output.put("f",f);
        output.put("g",g);
        output.put("h",h);

        return output;
    }
}
