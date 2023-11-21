import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
public class Circle extends JFrame {
    public static void main(String[] args) {
        new Circle();
    }
    GLCanvas glcanvas;
    FirstCircleEventListener listener = new FirstCircleEventListener();

    public Circle() {

        super("First Circle Using Sine and Cosine");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}