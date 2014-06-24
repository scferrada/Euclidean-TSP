package cc4102.kdtree.tree;

import cc4102.util.TSPPoint;

/**
 * Created with IntelliJ IDEA.
 * User: Claud
 * Date: 20-05-14
 * Time: 02:01 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class KDNode {


    protected KDInternalNode parent;

    public KDNode getParent(){
        return parent;
    }

    public abstract KDLeaf searchNeighbor(TSPPoint q);


    public abstract double distance(TSPPoint q);

    public abstract KDLeaf anotherSearch(KDNode currentBest, double currentDistance, TSPPoint q);

    public abstract boolean intersects(TSPPoint q, double currentDistance);

    public abstract int height();

    public abstract int usedSpace();
}
