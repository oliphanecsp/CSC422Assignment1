/*
 * CSC422Assignment1 class. This class is the main class for the 
 * CSC422Assignment1 program. This class contains the main method.
 */
package csc422assignment1;

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
     */
    public static void main(String[] args) {
        CSC422Assignment1 csc422assignment1 = new CSC422Assignment1();
        csc422assignment1.mainMenu();
        System.out.println("Goodbye!");
    }

    /**
     * mainMenu(). This method displays all of the options.
     */
    public void mainMenu() {
        System.out.println("What would you like to do?\n1) View all pets"
                + "\n2) Add more pets\n3) Search pets by name"
                + "\n4) Search pets by age\n5) Exit program\nYour choice:");
        int optionChoice = Integer.parseInt(scnr.nextLine());
        while (optionChoice != 5) {
            switch (optionChoice) {
                case 1:
                    tableData.viewAllPets();
                    break;
                case 2:
                    tableData.addMorePets();
                    break;
                case 3:
                    tableData.searchPetsByName();
                    break;
                case 4:
                    tableData.searchPetsByAge();
                    break;
                case 5:
                    break;
            }
            System.out.println("What would you like to do?\n1) View all pets"
                    + "\n2) Add more pets\n3) Search pets by name"
                    + "\n4) Search pets by age\n5) Exit program\nYour choice:");
            optionChoice = Integer.parseInt(scnr.nextLine());
        }

    }

}
