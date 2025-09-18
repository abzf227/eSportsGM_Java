package io.github.abzf227.esportsgm_java_java.entities;

public class PlayerLanguage {
    private final String language;  //language can't be changed
    private double fluency;

    public PlayerLanguage() { //default = English, fluency 10
        language = "English";
        fluency = 10.0; 
    }

    public PlayerLanguage(double fluency) { //General biligual language
        language = "English";
        this.fluency = fluency;
    }

    public PlayerLanguage(String language) { //For primary languages other than English
        this.language = language;
        fluency = 10.0;
    }

    public PlayerLanguage(String language, double fluency) { //For other biligual players (rare)
        this.language = language;
        this.fluency = fluency;
    }

    //getters
    public String getLanguage() {
        return language;
    }

    public double getFluency() {
        return fluency;
    }

    //setters
    public void editFluency(double fluency) {
        this.fluency = fluency;
    }
}
