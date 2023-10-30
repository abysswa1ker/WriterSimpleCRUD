package org.Dmytro.model;

public class Writer {
    private static int counterID = 0;
    private int id;
    private String firstName;
    private String lastName;

    public Writer(String firstName, String lastName) {
        this.id = counterID;
        this.firstName = firstName;
        this.lastName = lastName;
        counterID++;
    }

    public Writer() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
