/**
 * Created by dmitry on 28.02.2018.
 */
public class Distance {

    public static double Euclidean(Point a, Point b) {
        return Math.sqrt(((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)));
    }

}
