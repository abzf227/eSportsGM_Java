package io.github.abzf227.esportsgm_java_java.logic;
import io.github.abzf227.esportsgm_java_java.entities.*;
import io.github.abzf227.esportsgm_java_java.data.CountryManager;
import java.util.List;
import java.util.Random;

public class PlayerGenerator {
    private final CountryManager countryManager = new CountryManager();
    private final Random rand = new Random();
    private final RealNameGenerator realNameGenerator = new RealNameGenerator();

    public EsportsPlayer generateRandomPlayer() {
        EsportsPlayer player = new EsportsPlayer();

        // Nationality
        List<String> countries = countryManager.getCountries();
        String nationality = countries.get(rand.nextInt(countries.size()));

        // Fake IGN and real name (replace with name generator later)
        String inGameName = "GamingLegend"; //IGNGenerator.generateName();
        String realName = realNameGenerator.generateName(nationality);

        // Stats (randomized for now, scale 0-100)
        int mechanics = rand.nextInt(100);
        int sniping = rand.nextInt(100);
        int rifling = rand.nextInt(100);
        int experience = rand.nextInt(100);
        int utility = rand.nextInt(100);
        int gameSense = rand.nextInt(100);
        int comms = rand.nextInt(100);

        // Assign fields (use setters or public methods if needed)
        player.setInGameName(inGameName);
        player.setRealName(realName);
        player.setNationality(nationality);
        player.setMechanics(mechanics);
        player.setSniping(sniping);
        player.setRifling(rifling);
        player.setExperience(experience);
        player.setUtility(utility);
        player.setGameSense(gameSense);
        player.setComms(comms);

        return player;
    }
}
