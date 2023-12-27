package com.venoblin.hoverorb.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public  class TextureManager {
    public static Texture addStrokeToTexture(Texture texture, int strokeWidth, Color strokeColor) {
        Pixmap originalPixmap = new Pixmap(texture.getWidth(), texture.getHeight(), Pixmap.Format.RGBA8888);
        originalPixmap.drawPixmap(texture.getTextureData().consumePixmap(), 0, 0);

        Pixmap newPixmap = new Pixmap(texture.getWidth() + 2 * strokeWidth, texture.getHeight() + 2 * strokeWidth, Pixmap.Format.RGBA8888);
        newPixmap.setColor(strokeColor);

        newPixmap.fillRectangle(0, 0, newPixmap.getWidth(), newPixmap.getHeight());

        newPixmap.drawPixmap(originalPixmap, strokeWidth, strokeWidth);

        Texture resultTexture = new Texture(newPixmap);

        originalPixmap.dispose();
        newPixmap.dispose();

        return resultTexture;
    }
}