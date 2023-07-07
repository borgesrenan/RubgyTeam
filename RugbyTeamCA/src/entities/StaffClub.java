/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import generators.NameGenerator;
import java.util.UUID;

/**
 *
 * @author renan
 */
public class StaffClub extends Staffs {

    /* method to generate a random instance of a staff member for a club, with 
    a randomly generated name, unique identifier, and staff type. */
    
    public static StaffClub createRandom() {
        StaffClub staff = new StaffClub();
        initializeStaff(staff, getRandomType(Sector.CLUB));
        return staff;
    }

    private static void initializeStaff(StaffClub staff, StaffType type) {
        staff.name = NameGenerator.generate();
        staff.number = UUID.randomUUID().toString();
        staff.type = type;
    }
}
