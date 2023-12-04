import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;
public class Main extends  JFrame {

    public static void main(String[] args) {
        new Main();
    }
    GLCanvas glcanvas;
    Animator animator;
    eventListener listener = new eventListener();
    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        animator = new FPSAnimator(24);
        animator.add(glcanvas);
        animator.start();
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        setLocationRelativeTo(this);
        setVisible(true);
    }



}


