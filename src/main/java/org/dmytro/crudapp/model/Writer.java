package org.dmytro.crudapp.model;

import java.util.List;

public class Writer {
    private static int counterID = 0;
    private int id;
    private String firstName;
    private String lastName;
    private List<Post> postList;

    public Writer(int id, String firstName, String lastName, List<Post> postList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postList = postList;
    }

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


    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postList=" + postList +
                '}';
    }
}
