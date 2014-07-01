package cc4102.app;

import cc4102.EuclideanTSPResolver;
import cc4102.convexhull.ConvexHullResolver;
import cc4102.parser.InputParser;
import cc4102.util.TSPPoint;
import cc4102.util.hamiltonian.HamiltonianCircuit;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 01-07-14
 * Time: 05:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class CHTest {
    static public void main(String[] args) throws IOException {
        EuclideanTSPResolver resolver = new ConvexHullResolver();
        List<TSPPoint> points = InputParser.parseFile("input/djibouti.txt");
        HamiltonianCircuit circuit = resolver.resolveTSP(points);
        System.out.println(circuit.length() + " circ, " + points.size() + " points");
        System.out.println("Total distance: "+circuit.distance());
    }
}
