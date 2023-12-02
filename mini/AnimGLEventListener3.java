package Man;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project;

import Texture.TextureReader;
import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;
import javax.media.opengl.glu.GLU;

public class AnimGLEventListener3 extends AnimListener {

    int animationIndex = 0;
    int maxWidth = 100;
    int maxHeight = 100;
    int x = maxWidth/2, y = maxHeight/2 , xdir =1 , ydir =1;
    double xx = maxWidth/2 ,yy = maxHeight/2 ;
    int fps = 0 ;
    Random rand = new Random();
    ArrayList <ball> balls = new ArrayList<ball>();
    static ArrayList <bullet> bullets = new ArrayList<bullet>();
    static ArrayList <bullet> shot = new ArrayList<bullet>();


    /*
     5 means gun in array pos
     x and y coordinate for gun 
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0,0.7f, 0.3f,1);
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
        gl.glColor3f(0f,0f,0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(0,maxHeight);
        gl.glVertex2d(maxWidth,maxHeight);
        gl.glVertex2d(maxWidth,maxHeight -maxHeight/3);
        gl.glVertex2d(0,maxHeight -maxHeight/3);
        gl.glEnd();
        gl.glColor3f(1f,1f,1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(0,maxHeight-maxHeight/3);
        gl.glVertex2d(maxWidth,maxHeight-maxHeight/3);
        gl.glVertex2d(maxWidth,maxHeight-maxHeight/1.5);
        gl.glVertex2d(0,maxHeight-maxHeight/1.5);
        gl.glEnd();
        gl.glColor3f(1f,0f,0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,maxHeight);
        gl.glVertex2d(maxWidth/2,maxHeight/2);
        gl.glEnd();
        gl.glPushMatrix();
        gl.glTranslated(x,y,1);
        gl.glColor3f(1f,1f,0f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            xx = (15 * (Math.cos(a)) +(double) (maxWidth )/6);
            yy = (15 * (Math.sin(a)) +(double)  (maxHeight)/6);
            gl.glVertex2d(xx ,yy);

        }
        x+=xdir;
        y+=ydir;
        change();
        gl.glEnd();
        gl.glColor3f(1f,1f,0f);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < Math.toRadians(180); a += Math.toRadians(1)) {
            xx = (10 * (Math.cos(a)) +(double) (maxWidth )/2);
            yy = (10 * (Math.sin(a)) +(double)  (maxHeight)/2);
            gl.glVertex2d(xx ,yy);

        }
        gl.glEnd();
        gl.glPopMatrix();

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    void change (){
        if (xx +15 > maxWidth){
            xdir *= -1;
        }
       else if (xx +15 < 0){
            xdir *= -1;
        }
        if (yy +15 > maxHeight){
            ydir *= -1;
        }
        else if (yy +15 < 0){
            ydir *= -1;
        }
    }
    public void DrawSprite(GL gl,int x, int y, int index, float scale){
        gl.glEnable(GL.GL_BLEND);

        gl.glPushMatrix();
            gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
            gl.glScaled(0.1*scale, 0.1*scale, 1);
            //System.out.println(x +" " + y);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
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
   public void balls (GL gl,int x, int y, int index, float scale){
       for (ball b: balls ) {
           System.out.println(b.x);
           gl.glEnable(GL.GL_BLEND);
           gl.glPushMatrix();
           gl.glTranslated(b.x / (maxWidth / 2.0) - 0.9, b.y / (maxHeight / 2.0) - 0.9, 0);
           gl.glScaled(0.1 * scale, 0.1 * scale, 1);
           //System.out.println(x +" " + y);
           gl.glBegin(GL.GL_QUADS);
           // Front Face
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
            b.y--;
            if (b.y < 0)
                b.y = maxHeight;
       }

    }
    public void bullets (GL gl,int x, int y, int index, float scale){
        for (bullet b: shot ) {
            gl.glEnable(GL.GL_BLEND);
            gl.glPushMatrix();
            gl.glTranslated(b.x / (maxWidth / 2.0) - 0.9, b.y / (maxHeight / 2.0) - 0.9, 0);
            gl.glScaled(0.05 * scale, 0.05 * scale, 1);
            //System.out.println(x +" " + y);
            gl.glBegin(GL.GL_QUADS);
            // Front Face
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
            b.y++;
        }

    }
    public void DrawBackground(GL gl){
        gl.glEnable(GL.GL_BLEND);

        gl.glPushMatrix();
        gl.glColor3f(.6f,.6f,.6f);
            gl.glBegin(GL.GL_POLYGON);
            // Front Face
            gl.glVertex2d(0,maxHeight);
            gl.glVertex2d(maxWidth,maxHeight);
            gl.glVertex2d(maxWidth,0);
            gl.glVertex2d(0,0);

            gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    /*
     * KeyListener
     */    

    public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (x > 0) {
                x--;
            }
            animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (x < maxWidth-10) {
                x++;
            }
            animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (y > 0) {
                y--;
            }
            animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (y < maxHeight-10) {
                y++;
            }
            animationIndex++;
        }
        if (isKeyPressed(KeyEvent.VK_SPACE ) && fps > 7) {
            fps = 0 ;
        }
    }

    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }
    public void baloon(){
        System.out.println("frame");
    }
    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void keyTyped(final KeyEvent event) {
        // don't care
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
}
class ball {
   hitBox hit ;
   int x , y ;
   ball (int x , int y, int width){
       this.x = x ; this.y =y ;
       hit = new hitBox(x,y,width);
   }
}
class bullet {

    hitBox hit ;
    int x , y ;
    boolean shoted =false ;
    bullet (int x , int y, int width){
        this.x = x ; this.y =y ;
        hit = new hitBox(x,y,width);
    }
    void start(int x , int y){
        this.y = y ;
        this.x = x ;
        shoted = true ;
    }
}
class hitBox{
    int x, y , width;
    hitBox(int x , int y , int width){
        this.x =x;
        this.y =y;
        this.width =width;
    }
}
class gun  {
    static int idx = 9 ;
    gun (){
        for (int i = 0; i < 10; i++) {
           AnimGLEventListener3.bullets.add(new bullet(-1,-1,5)) ;
        }
    }
   static void shoot(int x , int y){
       bullet xx =  AnimGLEventListener3.bullets.remove(idx);
       xx.x =x ; xx.y =y ;
       AnimGLEventListener3.shot.add (xx);
       idx -- ;
       if (idx == -1 )
           gun.refill();

    }
    static void refill(){
        for (int i = 0; i < 10; i++) {
        AnimGLEventListener3.bullets.add(new bullet(-1,-1,5)) ;
    }
        idx =9 ;
    }
}