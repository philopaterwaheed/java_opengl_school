import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.swing.*;

public class task extends JFrame{

    static GLCanvas glcanvas = null;

    public static void main(String[] args) {
        final task app = new task();
// show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        app.setVisible(true);
                        glcanvas.requestFocusInWindow();
                    }
                }
        );
    }
    task(){
        super("exampls");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//create our KeyDisplay which serves two purposes
// 1) it is our GLEventListener, and
// 2) it is our KeyListener
        lis mmd = new lis();
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(mmd);
        glcanvas.addMouseMotionListener(mmd);
//we'll want this for our repaint requests
        mmd.setGLCanvas(glcanvas);
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(1000, 1000);
//center the JFrame on the screen
        centerWindow(this);
    }
    public void centerWindow(Component frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}
class lis implements GLEventListener, MouseMotionListener ,MouseListener {

    int xPosition = 50;
    int yPosition = 50;
    float red = 0.0f;
    float green = 0.5f;
    float blue = 0.5f;
    GLCanvas glc;

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        red = 0.5f;
        green = 0.0f;
        blue = 1.0f;
        gl.glClearColor(red, green, blue, 0.0f);
        gl.glViewport(0, 0, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 100, 0, 100, -1, 1);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
//Remember point size refers
//to pixels, not the coordinate
//system we've set up in the
//GLCanvas

        double x, y;
        double fradius = 20,sradius = 10;
        double centerRFX =   fradius , centerRSX =   sradius + xPosition;
        double centerRFY =   fradius , centerRSY =   sradius + yPosition;


        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(0.419608f, 0.556863f, 0.137255f);
        gl.glBegin(GL.GL_POINTS);
        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = fradius * (Math.cos(a )) + 50;
            y = fradius * (Math.sin(a)) + 50;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        gl.glPointSize(4.0f);
        red = 0.0f;
        green = 0.0f;
        blue = 0.0f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(xPosition, yPosition);
        gl.glEnd();


        double distance = Math.sqrt(Math.pow(50-xPosition,2)+Math.pow(50-yPosition,2));

        if (distance > fradius + sradius )
            gl.glColor3f(0.19608f, 0.556863f, 0.137255f);
        else if (distance < fradius + sradius && distance > fradius && distance > sradius) {
            gl.glColor3f(0, 0, 0f);

        }
        else if (distance < fradius + sradius && distance < sradius)
            gl.glColor3f(1, 1, 1f);

        // moving circle
        gl.glBegin(GL.GL_POINTS);
        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = sradius * (Math.cos(a )) + xPosition;
            y = sradius * (Math.sin(a)) + yPosition;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        gl.glColor3f(0.419608f, 0.556863f, 0.137255f);
    }

    /**
     * Called when the GLDrawable (GLCanvas or GLJPanel) has changed in size. We
     * won't need this, but you may eventually need it -- just not yet.
     */
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    /**
     * If the display depth is changed while the program is running this method
     * is called. Nowadays this doesn't happen much, unless a programmer has his
     * program do it.
     */
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }
////////////////////////////////////////////
// MouseMotionListener implementation below

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
//get percent of GLCanvas instead of
//points and then converting it to our
//'100' based coordinate system.
        xPosition = (int) ((x / width) * 100);
        yPosition = ((int) ((y / height) * 100));
//reversing direction of y axis
        yPosition = 100 - yPosition;
        glc.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println("hello");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
