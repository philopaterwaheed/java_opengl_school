import javax.media.opengl.GL;
import java.util.ArrayList;

public class background extends Entity {

    background(int x, int y, boolean render, String[] texturesStrings) {
        super(x, y, render, texturesStrings);
    }

    @Override
    public void update() {

    }

    @Override
    public void addTextures(ArrayList<String> textures) {

    }

    @Override
    public void render(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, this.textures[0]);	// Turn Blending On

        gl.glPushMatrix();

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
