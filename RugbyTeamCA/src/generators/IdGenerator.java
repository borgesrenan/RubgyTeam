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
public class IdGenerator {

    public static String generate() {
        return String.format("%03d", new Random().nextInt(100));
    }
}
