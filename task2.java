import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.swing.*;

public class task2 extends JFrame{

    static GLCanvas glcanvas = null;

    public static void main(String[] args) {
        final task2 app = new task2();
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
    task2(){
        super("KeyListener Example");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//create our KeyDisplay which serves two purposes
// 1) it is our GLEventListener, and
// 2) it is our KeyListener
        MouseDispla md = new MouseDispla();
//only three JOGL lines of code ... and here they are
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(md);
        glcanvas.addMouseListener(md);
        glcanvas.addMouseMotionListener(md);
//we'll want this for our repaint requests
        md.setGLCanvas(glcanvas);
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
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
class MouseDispla
        implements GLEventListener, MouseMotionListener,MouseListener{

    int xPosition = -150;
    int yPosition = -150;
    float red = 0.0f;
    float green = 0.5f;
    float blue = 0.5f;
    int xposEnd=-150 ;
    int yposEnd =-150  ;
    boolean draw = false ;
    GLCanvas glc;

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        red = 0.0f;
        green = 0.7f;
        blue = 0.3f;
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
        gl.glPointSize(6.0f);
        red = 0.0f;
        green = 0.0f;
        blue = 0.0f;

        int fRX , fRY , sRX , sRY ;
         double squareL =  Math.sqrt(Math.pow(xposEnd-xPosition,2)+Math.pow(yposEnd-yPosition,2));
         double reqW = Math.abs(xPosition - xposEnd) , reqH = Math.abs(xPosition - yposEnd);

//        fRX = (int) (xPosition+ reqW) ;
//        fRY =(int) yPosition ;
//
//        sRX =(int) (xPosition);
//        sRY =(int) (yPosition + reqH);
//

        fRX = xPosition;
        fRY = yposEnd;

        sRX = xposEnd;
        sRY = yPosition;

        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(xPosition, yPosition);
        gl.glEnd();
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(sRX, sRY);
        gl.glEnd();
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(xposEnd, yposEnd);
        gl.glEnd();
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2i(fRX,fRY);
        gl.glVertex2i(xPosition, yPosition);
        gl.glVertex2i(sRX , sRY);
        gl.glVertex2i(xposEnd, yposEnd);
        gl.glEnd();
        if (draw){
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2i(xPosition, yPosition);
        gl.glVertex2i(sRX , sRY);
        gl.glVertex2i(Math.abs(xPosition + sRX) /2 , (sRY  - yposEnd ));
        gl.glEnd();}
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
// MouseListener implementation below

    public void mouseClicked(MouseEvent e) {

        double x = e.getX();
        double y = e.getY();

        System.out.println(x+" "+y);

        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        System.out.println(width+" "+height);
//get percent of GLCanvas instead of
//points and then converting it to our
//'100' based coordinate system.
        xPosition = (int) ((x / width) * 100);
        yPosition = ((int) ((y / height) * 100));
//reversing direction of y axis
        yPosition = 100 - yPosition;
        xposEnd = xPosition;
        yposEnd = yPosition;
        draw = true;
        glc.repaint();

    }


    public void mouseDragged(MouseEvent e) {
        {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
//get percent of GLCanvas instead of
//points and then converting it to our
//'100' based coordinate system.
        xposEnd = (int) ((x / width) * 100);
        yposEnd = ((int) ((y / height) * 100));
//reversing direction of y axis
        yposEnd = 100 - yposEnd;}
        glc.repaint();
    }
    public void mouseMoved(MouseEvent e) {



    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        draw = false ;
    }
}
