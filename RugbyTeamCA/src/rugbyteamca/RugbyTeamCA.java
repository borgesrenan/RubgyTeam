/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rugbyteamca;

import menu.Interface;
import printer.Printer;
import printer.PrinterConsole;
import view.Menu;

/**
 *
 * @author renan
 */
public class RugbyTeamCA {

    public static void main(String[] args) throws Exception {
        RugbyClub rugbyClub = new RugbyClub();
        rugbyClub.execute();

        Printer printer = new PrinterConsole();
        Menu menu = new Interface(printer, rugbyClub);
        menu.render();
    }
}