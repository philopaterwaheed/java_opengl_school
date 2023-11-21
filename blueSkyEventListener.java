import javax.media.opengl.GLEventListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
public class blueSkyEventListener implements GLEventListener  {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(0.3f,0.2f,1f,1);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1050.0, 1050.0, -850.0, 850.0, -1, 1);

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        double x, y;
        double radius = 200;

        GL gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor4f(0.9f, 0.9f, 0.9f,1);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = radius * (Math.cos(a )) +200 ;
            y = radius * (Math.sin(a)) +520;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

        gl.glColor3f(0.9f, 0.9f, 0.9f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = (radius) * (Math.cos(a )) + 103  ;
            y = (radius) * (Math.sin(a)) +580;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

        gl.glColor3f(0.9f, 0.9f, 0.9f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = radius * (Math.cos(a )) -100 ;
            y = radius * (Math.sin(a)) +500;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
//
        gl.glColor3f(0.9f, 0.9f, 0.9f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = radius * (Math.cos(a )) +360 ;
            y = radius * (Math.sin(a)) +530;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

//        gl.glColor3f(0.9f, 0.9f, 0.9f);
//        gl.glBegin(GL.GL_POLYGON);
//
//        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
//            x = radius * (Math.cos(a )) + 310 ;
//            y = radius * (Math.sin(a)) +500;
//            gl.glVertex2d(x, y);
//        }
//        gl.glEnd();
//        gl.glColor3f(0.9f, 0.9f, 0.9f);
//        gl.glBegin(GL.GL_POLYGON);
//
//        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
//            x = radius * (Math.cos(a )) +210 ;
//            y = radius * (Math.sin(a)) +540;
//            gl.glVertex2d(x, y);
//        }
//        gl.glEnd();
//
//        gl.glColor3f(0.9f, 0.9f, 0.9f);
//        gl.glBegin(GL.GL_POLYGON);
//
//        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
//            x = radius * (Math.cos(a )) +100 ;
//            y = radius * (Math.sin(a)) +440;
//            gl.glVertex2d(x, y);
//        }
//        gl.glEnd();
        gl.glColor3f(.1f,.7f,.1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(-1050, 0 );
        gl.glVertex2d(-1050, -850 );
        gl.glVertex2d(1050, -850 );
        gl.glVertex2d(1050, 0 );
        gl.glEnd();




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




        gl.glColor3f(1.0f , 1.0f , 0.0f); // sets the color of the drawing
        gl.glBegin(GL.GL_POLYGON); // tells it to begin a polygon
        gl.glVertex2i(-300,200); // sets the dots of it
        gl.glVertex2i(-450,0);
        gl.glVertex2i(-150,0);
        gl.glEnd();

        gl.glColor3f(1.2f , 1.0f , 0.0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-500,220);
        gl.glVertex2i(-350,0);
        gl.glVertex2i(-650,0);
        gl.glEnd();

        gl.glColor3f(1.2f , 1.0f , 0.0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-700,220);
        gl.glVertex2i(-1050,-20);
        gl.glVertex2i(-350,-20);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
