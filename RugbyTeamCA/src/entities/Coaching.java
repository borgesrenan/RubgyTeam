/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import generators.LevelGenerator;
import generators.NameGenerator;
import java.util.UUID;

/**
 *
 * @author renan
 */
public class Coaching extends Staffs {

    private int level; // Declares an instance variable level that represents the coach's level.

    public static Coaching createHeadCoach() {
        Coaching staff = new Coaching();
        initializeStaff(staff, StaffType.HEAD_COACH, 5); // method to set the attributes of the staff object with the type and level 5.
        return staff;
    }

    public static Coaching createRandom() {
        Coaching staff = new Coaching();
        initializeStaff(staff, getRandomType(Sector.COACHING), LevelGenerator.generate());
        return staff;
    }

    private static void initializeStaff(Coaching staff, StaffType type, int level) {
        staff.name = NameGenerator.generate();
        staff.number = UUID.randomUUID().toString();
        staff.type = type;
        staff.level = level;
    }

    @Override
    public String toString() {
        return super.toString() + "\tLevel = " + level + System.lineSeparator();
    }
}
