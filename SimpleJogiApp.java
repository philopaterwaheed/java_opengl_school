import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
public class SimpleJogiApp extends JFrame {
    public static void main(String[] args) {
        new SimpleJogiApp();
    }
    GLCanvas glcanvas;
    SimpleGLEventListener listener = new SimpleGLEventListener();

    public SimpleJogiApp() {

        super("piramids");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(700,300);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}