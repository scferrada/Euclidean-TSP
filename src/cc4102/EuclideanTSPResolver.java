package cc4102;

import cc4102.util.hamiltonian.HamiltonianCircuit;
import cc4102.util.TSPPoint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EuclideanTSPResolver {

    public HamiltonianCircuit resolveTSP(List<TSPPoint> points);

}
