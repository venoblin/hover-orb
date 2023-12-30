package com.venoblin.hoverorb.preferences;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GamePreferences {
    private static final Preferences prefs = Gdx.app.getPreferences("HoverOrbPrefs");
    private static final String highScorePref = "highScore";
    private static final String currentBallPref = "currentBall";

    public static void setHighScore(int score) {
        prefs.putInteger(highScorePref, score);
        prefs.flush();
    }

    public static int loadHighScore() {
        return prefs.getInteger(highScorePref, 0);
    }

    public static void setCurrentBall(String path) {
        prefs.putString(currentBallPref, path);
        prefs.flush();
    }

    public static String loadCurrentBall() {
        return prefs.getString(currentBallPref, "balls/ball_1.png");
    }
}