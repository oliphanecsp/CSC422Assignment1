/*
 * DataBase.java class. This class is used to change and display the data
 * of the Pet[] pets array.
 */
package csc422assignment1;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Eric Oliphant
 */
public class DataBase implements Serializable {

    //instance variables
    Pet[] pets = {};

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
     * addMorePets().This method adds pet objects to the Pet[] pets array.
     *
     * @param scnr Scanner
     */
    public void addMorePets(Scanner scnr) {
        int numberOfPetsAdded = 0;
        int age = 0;
        String name = "";
        String[] response = {};
        int errorCount = 0;
        System.out.println("Enter 'done' when you are done entering pet names"
                + " and ages.");
        System.out.print("\n(Please put a space between the age and name) "
                + "\nadd pet (name, age): ");
        try {
            response = scnr.nextLine().split(" ");
            name = response[0].substring(0, 1).toUpperCase() + response[0].substring(1);
            if (name.equals("Done")) {

            } else {

                age = Integer.parseInt(response[1]);
            }
        } catch (Exception e) {
            System.out.print("Error: ");
            for (Object input : response) {
                System.out.print(input + " ");
            }
            System.out.println("is not a valid input.");
            errorCount = 1;
        }
        while (!(name.equals("Done"))) {
            try {
                if ((age > 20 || age < 1)) {
                    if (errorCount != 1) {
                        System.out.println("Error: " + age + " is not a valid age.");
                    }
                } else if (pets.length >= 5 || pets.length < 0) {
                    System.out.println("Error: Database is full.");
                } else if ((response.length > 2 || (response.length == 1 && !(response[0].equals("done")))) && errorCount != 1) {
                    System.out.print("Error: ");
                    for (Object input : response) {
                        System.out.print(input + " ");
                    }
                    System.out.println("is not a valid input.");
                } else {
                    numberOfPetsAdded++;
                    int length = this.pets.length;
                    Pet[] temporary = new Pet[length + 1];
                    for (int i = 0; i < this.pets.length; i++) {
                        temporary[i] = this.pets[i];
                    }
                    temporary[temporary.length - 1] = new Pet(name, age);
                    this.pets = temporary;
                }
                errorCount = 0;
                System.out.print("\n(Please put a space between the name and age) "
                        + "\nadd pet (name, age): ");

                response = scnr.nextLine().split(" ");
                name = response[0].substring(0, 1).toUpperCase() + response[0].substring(1);
                if (name.equals("Done")) {

                } else {

                    age = Integer.parseInt(response[1]);
                }
            } catch (Exception e) {
                System.out.print("Error: ");
                for (Object input : response) {
                    System.out.print(input + " ");
                }
                System.out.println("is not a valid input.");
                errorCount = 1;
                age = 0;
            }
        }
        System.out.println(numberOfPetsAdded + " pets added.");
    }

    /**
     * updateAnExistingPet().This method updates the name value and age value of
     * the Pet object that is at the index, that is entered in the method, of
     * the Pet[] pets array with the name value that is entered in the method
     * and the age value that is entered in the method.
     *
     * @param scnr Scanner
     */
    public void updateAnExistingPet(Scanner scnr) {
        viewAllPets();
        System.out.print("Enter the pet ID you want to update: ");
        int petID = Integer.parseInt(scnr.nextLine());
        System.out.println("\n(Please put a space between the name and age)"
                + "\nEnter new name and new age: ");
        String[] response = scnr.nextLine().split(" ");
        System.out.println(this.pets[petID].getName() + " " + this.pets[petID].getAge()
                + " changed to " + response[0] + " " + response[1] + ".");
        this.pets[petID].setName(response[0]);
        this.pets[petID].setAge(Integer.parseInt(response[1]));

    }

    /**
     * removeAnExistingPet().This method removes the Pet object that is at the
     * index, that is entered in the method, of the Pet[] pets array from the
     * Pet[] pets array.
     *
     * @param scnr Scanner
     */
    public void removeAnExistingPet(Scanner scnr) {
        viewAllPets();
        System.out.print("Enter the pet ID to remove: ");
        int petID = Integer.parseInt(scnr.nextLine());
        if (petID > pets.length - 1 || petID < 0) {
            System.out.println("Error: ID " + petID + " does not exist.\n");
        } else {
            Pet[] temporary = new Pet[this.pets.length - 1];
            int temporaryIndex = 0;
            int petsIndex = 0;
            while (temporaryIndex < (pets.length - 1) || petsIndex < this.pets.length) {
                if (petsIndex == petID) {
                    petsIndex++;
                } else {
                    temporary[temporaryIndex] = pets[petsIndex];
                    temporaryIndex++;
                    petsIndex++;
                }
            }
            System.out.println(this.pets[petID].getName() + " "
                    + this.pets[petID].getAge() + " is removed.\n");
            this.pets = temporary;
        }
    }

    /**
     * searchPetsByName().This method checks each Pet object in the Pet[] pets
     * array to see if the Pet object's name value is equal to the name value
     * that is entered in the method. If the Pet object's name value is equal to
     * the name value that is entered in the method, the Pet object's name value
     * and age value are displayed.
     *
     * @param scnr Scanner
     */
    public void searchPetsByName(Scanner scnr) {
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
     * searchPetsByAge().This method checks each Pet object in the Pet[] pets
     * array to see if the Pet object's age value is equal to the age value that
     * is entered in the method. If the Pet object's age value is equal to the
     * age value that is entered in the method, the Pet object's name value and
     * age value are displayed.
     *
     * @param scnr Scanner
     */
    public void searchPetsByAge(Scanner scnr) {
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
