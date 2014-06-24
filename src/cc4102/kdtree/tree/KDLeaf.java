package cc4102.kdtree.tree;

import cc4102.util.TSPPoint;

/**
 * Created with IntelliJ IDEA.
 * User: Claud
 * Date: 20-05-14
 * Time: 02:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class KDLeaf extends KDNode {

    protected TSPPoint point;

    public KDLeaf(TSPPoint point) {
        this.point = point;
    }

    @Override
    public KDLeaf searchNeighbor(TSPPoint q) {

        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double distance(TSPPoint q) {
        return point.distance(q);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KDLeaf anotherSearch(KDNode currentBest, double currentDistance, TSPPoint q){
        if( point.distance(q)<currentDistance){
            return this;
        }
        return new KDNullNode(null);
    }

    @Override
    public boolean intersects(TSPPoint q, double currentDistance) {
        return point.distance(q)<=currentDistance;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int height() {
        return 1;
    }

    @Override
    public int usedSpace() {
        return 32;
    }


    public TSPPoint getPoint() {
        return point;
    }
}
