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
        String lineSeparator = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("STAFF:").append(lineSeparator);
        sb.append("\tNAME = ").append(name).append(lineSeparator);
        sb.append("\tNUMBER = ").append(number).append(lineSeparator);
        sb.append("\tTYPE = ").append(type.getName()).append(lineSeparator);
        return sb.toString();
    }

    protected static StaffType getRandomType(final Sector sector) {
        final List<StaffType> values = StaffType.listBySector(sector);
        Random random = new Random();
        return values.get(random.nextInt(values.size()));
    }
}
