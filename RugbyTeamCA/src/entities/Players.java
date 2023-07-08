/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import generators.NameGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 *
 * @author renan
 */
public class Players {

    private String name;
    private int age;

    public static Players createRandom() {
        int minimumAge = 5;
        Random random = new Random();
        Players player = new Players();
        player.name = NameGenerator.generate();
        player.age = random.nextInt(60) + minimumAge;
        return player;
    }

    @Override
    public String toString() {
        return "PLAYER:\n"
                + "\tNAME = " + name + "\n"
                + "\tAGE = " + age + "\n";
    }
}
