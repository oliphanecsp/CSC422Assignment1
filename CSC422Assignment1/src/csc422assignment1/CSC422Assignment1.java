/*
 * CSC422Assignment1 class. This class is the main class for the 
 * CSC422Assignment1 program. This class contains the main method.
 */
package csc422assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Eric Oliphant
 */
public class CSC422Assignment1 {

    Scanner scnr = new Scanner(System.in);
    DataBase tableData = new DataBase();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Pet Database Program.\n");
        CSC422Assignment1 csc422assignment1 = new CSC422Assignment1();
        csc422assignment1.loadFile();
        csc422assignment1.mainMenu();
        csc422assignment1.saveFile();
    }

    /**
     * loadFile(). This method loads the file with the name "Pets".
     *
     * @throws IOException
     */
    public void loadFile() throws IOException {
        FileInputStream fis;
        ObjectInputStream in;

        fis = new FileInputStream("Pets");
        in = new ObjectInputStream(fis);
        try {
            tableData = (DataBase) in.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println("\nFile did not load.");
        }
    }

    /**
     * saveFile(). This method saves the tableData DataBase object instance
     * variable to the file with the name "Pets".
     *
     * @throws IOException
     */
    public void saveFile() throws IOException {
        FileOutputStream fos;
        ObjectOutputStream out;

        try {
            fos = new FileOutputStream("Pets");
            out = new ObjectOutputStream(fos);
            out.writeObject(tableData);
            out.close();
            System.out.println("\nGoodbye!");
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile did not save." + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("\nFile did not save." + ex.getMessage());
        }
    }

    /**
     * mainMenu(). This method displays all of the options.
     */
    public void mainMenu() {
        System.out.println("What would you like to do?"
                + "\n1) View all pets"
                + "\n2) Add new pets"
                + "\n3) Remove a pet"
                + "\n4) Exit program"
                + "\nYour choice:");
        int optionChoice = Integer.parseInt(scnr.nextLine());
        while (optionChoice != 4) {
            switch (optionChoice) {
                case 1:
                    tableData.viewAllPets();
                    break;
                case 2:
                    tableData.addMorePets(scnr);
                    break;
                case 3:
                    tableData.removeAnExistingPet(scnr);
                    break;
                case 4:
                    break;
            }
            System.out.println("What would you like to do?"
                    + "\n1) View all pets"
                    + "\n2) Add new pets"
                    + "\n3) Remove a pet"
                    + "\n4) Exit program"
                    + "\nYour choice:");
            optionChoice = Integer.parseInt(scnr.nextLine());
        }

    }

}
