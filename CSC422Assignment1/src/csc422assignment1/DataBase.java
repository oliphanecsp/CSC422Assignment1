/*
 * DataBase.java class. This class is used to change and display the data
 * of the Pet[] pets array.
 */
package csc422assignment1;

import java.util.Scanner;

/**
 *
 * @author Eric Oliphant
 */
public class DataBase {

    //instance variables
    Pet[] pets = {};
    Scanner scnr = new Scanner(System.in);

    /**
     * viewAllPets(). This method displays all of the pet names and ages of the
     * Pet objects from the Pet[] pets array.
     */
    public void viewAllPets() {
        System.out.println("+----------------------+"
                + "\n| ID | NAME      | AGE |"
                + "\n+----------------------+");
        for (int i = 0; i < this.pets.length; i++) {
            System.out.printf("|%3s | %-10s|%4s |%n", i, this.pets[i].getName(), this.pets[i].getAge());
        }
        System.out.println("+----------------------+"
                + "\n" + this.pets.length + " rows in set.\n");
    }

    /**
     * addMorePets(). This method adds pet objects to the Pet[] pets array.
     */
    public void addMorePets() {
        int numberOfPetsAdded = 0;
        System.out.println("Enter 'done' when you are done entering pet names"
                + "and ages.");
        System.out.print("(Please put a space between the age and name) "
                + "\nadd pet (name, age): ");
        String[] response = scnr.nextLine().split(" ");
        String name = response[0].substring(0, 1).toUpperCase() + response[0].substring(1);
        int age = 0;
        if (name.equals("Done")) {

        } else {
            age = Integer.parseInt(response[1]);
        }
        while (!(name.equals("Done"))) {
            numberOfPetsAdded++;
            int length = this.pets.length;
            Pet[] temporary = new Pet[length + 1];
            for (int i = 0; i < this.pets.length; i++) {
                temporary[i] = this.pets[i];
            }
            temporary[temporary.length - 1] = new Pet(name, age);
            this.pets = temporary;
            System.out.print("(Please put a space between the age and name) "
                    + "\nadd pet (name, age): ");
            response = scnr.nextLine().split(" ");
            name = response[0].substring(0, 1).toUpperCase() + response[0].substring(1);
            if (name.equals("Done")) {

            } else {
                age = Integer.parseInt(response[1]);
            }
        }
        System.out.println(numberOfPetsAdded + " pets added.");
    }

    /**
     * searchPetsByName(). This method checks each Pet object in the Pet[] pets
     * array to see if the Pet object's name value is equal to the name value
     * that is entered in the method. If the Pet object's name value is equal to
     * the name value that is entered in the method, the Pet object's name value
     * and age value are displayed.
     */
    public void searchPetsByName() {
        int numberOfPets = 0;
        System.out.print("Enter a name to search:");
        String name = scnr.nextLine();
        System.out.println("+----------------------+"
                + "\n| ID | NAME      | AGE |"
                + "\n+----------------------+");
        for (int i = 0; i < this.pets.length; i++) {
            if (this.pets[i].getName().equals(name.substring(0, 1).toUpperCase() + name.substring(1))) {
                System.out.printf("|%3s | %-10s|%4s |%n", i, this.pets[i].getName(), this.pets[i].getAge());
                numberOfPets++;
            }
        }
        System.out.println("+----------------------+"
                + "\n" + numberOfPets + " rows in set.\n");

    }

    /**
     * searchPetsByAge(). This method checks each Pet object in the Pet[] pets
     * array to see if the Pet object's age value is equal to the age value that
     * is entered in the method. If the Pet object's age value is equal to the
     * age value that is entered in the method, the Pet object's name value and
     * age value are displayed.
     */
    public void searchPetsByAge() {
        int numberOfPets = 0;
        System.out.print("Enter age to search:");
        int age = Integer.parseInt(scnr.nextLine());
        System.out.println("+----------------------+"
                + "\n| ID | NAME      | AGE |"
                + "\n+----------------------+");
        for (int i = 0; i < this.pets.length; i++) {
            if (this.pets[i].getAge() == age) {
                System.out.printf("|%3s | %-10s|%4s |%n", i, this.pets[i].getName(), this.pets[i].getAge());
                numberOfPets++;
            }
        }
        System.out.println("+----------------------+"
                + "\n" + numberOfPets + " rows in set.\n");
    }

}
