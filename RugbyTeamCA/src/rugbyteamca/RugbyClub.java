/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rugbyteamca;

import entities.Coaching;
import entities.GroupTraining;
import entities.Players;
import entities.Sector;
import entities.StaffClub;
import entities.Staffs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author renan
 */
public class RugbyClub {

    private final List<Staffs> staffs = new ArrayList<>();
    private final List<GroupTraining> trainingsGroups = new ArrayList<>();
    private final List<Players> players = new ArrayList<>();

    /* Squence of actions to create club staff, coaching staff, players, groups,
    and assigns players and coaches to the groups. */
    public void execute() throws Exception {
        createClubStaffs();
        createCoachingStaffs();
        createPlayers();
        createGroups();
        assignPlayerToGroup();
        assignCoachToGroup();
    }

    public List<Staffs> listAllStaff() {
        return new ArrayList<>(staffs);
    }

    public List<Staffs> listAllCoaches() {
        return staffs.stream()
                .filter(staff -> staff instanceof Coaching)
                .collect(Collectors.toList());
    }

    public List<Staffs> listStaffByType(int typeId) {
        return staffs.stream()
                .filter(staff -> staff.getType().getId() == typeId)
                .collect(Collectors.toList());
    }

    public List<GroupTraining> listAllGroups() {
        return new ArrayList<>(trainingsGroups);
    }

    public List<Players> listAllPlayersByCoach(Staffs coach) {
        return trainingsGroups.stream()
                .filter(group -> group.getCoach().equals(coach))
                .flatMap(group -> group.getPlayers().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<GroupTraining> listGroupsByWeekday(int weekday) {
        return trainingsGroups.stream()
                .filter(group -> group.isSameWeekday(weekday))
                .collect(Collectors.toList());
    }

    public List<Players> listAllPlayers() {
        return new ArrayList<>(players);
    }

    public GroupTraining getGroupById(String id) {
        return trainingsGroups.stream()
                .filter(group -> group.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private void createClubStaffs() {
        int maxClubStaff = 10;
        Set<String> typesCreated = new HashSet<>();
        while (staffs.size() < maxClubStaff || typesCreated.size() < 2) {
            StaffClub staff = StaffClub.createRandom();
            staffs.add(staff);
            typesCreated.add(staff.getType().name());
        }
    }

    /* This method creates coaching staff members, including a head coach, and 
    randomly generates additional coaching staff until a maximum number is 
    reached or three different types of coaching staff are created. */
    
    private void createCoachingStaffs() {
        Coaching staff = Coaching.createHeadCoach();
        staffs.add(staff);
        Set<String> typesCreated = new HashSet<>();
        typesCreated.add(staff.getType().name());
        int maxClubStaff = 20;
        while (staffs.size() < maxClubStaff || typesCreated.size() < 3) {
            staff = Coaching.createRandom();
            staffs.add(staff);
            typesCreated.add(staff.getType().name());
        }
    }

    private void createGroups() {
        int maxGroup = 20;
        Set<String> typesCreated = new HashSet<>();
        while (trainingsGroups.size() < maxGroup || typesCreated.size() < 3) {
            GroupTraining group = GroupTraining.createRandom();
            trainingsGroups.add(group);
            typesCreated.add(group.getType().name());
        }
    }

    private void createPlayers() {
        int maxPlayers = 330;
        for (int i = 0; i < maxPlayers; i++) {
            players.add(Players.createRandom());
        }
    }

    /* This method assigns players to training groups, with a random number of 
       players (up to a maximum limit) being assigned to each group.
     */
    private void assignPlayerToGroup() {
        int maxPlayerByGroup = 30;
        int initialPlayerIndex = 0;
        Random random = new Random();
        for (GroupTraining group : trainingsGroups) {
            int amountOfPlayerInAGroup = random.nextInt(maxPlayerByGroup);
            for (int i = 0; i < amountOfPlayerInAGroup; i++) {
                try {
                    Players player = players.get(initialPlayerIndex + i);
                    group.assignPlayer(player);
                } catch (Exception e) {
                }
            }
            initialPlayerIndex += amountOfPlayerInAGroup;
        }
    }

    /* 
    This method assigns coaching staff members to training groups based on the 
    weekday of the group, with each group being assigned a coach in sequential 
    order, looping back to the first coach if necessary.
     */
    private void assignCoachToGroup() throws Exception {
        List<Staffs> coachingStaff = staffs.stream()
                .filter(staff -> staff.getType().getSector() == Sector.COACHING)
                .collect(Collectors.toList());

        int coachIndex = 0;

        trainingsGroups.sort(Comparator.comparingInt(GroupTraining::getWeekday));

        for (GroupTraining group : trainingsGroups) {
            if (!coachingStaff.isEmpty()) {
                try {
                    group.assignCoaching(coachingStaff.get(coachIndex));
                } catch (Exception ex) {
                    group.assignCoaching(coachingStaff.get(0));
                    coachIndex = 0;
                }
                coachIndex++;
            }
        }
    }
}
