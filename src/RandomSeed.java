import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dmitry on 10.03.2018.
 */
public class RandomSeed {
    private final Random random = new Random();

    public ArrayList<Point> GetPoints(int k) {
        ArrayList<Point> points = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            points.add(new Point(600 * random.nextDouble(), 600 * random.nextDouble()));
        }
        return points;
    }

}
