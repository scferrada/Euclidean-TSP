package cc4102.util.graph;

import cc4102.util.TSPPoint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vertex {
    private TSPPoint point;

    public Vertex(TSPPoint p) {
        point = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Vertex vertex = (Vertex) o;
        if (point != null ? !point.equals(vertex.point) : vertex.point != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return point != null ? point.hashCode() : 0;
    }

    public TSPPoint getPoint() {
        return point;
    }
}
