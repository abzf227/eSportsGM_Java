package io.github.abzf227.esportsgm_java_java.screens;

import java.util.List;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.abzf227.esportsgm_java_java.entities.EsportsPlayer;
import io.github.abzf227.esportsgm_java_java.logic.PlayerGenerator;


/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    private BitmapFont font;
    private SpriteBatch batch;
    private List<String> debugLines;

    @Override
    public void show() {
        // Prepare your screen here.
        font = new BitmapFont();
        batch = new SpriteBatch();

        

    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(!(width <= 0 || height <= 0)) {

        }
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        this.font.dispose();
        this.batch.dispose();
    }

    public static void main(String[] args) {
        //testing only
        PlayerGenerator playerGen = new PlayerGenerator();
        EsportsPlayer testPlayer = playerGen.generateRandomPlayer();

        System.out.println(testPlayer.getAge());

    }
}