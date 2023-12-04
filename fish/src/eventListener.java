import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import Texture.TextureReader;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class eventListener  extends AnimListener implements GLEventListener{
    int frame = 0 ;
    //String textureNames[] = {"flag//flag animation1.png","flag//flag animation2.png","flag//flag animation3.png","flag//flag animation4.png","flag//flag animation5.png"};
   // TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    //int textures[] = new int[textureNames.length];
    ArrayList <fish> fishes = new ArrayList<>();
    background back ;
    static GL gl ;
    fish fish ;
    static int maxWidth = 100 , maxHeight = 100;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL();
        gl.glClearColor(1.5f, 0.5f, 0.5f, 0.0f); // the color of the canvas ;

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity(); // resets the identity of the matrix ;
        gl.glOrtho(0.0, 100.0, 0.0, 100.0, -1, 1); // is not need to easy
        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        back = new background(1,1 , true , new String []{"Fish//Back.png"});
        entityManager.addEntity(back);
        for (int oo = 0 ; oo  < 10 ; oo ++) {
            Random random = new Random();
            fish fish = ( new fish(random.nextInt(0,90), random.nextInt(0,90), true, new String[]{"Fish//Swim1.png", "Fish//Swim2.png", "Fish//Swim3.png", "Fish//Swim4.png", "Fish//Swim5.png", "Fish//Swim6.png", "Fish//Swim7.png", "Fish//Swim8.png", "Fish//Swim9.png", "Fish//Swim10.png", "Fish//Swim11.png", "Fish//Swim12.png", "Fish//turn1.png", "Fish//turn2.png", "Fish//turn3.png", "Fish//turn4.png", "Fish//turn5.png",}));
            fishes.add(fish);
            entityManager.addEntity(fish);
        }
         fish = new fish ( 50, 50, true, new String[]{"Fish//Swim1.png", "Fish//Swim2.png", "Fish//Swim3.png", "Fish//Swim4.png", "Fish//Swim5.png", "Fish//Swim6.png", "Fish//Swim7.png", "Fish//Swim8.png", "Fish//Swim9.png", "Fish//Swim10.png", "Fish//Swim11.png", "Fish//Swim12.png", "Fish//turn1.png", "Fish//turn2.png", "Fish//turn3.png", "Fish//turn4.png", "Fish//turn5.png",});
         entityManager.addEntity(fish);

        for (Entity entity : entityManager.entities) {

            for(int i = 0; i < entity.texture.length; i++) {


                try {
                    entity.texture [i] = TextureReader.readTexture(assetsFolderName + "//" + entity.Textures.get(i), true);
                    gl.glBindTexture(GL.GL_TEXTURE_2D, entity.textures[i] );

    //                mipmapsFromPNG(gl, new GLU(), texture[i]);
                    new GLU().gluBuild2DMipmaps(
                            GL.GL_TEXTURE_2D,
                            GL.GL_RGBA, // Internal Texel Format,
                            entity.texture[i].getWidth(),entity.texture[i].getHeight(),
                            GL.GL_RGBA, // External format from image,
                            GL.GL_UNSIGNED_BYTE,
                            entity.texture[i].getPixels() // Image_data
                    );
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
//        DrawBackground(gl);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glLoadIdentity();
        entityManager.update();
        entityManager.render(gl);

    }
    public void DrawBackground(GL gl){
    }    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key");
        if (e.getKeyCode()==KeyEvent.VK_UP)
        {
            fish.y++;
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            fish.x++;
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            fish.x--;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            fish.y--;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}