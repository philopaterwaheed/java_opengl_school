package xo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.media.opengl.*;
import javax.swing.*;

public class task extends JFrame implements ActionListener{

    static GLCanvas glcanvas = null;
    JPanel jp = new JPanel();
    JButton button = new JButton("new");

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
        super("XO");
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
        glcanvas.addMouseListener(mmd);
//we'll want this for our repaint requests
        mmd.setGLCanvas(glcanvas);
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(1000, 1000);
        jp.add(button);
        button.addActionListener(this);
        add(jp, BorderLayout.SOUTH);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        logic.play =true;
        logic.resetGame();
    }
}
class lis implements GLEventListener, MouseMotionListener ,MouseListener {

    int xPosition = 50;
    int yPosition = 50;
    float red = 0.0f;
    float green = 0.5f;
    float blue = 0.5f;
    GLCanvas glc;
    ArrayList points = new ArrayList<point>();
    static GL gl =null ;

    public static void draw_c(point midp) {
        double x =  midp.x +0.5;
        double y =  midp.y +0.5;
        gl.glBegin(GL.GL_POINTS);
        // angle is
        // x = radius * (cosine of angle)
        // y = radius * (sine of angle)
        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            x = midp.x + .5+6.5 * (Math.cos(a));
            y =midp.y + .5+ 6.5 * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
    }

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL();
        red = 0f;
        green = 0.0f;
        blue = 0f;
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
        gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1f,1,1);

        // the border
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(20,20);
        gl.glVertex2d(20,80);
        gl.glVertex2d(80,80);
        gl.glVertex2d(80, 20);
        gl.glEnd();
        points.clear();
        int wid = 15 , gap =4 , startp = 20 ;

        for (int i = 1 ; i < 4 ; i ++)
            for (int c =1 ; c < 4 ; c++)
            {
                gl.glBegin(GL.GL_LINE_LOOP);
                gl.glVertex2d(startp + gap* (c  ) + wid  * (c  - 1 ),startp + gap * (i  ) + wid  * (i  - 1 ) );
                gl.glVertex2d(startp + gap* (c )+ wid  * (c  - 1 ),startp + wid  * (i )+ gap* (i  ));
                gl.glVertex2d(startp + gap* (c  )+ wid * (c  ) ,startp + wid  * (i  )+ gap* (i ) );
                gl.glVertex2d(startp+wid * (c ) + gap * (c  ), startp + gap* (i )+ wid  * (i -1 ));
                gl.glEnd();

            }
        gl.glColor3f(1,1,1);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(xPosition, yPosition);
        gl.glEnd();
        board.draw();

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


    @Override
    public void mouseClicked(MouseEvent e) {



    }

    @Override
    public void mouseDragged(MouseEvent e) {
        {
    }


    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!logic.play){
            logic.showResult();
            return;
        }
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
        System.out.println(xPosition+" "+yPosition);
         new logic (xPosition, yPosition);
        for (int[] xx : board.map)
        {
            System.out.println(Arrays.toString(xx));
        }
        glc.repaint();
        if(logic.checkWin()|| logic.checkDraw()){
            logic.showResult();
        }

        glc.repaint();
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
public static void draw_x (point f , point s , point t ,point ff ){
    gl.glColor3f(1,1,1);
    gl.glBegin(GL.GL_LINES);
    gl.glVertex2d(f.x,f.y);
    gl.glVertex2d(s.x,s.y);
    gl.glEnd();
    gl.glBegin(GL.GL_LINES);
    gl.glVertex2d(t.x,t.y);
    gl.glVertex2d(ff.x, ff.y);
    gl.glEnd();
}

}
class point {
    int x , y ;
    point(int x, int y){this.x = x ; this.y = y;}
}
class req {
    int fx , fy  ;
    point[] get_points (){
        return new point[]{new point(fx , fy) , new point(fx+15 , fy), new point(fx+15 , fy + 15) , new point(fx , fy + 15)  };
    }
    point midp(){
        return new point(fx+7 , fy+7);
    }
    req (int fx ,int fy) {
        this.fx = fx ; this.fy=fy;

    }
}
class board {
   public static int[][] map = {
        {0,0,0},
        {0,0,0},
        {0,0,0}
    };
    static void refill() {
        for(int[] x : map) {
            Arrays.fill(x,0);
        }
    }
   static void insert (int x , int y , int val) {
        map[x][y] =  val;
   }
   static void draw() {
        req reqt = null;
        int x ,y ;
       for (int i = 1; i < 4; i++) {
           for (int c = 1; c < 4; c++) {
               x = 20 + 4* (c  ) + 15  * (c  - 1 );  y = 20 + 4 * (i  ) + 15  * (i  - 1 );
               reqt = new req(x,y);
               point points []= reqt.get_points();
                if (map[i-1][c-1]==1)
                {
                    lis.draw_x(points[0],points[2],points[1] , points[3]);
                }
                else if (map[i-1] [c-1] ==2 )
                {
                    lis.draw_c(reqt.midp());
                }
           }

       }
       task.glcanvas.repaint();
   }
}
class logic {
    static boolean X  =true,play =true ;
    int insy = 0 ,insx = 0;
    logic ( int xPos , int yPos) {
       if (valid_point(xPos, yPos)){
           if (!(board.map[insx] [insy]>0)){
           insert(insx,insy);
           sw();}
       }
       else return;
    }
    static void sw(){
        X = !X;
    }
    static void insert (int x , int y) {
        if (X) {
            board.insert(x, y, 1);
        } else if (!(X)) {
            board.insert(x, y, 2);
        }
    }

    public static void resetGame() {
        X=true;
        board.refill();
        board.draw();

    }

    boolean valid_point (int x ,int y ) {
       if (x> 20 && x < 85  && y > 20 && y < 85 )
       {
         insx = geti(y) ; insy = getc(x);
         return true;
       }
       else return false;
    }
    int geti (int y ){
        return (y-20)/20;
    }
    int getc (int x ){
        return (x-20)/20;
    }
    public static boolean  checkWin(){

        for (int i = 0; i < 3; i++) {
            if (board.map[i][0] ==  board.map[i][1]  && board.map[i][2] == board.map[i][1] && board.map[i][0] != 0 && board.map[i][1] != 0) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board.map[0][i] ==  board.map[1][i]  && board.map[2][i] == board.map[1][i]&& board.map[0][i] != 0 && board.map[1][i] != 0) {
                return true  ;
            }
        }
        if (board.map[1][1] ==  board.map[0][2]  && board.map[1][1] == board.map[2][0]&& board.map[1][1] != 0 ) return true;
        if (board.map[1][1] ==  board.map[2][2]  && board.map[1][1] == board.map[0][0]&& board.map[1][1] != 0 ) return true;
        return false ;
    }
    static void showResult() {
        String result;
        if (!play) result = "continue?";
        else if (checkWin()) {
            result = (X)?"O":"X" + " wins";
        }

        else {

            result = "It's a draw!";
        }
        Object[] options = {"YES", "No"};

        // Show the option dialog
        int resultt = JOptionPane.showOptionDialog(
                task.glcanvas,
                "continue?",
                result,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        // Process the user's choice
        switch (resultt) {
            case JOptionPane.YES_OPTION:
                play = true ;
                logic.resetGame();
                break;
            case JOptionPane.NO_OPTION:
                play = false ;
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
            default:
                play=false;
        }
    }
    public static boolean checkDraw(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}