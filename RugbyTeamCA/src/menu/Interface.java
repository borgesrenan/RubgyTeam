/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import entities.GroupTraining;
import entities.Players;
import entities.StaffType;
import entities.Staffs;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import printer.Printer;
import rugbyteamca.RugbyClub;
import view.Menu;

/**
 *
 * @author renan
 */
public class Interface implements Menu {

    private final Printer printer;
    private final RugbyClub rugbyClub;

    public Interface(Printer printer, RugbyClub rugbyClub) {
        this.printer = printer;
        this.rugbyClub = rugbyClub;
    }

    @Override
    public void render() {
        int chosenOption = 0;
        Scanner scanner = new Scanner(System.in);

        while (chosenOption != 7) {
            renderMenuOptions();
            chosenOption = handleUserInput(scanner.nextLine());

            if (chosenOption != 7) {
                waitUntilUserPressEnter(scanner);
            }
        }
    }

    private void renderMenuOptions() {
        printer.print("###################################");
        printer.print("WELCOME TO THE CLUB");
        printer.print("###################################");
        printer.print("MENU:");
        printer.print("1 - LIST ALL STAFFS MEMBERS");
        printer.print("2 - LIST STAFF BY A CATEGORY");
        printer.print("3 - LIST ALL GROUPS");
        printer.print("4 - LIST GROUPS BY WEEKDAY");
        printer.print("5 - LIST PLAYERS");
        printer.print("6 - LIST PLAYERS BY GROUP");
        printer.print("7 - LIST PLAYERS BY COACH");
        printer.print("0 - EXIT");
    }

    private int handleUserInput(String option) {
        if (!validNumberInput(option)) {
            printer.print("INVALID OPTION!");
            return 0;
        }

        int chosenOption = Integer.parseInt(option);

        if (chosenOption == 0) {
            printer.print("EXITING THE PROGRAM...");
            System.exit(0);
        }

        takeActionBasedOnUserChoice(chosenOption);
        return chosenOption;
    }

    private void takeActionBasedOnUserChoice(int chosenOption) {
        switch (chosenOption) {
            case 1:
                printStaff(rugbyClub.listAllStaff());
                break;
            case 2:
                handleClubStaffByCategory();
                break;
            case 3:
                printGroup(rugbyClub.listAllGroups());
                break;
            case 4:
                handleGroupsByWeekdaySelection();
                break;
            case 5:
                printPlayer(rugbyClub.listAllPlayers());
                break;
            case 6:
                handlePlayersByGroup();
                break;
            case 7:
                handlePlayersByCoach();
                break;
            case 0:
                break;
            default:
                printer.print("INVALID OPTION!");
        }
    }

    private void waitUntilUserPressEnter(Scanner scanner) {
        printer.print("PLEASE, PRESS ENTER TO CONTINUE!");
        scanner.nextLine();
    }

    private void printStaff(List<Staffs> staffs) {
        staffs.forEach(staff -> printer.print(staff.toString()));
    }

    private void handleClubStaffByCategory() {
        printer.print("PLEASE, PICK ONE TYPE");
        StaffType[] types = StaffType.values();

        for (StaffType type : types) {
            printer.print(type.getId() + " - " + type.getName());
        }

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if (!validNumberInput(option)) {
            printer.print("INVALID OPTION!");
            return;
        }

        int typeIdSelected = Integer.parseInt(option);
        printStaff(rugbyClub.listStaffByType(typeIdSelected));
    }

    private void printGroup(List<GroupTraining> groups) {
        groups.forEach(group -> printer.print(group.toString()));
    }

    private void handleGroupsByWeekdaySelection() {
        printer.print("PLEASE, PICK ONE DAY OF THE WEEK");
        printer.print("1 - SUNDAY");
        printer.print("2 - MONDAY");
        printer.print("3 - TUESDAY");
        printer.print("4 - WEDNESDAY");
        printer.print("5 - THURSDAY");
        printer.print("6 - FRIDAY");
        printer.print("7 - SATURDAY");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if (!validNumberInput(option)) {
            printer.print("INVALID OPTION!");
            return;
        }

        int typeIdSelected = Integer.parseInt(option);

        if (typeIdSelected < 1 || typeIdSelected > 7) {
            printer.print("INVALID OPTION!");
            return;
        }

        printGroup(rugbyClub.listGroupsByWeekday(typeIdSelected));
    }

    private void printPlayer(List<Players> players) {
        players.forEach(player -> printer.print(player.toString()));
    }

    /* This method allows the user to select a group, displays the group
        details, prompts for a group ID, retrieves the group and print the 
        players associated. 
     */
    private void handlePlayersByGroup() {
        printer.print("PLEASE PICK A GROUP");
        List<GroupTraining> groups = rugbyClub.listAllGroups();

        for (GroupTraining group : groups) {
            printer.print("GROUP ID: " + group.getId() + " - " + group.getType() + " / WEEKDAY - " + group.getWeekday());
        }

        printer.print("PLEASE, ENTER THE GROUP ID: ");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if (!validNumberInput(option)) {
            printer.print("INVALID OPTION!");
            return;
        }

        GroupTraining selectedGroup = rugbyClub.getGroupById(option);

        if (selectedGroup == null) {
            printer.print("GROUP NOT FOUND, PLASE TRY AGAIN!");
            return;
        }

        printPlayer(selectedGroup.getPlayers());
    }

    private void handlePlayersByCoach() {
        printer.print("PLEASE, PICK A COACH!");
        List<Staffs> staffs = rugbyClub.listAllCoaches();

        for (int i = 0; i < staffs.size(); i++) {
            Staffs staff = staffs.get(i);
            printer.print((i + 1) + " - " + staff.getName() + " - " + staff.getType());
        }

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if (!validNumberInput(option)) {
            printer.print("INVALID OPTION!");
            return;
        }

        int selectedIndex = Integer.parseInt(option);

        if (selectedIndex == 0) {
            waitUntilUserPressEnter(scanner);
            return;
        }

        if (selectedIndex < 1 || selectedIndex > staffs.size()) {
            printer.print("INVALID OPTION, PLEASE TRY AGAIN!");
            return;
        }

        Staffs staff = staffs.get(selectedIndex - 1);
        printer.print(staff.toString());
        printPlayer(rugbyClub.listAllPlayersByCoach(staff));

        waitUntilUserPressEnter(scanner);

    }

    private boolean validNumberInput(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        return pattern.matcher(input).matches();
    }
}
