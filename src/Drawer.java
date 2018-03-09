import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by dmitry on 10.03.2018.
 */


public class Drawer {
    private Color[] colors = new Color[] {Color.black, Color.red, Color.green, Color.blue, Color.yellow, Color.magenta, Color.pink, Color.darkGray, Color.orange};

    public void paint(Graphics g, Point point, int i) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(colors[i]);
        g2.draw(new Ellipse2D.Double(point.x, point.y, 3, 3));

    }

    public void paintCentroid(Graphics g, Point point) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(colors[0]);
        Ellipse2D circle = new Ellipse2D.Double(point.x, point.y, 7, 7);
        g2.draw(circle);
        g2.fill(circle);

    }

}
