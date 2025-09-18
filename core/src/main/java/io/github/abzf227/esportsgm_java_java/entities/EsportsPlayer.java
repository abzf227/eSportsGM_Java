package io.github.abzf227.esportsgm_java_java.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EsportsPlayer {
    //tools
    private final Random rand = new Random();
    private static List<String> usedIds = new ArrayList<>();
    private static final String[] letters = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static final int LETTERS_SIZE = letters.length;
    private static final int ID_SIZE = 10;

	//general reference stuff
    private final String playerId;
    private int age;
	private String nationality; //isn't important BUT determintes language which is very important
	private String inGameName;
	private String realName;
	private List<PlayerLanguage> languages = new ArrayList<>(); //generally 1 but can be 2 and sometimes 3....affects comms heavily
    private boolean isRetired;

	//actually important stuff (well age is important too because it has a factor in a lot of things)...similar to nba2k, has a rating out of 100 + a final OVR
	private int mechanics;  //bread and butter, basically the most important stat...affects how much the bottom 2 improve
	private int sniping;    //awp
	private int rifling;    //ak
	private int experience; //younger players = less experience
	private int utility;
	private int gameSense;
	private int comms;

	//below 2 will change throughout games
	private int fatigue;  //gets worse and worse over time, affects all other stats. higher experience = less fatigue 
	private int confidence; //affected by recent performances. higher experience = less confidence detriments
	private double mood; //how happy person is....how likely they are to want to play at the highest level/resign with team
	private String demeanor; //affects other teammates...for example vibey will influence others' confidence, while angry will be detrimental, etc.
	private boolean isIGL;  //only 1 igl per team.... better gameSense + comms = better igl
	private String role; //super important, can be changed, also similar to 2K where u can put players on different positions

	private int overallRating; //will calculate this later
	private int potentialRating; //honestly don't wanna keep this given how different esports is, most esports players retire at like 30 anyway so i want it to be a lot more slower placed
	private int scoutedRating; //what im thinking should replace POT

    //team specific stuff
    //private int yearsWithTeam;


    //constructors
    public EsportsPlayer() {
        this.playerId = generateId();
    }

    public EsportsPlayer(int age, String nationality, String inGameName, String realName, List<PlayerLanguage> languages, boolean isRetired, int mechanics, int sniping, int rifling, int experience, int utility, int gameSense, int comms, int fatigue, int confidence, double mood, String demeanor, boolean isIGL, String role) {
        this.playerId = generateId();
        this.age = age;
        this.nationality = nationality;
        this.inGameName = inGameName;
        this.realName = realName;
        this.languages = languages;
        this.isRetired = isRetired;
        this.mechanics = mechanics;
        this.sniping = sniping;
        this.rifling = rifling;
        this.experience = experience;
        this.utility = utility;
        this.gameSense = gameSense;
        this.comms = comms;
        this.fatigue = fatigue;
        this.confidence = confidence;
        this.mood = mood;
        this.demeanor = demeanor;
        this.isIGL = isIGL;
        this.role = role;
    }

    //getters
    public String getId() {
        return this.playerId;
    }
    
    public int getAge() {
        return this.age;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getInGameName() {
        return this.inGameName;
    }

    public String getRealName() {
        return this.realName;
    }

    public List<PlayerLanguage> getLanguages() {
        return this.languages;
    }

    public boolean getRetiredStatus() {
        return this.isRetired;
    }

    public int getMechanics() {
        return this.mechanics;
    }

    public int getSniping() {
        return this.sniping;
    }

    public int getRifling() {
        return this.rifling;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getUtility() {
        return this.utility;
    }

    public int getGameSense() {
        return this.gameSense;
    }

    public int getComms() {
        return this.comms;
    }

    public int getFatigue() {
        return this.fatigue;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public double getMood() {
        return this.mood;
    }

    public String getDemeanor() {
        return this.demeanor;
    }

    public boolean getIGLStatus() {
        return this.isIGL;
    }

    public String getRole() {
        return this.role;
    }

    public int getOverallRating() {
        return this.overallRating;
    }

    public int getPotentialRating() {
        return this.potentialRating;
    }

    public int getScoutedRating() {
        return this.scoutedRating;
    }

    public static List<String> getUsedIds() {
        return EsportsPlayer.usedIds;
    }

    //setters
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setInGameName(String inGameName) {
        this.inGameName = inGameName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setLanguages(ArrayList<PlayerLanguage> languages) { //rare, don't use if unneccessary
        this.languages = languages;
    }

    public void retire() {
        this.isRetired = true;
    }

    public void unRetire() {
        this.isRetired = false;
    }

    public void setRetirement(boolean isRetired) {
        this.isRetired = isRetired;
    }

    public void setMechanics(int mechanics) {
        this.mechanics = mechanics;
    }

    public void setSniping(int sniping) {
        this.sniping = sniping;
    }

    public void setRifling(int rifling) {
        this.rifling = rifling;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public void setGameSense(int gameSense) {
        this.gameSense = gameSense;
    }

    public void setComms(int comms) {
        this.comms = comms;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public void setMood(double mood) {
        this.mood = mood;
    }

    public void setDemeanor(String demeanor) {
        this.demeanor = demeanor;
    }

    public void setIsIGL(boolean isIGL) {
        this.isIGL = isIGL;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public void setPotentialRating(int potentialRating) {
        this.potentialRating = potentialRating;
    }

    public void setScoutedRating(int scoutedRating) {
        this.scoutedRating = scoutedRating;
    }

    //incrementers
    public void ageUp() {
        age++;
    }

    public void addLanguage(PlayerLanguage language) {
        languages.add(language);
    }

    //generators
    private String generateId() {
            if(!this.playerId.isEmpty()) {
                throw new IllegalStateException("Team ID already generated!");
            }

            String id = "";
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ID_SIZE; i++) {
                    sb.append(letters[rand.nextInt(LETTERS_SIZE)]);
                }

                id = sb.toString();
            } while(usedIds.contains(id));

            usedIds.add(id);
            return id;
        }

    
}
