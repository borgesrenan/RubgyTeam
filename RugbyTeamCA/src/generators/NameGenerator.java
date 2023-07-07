/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generators;

import java.util.Random;

/**
 *
 * @author renan
 */
public class NameGenerator {

    private static final String[] firstNames = {"Seamus", "Aoife", "Ciaran", "Fiona", "Declan", "Niamh", "Ronan"};
    private static final String[] surnames = {"O'Brien", "Murphy", "Kelly", "Doherty", "Byrne", "Gallagher"};

    /**
     * Generates random names
     *
     * @return names as a string
     */
    public static String generate() {
        Random r = new Random();
        String firstName = firstNames[r.nextInt(firstNames.length)];
        String surname = surnames[r.nextInt(surnames.length)];
        return firstName + " " + surname;
    }
}
