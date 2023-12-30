package com.venoblin.hoverorb.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Graphics {
    public static Texture addStrokeToTexture(FileHandle ball, Color strokeColor) {

        Pixmap texturePixmap = new Pixmap(ball);
        texturePixmap.setColor(strokeColor);
        texturePixmap.drawRectangle(0, 0, texturePixmap.getWidth(), texturePixmap.getHeight());

        Texture ballTexture = new Texture(texturePixmap);

        texturePixmap.dispose();

        return ballTexture;
    }
}