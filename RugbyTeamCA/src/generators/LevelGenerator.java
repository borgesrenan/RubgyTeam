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
public class LevelGenerator {

    public static int generate() {
        Random random = new Random();
        return random.nextInt(4);
    }
}
