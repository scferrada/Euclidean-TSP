package cc4102.kdtree.tree;
import cc4102.util.TSPPoint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 02-06-14
 * Time: 09:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class KDTreeFactory {
    public static KDTree makeMedianTreeWith(List<TSPPoint> points) {
        return new KDMedianTree(new KDMedianTree().constructKdtree(points, Axis.X));
    }
}
