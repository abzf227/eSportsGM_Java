package io.github.abzf227.esportsgm_java_java;

import com.badlogic.gdx.Game;

import io.github.abzf227.esportsgm_java_java.screens.FirstScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGM extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
}