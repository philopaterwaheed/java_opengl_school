//package Man;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
////package project;
//
//import Texture.TextureReader;
//
//import javax.media.opengl.GL;
//import javax.media.opengl.GLAutoDrawable;
//import javax.media.opengl.glu.GLU;
//import java.awt.event.KeyEvent;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.Random;
//
//public class AnimGLEventListener4 extends AnimListener {
//
//    int animationIndex = 0;
//    int maxWidth = 100;
//    int maxHeight = 100;
//    int x = maxWidth/2, y = maxHeight/2;
//    int fps = 0 ;
//    ArrayList <ball> balls = new ArrayList<ball>();
//    static ArrayList <bullet> bullets = new ArrayList<bullet>();
//    static ArrayList <bullet> shot = new ArrayList<bullet>();
//
//    String textureNames[] = {"Man1.png","Man2.png","Man3.png","Man4.png","Back.png","Balloon1.png","bull.png"};
//    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
//    int textures[] = new int[textureNames.length];
//
//    /*
//     5 means gun in array pos
//     x and y coordinate for gun
//     */
//    public void init(GLAutoDrawable gld) {
//        for (int i = 0; i < 10; i++) {
//            Random rand = new Random();
//            balls.add(new ball((int)( rand.nextInt(maxWidth-2)),rand.nextInt(100,maxHeight+100),5 ));
//        }
//        for (int i = 0; i < 10; i++) {
//            Random rand = new Random();
//            bullets.add(new bullet((int)( rand.nextInt(maxWidth-2)),rand.nextInt(100,maxHeight+100),5 ));
//        }
//        GL gl = gld.getGL();
//        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black
//
//        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
//        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
//        gl.glGenTextures(textureNames.length, textures, 0);
//
//        for(int i = 0; i < textureNames.length; i++){
//            try {
//                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i] , true);
//                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);
//
////                mipmapsFromPNG(gl, new GLU(), texture[i]);
//                new GLU().gluBuild2DMipmaps(
//                    GL.GL_TEXTURE_2D,
//                    GL.GL_RGBA, // Internal Texel Format,
//                    texture[i].getWidth(), texture[i].getHeight(),
//                    GL.GL_RGBA, // External format from image,
//                    GL.GL_UNSIGNED_BYTE,
//                    texture[i].getPixels() // Imagedata
//                    );
//            } catch( IOException e ) {
//              System.out.println(e);
//              e.printStackTrace();
//            }
//        }
//    }
//
//    public void display(GLAutoDrawable gld) {
//
//        GL gl = gld.getGL();
//        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
//        gl.glLoadIdentity();
//
//        DrawBackground(gl);
//        handleKeyPress();
//        animationIndex = animationIndex % 4;
//
//
////        DrawGraph(gl);
//        DrawSprite(gl, x, y, animationIndex, 1);
//        balls(gl, x, y, animationIndex, 1);
//        bullets(gl, x, y, animationIndex, 1);
//        fps++;
//        if (fps > 16) fps = 0 ;
//    }
//
//    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//    }
//
//    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
//    }
//
//    public void DrawSprite(GL gl,int x, int y, int index, float scale){
//        gl.glEnable(GL.GL_BLEND);
//        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On
//
//        gl.glPushMatrix();
//            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
//            gl.glScaled(0.1*scale, 0.1*scale, 1);
//            //System.out.println(x +" " + y);
//            gl.glBegin(GL.GL_QUADS);
//            // Front Face
//                gl.glTexCoord2f(0.0f, 0.0f);
//                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
//                gl.glTexCoord2f(1.0f, 0.0f);
//                gl.glVertex3f(1.0f, -1.0f, -1.0f);
//                gl.glTexCoord2f(1.0f, 1.0f);
//                gl.glVertex3f(1.0f, 1.0f, -1.0f);
//                gl.glTexCoord2f(0.0f, 1.0f);
//                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
//            gl.glEnd();
//        gl.glPopMatrix();
//
//        gl.glDisable(GL.GL_BLEND);
//    }
//   public void balls (GL gl,int x, int y, int index, float scale){
//       for (ball b: balls ) {
//           System.out.println(b.x);
//           gl.glEnable(GL.GL_BLEND);
//           gl.glBindTexture(GL.GL_TEXTURE_2D, textures[5]);    // Turn Blending On
//           gl.glPushMatrix();
//           gl.glTranslated(b.x / (maxWidth / 2.0) - 0.9, b.y / (maxHeight / 2.0) - 0.9, 0);
//           gl.glScaled(0.1 * scale, 0.1 * scale, 1);
//           //System.out.println(x +" " + y);
//           gl.glBegin(GL.GL_QUADS);
//           // Front Face
//           gl.glTexCoord2f(0.0f, 0.0f);
//           gl.glVertex3f(-1.0f, -1.0f, -1.0f);
//           gl.glTexCoord2f(1.0f, 0.0f);
//           gl.glVertex3f(1.0f, -1.0f, -1.0f);
//           gl.glTexCoord2f(1.0f, 1.0f);
//           gl.glVertex3f(1.0f, 1.0f, -1.0f);
//           gl.glTexCoord2f(0.0f, 1.0f);
//           gl.glVertex3f(-1.0f, 1.0f, -1.0f);
//           gl.glEnd();
//           gl.glPopMatrix();
//
//           gl.glDisable(GL.GL_BLEND);
//            b.y--;
//            if (b.y < 0)
//                b.y = maxHeight;
//       }
//
//    }
//    public void bullets (GL gl,int x, int y, int index, float scale){
//        for (bullet b: shot ) {
//            gl.glEnable(GL.GL_BLEND);
//            gl.glBindTexture(GL.GL_TEXTURE_2D, textures[6]);    // Turn Blending On
//            gl.glPushMatrix();
//            gl.glTranslated(b.x / (maxWidth / 2.0) - 0.9, b.y / (maxHeight / 2.0) - 0.9, 0);
//            gl.glScaled(0.05 * scale, 0.05 * scale, 1);
//            //System.out.println(x +" " + y);
//            gl.glBegin(GL.GL_QUADS);
//            // Front Face
//            gl.glTexCoord2f(0.0f, 0.0f);
//            gl.glVertex3f(-1.0f, -1.0f, -1.0f);
//            gl.glTexCoord2f(1.0f, 0.0f);
//            gl.glVertex3f(1.0f, -1.0f, -1.0f);
//            gl.glTexCoord2f(1.0f, 1.0f);
//            gl.glVertex3f(1.0f, 1.0f, -1.0f);
//            gl.glTexCoord2f(0.0f, 1.0f);
//            gl.glVertex3f(-1.0f, 1.0f, -1.0f);
//            gl.glEnd();
//            gl.glPopMatrix();
//
//            gl.glDisable(GL.GL_BLEND);
//            b.y++;
//        }
//
//    }
//    public void DrawBackground(GL gl){
//        gl.glEnable(GL.GL_BLEND);
//        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]);	// Turn Blending On
//
//        gl.glPushMatrix();
//            gl.glBegin(GL.GL_QUADS);
//            // Front Face
//                gl.glTexCoord2f(0.0f, 0.0f);
//                gl.glVertex3f(-1.0f, -1.0f, -1.0f);
//                gl.glTexCoord2f(1.0f, 0.0f);
//                gl.glVertex3f(1.0f, -1.0f, -1.0f);
//                gl.glTexCoord2f(1.0f, 1.0f);
//                gl.glVertex3f(1.0f, 1.0f, -1.0f);
//                gl.glTexCoord2f(0.0f, 1.0f);
//                gl.glVertex3f(-1.0f, 1.0f, -1.0f);
//            gl.glEnd();
//        gl.glPopMatrix();
//
//        gl.glDisable(GL.GL_BLEND);
//    }
//
//    /*
//     * KeyListener
//     */
//
//    public void handleKeyPress() {
//
//        if (isKeyPressed(KeyEvent.VK_LEFT)) {
//            if (x > 0) {
//                x--;
//            }
//            animationIndex++;
//        }
//        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
//            if (x < maxWidth-10) {
//                x++;
//            }
//            animationIndex++;
//        }
//        if (isKeyPressed(KeyEvent.VK_DOWN)) {
//            if (y > 0) {
//                y--;
//            }
//            animationIndex++;
//        }
//        if (isKeyPressed(KeyEvent.VK_UP)) {
//            if (y < maxHeight-10) {
//                y++;
//            }
//            animationIndex++;
//        }
//        if (isKeyPressed(KeyEvent.VK_SPACE ) && fps > 7) {
//            gun.shoot(x , y );
//            fps = 0 ;
//        }
//    }
//
//    public BitSet keyBits = new BitSet(256);
//
//    @Override
//    public void keyPressed(final KeyEvent event) {
//        int keyCode = event.getKeyCode();
//        keyBits.set(keyCode);
//    }
//    public void baloon(){
//        System.out.println("frame");
//    }
//    @Override
//    public void keyReleased(final KeyEvent event) {
//        int keyCode = event.getKeyCode();
//        keyBits.clear(keyCode);
//    }
//
//    @Override
//    public void keyTyped(final KeyEvent event) {
//        // don't care
//    }
//
//    public boolean isKeyPressed(final int keyCode) {
//        return keyBits.get(keyCode);
//    }
//}
//class ball {
//   hitBox hit ;
//   int x , y ;
//   ball (int x , int y, int width){
//       this.x = x ; this.y =y ;
//       hit = new hitBox(x,y,width);
//   }
//}
//class bullet {
//
//    hitBox hit ;
//    int x , y ;
//    boolean shoted =false ;
//    bullet (int x , int y, int width){
//        this.x = x ; this.y =y ;
//        hit = new hitBox(x,y,width);
//    }
//    void start(int x , int y){
//        this.y = y ;
//        this.x = x ;
//        shoted = true ;
//    }
//}
//class hitBox{
//    int x, y , width;
//    hitBox(int x , int y , int width){
//        this.x =x;
//        this.y =y;
//        this.width =width;
//    }
//}
//class gun  {
//    static int idx = 9 ;
//    gun (){
//        for (int i = 0; i < 10; i++) {
//           AnimGLEventListener3.bullets.add(new bullet(-1,-1,5)) ;
//        }
//    }
//   static void shoot(int x , int y){
//       bullet xx =  AnimGLEventListener3.bullets.remove(idx);
//       xx.x =x ; xx.y =y ;
//       AnimGLEventListener3.shot.add (xx);
//       idx -- ;
//       if (idx == -1 )
//           gun.refill();
//
//    }
//    static void refill(){
//        for (int i = 0; i < 10; i++) {
//        AnimGLEventListener3.bullets.add(new bullet(-1,-1,5)) ;
//    }
//        idx =9 ;
//    }
//}