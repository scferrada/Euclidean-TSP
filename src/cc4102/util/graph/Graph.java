package cc4102.util.graph;


import cc4102.util.TSPPoint;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {
    private List<Vertex> vertexes;
    private double[][] adjacency;

    public void addVertex(Vertex v){
        vertexes.add(v);
    }

    public void addVertex(TSPPoint p){
        vertexes.add(new Vertex(p));
    }

    public void addEdge(Vertex from, Vertex to){
        adjacency[vertexes.indexOf(from)][vertexes.indexOf(to)] =  from.getPoint().distance(to.getPoint());
    }

    public void addEdge(TSPPoint from, TSPPoint to) {
        adjacency[vertexes.indexOf(new Vertex(from))][vertexes.indexOf(new Vertex(to))] =  from.distance(to);
    }

    public static Graph makeCompleteGraphWith(List<TSPPoint> points) {
        Graph k = new Graph();
        for (TSPPoint i : points){
            k.addVertex(i);
            for(TSPPoint j : points){
                if(! i.equals(j)){
                    k.addEdge(i, j);
                }
            }
        }
        return k;
    }
}
