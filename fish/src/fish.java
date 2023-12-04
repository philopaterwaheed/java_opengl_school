import javax.media.opengl.GL;
import java.util.ArrayList;
import java.util.Random;

public class fish extends Entity{
    int frame = -1 , xdir =1 , ydir = 1 ;
    int degree = 0 ;
    Random random = new Random();
    boolean hit = false ;
    fish(int x, int y, boolean render, String[] texturesStrings) {
        super(x, y, render, texturesStrings);
        xdir = random.nextInt(-1,1);
        ydir = random.nextInt(-1,1);
        if (xdir ==0) xdir =1;
        if (ydir ==0) ydir =1;
    }

    @Override
    public void update() {
        Random random = new Random();
        frame++;
        y+=ydir;
        if (hit){
            if (frame > 16)
            {
                frame = 0 ;
                hit = false ;
                xdir *=-1;
            }
        }
        else {
            x += xdir ;
            if (frame > 11)
                frame = 0;
            if (x >= eventListener.maxWidth -10) {
                hit = true ;
                frame = 12;
                degree = random.nextInt(0,45);
                x= eventListener.maxHeight -10 ;
            }
            if (x <= 0) {
                hit = true ;
                frame =12 ;
                degree = random.nextInt(0,45);
                x= 0 ;
            }
        }
        if (y > eventListener.maxHeight-10) {
            degree = random.nextInt(0,45);
            ydir*= -1;
            y=eventListener.maxHeight -10;
        }
        if (y < 0) {
            degree = random.nextInt(0,45);
            ydir *=-1;
            y=0 ;
        }
        System.out.println(y + " " + frame);
    }



    @Override
    public void addTextures(ArrayList<String> textures) {

    }

    @Override
    public void render(GL gl) {
       gl.glEnable(GL.GL_BLEND);
       gl.glBindTexture(GL.GL_TEXTURE_2D, this.textures[frame]);	// Turn Blending On

       gl.glPushMatrix();
        gl.glTranslated(((double) x)/(eventListener.maxWidth/2.0)-.9,y/(eventListener.maxHeight/2.0)-0.9,1);
        gl.glRotated(degree/10.0,1,0,0);

       gl.glScaled(.1 * xdir *-1,.1,1);

       gl.glBegin(GL.GL_QUADS);
       gl.glTexCoord2f(0.0f, 0.0f);
       gl.glVertex3f(-1.0f, -1.0f, -1.0f);
       gl.glTexCoord2f(1.0f, 0.0f);
       gl.glVertex3f(1.0f, -1.0f, -1.0f);
       gl.glTexCoord2f(1.0f, 1.0f);
       gl.glVertex3f(1.0f, 1.0f, -1.0f);
       gl.glTexCoord2f(0.0f, 1.0f);
       gl.glVertex3f(-1.0f, 1.0f, -1.0f);
       gl.glEnd();
       gl.glPopMatrix();
       gl.glDisable(GL.GL_BLEND);

    }

    @Override
    public void destroy() {

    }
}
