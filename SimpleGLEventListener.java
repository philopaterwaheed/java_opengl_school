import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class SimpleGLEventListener implements GLEventListener {

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(0.5f, 0.5f, 0.5f, 0.0f); // the color of the canvas ;

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity(); // resets the identity of the matrix ;
        gl.glOrtho(0.0, 900.0, 0.0, 600.0, -1, 1);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


        gl.glColor3f(1.0f , 1.0f , 0.0f); // sets the color of the drawing
        gl.glBegin(GL.GL_POLYGON); // tells it to begin a polygon
        gl.glVertex2i(300,250); // sets the dots of it
        gl.glVertex2i(450,50);
        gl.glVertex2i(150,50);
        gl.glEnd();

        gl.glColor3f(0.2f , 1.0f , 0.0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(500,250);
        gl.glVertex2i(350,60);
        gl.glVertex2i(650,60);
        gl.glEnd();

        gl.glColor3f(1.2f , 1.0f , 0.0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(700,250);
        gl.glVertex2i(850,70);
        gl.glVertex2i(550,70);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}