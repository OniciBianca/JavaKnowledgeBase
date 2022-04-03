
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Vapor {

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        Random r = new Random();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new FlowLayout());
        frame.setContentPane(panel);
        frame.setBackground(Color.white);
        frame.pack();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        while (true) {
            Thread.sleep(5000);
            robot.mouseMove(r.nextInt(1000), r.nextInt(500));
            frame.revalidate();
            frame.repaint();
        }
    }
}
