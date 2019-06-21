//No packages

// Import project

import quoridor.Quoridor;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

// Import Java
// No import

/**
 * Game launcher of Quoridor
 * Contains the main method of the project
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class Launcher {

    /**
     * Project's main method
     * @param args optional arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            System.out.println(e);
        }
        new Quoridor(args);
        while (true) {
            try {
                Thread.sleep(100);
                FileReader fr = new FileReader(new File("./data/new.bin"));
                Scanner sc = new Scanner(fr);
                String string = sc.nextLine();
                fr.close();
                PrintWriter printwriter = new PrintWriter(new FileOutputStream("./data/new.bin"));
                printwriter.println("");
                printwriter.close();
                if (string.equals("gui")) {
                    String[] args2 = {"gui"};
                    new Quoridor(args2);
                }
                if (string.equals("menu")) {
                    String[] args2 = {};
                    new Quoridor(args2);
                }
                if (string.equals("load")) {
                    String[] args2 = {"load"};
                    new Quoridor(args2);
                }
            }
            catch (FileNotFoundException e){
                try {
                    PrintWriter printwriter = new PrintWriter(new FileOutputStream("./data/new.bin"));
                    printwriter.println("");
                    printwriter.close();
                }catch (Exception ex){
                }
            }
            catch (Exception e) {
            }

        }
    }

}
