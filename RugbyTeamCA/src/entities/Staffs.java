/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author renan
 */
public class Staffs {

    protected String name;
    protected String number;
    protected StaffType type;

    public String getName() {
        return name;
    }

    public StaffType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "STAFF:\n"
                + "\tNAME = " + name + "\n"
                + "\tNUMBER = " + number + "\n"
                + "\tTYPE = " + type.getName() + "\n";
    }

    protected static StaffType getRandomType(Sector sector) {
        List<StaffType> values = StaffType.listBySector(sector);
        Random random = new Random();
        return values.get(random.nextInt(values.size()));
    }
}
