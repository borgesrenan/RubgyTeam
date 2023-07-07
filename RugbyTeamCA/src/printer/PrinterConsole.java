/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printer;

/**
 *
 * @author renan
 */
public class PrinterConsole implements Printer {

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}