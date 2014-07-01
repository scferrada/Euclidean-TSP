package cc4102.util.hamiltonian;

import cc4102.util.TSPPoint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class HamiltonianCircuit {
    private HVertex start;
    private HVertex end;
    private TSPPoint first;

    public HamiltonianCircuit(TSPPoint tspPoint) {
        start = end = new HVertex(tspPoint);
    }

    public HamiltonianCircuit() {

    }

    public void appendVertex(HVertex v){
        if(start == null){
            start = end = v;
        }
        end.setNext(v);
        end = v;
        end.setNext(start);
    }

    public static HamiltonianCircuit constructWith(List<TSPPoint> points) {
        HamiltonianCircuit res = new HamiltonianCircuit();
        for(TSPPoint point : points){
           res.appendVertex(new HVertex(point));
        }
        return res;
    }

    public HVertex getMinimumDistanceModuleTo(TSPPoint p) {
        double min = Double.POSITIVE_INFINITY;
        HVertex minVertex = start;
        HVertex curr = start;
        while (curr != end){
            double distance = p.distance(curr.getPoint()) + p.distance(curr.next().getPoint()) - curr.getPoint().distance(curr.next().getPoint());
            if(distance < min){
                min = distance;
                minVertex = curr;
            }
            curr = curr.next();
        }
        return minVertex;
    }

    public void addPointAfter(TSPPoint p, HVertex v) {
        HVertex temp = v.next();
        HVertex toAdd = new HVertex(p);
        v.setNext(toAdd);
        toAdd.setNext(temp);
    }

    public int length() {
        int l = 0;
        HVertex curr = start;
        while(curr != end){
            l++;
            curr = curr.next();
        }
        return l+1;
    }

    public double distance() {
        double d = 0.0;
        HVertex curr = start;
        while(curr != end){
            d += curr.getPoint().distance(curr.next().getPoint());
            curr = curr.next();
        }
        return d + start.getPoint().distance(end.getPoint());
    }
    public HVertex calcMinDistance(TSPPoint p) {
        double min = Double.POSITIVE_INFINITY;
        HVertex minVertex = start;
        HVertex curr = start;
        while (curr != end){
            double distance = p.distance(curr.getPoint());
            if(distance < min){
                min = distance;
                minVertex = curr;
            }
            curr = curr.next();
        }
        return minVertex;
    }

    public HVertex getFirst() {
        return start;
    }
}
