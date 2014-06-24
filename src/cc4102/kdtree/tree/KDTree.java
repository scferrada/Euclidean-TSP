package cc4102.kdtree.tree;
import cc4102.util.TSPPoint;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 20-05-14
 * Time: 01:40 PM
 * To change this template use File | Settings | File Templates.
 */

public abstract class KDTree {
    KDNode root;

    protected KDTree(){}

    protected KDTree(KDNode root) {
        this.root = root;
    }

    public KDNode constructKdtree(List<TSPPoint> points, Axis axis){
        if(points.size() == 1 ){
            return new KDLeaf(points.get(0));
        }
        KDLine line = getLine(points, axis) ;
        List<List<TSPPoint>> partition = makePartition(points,line);

        return new KDInternalNode(line,
                                  constructKdtree(partition.get(0),axis.negated()),
                                  constructKdtree(partition.get(1),axis.negated()));

    }

    public int height(){
        return root.height();
    }

    public int usedSpace(){
        return root.usedSpace();
    }

    protected List<List<TSPPoint>> makePartition(List<TSPPoint> points, KDLine line) {
        List<TSPPoint> low = new LinkedList<TSPPoint>();
        List<TSPPoint> high = new LinkedList<TSPPoint>();

        for(TSPPoint p: points){
            // point in line is considered "low"
            if(p.getCoord(line.getAxis()) <= line.getPos() )
                low.add(p);
            else
                high.add(p);
        }
        List<List<TSPPoint>> part = new LinkedList<List<TSPPoint>>();
        part.add(low);
        part.add(high);
        return part;
    }

    protected abstract KDLine getLine(List<TSPPoint> points, Axis axis);

    public TSPPoint closestNeighbor(TSPPoint q){

        KDLeaf currentBest = root.searchNeighbor(q);
        double currentDistance = currentBest.distance(q);

        KDNode actual = currentBest.getParent();
        KDNode prev = currentBest;

        while(actual!= null){
            KDLeaf temp = actual.anotherSearch(prev, currentDistance,q);
            if(temp.distance(q)<currentDistance){
                currentBest = temp;
                currentDistance = currentBest.distance(q);
            }
            prev = actual;
            actual = actual.getParent();
        }
        return currentBest.getPoint();
    }

    public KDNode getRoot() {
        return root;
    }
}
