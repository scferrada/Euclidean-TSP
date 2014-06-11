package cc4102.util.graph;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Edge {
    private Vertex to;
    private double weight;

    public Vertex to() {
        return to;
    }

    public double weight() {
        return weight;
    }
}
