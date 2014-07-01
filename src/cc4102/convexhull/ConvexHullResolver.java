package cc4102.convexhull;

import cc4102.EuclideanTSPResolver;
import cc4102.util.hamiltonian.HVertex;
import cc4102.util.hamiltonian.HamiltonianCircuit;
import cc4102.util.TSPPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvexHullResolver implements EuclideanTSPResolver {
    @Override
    public HamiltonianCircuit resolveTSP(List<TSPPoint> points) {
        ConvexHullAlgorithm algorithm = new FastConvexHull();
        List<TSPPoint> pre_circuit = algorithm.execute((ArrayList<TSPPoint>) points);
        HamiltonianCircuit circuit = HamiltonianCircuit.constructWith(pre_circuit);
        points.removeAll(pre_circuit);
        for(TSPPoint p : points){
            HVertex v = circuit.getMinimumDistanceModuleTo(p);
            TSPPoint pmin = getMinimumDistanceModuleFor(v, points);
            circuit.addPointAfter(pmin, v);
        }
        return circuit;
    }

    private TSPPoint getMinimumDistanceModuleFor(HVertex v, List<TSPPoint> points) {
        double min = Double.POSITIVE_INFINITY;
        TSPPoint minPoint = new TSPPoint();
        for(TSPPoint p : points){
            double distance = (p.distance(v.getPoint()) + p.distance(v.next().getPoint())) / v.getPoint().distance(v.next().getPoint());
            if(distance < min){
                min = distance;
                minPoint = p;
            }
        }
        return minPoint;
    }
}
