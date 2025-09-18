package io.github.abzf227.esportsgm_java_java.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EsportsTeam {
    //tools
    private final Random rng = new Random();
    private static final String[] letters = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static final int LETTERS_SIZE = letters.length;
    private static final int ID_SIZE = 10;
    private static List<String> usedIds = new ArrayList<>();
    private static Set<String> usedTags = new HashSet<>(); // global or static
    private static int minSize = 5; //playing size
    private static int maxSize = 8; //with like 7 man rosters and shi idk
    
    //variables
    private final String teamId;
    private String name;
    private String abbreviation;
    private String region;
    private int ovrRating; //calculate later
    private List<EsportsPlayer> roster;

    //constructors
    public EsportsTeam() {  //probably
        this.teamId = generateId();
        this.name = null;
        this.abbreviation = null;
        this.region = null;

        roster = new ArrayList<>();
    }

    public EsportsTeam(String name) {
        this.teamId = generateId();
        this.name = name;
        this.abbreviation = generateAbbreviation(this.name);
        this.region = null;

        roster = new ArrayList<>();
    }

    //getters
    public String getId() {
        return this.teamId;
    }

    public String getName() {
        return this.name;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public String getRegion() {
        return this.region;
    }

    public int getrosterSize() {
        return roster.size();
    }

    public static int getMinSize() {
        return EsportsTeam.minSize;
    }

    public static int getMaxSize() {
        return EsportsTeam.maxSize;
    }

    public int getOvrRating() {
        return this.ovrRating;
    }

    public List<EsportsPlayer> getRoster() {
        return this.roster;
    }

    public static List<String> getIds() {
        return EsportsTeam.usedIds;
    }

    //setters
    public void setName(String name) {
        this.name = name;
        this.abbreviation = generateAbbreviation(name);
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setRoster(List<EsportsPlayer> roster) {
        this.roster = roster;
    }

    public static void setMinSize(int minSize) {
        if(minSize < 1) {
            throw new IllegalArgumentException("Min size cannot be lower than 1!");
        } else if (minSize > maxSize) {
            throw new IllegalArgumentException("Min size cannot be greater than max size!");
        }
        EsportsTeam.minSize = minSize;
    }

    public static void setMaxSize(int maxSize) {
        if(maxSize < minSize) {
            throw new IllegalArgumentException("Max size cannot be smaller than min size!");
        }
        EsportsTeam.maxSize = maxSize;
    }


    //incrementors
    public void addPlayer(EsportsPlayer player) {
        if(player == null) {
            throw new IllegalArgumentException("Attempted to add null player to roster");
        }
        
        for(int i = 0; i < roster.size(); i++) {
            if(player.getId().equals(roster.get(i).getId())) {
                throw new IllegalStateException("Roster already contains player!");
            }
        }
            
        roster.add(player);
    }

    public void removePlayer(String playerId) {
        for(int i = 0; i < roster.size(); i++) {
            if(roster.get(i).getId().equals(playerId)) {
                roster.remove(i);
                return;
            }
        }

        throw new IllegalStateException("Player not found in roster!");
    }

    //generators
    private String generateId() {
        if(!this.teamId.isEmpty()) {
            throw new IllegalStateException("Team ID already generated!");
        }

        String id = "";
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ID_SIZE; i++) {
                sb.append(letters[rng.nextInt(LETTERS_SIZE)]);
            }

            id = sb.toString();
        } while(usedIds.contains(id));

        usedIds.add(id);
        return id;
    }

    private String generateAbbreviation(String teamName) {  //i chatgpted this entire mf im ngl i wasnt writing allat
        String[] words = teamName.trim().split("\\s+");
        String base;

        if (words.length == 1) {
            base = words[0].toUpperCase();
            base = base.length() >= 3 ? base.substring(0, 3) : base;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length && sb.length() < 3; i++) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
            }
            base = sb.toString();
        }

        base = base.length() > 3 ? base.substring(0, 3) : base;

        String tag = base;
        int fallbackDigit = 0;
        while (usedTags.contains(tag)) {
            if (base.length() < 2) break; // failsafe
            tag = base.substring(0, 2) + fallbackDigit;
            fallbackDigit++;
            if (fallbackDigit > 9) break; // optional limit
        }

        usedTags.add(tag);
        return tag;
    }
}
