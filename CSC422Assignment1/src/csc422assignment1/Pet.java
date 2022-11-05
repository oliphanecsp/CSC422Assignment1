/*
 * Pet class. This class is used to store the name and age of a pet.
 */
package csc422assignment1;

/**
 *
 * @author Eric Oliphant
 */
public class Pet {

    //instance variables
    private String name;
    private int age;

    /**
     * Pet(String name, int age) constructor.
     *
     * @param name String
     * @param age int
     */
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * getName(). This method returns the String name instance variable.
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * getAge(). This method returns the int age instance variable.
     *
     * @return int
     */
    public int getAge() {
        return this.age;
    }
}
