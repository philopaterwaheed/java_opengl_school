import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
public class sky extends  JFrame {
    public static void main(String[] args) {
        new sky();
    }
    GLCanvas glcanvas;
    blueSkyEventListener listener = new blueSkyEventListener();
    public sky(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}