package cc4102.kdtree;

import cc4102.EuclideanTSPResolver;
import cc4102.util.hamiltonian.HamiltonianCircuit;
import cc4102.util.TSPPoint;

import java.util.List;

public class ClosestNeighborResolver implements EuclideanTSPResolver{

    @Override
    public HamiltonianCircuit resolveTSP(List<TSPPoint> points) {
       // KDTree kdTree = KDTreeFactory.makeMedianTreeWith(points);
        HamiltonianCircuit C = new HamiltonianCircuit(points.get(0));

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}