/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import generators.IdGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author renan
 */
public class GroupTraining {

    private String id;
    private int weekday;
    private GroupTrainingType type;
    private Staffs coach;
    private final List<Players> players = new ArrayList<>();
    
    /* Method to generate a random instance of "GroupTraining" class by selecting 
    a random GroupTrainingType, generating an ID, and assigning a random duration.
    */
    public static GroupTraining createRandom() {
        GroupTrainingType[] values = GroupTrainingType.values();
        Random ran = new Random();
        int x = ran.nextInt(values.length - 1) + 1;
        return new GroupTraining(values[x], IdGenerator.generate(), ran.nextInt(7) + 1);
    }

    public GroupTraining(GroupTrainingType type, String id, int weekday) {
        this.type = type;
        this.id = id;
        this.weekday = weekday;
    }

    public Staffs getCoach() {
        return coach;
    }

    public GroupTrainingType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public int getWeekday() {
        return weekday;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public boolean isSameWeekday(int weekday) {
        return this.weekday == weekday;
    }

    public void assignCoaching(Staffs coach) {
        this.coach = coach;
    }

    public void assignPlayer(Players player) throws Exception {
        int MAX_PLAYER_ALLOWED = 30;
        if (players.size() == MAX_PLAYER_ALLOWED) {
            throw new Exception("TrainingGroup contains the maximum allowed number of players");
        }
        players.add(player);
    }

    @Override
    public String toString() {
        return "TRAINING GROUP:\n"
                + "\tID = " + id + "\n"
                + "\tWEEKDAY = " + weekday + "\n"
                + "\tTYPE = " + type + "\n"
                + "\tCOACH = " + coach.getName() + "\n"
                + "\tPLAYERS AMOUNT = " + players.size() + "\n";
    }
}
