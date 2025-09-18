package io.github.abzf227.esportsgm_java_java.logic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.*;

public class RealNameGenerator {
    private final Random rand = new Random();

    public String generateName(String nationality) {
        String firstFile;
        String lastFile;

        switch (nationality.toLowerCase()) {
            case "china":
                firstFile = "possibleNames/firstNames/MaleFirstNames/ChineseFirstNames.txt";
                lastFile = "possibleNames/lastNames/ChineseLastNames.txt";
                break;
            case "france":
                firstFile = "possibleNames/firstNames/MaleFirstNames/FrenchFirstNames.txt";
                lastFile = "possibleNames/lastNames/FrenchLastNames.txt";
                break;
            case "united states of america":
            case "usa":
                firstFile = "possibleNames/firstNames/MaleFirstNames/EnglishFirstNames.txt";
                lastFile = "possibleNames/lastNames/EnglishLastNames.txt";
                break;
            case "south korea":
            case "korea":
                firstFile = "possibleNames/firstNames/MaleFirstNames/KoreanFirstNames.txt";
                lastFile = "possibleNames/lastNames/KoreanLastNames.txt";
                break;
            case "brazil":
                firstFile = "possibleNames/firstNames/MaleFirstNames/PortugueseFirstNames.txt";
                lastFile = "possibleNames/lastNames/PortugueseLastNames.txt";
                break;
            case "japan":
                firstFile = "possibleNames/firstNames/MaleFirstNames/JapaneseFirstNames.txt";
                lastFile = "possibleNames/lastNames/JapaneseLastNames.txt";
                break;
            case "germany":
                firstFile = "possibleNames/firstNames/MaleFirstNames/GermanFirstNames.txt";
                lastFile = "possibleNames/lastNames/GermanLastNames.txt";
                break;
            case "spain":
                firstFile = "possibleNames/firstNames/MaleFirstNames/SpanishFirstNames.txt";
                lastFile = "possibleNames/lastNames/SpanishLastNames.txt";
                break;
            case "russia":
                firstFile = "possibleNames/firstNames/MaleFirstNames/RussianFirstNames.txt";
                lastFile = "possibleNames/lastNames/RussianLastNames.txt";
                break;
            case "philippines":
                firstFile = "possibleNames/firstNames/MaleFirstNames/EnglishFirstNames.txt";
                lastFile = "possibleNames/lastNames/SpanishLastNames.txt";
                break;
            case "canada":
                firstFile = "possibleNames/firstNames/MaleFirstNames/EnglishFirstNames.txt";
                lastFile = "possibleNames/lastNames/EnglishLastNames.txt";
                break;
            case "united kingdom":
            case "uk":
                firstFile = "possibleNames/firstNames/MaleFirstNames/EnglishFirstNames.txt";
                lastFile = "possibleNames/lastNames/EnglishLastNames.txt";
                break;
            case "portugal":
                firstFile = "possibleNames/firstNames/MaleFirstNames/PortugueseFirstNames.txt";
                lastFile = "possibleNames/lastNames/PortugueseLastNames.txt";
                break;
            case "vietnam":
                firstFile = "possibleNames/firstNames/MaleFirstNames/VietnameseFirstNames.txt";
                lastFile = "possibleNames/lastNames/VietnameseLastNames.txt";
                break;
            case "mexico":
                firstFile = "possibleNames/firstNames/MaleFirstNames/SpanishFirstNames.txt";
                lastFile = "possibleNames/lastNames/SpanishLastNames.txt";
                break;
            case "indonesia":
                firstFile = "possibleNames/firstNames/MaleFirstNames/IndonesianFirstNames.txt";
                lastFile = "possibleNames/lastNames/IndonesianLastNames.txt";
                break;
            case "thailand":
                firstFile = "possibleNames/firstNames/MaleFirstNames/ThaiFirstNames.txt";
                lastFile = "possibleNames/lastNames/ThaiLastNames.txt";
                break;
            case "sweden":
                firstFile = "possibleNames/firstNames/MaleFirstNames/SwedishFirstNames.txt";
                lastFile = "possibleNames/lastNames/SwedishLastNames.txt";
                break;
            case "finland":
                firstFile = "possibleNames/firstNames/MaleFirstNames/FinnishFirstNames.txt";
                lastFile = "possibleNames/lastNames/FinnishLastNames.txt";
                break;
            case "denmark":
                firstFile = "possibleNames/firstNames/MaleFirstNames/DanishFirstNames.txt";
                lastFile = "possibleNames/lastNames/DanishLastNames.txt";
                break;
            case "ukraine":
                firstFile = "possibleNames/firstNames/MaleFirstNames/UkrainianFirstNames.txt";
                lastFile = "possibleNames/lastNames/UkrainianLastNames.txt";
                break;
            case "malaysia":
                firstFile = "possibleNames/firstNames/MaleFirstNames/MalayFirstNames.txt";
                lastFile = "possibleNames/lastNames/MalayLastNames.txt";
                break;
            case "taiwan":
                firstFile = "possibleNames/firstNames/MaleFirstNames/ChineseFirstNames.txt";
                lastFile = "possibleNames/lastNames/ChineseLastNames.txt";
                break;
            case "poland":
                firstFile = "possibleNames/firstNames/MaleFirstNames/PolishFirstNames.txt";
                lastFile = "possibleNames/lastNames/PolishLastNames.txt";
                break;
            case "australia":
                firstFile = "possibleNames/firstNames/MaleFirstNames/EnglishFirstNames.txt";
                lastFile = "possibleNames/lastNames/EnglishLastNames.txt";
                break;
            default:  //default: English name
                firstFile = "possibleNames/firstNames/MaleFirstNames/EnglishFirstNames.txt";
                lastFile = "possibleNames/lastNames/EnglishLastNames.txt";
        }

        List<String> firstNames = loadNames(firstFile);
        List<String> lastNames =  loadNames(lastFile);

        if(firstNames.isEmpty() || lastNames.isEmpty()) {
            return "Unknown";
        }

        String firstName = firstNames.get(rand.nextInt(firstNames.size()));
        String lastName = lastNames.get(rand.nextInt(lastNames.size()));

        return firstName + " " + lastName;
    }

    private List<String> loadNames(String path) {
        List<String> names = new ArrayList<>();
        try {
            FileHandle nameFile = Gdx.files.internal(path);
            for(String line : nameFile.readString().split("\\r?\\n")) {
                names.add(line.trim());
            }
        } catch(Exception e) {
            System.err.println("Failed to load file a: " + path);
        }

        return names;
    }
}
