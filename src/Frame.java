/**
 * Created by dmitry on 09.03.2018.
 */

import javax.swing.JFrame;
public class Frame extends JFrame {
    public Panel panel = new Panel();

    public Frame() {

        setTitle("Visualization");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        add(panel);
    }
}
