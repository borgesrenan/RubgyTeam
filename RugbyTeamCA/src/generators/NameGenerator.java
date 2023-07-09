/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 *
 * @author renan
 */
public class NameGenerator {

    private static final String[] firstNames = {"Seamus", "Aoife", "Ciaran", "Fiona", "Declan", "Niamh", "Ronan", "Eoin", "Orlaith", "Padraig", "Sinead", "Tadhg", "Grainne", "Darragh", "Maeve", "Liam", "Ciara", "Sean"};
    private static final String[] surnames = {"O'Brien", "Murphy", "Kelly", "Doherty", "Byrne", "Gallagher", "Ryan", "Quinn", "Duffy", "O'Sullivan", "Fitzgerald", "Doyle", "Reilly", "Kennedy", "McCarthy", "Walsh", "O'Connor", "O'Neill"};

    /* method to generate names
     */
    public static String generate() {
        Random r = new Random();
        String firstName = firstNames[r.nextInt(firstNames.length)];
        String surname = surnames[r.nextInt(surnames.length)];
        return firstName + " " + surname;
    }
}
