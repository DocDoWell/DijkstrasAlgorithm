package main;

import algorithms.Dijkstras;
import graph.Edge;
import graph.Vertex;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args){
        //vertices
        Map<String, Vertex> graph =  makeGraph();
        Vertex source = graph.get("a");
        Vertex target = graph.get("g");

        //algorithm
        Dijkstras dijkstras = new Dijkstras();
        dijkstras.computePath(source);

        //shortest path
        System.out.println(dijkstras.getShortestPath(target));
    }

    static Map<String, Vertex> makeGraph(){
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
