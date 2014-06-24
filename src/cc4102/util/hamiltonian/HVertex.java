package cc4102.util.hamiltonian;

import cc4102.util.TSPPoint;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class HVertex {
    private HVertex next;
    private TSPPoint point;

    public HVertex(TSPPoint tspPoint) {
        point = tspPoint;
    }

    public HVertex next() {
        return next;
    }

    public TSPPoint getPoint() {
        return point;
    }
}
