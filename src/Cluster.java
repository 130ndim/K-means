/**
 * Created by dmitry on 28.02.2018.
 */
import java.util.ArrayList;

public class Cluster {
    public ArrayList<Point> points;
    private Point centroid;


    public Cluster(Point c) {
        centroid = c;
        points = new ArrayList<>();
    }

    public Point GetCentroid() {
        return centroid;
    }

    public int GetSize() {
        return points.size();
    }

    public void InsertPoint(Point point) {
        points.add(point);
    }

    public void ClearPoints() {
        points = new ArrayList<>();
    }

    public void CalculateCentroid() {
        double[] sum = new double[2];
        int count = 0;

        for(Point point : points) {
            sum[0] += point.x;
            sum[1] += point.y;
            count++;
        }

        centroid.x = sum[0] / count;
        centroid.y = sum[1] / count;

    }



}
