/**
 * Created by dmitry on 28.02.2018.
 */
public class Distance {

    /**
     * Calculates and returns Euclidean distance between two points
     *
     * @param a Point 1 coordinates
     * @param b Point 2 coordinates
     * @return Distance between points
     */

    public static double Euclidean(Point a, Point b) {
        return Math.sqrt(((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)));
    }

}
