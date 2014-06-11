package cc4102.convexhull;

import cc4102.util.TSPPoint;

import java.util.ArrayList;


public interface ConvexHullAlgorithm {
    ArrayList<TSPPoint> execute(ArrayList<TSPPoint> points);
}

