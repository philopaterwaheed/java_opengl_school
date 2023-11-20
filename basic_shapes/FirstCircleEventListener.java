import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class FirstCircleEventListener implements GLEventListener {

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -250.0, 250.0, -1, 1);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        double x, y;
        double radius = 100;

        GL gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(0.419608f, 0.556863f, 0.137255f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = radius * (Math.cos(a )) +100 ;
            y = radius * (Math.sin(a)) +100;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();



        gl.glColor3f(0.419608f, 0.556863f, 0.137255f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = (radius * (Math.cos(a)) +50);
            y = (radius * (Math.sin(a)) +50);
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

        gl.glColor3f(0.419608f, 0.556863f, 0.137255f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = radius * (Math.cos(a )) +5 ;
            y = radius * (Math.sin(a)) +80;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();




        gl.glColor3f(0.419608f, 0.556863f, 0.137255f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = radius * (Math.cos(a )) +10 ;
            y = radius * (Math.sin(a)) +130;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();



        gl.glColor3f(0.6f, 0.3f, 0.1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(32,-200);
        gl.glVertex2i(50,50);
        gl.glVertex2i(75,-200);
        gl.glEnd();
        gl.glColor3f(0.6f, 0.3f, 0.1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(50,0);
        gl.glVertex2i(50,20);
        gl.glVertex2i(-50,50);
        gl.glEnd();
        gl.glColor3f(0.6f, 0.3f, 0.1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(50,0);
        gl.glVertex2i(100,50);
        gl.glVertex2i(50,20);
        gl.glEnd();


    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
