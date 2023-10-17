import java.awt.*;
import javax.swing.*;
public class JFrameTest extends JFrame {
    public static void main(String[] args) {
        System.setProperty("awt.toolkit", "sun.awt.X11.XToolkit");
        SwingUtilities.invokeLater(() -> {
            JFrameTest app = new JFrameTest();
        });
    }

    public JFrameTest() {
        super("test");
        setSize(2000, 500);
        // setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        JButton btnl = new JButton("philo was here");
        jp.add(btnl);
        add(jp, BorderLayout.NORTH);
        setVisible(true);
	System.out.println("hello");
    }
}
