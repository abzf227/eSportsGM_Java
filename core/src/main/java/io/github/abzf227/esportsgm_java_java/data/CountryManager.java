package io.github.abzf227.esportsgm_java_java.data;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class CountryManager {
    private final List<String> countries;

    public CountryManager() {
        countries = new ArrayList<>();
        FileHandle countriesFile = Gdx.files.internal("countries.txt");
        for (String country : countriesFile.readString().split("\\r?\\n")) {
            countries.add(country.trim());
        }
    }

    public List<String> getCountries() {
        return countries;
    }
}
